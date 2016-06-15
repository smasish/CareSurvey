package caresurvey.sci.com.caresurvey.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.FPObservationSupervisorTable;
import caresurvey.sci.com.caresurvey.database.FpObservationTable;
import caresurvey.sci.com.caresurvey.model.FpObservationFormItem;
import caresurvey.sci.com.caresurvey.utils.AppUtils;
import caresurvey.sci.com.caresurvey.widgets.QCheckBox;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

/**
 * Created by Shahin on 5/4/2016.
 */
public class FpObservationActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mFp101TextView, mFp102TextView, mFp103TextView, mFp104TextView;
    private EditText mFp101EditText, mFp102EditText, mFp103EditText, mFp104EditText;
    private View mFpQuesView1, mFpQuesView2, mFpQuesView3, mFpQuesView4, mFpQuesView5, mFpQuesView6, mFpQuesView7, mFpQuesView8;
    private FpObservationTable table;
    private long formID = 0;
    private FpObservationFormItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp_observation);
        table = new FpObservationTable(this);
        initIncludedViews();
        initQuestion();
        Intent mIntent = getIntent();
        if(mIntent.hasExtra(DisplayUserActivity.FORM_ID)){ //alreay have one
            if(mIntent.hasExtra(SurveyActivity.FROM_ADMIN)){
                findViewById(R.id.admin_btn_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.user_btn_layout).setVisibility(View.GONE);
                editable(false);
                FPObservationSupervisorTable supervisorTable = new FPObservationSupervisorTable(this);
                item = supervisorTable.get(mIntent.getLongExtra(DisplayUserActivity.FORM_ID,0L));
            }
            else {
                findViewById(R.id.user_btn_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.admin_btn_layout).setVisibility(View.GONE);
                item = table.get(mIntent.getLongExtra(DisplayUserActivity.FORM_ID, 0));
            }
        }
        else{
            item = new FpObservationFormItem();
            item.name = mIntent.getStringExtra("name");
            item.designation = mIntent.getStringExtra("designation");
            item.description = mIntent.getStringExtra("description");
            item.mark = mIntent.getIntExtra("mark", 0);
            item.client_name = item.collector_name = mIntent.getStringExtra("c_name");
            item.upozila = mIntent.getStringExtra("upozila");
            item.union = mIntent.getStringExtra("union");
            item.village = mIntent.getStringExtra("village");
            item.serial_no = item.facility_id = mIntent.getStringExtra("serial");
            item.date = item.datepick = mIntent.getStringExtra("datepicker");
            item.start_time = item.timepick = mIntent.getStringExtra("timepicker");
            item.facility = mIntent.getStringExtra("facility");
            item.obs_type = mIntent.getStringExtra("obstype");
            item.district = mIntent.getStringExtra("district");
        }

        loadForm();
    }

    private void initIncludedViews() {
        mFpQuesView1 = findViewById(R.id.include_fb_ques_01);
        mFpQuesView2 = findViewById(R.id.include_fb_ques_02);
        mFpQuesView3 = findViewById(R.id.include_fb_ques_03);
        mFpQuesView4 = findViewById(R.id.include_fb_ques_04);
        mFpQuesView5 = findViewById(R.id.include_fb_ques_05);
        mFpQuesView6 = findViewById(R.id.include_fb_ques_06);
        mFpQuesView7 = findViewById(R.id.include_fb_ques_07);
        mFpQuesView8 = findViewById(R.id.include_fb_ques_08);
    }

    private void loadForm(){
        if(item.status == 2){ //reverted
            EditText comment = (EditText) findViewById(R.id.comment);
            comment.setText(item.comments);
            comment.setFocusable(false);
            findViewById(R.id.revert_submit).setVisibility(View.GONE);
            LinearLayout fieldLayout = (LinearLayout) findViewById(R.id.fields);
            fieldLayout.removeAllViews();
            TextView textView = new TextView(this);
            textView.setTextSize(25f);
            textView.setText(item.fields);
            fieldLayout.addView(textView);
            findViewById(R.id.commentSection).setVisibility(View.VISIBLE);
            findViewById(R.id.revert_cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    findViewById(R.id.commentSection).setVisibility(View.GONE);
                }
            });
        }
        sETv(R.id.et_fp_101,item.serial_no);
        sETv(R.id.et_fp_102,item.date);
        sETv(R.id.et_fp_103,item.start_time);
