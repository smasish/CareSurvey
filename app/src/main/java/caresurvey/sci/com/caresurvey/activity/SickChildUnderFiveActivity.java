package caresurvey.sci.com.caresurvey.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
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
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.SickChildSupervisorTable2;
import caresurvey.sci.com.caresurvey.database.SickChildTable;
import caresurvey.sci.com.caresurvey.model.SickChildItem;
import caresurvey.sci.com.caresurvey.utils.AppUtils;
import caresurvey.sci.com.caresurvey.widgets.QCheckBox;

/**
 * Created by shantanu on 6/1/16.
 */
public class SickChildUnderFiveActivity extends AppCompatActivity implements View.OnClickListener {
    private SickChildItem  item;
    private SickChildTable table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test12);
        Intent mIntent = getIntent();
        table = new SickChildTable(this);
        if(mIntent.hasExtra(DisplayUserActivity.FORM_ID)) { //alreay have one
            if(mIntent.hasExtra(SurveyActivity.FROM_ADMIN)){
                editable(false);
                findViewById(R.id.admin_btn_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.user_btn_layout).setVisibility(View.GONE);
                SickChildSupervisorTable2 supervisorTable = new SickChildSupervisorTable2(this);
                item = supervisorTable.get(mIntent.getLongExtra(DisplayUserActivity.FORM_ID,0L));
            }
            else {
                findViewById(R.id.user_btn_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.admin_btn_layout).setVisibility(View.GONE);
                item = table.get(mIntent.getLongExtra(DisplayUserActivity.FORM_ID, 0));
            }
        }
        else{
            item = new SickChildItem();
            item.name = mIntent.getStringExtra("name");
            item.so_designation = item.designation = mIntent.getStringExtra("designation");
            item.sp_client = item.collector_name = mIntent.getStringExtra("c_name");
            item.upozila = mIntent.getStringExtra("upozila");
            item.union = mIntent.getStringExtra("union");
            item.village = mIntent.getStringExtra("village");
            item.child_description = mIntent.getStringExtra("description");
            item.serial_no = item.facility_id = mIntent.getStringExtra("serial");
            item.form_date = item.datepick = mIntent.getStringExtra("datepicker");
            item.start_time = item.timepick = mIntent.getStringExtra("timepicker");
            item.facility = mIntent.getStringExtra("facility");
            item.obs_type = mIntent.getStringExtra("obstype");
            item.district = mIntent.getStringExtra("district");
        }
        findViewById(R.id.insert).setOnClickListener(this);
        findViewById(R.id.submit).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.accept).setOnClickListener(this);
        findViewById(R.id.revert).setOnClickListener(this);

        loadForm();
    }



    private void sETv(int id,String val){
        EditText et = (EditText) findViewById(id);
        if(et != null){
            et.setText(val);
        }
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

    void collectForm() throws Exception {
//        item.serial_no = gETv(R.id.serial_no);
//        item.form_date = gETv(R.id.form_date);
//        item.start_time = gETv(R.id.start_time);
//        item.child_description = gSPi(R.id.child_description);
        item.age = gETv(R.id.age);
        if(gRBv(R.id.day)){
            item.age += " day";
        }
        else if(gRBv(R.id.month)){
            item.age += " month";
        }
        else if(gRBv(R.id.year)){
            item.age += " year";
        }
        item.feed = gRGv(R.id.feed);
        item.vomit = gRGv(R.id.vomit);
        item.stutter = gRGv(R.id.stutter);
        item.cough = gRGv(R.id.cough);
        item.diahorea = gRGv(R.id.diahorea);
        item.fever = gRGv(R.id.fever);
        item.measure_fever = gRGv(R.id.measure_fever);
        item.stethoscope = gRGv(R.id.stethoscope);
        item.breathing_test = gRGv(R.id.breathing_test);
        item.eye_test = gRGv(R.id.eye_test);
        item.infected_mouth = gRGv(R.id.infected_mouth);
        item.neck = gRGv(R.id.neck);
        item.ear = gRGv(R.id.ear);
        item.hand = gRGv(R.id.hand);
        item.dehydration = gRGv(R.id.dehydration);
        item.weight = gRGv(R.id.weight);
        item.clinic_test = gRGv(R.id.clinic_test);
        item.belly_button = gRGv(R.id.belly);
        item.height = gRGv(R.id.height);
        item.bmi = gRGv(R.id.bmi);
        item.result = gCBsv(R.id.checkBox1);
        item.result += ","+gCBsv(R.id.checkBox2);
        item.result += ","+gCBsv(R.id.checkBox3);
        item.result += ","+gCBsv(R.id.checkBox4);
        item.result += ","+gCBsv(R.id.checkBox5);
        item.end_time = gETv(R.id.end_time);
        item.end_time = AppUtils.getTime(); //update end time when load
        sETv(R.id.end_time,item.end_time);
    }

    private boolean gRBv(int id) {
        RadioButton btn = (RadioButton) findViewById(id);
        return btn.isChecked();
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
        sETv(R.id.serial_no,item.serial_no);
        sETv(R.id.form_date,item.form_date);
        sETv(R.id.start_time,item.start_time);
        sSPi(R.id.child_description, item.child_description);
        sETv(R.id.age,getAge(item.age));
        sETv(R.id.end_time,item.end_time);
        String ageType = getAgeType(item.age);
        if(ageType.equals("day")){
            sRBv(R.id.day, true);
        }
        else if(ageType.equals("month")){
            sRBv(R.id.month,true);
        }
        else if(ageType.equals("year")){
            sRBv(R.id.year,true);
        }
        sRGv(R.id.feed,item.feed);
        sRGv(R.id.vomit,item.vomit);
        sRGv(R.id.stutter,item.stutter);
        sRGv(R.id.cough,item.cough);
        sRGv(R.id.diahorea,item.diahorea);
        sRGv(R.id.fever,item.fever);
        sRGv(R.id.measure_fever,item.measure_fever);
        sRGv(R.id.stethoscope,item.stethoscope);
        sRGv(R.id.breathing_test,item.breathing_test);
        sRGv(R.id.eye_test,item.eye_test);
        sRGv(R.id.infected_mouth,item.infected_mouth);
        sRGv(R.id.neck,item.neck);
        sRGv(R.id.ear,item.ear);
        sRGv(R.id.hand,item.hand);
        sRGv(R.id.dehydration,item.dehydration);
        sRGv(R.id.weight,item.weight);
        sRGv(R.id.clinic_test,item.clinic_test);
        sRGv(R.id.belly,item.belly_button);
        sRGv(R.id.height,item.height);
        sRGv(R.id.bmi,item.bmi);
        if(item.result != null) {
            String tokens[] = item.result.split(",");
            int ids[] = new int[]{R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4, R.id.checkBox5};
            for (int i = 0; i < tokens.length; i++) {
                sCBv(ids[i], tokens[i].trim());
            }
        }
    }

    private void editable(boolean state){
        sVEs(R.id.serial_no,state);
        sVEs(R.id.form_date,state);
        sVEs(R.id.start_time,state);
        sVEs(R.id.child_description, state);
        sVEs(R.id.age,state);
        sVEs(R.id.end_time,state);
        sVEs(R.id.day, state);
        sVEs(R.id.month,state);
        sVEs(R.id.year,state);
        sRGs(R.id.feed,state);
        sRGs(R.id.vomit,state);
        sRGs(R.id.stutter,state);
        sRGs(R.id.cough,state);
        sRGs(R.id.diahorea,state);
        sRGs(R.id.fever,state);
        sRGs(R.id.measure_fever,state);
        sRGs(R.id.stethoscope,state);
        sRGs(R.id.breathing_test,state);
        sRGs(R.id.eye_test,state);
        sRGs(R.id.infected_mouth,state);
        sRGs(R.id.neck,state);
        sRGs(R.id.ear,state);
        sRGs(R.id.hand,state);
        sRGs(R.id.dehydration,state);
        sRGs(R.id.weight,state);
        sRGs(R.id.clinic_test,state);
        sRGs(R.id.belly,state);
        sRGs(R.id.height,state);
        sRGs(R.id.bmi,state);
        sVEs(R.id.checkBox1,state);
        sVEs(R.id.checkBox2,state);
        sVEs(R.id.checkBox3,state);
        sVEs(R.id.checkBox4,state);
        sVEs(R.id.checkBox5,state);
    }

    private void sVEs(int id, boolean state){
        findViewById(id).setEnabled(state);
    }

    private void sRGs(int id,boolean state){
        RadioGroup radioGroup = (RadioGroup) findViewById(id);
        for(int i=0;i<radioGroup.getChildCount();i++){
            RadioButton btn = (RadioButton) radioGroup.getChildAt(i);
            btn.setEnabled(state);
        }
    }

    private void sCBv(int id, String val) {
        if(val == null) return;
        CheckBox chBox = (CheckBox) findViewById(id);
        if(val.equals("1")){
            chBox.setChecked(true);
        }
        else if(val.equals("0")){
            chBox.setChecked(false);
        }
    }

    private void sRGv(int id, String value) {
        if(value == null) return;
        RadioGroup btn = (RadioGroup) findViewById(id);
        if(value.equals("true")){
            ((RadioButton)btn.getChildAt(0)).setChecked(true);
        }
        else if(value.equals("false")){
            ((RadioButton)btn.getChildAt(1)).setChecked(true);
        }
    }

    private void sRBv(int id, boolean value) {
        RadioButton btn = (RadioButton) findViewById(id);
        btn.setChecked(value);
    }

    private String getAge(String str){
        if(str == null) return "";
        String tokens[] = str.split(" ");
        if(tokens.length > 0){
            return tokens[0].trim();
        }
        return "";
    }

    private String getAgeType(String str){
        if(str == null) return "";
        String tokens[] = str.split(" ");
        if(tokens.length == 2){
            return tokens[1].trim();
        }
        return "";
    }

    private String gCBsv(int id){
        CheckBox ch = (CheckBox) findViewById(id);
        if(ch.isChecked()) return "1";
        return "0";
    }
    private boolean gCBv(int id){
        CheckBox ch = (CheckBox) findViewById(id);
        return ch.isChecked();
    }

    private String gRGv(int id) throws Exception {
        RadioGroup radioGroup = (RadioGroup) findViewById(id);
        int rbId = radioGroup.getCheckedRadioButtonId();
        if(rbId == -1) throw new Exception();
        if(radioGroup.getChildAt(0).getId() == rbId){
            return "true";
        }
        else{
            return "false";
        }
    }

    private String gETv(int id) {
        EditText text = (EditText) findViewById(id);
        return text.getText().toString();
    }

    private String gSPi(int id) throws Exception {
        Spinner sp = (Spinner) findViewById(id);
        int selection = sp.getSelectedItemPosition();
        if(selection == 0) throw new Exception();
        return Integer.toString(selection);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.insert){
            try{
                collectForm();
                long id = table.insert(item);
                if(id > 0) {
                    Toast.makeText(this, "Form saved successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(this,"Form is not complete",Toast.LENGTH_SHORT).show();
            }
        }
        else if(v.getId() == R.id.back){
            finish();
        }
        else if(v.getId() == R.id.submit){
            try{
                collectForm();
                if(item.status == 2){ //reverted
                    item.status = 4;
                }
                long id = table.insert(item);
                if(id == -1){
                    Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT).show();
                    return;
                }
                submit();
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(this,"Form is not complete",Toast.LENGTH_SHORT).show();
            }
        }
        else if(v.getId() == R.id.accept){
            final ProgressDialog progressDialog = new ProgressDialog(SickChildUnderFiveActivity.this);
            progressDialog.setMessage("Please wait...");
            String url = "http://119.148.43.34/mamoni/survey/api/form";
            final SickChildItem fItem = SickChildUnderFiveActivity.this.item;
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
                                SickChildSupervisorTable2 t = new SickChildSupervisorTable2(SickChildUnderFiveActivity.this);
                                fItem.status =1;
                                t.insert(fItem); //update db
                                Toast.makeText(SickChildUnderFiveActivity.this,"Successfully submitted",Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(SickChildUnderFiveActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                        requests.put("form_type","dh_sickchild");
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

            RequestQueue requestQueue = Volley.newRequestQueue(SickChildUnderFiveActivity.this);
            requestQueue.add(stringRequest);
            progressDialog.show();
        }
        else if(v.getId() == R.id.revert){
            generateFieldsBox();
            findViewById(R.id.commentSection).setVisibility(View.VISIBLE);
        }
        else if(v.getId() == R.id.revert_cancel){
            findViewById(R.id.commentSection).setVisibility(View.GONE);
        }
        else if(v.getId() == R.id.revert_submit){
            final ProgressDialog progressDialog = new ProgressDialog(SickChildUnderFiveActivity.this);
            progressDialog.setMessage("Please wait...");
            String url = "http://119.148.43.34/mamoni/survey/api/form";
            final SickChildItem fItem = SickChildUnderFiveActivity.this.item;
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
                                SickChildSupervisorTable2 t = new SickChildSupervisorTable2(SickChildUnderFiveActivity.this);
                                fItem.status =2;
                                t.insert(fItem); //update db
                                Toast.makeText(SickChildUnderFiveActivity.this,"Successfully submitted",Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(SickChildUnderFiveActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                        requests.put("submitted_by", fItem.submittedBy);
                        requests.put("form_id", fItem.id);
                        //og.d(".....>>>>>>>>>>", "response length      " + formItem1.getGlobal_id());
                        requests.put("form_type","dh_sickchild");
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

            RequestQueue requestQueue = Volley.newRequestQueue(SickChildUnderFiveActivity.this);
            requestQueue.add(stringRequest);
            progressDialog.show();
        }
    }

    private void submit(){
        final SickChildItem sickChildItem = item;
        String url = "http://119.148.43.34/mamoni/survey/api/form";
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait...");
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        dialog.dismiss();

                        try {
                            JSONObject jo = new JSONObject(response);
                            Log.e("response:", response);
                            if(jo.has("errorCount")){
                                alert.setMessage(jo.getString("message"));
                                if(jo.getInt("errorCount") == 0){
                                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                            if(item.status == 7) //incomplete
                                            {
                                                item.status = 3;//pending
                                                table.insert(item);
                                            }
                                            finish();
                                        }
                                    });
                                }

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
//                            Toast.makeText(SateliteClinicInventoryActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                    JSONArray requests = new JSONArray();
//                            JSONArray jsonArray =new JSONArray();
                    JSONObject jf= new JSONObject();
                    JSONObject fs=new JSONObject();



                    fs.put("form_type", "dh_sickchild");
                    fs.put("form_id",sickChildItem.id);
                    jf.put("facility_id",sickChildItem.getFacility_id());
                    jf.put("sp_client",sickChildItem.getSp_client());
                    jf.put("sp_designation",sickChildItem.getSo_designation());
                    jf.put("seral_no",sickChildItem.getSerial_no());
                    jf.put("form_date",sickChildItem.getForm_date());
                    jf.put("start_time",sickChildItem.getStart_time());
                    jf.put("child_description",sickChildItem.getChild_description());
                    jf.put("age",sickChildItem.getAge());
                    jf.put("feed",sickChildItem.getFeed());
                    jf.put("vomit",sickChildItem.getVomit());
                    jf.put("stutter",sickChildItem.getStutter());
                    jf.put("cough",sickChildItem.getCough());
                    jf.put("diaria",sickChildItem.getDiahorea());
                    jf.put("fever",sickChildItem.getFever());
                    jf.put("measure_fever",sickChildItem.getMeasure_fever());
                    jf.put("stethoscope",sickChildItem.getStethoscope());
                    jf.put("breathing_test",sickChildItem.getBreathing_test());
                    jf.put("eye_test",sickChildItem.getEye_test());
                    jf.put("infected_mouth",sickChildItem.getInfected_mouth());
                    jf.put("neck",sickChildItem.getNeck());
                    jf.put("ear",sickChildItem.getEar());
                    jf.put("hand",sickChildItem.getHand());
                    jf.put("dehydration",sickChildItem.getDehydration());
                    jf.put("weight",sickChildItem.getWeight());
                    jf.put("clinic_test",sickChildItem.getClinic_test());
                    jf.put("belly_button",sickChildItem.getBelly_button());
                    jf.put("height",sickChildItem.getHeight());
//                    jf.put("bmi",sickChildItem.bmi);
                    jf.put("result",sickChildItem.getResult());
                    jf.put("end_time",sickChildItem.getEnd_time());
                    jf.put("village",sickChildItem.getVillage());
                    jf.put("district",sickChildItem.getDistrict());
                    jf.put("union",sickChildItem.getUnion());
                    jf.put("sub_district",sickChildItem.getSub_district());
                    fs.put("data",jf);
                    requests.put(fs);





                    //record ====================================2
                    //record
                    JSONObject record2 = new JSONObject();
                    record2.put("hemoglobintest", true);
                    record2.put("urinetest", true);


                    //request
//                            JSONObject request2 = new JSONObject();
//                            request2.put("type", add_update);
//                            request2.put("form_type", "dh_sickchild");
                    //       request2.put("data", record);


                    //requests


                    //data
                    JSONObject data = new JSONObject();
                    data.put("username", AppUtils.getUserName(SickChildUnderFiveActivity.this));
                    data.put("password", AppUtils.getPassword(SickChildUnderFiveActivity.this));
                    data.put("requests", requests);
                    Log.e("request: ", data.toString());
                    params.put("data", data.toString());
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                return params;
            }

        };

// Adding request to request queue

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

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
    private static String FIELDS[] = {"105","105-1","106-1","106-2","106-3","107-1","107-2","107-3","108-1"
            ,"108-2","108-3","108-4","108-5","108-6","108-7","108-8","108-9","108-10","108-11","108-12","108-13"
            ,"108-14","109","110"};
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

}
