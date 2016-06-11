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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
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
import caresurvey.sci.com.caresurvey.database.SickChildTable;
import caresurvey.sci.com.caresurvey.model.SickChildItem;
import caresurvey.sci.com.caresurvey.utils.AppUtils;

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
            item = table.get(mIntent.getIntExtra(DisplayUserActivity.FORM_ID,0));
        }
        else{
            item = new SickChildItem();
            item.name = mIntent.getStringExtra("name");
            item.designation = mIntent.getStringExtra("designation");
            item.collector_name = mIntent.getStringExtra("c_name");
            item.upozila = mIntent.getStringExtra("upozila");
            item.union = mIntent.getStringExtra("union");
            item.village = mIntent.getStringExtra("village");
            item.serial_no = item.facility_id = mIntent.getStringExtra("serial");
            item.datepick = mIntent.getStringExtra("datepicker");
            item.timepick = mIntent.getStringExtra("timepicker");
            item.facility = mIntent.getStringExtra("facility");
            item.obs_type = mIntent.getStringExtra("obstype");
            item.district = mIntent.getStringExtra("district");
        }
        findViewById(R.id.insert).setOnClickListener(this);
        findViewById(R.id.submit).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);

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
        item.serial_no = gETv(R.id.serial_no);
        item.form_date = gETv(R.id.form_date);
        item.start_time = gETv(R.id.start_time);
        item.child_description = gSPi(R.id.child_description);
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
        item.circle = gRGv(R.id.circle);
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
        sRGv(R.id.dehydration,item.dehydration);
        sRGv(R.id.weight,item.weight);
        sRGv(R.id.circle,item.circle);
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
                long id = table.insertItem(item);
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
                long id = table.insertItem(item);
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
                    fs.put("form_id",2);
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
}