//        sSPi(R.id.et_fp_104, item.client_name);
        sRGv(mFpQuesView1, item.cover);
        sRGv(mFpQuesView2,item.sound_prove);
        sRGv(mFpQuesView3,item.discuss_fp);
        sRGv(mFpQuesView4,item.discuss_fp_protocol);
        sRGv(mFpQuesView5,item.what_to_do);
        sRGv(mFpQuesView6,item.questions);
        sRGv(mFpQuesView7,item.job_aid);
        sRGv(mFpQuesView8,item.followup);
        sETv(R.id.et_fp_109,item.start_time);
    }

    private void editable(boolean state){
        sVEs(R.id.et_fp_101,state);
        sVEs(R.id.et_fp_102,state);
        sVEs(R.id.et_fp_103,state);
        sVEs(R.id.et_fp_104,state);
        sVEs(R.id.et_fp_109,state);
        sRGs(mFpQuesView1, state);
        sRGs(mFpQuesView2,state);
        sRGs(mFpQuesView3,state);
        sRGs(mFpQuesView4,state);
        sRGs(mFpQuesView5,state);
        sRGs(mFpQuesView6,state);
        sRGs(mFpQuesView7,state);
        sRGs(mFpQuesView8,state);
    }

    private void sVEs(int id, boolean state){
        findViewById(id).setEnabled(state);
    }

    private String gSPi(int id) {
        Spinner sp = (Spinner) findViewById(id);
        int selection = sp.getSelectedItemPosition();
        if(selection == 0) return null;
        return Integer.toString(selection);
    }

    private void sSPi(int id,String val){
        Spinner sp = (Spinner) findViewById(id);
        try{
            sp.setSelection(Integer.parseInt(val));
        }catch(Exception e){
            e.printStackTrace();
            sp.setSelection(0);
        }
    }

    private FpObservationFormItem collectAnswers() {
        FpObservationFormItem mFpObservationFormItem = item;
        if(TextUtils.isEmpty( (mFpObservationFormItem.cover = getRadioSelectionAns(mFpQuesView1)))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty( (mFpObservationFormItem.sound_prove = getRadioSelectionAns(mFpQuesView2)))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty( (mFpObservationFormItem.discuss_fp = getRadioSelectionAns(mFpQuesView3)))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty( (mFpObservationFormItem.discuss_fp_protocol = getRadioSelectionAns(mFpQuesView4)))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty( (mFpObservationFormItem.what_to_do = getRadioSelectionAns(mFpQuesView5)))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty( (mFpObservationFormItem.questions = getRadioSelectionAns(mFpQuesView6)))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty( (mFpObservationFormItem.job_aid = getRadioSelectionAns(mFpQuesView7)))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty( (mFpObservationFormItem.followup = getRadioSelectionAns(mFpQuesView8)))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty(( mFpObservationFormItem.serial_no = getEString(R.id.et_fp_101) ))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
//        if(TextUtils.isEmpty(( mFpObservationFormItem.date = getEString(R.id.et_fp_102) ))){
//            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
//        }
//        if(TextUtils.isEmpty(( mFpObservationFormItem.start_time = getEString(R.id.et_fp_103) ))){
//            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
//        }
//        if(TextUtils.isEmpty(( mFpObservationFormItem.client_name = gSPi(R.id.et_fp_104) ))){
//            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
//        }
        if(TextUtils.isEmpty(( mFpObservationFormItem.end_time = getEString(R.id.et_fp_109) ))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        mFpObservationFormItem.end_time = AppUtils.getTime();
        sETv(R.id.et_fp_109,mFpObservationFormItem.end_time);
        mFpObservationFormItem.status = 3; //pending
        return mFpObservationFormItem;
    }

    private String getEString(int id){
        Editable text = ((EditText) findViewById(id)).getText();
        if(TextUtils.isEmpty(text)){
            return null;
        }
        else{
            return text.toString();
        }
    }

    private void sETv(int id,String val){
        EditText et = (EditText) findViewById(id);
        if(et != null){
            et.setText(val);
        }
    }

    private void sRGv(View radioGroupHolder,String val){
        RadioGroup radioGroup = (RadioGroup) radioGroupHolder.findViewById(R.id.fp_yes_no_radiogroup);
        if(val != null){
            if(val.equals("true")){
                ((RadioButton)radioGroup.findViewById(R.id.yes)).setChecked(true);
            }
            else if(val.equals("false")){
                ((RadioButton)radioGroup.findViewById(R.id.no)).setChecked(true);
            }
        }
    }

    private void sRGs(View radioGroupView,boolean state){
        RadioGroup radioGroup = (RadioGroup) radioGroupView.findViewById(R.id.fp_yes_no_radiogroup);
        for(int i=0;i<radioGroup.getChildCount();i++){
            RadioButton btn = (RadioButton) radioGroup.getChildAt(i);
            btn.setEnabled(state);
        }
    }

    private int getEInt(int id){
        Editable text = ((EditText) findViewById(id)).getText();
        if(TextUtils.isEmpty(text)){
            return -1;
        }
        else{
            int res = -1;
            try {
                res = Integer.parseInt(text.toString());
            }catch(Exception e){
                e.printStackTrace();
            }
            return res;
        }
    }


    private String getRadioSelectionAns(View radioGroupHolder) {
        RadioGroup radioGroup = (RadioGroup) radioGroupHolder.findViewById(R.id.fp_yes_no_radiogroup);
        int selectedRadioBtnId = radioGroup.getCheckedRadioButtonId();
        if(selectedRadioBtnId == R.id.yes){
            return "true";
        }
        else if(selectedRadioBtnId == R.id.no){
            return "false";
        }
        return null;
    }

    private void initQuestion() {
        AppUtils.setTextWithFonts(this, (TextView) findViewById(R.id.tv_fp_101), getString(R.string.fp_ques_101));
        AppUtils.setTextWithFonts(this, (TextView) findViewById(R.id.tv_fp_102), getString(R.string.fp_ques_102));
        AppUtils.setTextWithFonts(this, (TextView) findViewById(R.id.tv_fp_103), getString(R.string.fp_ques_103));
        AppUtils.setTextWithFonts(this, (TextView) findViewById(R.id.tv_fp_104), getString(R.string.fp_ques_104));
        AppUtils.setTextWithFonts(this, (TextView) findViewById(R.id.tv_fp_105), getString(R.string.fp_ques_105));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_01), getString(R.string.fp_ques_01));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_02), getString(R.string.fp_ques_02));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_03), getString(R.string.fp_ques_03));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_04), getString(R.string.fp_ques_04));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_05), getString(R.string.fp_ques_05));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_06), getString(R.string.fp_ques_06));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_07), getString(R.string.fp_ques_07));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_08), getString(R.string.fp_ques_08));
        AppUtils.setTextWithFonts(this, (TextView) findViewById(R.id.tv_fp_109), getString(R.string.fp_ques_09));
    }

    public void onClickBtn(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(FpObservationActivity.this);
        RequestQueue requestQueue = Volley.newRequestQueue(FpObservationActivity.this);
        switch (view.getId()) {
            case R.id.back:
//                Intent start = new Intent(FpObservationActivity.this, DisplayUserActivity.class);
//                start.putExtra("fp", "fp");
//                startActivity(start);
                finish();
                break;
            case R.id.Savebtn:
//                Intent start1 = new Intent(FpObservationActivity.this, DisplayUserActivity.class);
//                start1.putExtra("fp", "fp");
//                startActivity(start1);
//                finish();
                FpObservationFormItem item = collectAnswers();
                if(item != null){
                    long status = table.insert(item);
                    if(status >= 0){
                        formID = status;
                        Toast.makeText(this,"Save successfully",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this,"Failed to save data",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.Submit:
                final FpObservationFormItem fpItem = collectAnswers();
                if(fpItem == null){
                    Toast.makeText(FpObservationActivity.this, "Form is not complete", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(fpItem.status == 2){ //reverted
                    fpItem.status = 4;
                }
                long status = table.insert(fpItem);
                if(status >= 0){
                    formID = status;
//                    Toast.makeText(this,"Save successfully",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,"Failed to save data",Toast.LENGTH_SHORT).show();
                    return;
                }
                final ProgressDialog dialog = new ProgressDialog(this);
                dialog.setMessage("Please wait...");
                final AlertDialog.Builder alert = new AlertDialog.Builder(FpObservationActivity.this);
                if(fpItem != null) {
                    String url = "http://119.148.43.34/mamoni/survey/api/form";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {

                                @Override
                                public void onResponse(String response) {
                                    dialog.dismiss();

                                    try {
                                        final JSONObject jo = new JSONObject(response);
                                        if(jo.has("errorCount")){
                                            alert.setMessage(jo.getString("message"));
                                        }
                                        else{
                                            alert.setMessage("Invalid response");
                                        }
                                        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                                try {
                                                    if(jo.getInt("errorCount") == 0){
                                                        finish();
                                                    }
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        });
                                        alert.show();

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        alert.setMessage("An error occurred")   ;
                                        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        });
                                        alert.show();
                                    }
                                    //  Toast.makeText(TestActivity.this,response,Toast.LENGTH_SHORT).show();
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    dialog.dismiss();
                                    //    Toast.makeText(TestActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                                    alert.setMessage("An error occurred");
                                    alert.show();
                                    error.printStackTrace();
                                }
                            }) {

                        @Override
                        protected Map<String, String> getParams() {

                            Map<String, String> params = new HashMap<>();

                            try {
                                //record ====================================1
                                //record
                                JSONObject finalRequest = new JSONObject();
                                finalRequest.put("username",AppUtils.getUserName(FpObservationActivity.this));
                                finalRequest.put("password",AppUtils.getPassword(FpObservationActivity.this));
                                JSONArray requests = new JSONArray();
                                JSONObject object = new JSONObject();
                                object.put("form_id",fpItem.id);
                                object.put("form_type","dh_familyplan");
                                JSONObject data = new JSONObject();
                                data.put("facility_id",toInt(fpItem.getFacility_id()));
                                data.put("sp_name",toQStr(fpItem.collector_name));
                                data.put("sp_designation",toQStr(fpItem.designation));
                                data.put("client_name",toQStr(fpItem.client_name));
                                data.put("serial_no",toInt(fpItem.serial_no));
                                data.put("date",toQStr(fpItem.date));
                                data.put("start_time",toQStr(fpItem.start_time));
                                data.put("concent",toQStr(fpItem.concent));
                                data.put("sound_prove",toBool(fpItem.sound_prove));
                                data.put("discuss_fp",toBool(fpItem.discuss_fp));
                                data.put("discuss_fp_protocol",toBool(fpItem.discuss_fp_protocol));
                                data.put("questions",toBool(fpItem.questions));
                                data.put("job_aid",toBool(fpItem.job_aid));
                                data.put("village",toQStr(fpItem.village));
                                data.put("district",toQStr(fpItem.district));
                                data.put("union",toQStr(fpItem.union));
                                data.put("sub_district",toQStr(fpItem.subdistrict));

                                object.put("data",data);
                                requests.put(object);
                                finalRequest.put("requests",requests);


                                params.put("data", finalRequest.toString());
                                Log.e("request: ",finalRequest.toString());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            return params;
                        }

                    };
                    dialog.show();
                    requestQueue.add(stringRequest);

                }

                break;
            case R.id.accept:
                progressDialog.setMessage("Please wait...");
                String url = "http://119.148.43.34/mamoni/survey/api/form";
                final  FpObservationFormItem fItem = FpObservationActivity.this.item;
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    progressDialog.dismiss();
                                    Log.d(".....>>>>>>>>>>", "response length" +response);
                                    JSONObject jsonObject = new JSONObject(response);
                                    int status;
                                    status= jsonObject.getInt("status");
                                    Log.d(".....>>>>>>>>>>", "response length" +status);
                                    FPObservationSupervisorTable t = new FPObservationSupervisorTable(FpObservationActivity.this);
                                    fItem.status =1;
                                    t.insert(fItem); //update db
                                    Toast.makeText(FpObservationActivity.this,"Successfully submitted",Toast.LENGTH_SHORT).show();
                                    finish();
                                }

                                catch (Exception e)
                                {

                                }
                                //   Toast.makeText(Supervisor_verificationActivity.this, response, Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                progressDialog.dismiss();
                                Toast.makeText(FpObservationActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                            }
                        }) {

                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        try {
                            //record ====================================1
                            //record
                            JSONObject requests = new JSONObject();
                            JSONArray jsonArray =new JSONArray();
                            JSONObject jf= new JSONObject();
                            JSONObject meta=new JSONObject();
                            meta.put("comments","");
                            meta.put("fields", "");
                            requests.put("meta",meta);
                            requests.put("submitted_by", fItem.submittedBy);
                            requests.put("form_id", fItem.id);
                            //og.d(".....>>>>>>>>>>", "response length      " + formItem1.getGlobal_id());
                            requests.put("form_type","dh_familyplan");
                            requests.put("status",1);
                            jsonArray.put(requests);

                            //data
                            JSONObject data = new JSONObject();
                            data.put("username", "supervisor");
                            data.put("password", "supervisor");
                            data.put("requests", jsonArray);
                            params.put("data", data.toString());
                        }
                        catch (Exception e){

                        }

                        return params;
                    }

                };

                requestQueue.add(stringRequest);
                progressDialog.show();
                break;
            case R.id.revert:
                generateFieldsBox();
                findViewById(R.id.commentSection).setVisibility(View.VISIBLE);
                break;
            case R.id.revert_cancel:
                findViewById(R.id.commentSection).setVisibility(View.GONE);
                break;
            case R.id.revert_submit:
                progressDialog.setMessage("Please wait...");
                url = "http://119.148.43.34/mamoni/survey/api/form";
                final FpObservationFormItem item2 = FpObservationActivity.this.item;
                StringRequest stringRequest2 = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    progressDialog.dismiss();
                                    Log.d(".....>>>>>>>>>>", "response length" +response);
                                    JSONObject jsonObject = new JSONObject(response);
                                    int status;
                                    status= jsonObject.getInt("status");
                                    Log.d(".....>>>>>>>>>>", "response length" +status);
                                    FPObservationSupervisorTable t = new FPObservationSupervisorTable(FpObservationActivity.this);
                                    item2.status =2;
                                    t.insert(item2); //update db
                                    Toast.makeText(FpObservationActivity.this,"Successfully submitted",Toast.LENGTH_SHORT).show();
                                    finish();
                                }

                                catch (Exception e)
                                {

                                }
                                //   Toast.makeText(Supervisor_verificationActivity.this, response, Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                progressDialog.dismiss();
                                Toast.makeText(FpObservationActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                            }
                        }) {

                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        try {
                            //record ====================================1
                            //record
                            JSONObject requests = new JSONObject();
                            JSONArray jsonArray =new JSONArray();
                            JSONObject jf= new JSONObject();
                            JSONObject meta=new JSONObject();
                            meta.put("comments",getComments());
                            meta.put("fields", getFields());
                            requests.put("meta",meta);
                            requests.put("submitted_by", item2.submittedBy);
                            requests.put("form_id", item2.id);
                            //og.d(".....>>>>>>>>>>", "response length      " + formItem1.getGlobal_id());
                            requests.put("form_type","dh_familyplan");
                            requests.put("status",2);
                            jsonArray.put(requests);

                            //data
                            JSONObject data = new JSONObject();
                            data.put("username", "supervisor");
                            data.put("password", "supervisor");
                            data.put("requests", jsonArray);
                            params.put("data", data.toString());
                        }
                        catch (Exception e){

                        }

                        return params;
                    }

                };

                requestQueue.add(stringRequest2);
                progressDialog.show();
                break;
        }
    }

    private String getFields(){
        LinearLayout fieldLayout = (LinearLayout) findViewById(R.id.fields);
        int len = fieldLayout.getChildCount();
        String str = "";
        for(int i=0;i<len;i++){
            QCheckBox checkBox = (QCheckBox) fieldLayout.getChildAt(i);
            if(checkBox.isChecked()){
                if(str.length() > 0){
                    str += ",";
                }
                str += checkBox.getText();
            }
        }
        return str;
    }
    private String getComments(){
        return ((EditText)findViewById(R.id.comment)).getText().toString();
    }
    private static String FIELDS[] = {"01","02","03","04","05","06","07","08","109"};
    private void generateFieldsBox(){
        LinearLayout fieldLayout = (LinearLayout) findViewById(R.id.fields);
        fieldLayout.removeAllViews();
        findViewById(R.id.revert_submit).setOnClickListener(this);
        findViewById(R.id.revert_cancel).setOnClickListener(this);
        for(int i=0;i<FIELDS.length;i++){
            QCheckBox checkBox = new QCheckBox(this);
            checkBox.setTextSize(25f);
            checkBox.setPadding(10,10,10,10);
            checkBox.setText(FIELDS[i]);
            fieldLayout.addView(checkBox);
        }
    }

    private String toQStr(String str){
        if(TextUtils.isEmpty(str)){
            return "";
        }
        return str;
    }


    private int toInt(String str){
        try{
            return Integer.parseInt(str);
        }catch(Exception e){
            return 0;
        }
    }

    private boolean toBool(String str){
        if(TextUtils.isEmpty(str)) return false;
        if(str.equals("true")){
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        onClickBtn(v);
    }
}
