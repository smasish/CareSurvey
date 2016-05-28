package caresurvey.sci.com.caresurvey.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.FormTableUser;
import caresurvey.sci.com.caresurvey.database.FpObservationTable;
import caresurvey.sci.com.caresurvey.model.FormItemUser;
import caresurvey.sci.com.caresurvey.model.FpObservationFormItem;
import caresurvey.sci.com.caresurvey.utils.AppUtils;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

/**
 * Created by Shahin on 5/4/2016.
 */
public class FpObservationActivity extends AppCompatActivity {
    private TextView mFp101TextView, mFp102TextView, mFp103TextView, mFp104TextView;
    private EditText mFp101EditText, mFp102EditText, mFp103EditText, mFp104EditText;
    private View mFpQuesView1, mFpQuesView2, mFpQuesView3, mFpQuesView4, mFpQuesView5, mFpQuesView6, mFpQuesView7, mFpQuesView8;
    private String names;
    private int mark;
    private String collector_name;
    private String upozila;
    private String union;
    private String village;
    private String datespicker;
    private String timepicker;
    private String facility;
    private String obsType;
    private FpObservationTable table;
    private long formID = 0;
    private String designation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp_observation);
        table = new FpObservationTable(this);
        initIncludedViews();
        initQuestion();

        Intent mIntent = getIntent();
        names = mIntent.getStringExtra("name");
        designation = mIntent.getStringExtra("designation");
        mark = mIntent.getIntExtra("mark", 0);
        collector_name = mIntent.getStringExtra("c_name");
        upozila = mIntent.getStringExtra("upozila");
        union = mIntent.getStringExtra("union");
        village = mIntent.getStringExtra("village");


        datespicker = mIntent.getStringExtra("datepicker");
        timepicker = mIntent.getStringExtra("timepicker");
        facility = mIntent.getStringExtra("facility");
        obsType = mIntent.getStringExtra("obstype");
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

    private FpObservationFormItem collectAnswers() {
        FpObservationFormItem mFpObservationFormItem = new FpObservationFormItem();
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
        if(TextUtils.isEmpty(( mFpObservationFormItem.date = getEString(R.id.et_fp_102) ))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty(( mFpObservationFormItem.start_time = getEString(R.id.et_fp_103) ))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty(( mFpObservationFormItem.client_name = getEString(R.id.et_fp_104) ))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty(( mFpObservationFormItem.end_time = getEString(R.id.et_fp_109) ))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        mFpObservationFormItem.status = 3; //pending
        mFpObservationFormItem.name = names;
        mFpObservationFormItem.collector_name = collector_name;
        mFpObservationFormItem.upozila = upozila;
        mFpObservationFormItem.union = union;
        mFpObservationFormItem.village = village;
        mFpObservationFormItem.datepick = datespicker;
        mFpObservationFormItem.timepick = timepicker;
        mFpObservationFormItem.facility = facility;
        mFpObservationFormItem.obs_type = obsType;
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
        switch (view.getId()) {
            case R.id.back:
                Intent start = new Intent(FpObservationActivity.this, DisplayUserActivity.class);
                start.putExtra("fp", "fp");
                startActivity(start);
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
                final ProgressDialog dialog = new ProgressDialog(this);
                dialog.setMessage("Please wait...");
                final AlertDialog.Builder alert = new AlertDialog.Builder(FpObservationActivity.this);
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                if(fpItem != null) {
                    String url = "http://www.kolorob.net/mamoni/survey/api/form";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {

                                @Override
                                public void onResponse(String response) {
                                    dialog.dismiss();

                                    try {
                                        JSONObject jo = new JSONObject(response);
                                        if(jo.has("errorCount")){
                                            alert.setMessage(jo.getString("message"));
                                        }
                                        else{
                                            alert.setMessage("Invalid response");
                                        }
                                        alert.show();

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        alert.setMessage("An error occurred")   ;
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
                                finalRequest.put("username","collector");
                                finalRequest.put("password","collector");
                                JSONArray requests = new JSONArray();
                                JSONObject object = new JSONObject();
                                object.put("form_id",formID);
                                object.put("form_type","dh_familyplan");
                                JSONObject data = new JSONObject();
                                data.put("facility_id",toInt(fpItem.getFacility_id()));
                                data.put("sp_name",toQStr(collector_name));
                                data.put("sp_designation",toQStr(designation));
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
                    RequestQueue requestQueue = Volley.newRequestQueue(FpObservationActivity.this);
                    requestQueue.add(stringRequest);

                }

                break;
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
}
