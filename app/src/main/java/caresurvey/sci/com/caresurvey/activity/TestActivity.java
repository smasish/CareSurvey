package caresurvey.sci.com.caresurvey.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.ANCSupervisorTable;
import caresurvey.sci.com.caresurvey.database.ANCTable;
import caresurvey.sci.com.caresurvey.model.ANCFormItem;
import caresurvey.sci.com.caresurvey.utils.AppUtils;
import caresurvey.sci.com.caresurvey.widgets.QCheckBox;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {


    String add_update, names, datespicker, timepicker, upozila, union, village, facility, obsname;
    int intValue, mark, intvalue2;
    ArrayList<String> form;
    Button Save, Submit, back;
    LinearLayout test;
    String collector_name, username, password;

    String date;
    public String bl_status, hem_status, uri_status, pregfood_status, pregdan_status, four_status, del_status, feed_status, six_status, family_status, foltab_status, folimp_status;
    int i = 0;
    RadioGroup bloodpressure, hemoglobintest,
            urinetest, pregnancyfood, pregnancydanger,
            fourparts, delivery, feedbaby,
            sixmonths, familyplanning, folictablet,
            folictabletimportance;

    // int id=intValue;
    String global_ida;

    ArrayList<ANCFormItem> formItemAll;
    private ANCFormItem item;
    private ANCTable table;

    TextView tv1, tv2, tv3, comment, field;
    private String district;
    private long formID;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test1);
//        test = (LinearLayout) findViewById(R.id.commentSection);
//        Save = (Button) findViewById(R.id.Savebtn);
//        Submit = (Button) findViewById(R.id.Submit);
//        bloodpressure = (RadioGroup) findViewById(R.id.bloodpressure);
//        hemoglobintest = (RadioGroup) findViewById(R.id.hemoglobintest);
//        urinetest = (RadioGroup) findViewById(R.id.urinetest);
//        pregnancyfood = (RadioGroup) findViewById(R.id.pregnancyfood);
//        pregnancydanger = (RadioGroup) findViewById(R.id.pregnancydanger);
//        fourparts = (RadioGroup) findViewById(R.id.fourparts);
//        delivery = (RadioGroup) findViewById(R.id.delivery);
//        feedbaby = (RadioGroup) findViewById(R.id.feedbaby);
//        sixmonths = (RadioGroup) findViewById(R.id.sixmonths);
//        familyplanning = (RadioGroup) findViewById(R.id.familyplanning);
//        folictablet = (RadioGroup) findViewById(R.id.folictablet);
//        folictabletimportance = (RadioGroup) findViewById(R.id.folictabletimportance);
//        comment = (TextView) findViewById(R.id.comment);
//        field = (TextView) findViewById(R.id.field);
//        tv1 = (TextView) findViewById(R.id.textView3);
//        Intent mIntent = getIntent();
//        intValue = mIntent.getIntExtra("id", 0);
//        names = mIntent.getStringExtra("name");
//        mark = mIntent.getIntExtra("mark", 0);
//        collector_name = mIntent.getStringExtra("c_name");
//        upozila = mIntent.getStringExtra("upozila");
//        union = mIntent.getStringExtra("union");
//        village = mIntent.getStringExtra("village");
//        district = mIntent.getStringExtra("district");
//        datespicker = mIntent.getStringExtra("datepicker");
//        timepicker = mIntent.getStringExtra("timepicker");
//        facility = mIntent.getStringExtra("facility");
//        if (intValue == 0)
//            intValue = 1;
//
//        intvalue2 = intValue;
//        intvalue2++;
//
//        SharedPreferences pref = this.getSharedPreferences("MyPref", MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
//        // Toast.makeText(getApplicationContext(), "Now I am in onResume ", Toast.LENGTH_SHORT).show();
//
//        username = pref.getString("username", null);
//        password = pref.getString("password", null);
//
//
//        Log.d("Status.......", "response length" + intValue);
//        if (mark == 1) {
//            test.setVisibility(View.GONE);
//            Save.setText("Insert");
//        }
//        // names = mIntent.getStringExtra("name");
//        Log.d(".....>>>>>>>>>>", "Id in TestActivity  " + intValue);
//        Log.d(".....>>>>>>>>>>", "response length" + names);
//        ArrayList<FormItemUser> formItems;
//        ArrayList<FormItemUser> formItems1;
//        ArrayList<FormItemUser> formItems2;
//        final FormTableUser formTable = new FormTableUser(TestActivity.this);
//        formItems = formTable.getSpecificItem(intValue);
//        formItems1 = formTable.getSpecificItem(intValue);
//        FormItemUser formItem;
//        Save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                StorevaluesinVar();
//
//                int status = 6;
//                String global_id = "1";
//                String name = names;
//                String comments = "";
//                String fields = "";
////                FormItemUser formItem = new FormItemUser(1, bl_status, hem_status, uri_status, pregfood_status, pregdan_status, four_status
////                        , del_status, feed_status, six_status, family_status, foltab_status, folimp_status,status,global_id,name,comments,fields);
//
//
//                FormTableUser formTable = new FormTableUser(TestActivity.this);
//                try {
//                    if (mark == 1) {
//                        if ((formTable.updateItemq(intValue, bl_status, hem_status, uri_status, pregfood_status, pregdan_status, four_status
//                                , del_status, feed_status, six_status, family_status, foltab_status, folimp_status, status, names, datespicker, timepicker, collector_name, facility, upozila, union, village)) == 1) {
//
//                            Toast.makeText(getApplicationContext(), "Data Inserted successfully for patient  " + name, Toast.LENGTH_SHORT).show();
//                            savevalue();
//                            Intent intent = new Intent(TestActivity.this, DisplayUserActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }
//                    } else {
//
//
//                        ArrayList<FormItemUser> formTableUsers;
//                        FormTableUser formTableUser = new FormTableUser(TestActivity.this);
//
//                        formTableUsers = formTableUser.dateconcate(intValue);
//
//                        for (FormItemUser formItemUser : formTableUsers) {
//                            date = formItemUser.getDatepick();
//                        }
//                        Calendar c = Calendar.getInstance();
//                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//                        String current_date = df.format(c.getTime());
//                        //  String current_date1= current_date.toString();
//
//                        String addspace = date.concat(" ");
//                        String dateconcate = addspace.concat(String.valueOf(current_date));
//
//
//                        if ((formTable.updatefor(intValue, bl_status, hem_status, uri_status, pregfood_status, pregdan_status, four_status
//                                , del_status, feed_status, six_status, family_status, foltab_status, folimp_status, status, dateconcate)) == 1) {
//
//                            Toast.makeText(getApplicationContext(), "Data Updated successfully ", Toast.LENGTH_SHORT).show();
//
//                            Intent intent = new Intent(TestActivity.this, DisplayUserActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }
//                    }
//                } catch (Exception e) {
//
//                }
//            }
//        });
//
//
//        for (FormItemUser ft : formItems) {
//            if (ft.getBloodpressure().equals("Yes"))
//                bloodpressure.check(R.id.ques1rad1);
//            else
//                bloodpressure.check(R.id.ques1rad2);
//
//            if (ft.getHemoglobintest().equals("Yes"))
//                hemoglobintest.check(R.id.radioButton3);
//            else
//                hemoglobintest.check(R.id.radioButton4);
//
//            if (ft.getUrinetest().equals("Yes"))
//                urinetest.check(R.id.radioButton);
//            else
//                urinetest.check(R.id.radioButton2);
//            if (ft.getPregnancyfood().equals("Yes"))
//                pregnancyfood.check(R.id.radioButton5);
//            else
//                pregnancyfood.check(R.id.radioButton6);
//
//            if (ft.getPregnancydanger().equals("Yes"))
//                pregnancydanger.check(R.id.radioButton7);
//            else
//                pregnancydanger.check(R.id.radioButton8);
//
//            if (ft.getFourparts().equals("Yes"))
//                fourparts.check(R.id.radioButton9);
//            else
//                fourparts.check(R.id.radioButton10);
//
//            if (ft.getDelivery().equals("Yes"))
//                delivery.check(R.id.radioButton11);
//            else
//                delivery.check(R.id.radioButton12);
//
//            if (ft.getFeedbaby().equals("Yes"))
//                feedbaby.check(R.id.radioButton13);
//            else
//                feedbaby.check(R.id.radioButton14);
//
//            if (ft.getSixmonths().equals("Yes"))
//                sixmonths.check(R.id.radioButton15);
//            else
//                sixmonths.check(R.id.radioButton16);
//
//            if (ft.getFamilyplanning().equals("Yes"))
//                familyplanning.check(R.id.radioButton17);
//            else
//                familyplanning.check(R.id.radioButton18);
//
//            if (ft.getFolictablet().equals("Yes"))
//                folictablet.check(R.id.radioButton19);
//            else
//                folictablet.check(R.id.radioButton20);
//            if (!ft.getComments().equals("")) {
//                comment.setVisibility(View.VISIBLE);
//                comment.setText(ft.getComments());
//
//            }
//
//            if (ft.getStatus() == 1)
//                test.setVisibility(View.INVISIBLE);
//
//            if (!ft.getFields().equals("")) {
//                field.setVisibility(View.VISIBLE);
//                field.setText(ft.getFields());
//
//            }
//
//            if (ft.getFolictabletimportance().equals("Yes"))
//                folictabletimportance.check(R.id.radioButton21);
//            else
//                folictabletimportance.check(R.id.radioButton22);
//        }
//        back = (Button) findViewById(R.id.back);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent back = new Intent(TestActivity.this, DisplayUserActivity.class);
//                startActivity(back);
//                finish();
//            }
//        });
//
//
//        Submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                FormTableUser formTableUser = new FormTableUser(TestActivity.this);
//                formTableUser.updateIns("2", intValue);
//                formItemAll = formTable.getSpecificItem(intValue);
//                String tag_json_obj = "json_obj_req";
//                String url = "http://119.148.43.34/mamoni/survey/api/form";
//                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                try {
//                                    JSONObject jo = new JSONObject(response);
//                                    Log.d(".....>>>>>>>>>>", "Status " + jo);
//                                    String status = jo.getString("status");
//                                    if (status.equals("2")) {
//                                        FormTableUser formtableuser = new FormTableUser(TestActivity.this);
//                                        formtableuser.updateglobalI(intValue, 3);
//                                        Save.setVisibility(View.GONE);
////                                        Intent intentw = new Intent(TestActivity.this, DisplayUserActivity.class);
////                                        startActivity(intentw);
//                                        finish();
//                                    }
//
//                                } catch (Exception e) {
//                                }
//                                //  Toast.makeText(TestActivity.this,response,Toast.LENGTH_SHORT).show();
//                            }
//                        },
//                        new Response.ErrorListener() {
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//                                //    Toast.makeText(TestActivity.this,error.toString(),Toast.LENGTH_LONG).show();
//                            }
//                        }) {
//
//                    @Override
//                    protected Map<String, String> getParams() {
//
//
//                        Map<String, String> params = new HashMap<>();
//
//                        try {
//                            //record ====================================1
//                            //record
//                            JSONArray requests = new JSONArray();
////                            JSONArray jsonArray =new JSONArray();
//                            for (FormItemUser formItem1 : formItemAll) {
//                                JSONObject jf = new JSONObject();
//                                JSONObject fs = new JSONObject();
//
//
//                                fs.put("form_type", "dh_antenantals");
//                                fs.put("form_id", intValue);
//                                jf.put("hemoglobintest", formItem1.getHemoglobintest());
//                                jf.put("bloodpressure", formItem1.getBloodpressure());
//                                jf.put("urinetest", formItem1.getUrinetest());
//                                jf.put("pregnancyfood", formItem1.getPregnancyfood());
//                                jf.put("pregnancydanger", formItem1.getPregnancydanger());
//                                jf.put("fourparts", formItem1.getFourparts());
//                                jf.put("delivery", formItem1.getDelivery());
//                                jf.put("feedbaby", formItem1.getFeedbaby());
//                                jf.put("sixmonths", formItem1.getSixmonths());
//                                jf.put("familyplanning", formItem1.getFamilyplanning());
//                                jf.put("folictablet", formItem1.getFolictablet());
//                                jf.put("folictabletimportance", formItem1.getFolictabletimportance());
//                                jf.put("patient_name", formItem1.getName());
//                                jf.put("district", formItem1.getDivision());
//                                jf.put("sub_district", formItem1.getUpozila());
//                                jf.put("union", formItem1.getUnion());
//                                jf.put("village", formItem1.getVillage());
//
//
//                                fs.put("data", jf);
//
//
//                                requests.put(fs);
//
//
//                            }
//
//
//                            //      jsonArray.put(formItemAll);
////                            JSONObject record = new JSONObject();
////                            record.put("hemoglobintest", false);
////                            record.put("urinetest", false);
//
//
//                            //request
//                            JSONObject request = new JSONObject();
//                            request.put("type", add_update);
//                            request.put("form_type", "dh_antenantals");
//                            request.put("data", formItemAll);
//
//
//                            //record ====================================2
//                            //record
//                            JSONObject record2 = new JSONObject();
//                            record2.put("hemoglobintest", true);
//                            record2.put("urinetest", true);
//
//
//                            //request
//                            JSONObject request2 = new JSONObject();
//                            request2.put("type", add_update);
//                            request2.put("form_type", "dh_antenantals");
//                            //       request2.put("data", record);
//
//
//                            //requests
//
//
//                            //data
//                            JSONObject data = new JSONObject();
//                            data.put("username", username);
//                            data.put("password", password);
//                            data.put("requests", requests);
//
//                            params.put("data", data.toString());
//                        } catch (Exception e) {
//
//                        }
//
//                        return params;
//                    }
//
//                };
//
//// Adding request to request queue
//
//                RequestQueue requestQueue = Volley.newRequestQueue(TestActivity.this);
//                requestQueue.add(stringRequest);
//            }
//        });
//
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        Intent mIntent = getIntent();
        table = new ANCTable(this);
        if(mIntent.hasExtra(DisplayUserActivity.FORM_ID)) { //alreay have one
            if(mIntent.hasExtra(SurveyActivity.FROM_ADMIN)){
                editable(false);
                findViewById(R.id.admin_btn_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.user_btn_layout).setVisibility(View.GONE);
                ANCSupervisorTable supervisorTable = new ANCSupervisorTable(this);
                item = supervisorTable.get(mIntent.getLongExtra(DisplayUserActivity.FORM_ID,0L));
            }
            else {
                findViewById(R.id.user_btn_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.admin_btn_layout).setVisibility(View.GONE);
                item = table.get(mIntent.getLongExtra(DisplayUserActivity.FORM_ID, 0));
            }
        }
        else{
            item = new ANCFormItem();
            item.name = mIntent.getStringExtra("name");
            item.designation = mIntent.getStringExtra("designation");
            item.serviceDescription = mIntent.getStringExtra("description");
            item.collector_name = mIntent.getStringExtra("c_name");
            item.upozila = mIntent.getStringExtra("upozila");
            item.union = mIntent.getStringExtra("union");
            item.village = mIntent.getStringExtra("village");
            item.serial_no = mIntent.getStringExtra("serial");
            item.date = item.datepick = mIntent.getStringExtra("datepicker");
            item.start_time = item.timepick = mIntent.getStringExtra("timepicker");
            item.facility = mIntent.getStringExtra("facility");
            item.obs_type = mIntent.getStringExtra("obstype");
            item.district = mIntent.getStringExtra("district");
            item.lat = mIntent.getStringExtra("lat");
            item.lon = mIntent.getStringExtra("lon");
        }
        loadForm();
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.submit).setOnClickListener(this);
        findViewById(R.id.accept).setOnClickListener(this);
        findViewById(R.id.revert).setOnClickListener(this);
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
        sETv(R.id.anc_101,item.serial_no);
        sETv(R.id.anc_102,item.date);
        sETv(R.id.anc_103,item.start_time);
//        sSPi(R.id.anc_104, item.serviceDescription);
        sETv(R.id.anc_106, item.end_time);
        sRGv(R.id.bloodpressure, item.bloodpressure);
        sRGv(R.id.weight,item.weight);
        sRGv(R.id.hemoglobintest,item.hemoglobintest);
        sRGv(R.id.urinetest,item.urinetest);
        sRGv(R.id.pregnancyfood,item.pregnancyfood);
        sRGv(R.id.pregnancydanger,item.pregnancydanger);
        sRGv(R.id.fourparts,item.fourparts);
        sRGv(R.id.delivery,item.delivery);
        sRGv(R.id.feedbaby,item.feedbaby);
        sRGv(R.id.sixmonths,item.sixmonths);
        sRGv(R.id.familyplanning,item.familyplanning);
        sRGv(R.id.folictablet,item.folictablet);
        sRGv(R.id.folictabletimportance,item.folictabletimportance);
        sRGv(R.id.folicsideeffect,item.folicsideeffect);
    }

    private void editable(boolean state){
        sVEs(R.id.anc_101,state);
        sVEs(R.id.anc_102,state);
        sVEs(R.id.anc_103,state);
        sVEs(R.id.anc_104, state);
        sVEs(R.id.anc_106, state);
        sRGs(R.id.bloodpressure, state);
        sRGs(R.id.weight,state);
        sRGs(R.id.hemoglobintest,state);
        sRGs(R.id.urinetest,state);
        sRGs(R.id.pregnancyfood,state);
        sRGs(R.id.pregnancydanger,state);
        sRGs(R.id.fourparts,state);
        sRGs(R.id.delivery,state);
        sRGs(R.id.feedbaby,state);
        sRGs(R.id.sixmonths,state);
        sRGs(R.id.familyplanning,state);
        sRGs(R.id.folictablet,state);
        sRGs(R.id.folictabletimportance,state);
        sRGs(R.id.folicsideeffect,state);
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

    private void sETv(int id,String val){
        EditText et = (EditText) findViewById(id);
        if(et != null){
            et.setText(val);
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

    private void collectData() throws Exception {
        item.serial_no = gETv(R.id.anc_101);
        item.date = gETv(R.id.anc_102);
        item.start_time = gETv(R.id.anc_103);
//        item.serviceDescription = gSPi(R.id.anc_104);
        item.bloodpressure = gRGv(R.id.bloodpressure);
        item.weight = gRGv(R.id.weight);
        item.hemoglobintest = gRGv(R.id.hemoglobintest);
        item.urinetest = gRGv(R.id.urinetest);
        item.pregnancyfood = gRGv(R.id.pregnancyfood);
        item.pregnancydanger = gRGv(R.id.pregnancydanger);
        item.fourparts = gRGv(R.id.fourparts);
        item.delivery = gRGv(R.id.delivery);
        item.feedbaby = gRGv(R.id.feedbaby);
        item.sixmonths = gRGv(R.id.sixmonths);
        item.familyplanning = gRGv(R.id.familyplanning);
        item.folictablet = gRGv(R.id.folictablet);
        item.folictabletimportance = gRGv(R.id.folictabletimportance);
        item.folicsideeffect = gRGv(R.id.folicsideeffect);
        item.end_time = AppUtils.getDate();//gETv(R.id.end_time);
        sETv(R.id.end_time,item.end_time);
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

    private String gSPi(int id) throws Exception {
        Spinner sp = (Spinner) findViewById(id);
        int selection = sp.getSelectedItemPosition();
        if(selection == 0) throw new Exception();
        return Integer.toString(selection);
    }

    private String gETv(int id){
        Editable text = ((EditText) findViewById(id)).getText();
        return text.toString();
    }

    public void savevalue() {
        SharedPreferences pref = this.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        // Toast.makeText(getApplicationContext(), "Now I am in onResume ", Toast.LENGTH_SHORT).show();

        editor.putInt("id", intvalue2);
        editor.commit();
    }

    public void StorevaluesinVar() {
        try {
            int selectedq1 = bloodpressure.getCheckedRadioButtonId();
            int selectedq2 = hemoglobintest.getCheckedRadioButtonId();
            int selectedq3 = urinetest.getCheckedRadioButtonId();
            int selectedq4 = pregnancyfood.getCheckedRadioButtonId();
            int selectedq5 = pregnancydanger.getCheckedRadioButtonId();
            int selectedq6 = fourparts.getCheckedRadioButtonId();
            int selectedq7 = delivery.getCheckedRadioButtonId();
            int selectedq8 = feedbaby.getCheckedRadioButtonId();
            int selectedq9 = sixmonths.getCheckedRadioButtonId();
            int selectedq10 = familyplanning.getCheckedRadioButtonId();
            int selectedq12 = folictabletimportance.getCheckedRadioButtonId();
            int selectedq11 = folictablet.getCheckedRadioButtonId();
            RadioButton rb1 = (RadioButton) findViewById(selectedq1);
            bl_status = rb1.getText().toString();
            bloodpressure.clearCheck();
            RadioButton rb2 = (RadioButton) findViewById(selectedq2);
            hem_status = rb2.getText().toString();
            hemoglobintest.clearCheck();
            RadioButton rb3 = (RadioButton) findViewById(selectedq3);
            uri_status = rb3.getText().toString();
            urinetest.clearCheck();
            RadioButton rb4 = (RadioButton) findViewById(selectedq4);
            pregfood_status = rb4.getText().toString();
            pregnancyfood.clearCheck();


            RadioButton rb5 = (RadioButton) findViewById(selectedq5);

            pregdan_status = rb5.getText().toString();
            pregnancydanger.clearCheck();


            RadioButton rb6 = (RadioButton) findViewById(selectedq6);

            four_status = rb6.getText().toString();
            fourparts.clearCheck();


            RadioButton rb7 = (RadioButton) findViewById(selectedq7);

            del_status = rb7.getText().toString();
            delivery.clearCheck();


            RadioButton rb8 = (RadioButton) findViewById(selectedq8);
            feed_status = rb8.getText().toString();
            feedbaby.clearCheck();


            RadioButton rb9 = (RadioButton) findViewById(selectedq9);
            six_status = rb9.getText().toString();
            sixmonths.clearCheck();


            RadioButton rb10 = (RadioButton) findViewById(selectedq10);
            family_status = rb10.getText().toString();
            familyplanning.clearCheck();

            RadioButton rb11 = (RadioButton) findViewById(selectedq11);

            foltab_status = rb11.getText().toString();
            folictablet.clearCheck();


            RadioButton rb12 = (RadioButton) findViewById(selectedq12);
            folimp_status = rb12.getText().toString();
            folictabletimportance.clearCheck();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.back){
            finish();
        }
        else if(v.getId() == R.id.submit){
            try{
                collectData();
                if(item.status == 2){ //reverted
                    item.status = 4;
                }
                table.insert(item);
                if(item.id > 0) {
                    submit();
                }
                else{
                    Toast.makeText(this,"An error occurred",Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(this,"Form is not complete",Toast.LENGTH_SHORT).show();
            }
        }
        else if(v.getId() == R.id.accept){
            final ProgressDialog progressDialog = new ProgressDialog(TestActivity.this);
            progressDialog.setMessage("Please wait...");
            String url = "http://119.148.43.34/mamoni/survey/api/form";
            final ANCFormItem fItem = TestActivity.this.item;
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
                                ANCSupervisorTable t = new ANCSupervisorTable(TestActivity.this);
                                fItem.status =1;
                                t.insert(fItem); //update db
                                Toast.makeText(TestActivity.this,"Successfully submitted",Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(TestActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                        requests.put("form_type","dh_antenantals");
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

            RequestQueue requestQueue = Volley.newRequestQueue(TestActivity.this);
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
            final ProgressDialog progressDialog = new ProgressDialog(TestActivity.this);
            progressDialog.setMessage("Please wait...");
            String url = "http://119.148.43.34/mamoni/survey/api/form";
            final ANCFormItem fItem = TestActivity.this.item;
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
                                ANCSupervisorTable t = new ANCSupervisorTable(TestActivity.this);
                                fItem.status =2;
                                t.insert(fItem); //update db
                                Toast.makeText(TestActivity.this,"Successfully submitted",Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(TestActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                        requests.put("form_type","dh_antenantals");
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

            RequestQueue requestQueue = Volley.newRequestQueue(TestActivity.this);
            requestQueue.add(stringRequest);
            progressDialog.show();
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
    private static String FIELDS[] = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","106"};
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

    private void submit() {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait...");
        final AlertDialog.Builder alert = new AlertDialog.Builder(TestActivity.this);
        if (item != null) {
            String url = "http://119.148.43.34/mamoni/survey/api/form";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            dialog.dismiss();

                            try {
                                final JSONObject jo = new JSONObject(response);
                                if (jo.has("errorCount")) {
                                    alert.setMessage(jo.getString("message"));
                                } else {
                                    alert.setMessage("Invalid response");
                                }
                                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        try {
                                            if (jo.getInt("errorCount") == 0) {
                                                if(item.status == 7) //incomplete
                                                {
                                                    item.status = 3;//pending
                                                    table.insert(item);
                                                }
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
                                alert.setMessage("An error occurred");
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
                        finalRequest.put("username", AppUtils.getUserName(TestActivity.this));
                        finalRequest.put("password", AppUtils.getPassword(TestActivity.this));
                        JSONArray requests = new JSONArray();
                        JSONObject object = new JSONObject();
                        object.put("form_id", item.id);
                        object.put("form_type", "dh_antenantals");
                        JSONObject data = new JSONObject();
                        data.put("hemoglobintest", toBool(item.hemoglobintest));
                        data.put("bloodpressure", toBool(item.bloodpressure));
                        data.put("urinetest", toBool(item.urinetest));
                        data.put("pregnancyfood", toBool(item.pregnancyfood));
                        data.put("pregnancydanger", toBool(item.pregnancydanger));
                        data.put("fourparts", toBool(item.fourparts));
                        data.put("delivery", toBool(item.delivery));
                        data.put("feedbaby", toBool(item.feedbaby));
                        data.put("sixmonths", toBool(item.sixmonths));
                        data.put("familyplanning", toBool(item.familyplanning));
                        data.put("folictablet", toBool(item.folictablet));
                        data.put("folictabletimportance", toBool(item.folictabletimportance));
                        data.put("folicacidsideeffect", toBool(item.folicsideeffect));
                        data.put("patient_name", item.collector_name);
                        data.put("district", item.district);
                        data.put("sub_district", item.subdistrict);
                        data.put("union", item.union);
                        data.put("village", item.village);
                        data.put("date",item.date);
                        data.put("start_time",item.start_time);
                        data.put("end_time",item.end_time);
                        data.put("doc_designation",item.designation);
                        data.put("facility",item.facility);
                        data.put("lat",item.lat);
                        data.put("lon",item.lon);
                        data.put("weight",toBool(item.weight));

                        object.put("data", data);
                        requests.put(object);
                        finalRequest.put("requests", requests);


                        params.put("data", finalRequest.toString());
                        Log.e("request: ", finalRequest.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return params;
                }

            };
            dialog.show();
            RequestQueue requestQueue = Volley.newRequestQueue(TestActivity.this);
            requestQueue.add(stringRequest);

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