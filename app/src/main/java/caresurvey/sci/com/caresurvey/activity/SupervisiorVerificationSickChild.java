package caresurvey.sci.com.caresurvey.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.FormTableUser;
import caresurvey.sci.com.caresurvey.database.SickChildSupervisorTable;
import caresurvey.sci.com.caresurvey.database.SickChildTable;
import caresurvey.sci.com.caresurvey.model.FormItem;
import caresurvey.sci.com.caresurvey.model.FormItemUser;
import caresurvey.sci.com.caresurvey.model.SickChildItem;
import caresurvey.sci.com.caresurvey.model.SickChildItemSupervisor;

public class SupervisiorVerificationSickChild extends AppCompatActivity {
    private String caretaker, name, c_name, designation, datepicker, timepicker, serial, facility, upozila, union, village, obstype, result;
    int id, mark, position;
    Button save, submit, update;
    ArrayList<SickChildItem> sickChildItems;
    RadioGroup feed, vomit, stutter, cough, diahorea, fever, measure_feaver, stethoscope, breathing_test,
            eye_test, infected_mouth, neck, ear, hand, dehydration, weight, circle, belly, height, bmi;
    String feedx, vomitx, stutterx, coughx, diahoreax, feverx, measure_feaverx, stethoscopex, breathing_testx, eye_testx, infected_mouthx, neckx, earx, handx, dehydrationx, weightx, circlex, bellyx, heightx, bmix, ChekboxText = null;
    EditText serial_no, form_date, start_time, child_description, age, endTime;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test12);


        Intent intent = getIntent();

        position = intent.getIntExtra("position", 0) + 1;


        caretaker = intent.getStringExtra("caretaker");
        name = intent.getStringExtra("name");
        id = intent.getIntExtra("id", 0);
        c_name = intent.getStringExtra("c_name");
        designation = intent.getStringExtra("designation");
        mark = intent.getIntExtra("mark", 0);
        datepicker = intent.getStringExtra("datepicker");
        timepicker = intent.getStringExtra("timepicker");
        serial = intent.getStringExtra("serial");
        facility = intent.getStringExtra("facility");
        upozila = intent.getStringExtra("upozila");
        union = intent.getStringExtra("union");
        village = intent.getStringExtra("village");
        obstype = intent.getStringExtra("obstype");


        submit = (Button) findViewById(R.id.Submit);
        save = (Button) findViewById(R.id.Savebtn);


        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);


        serial_no = (EditText) findViewById(R.id.serial_no);
        form_date = (EditText) findViewById(R.id.form_date);
        start_time = (EditText) findViewById(R.id.start_time);
        child_description = (EditText) findViewById(R.id.child_description);
        age = (EditText) findViewById(R.id.age);
        endTime = (EditText) findViewById(R.id.end_time);


        feed = (RadioGroup) findViewById(R.id.feed);
        vomit = (RadioGroup) findViewById(R.id.vomit);
        stutter = (RadioGroup) findViewById(R.id.stutter);
        cough = (RadioGroup) findViewById(R.id.cough);
        diahorea = (RadioGroup) findViewById(R.id.diahorea);
        fever = (RadioGroup) findViewById(R.id.fever);
        measure_feaver = (RadioGroup) findViewById(R.id.measure_fever);
        stethoscope = (RadioGroup) findViewById(R.id.stethoscope);
        breathing_test = (RadioGroup) findViewById(R.id.breathing_test);
        eye_test = (RadioGroup) findViewById(R.id.eye_test);
        infected_mouth = (RadioGroup) findViewById(R.id.infected_mouth);
        neck = (RadioGroup) findViewById(R.id.neck);
        ear = (RadioGroup) findViewById(R.id.ear);
        hand = (RadioGroup) findViewById(R.id.hand);
        dehydration = (RadioGroup) findViewById(R.id.dehydration);
        weight = (RadioGroup) findViewById(R.id.weight);
        circle = (RadioGroup) findViewById(R.id.circle);
        belly = (RadioGroup) findViewById(R.id.belly);
        height = (RadioGroup) findViewById(R.id.height);
        bmi = (RadioGroup) findViewById(R.id.bmi);


        StorevaluesinVar();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StorevaluesinVar();

                if (checkBox1.isChecked()) {
                    //  String value= checkBox1.getText().toString();
                    ChekboxText = ChekboxText + " ";
                    ChekboxText = ChekboxText + "1";
                }
                if (checkBox2.isChecked()) {
                    // String value= cb2.getText().toString();
                    ChekboxText = ChekboxText + " ";
                    ChekboxText = ChekboxText + "2";
                }
                if (checkBox3.isChecked()) {
                    //  String value= cb3.getText().toString();
                    ChekboxText = ChekboxText + " ";
                    ChekboxText = ChekboxText + "3";
                }
                if (checkBox4.isChecked()) {
                    // String value= cb4.getText().toString();
                    ChekboxText = ChekboxText + " ";
                    ChekboxText = ChekboxText + "4";
                }
                if (checkBox5.isChecked()) {
                    //  String value= cb5.getText().toString();
                    ChekboxText = ChekboxText + " ";
                    ChekboxText = ChekboxText + "5";
                }


                SickChildTable sickChildTable = new SickChildTable(SupervisiorVerificationSickChild.this);
                int faciltiy = Integer.parseInt(serial);
                SickChildItem sickChildItem = new SickChildItem(2, faciltiy, name, designation, serial, datepicker,
                        timepicker, child_description.getText().toString(), age.getText().toString(), feedx,
                        vomitx, stutterx, coughx, diahoreax, feverx, measure_feaverx, stethoscopex, breathing_testx, eye_testx,
                        infected_mouthx, neckx, earx, handx, dehydrationx, weightx, circlex, bellyx, heightx, ChekboxText,
                        endTime.getText().toString(), village, "hobiganj", union, upozila, c_name, "", "", "");

                if (mark == 1) {

                    if (sickChildTable.insertItem(sickChildItem) == 1) {
                        Log.d(">>>>>>", "Saved Successfully");
                        Toast.makeText(SupervisiorVerificationSickChild.this,
                                "Your Message", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<SickChildItem> sickChildItems1;
                SickChildTable sickChildTable = new SickChildTable(SupervisiorVerificationSickChild.this);
                sickChildItems = sickChildTable.getSpecificItem(2);
                String url = "http://www.kolorob.net/mamoni/survey/api/form";


                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                Toast.makeText(SupervisiorVerificationSickChild.this, response, Toast.LENGTH_SHORT).show();
                                try {
                                    JSONObject jo = new JSONObject(response);
                                    Log.d(".....>>>>>>>>>>", "Status " + jo);
                                    String status = jo.getString("status");
                                    if (status.equals("2")) {
                                        //  FormTableUser formtableuser= new FormTableUser(TestActivity.this);
                                        //   formtableuser.updateglobalI(intValue,3);
                                        //     Save.setVisibility(View.GONE);
                                        //     Intent intentw = new Intent(TestActivity1.this,DisplayUserActivity.class);
                                        //  startActivity(intentw);
                                        //  finish();
                                    }

                                } catch (Exception e) {
                                }
                                //  Toast.makeText(TestActivity.this,response,Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //    Toast.makeText(TestActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                            for (SickChildItem sickChildItem : sickChildItems) {
                                JSONObject jf = new JSONObject();
                                JSONObject fs = new JSONObject();


                                fs.put("form_type", "dh_sickchild");
                                fs.put("form_id", 2);
                                jf.put("facility_id", sickChildItem.getFacility_id());
                                jf.put("sp_client", sickChildItem.getSp_client());
                                jf.put("sp_designation", sickChildItem.getSo_designation());
                                jf.put("seral_no", sickChildItem.getSerial_no());
                                jf.put("form_date", sickChildItem.getForm_date());
                                jf.put("start_time", sickChildItem.getStart_time());
                                jf.put("child_description", sickChildItem.getChild_description());
                                jf.put("age", sickChildItem.getAge());
                                jf.put("feed", sickChildItem.getFeed());
                                jf.put("vomit", sickChildItem.getVomit());
                                jf.put("stutter", sickChildItem.getStutter());
                                jf.put("cough", sickChildItem.getCough());
                                jf.put("diaria", sickChildItem.getDiahorea());
                                jf.put("fever", sickChildItem.getFever());
                                jf.put("measure_fever", sickChildItem.getMeasure_fever());
                                jf.put("stethoscope", sickChildItem.getStethoscope());
                                jf.put("breathing_test", sickChildItem.getBreathing_test());
                                jf.put("eye_test", sickChildItem.getEye_test());
                                jf.put("infected_mouth", sickChildItem.getInfected_mouth());
                                jf.put("neck", sickChildItem.getNeck());
                                jf.put("ear", sickChildItem.getEar());
                                jf.put("hand", sickChildItem.getHand());
                                jf.put("dehydration", sickChildItem.getDehydration());
                                jf.put("weight", sickChildItem.getWeight());
                                jf.put("clinic_test", sickChildItem.getClinic_test());
                                jf.put("belly_button", sickChildItem.getBelly_button());
                                jf.put("height", sickChildItem.getHeight());
                                jf.put("result", sickChildItem.getResult());
                                jf.put("end_time", sickChildItem.getEnd_time());
                                jf.put("village", sickChildItem.getVillage());
                                jf.put("district", sickChildItem.getDistrict());
                                jf.put("union", sickChildItem.getUnion());
                                jf.put("sub_district", sickChildItem.getSub_district());
                                fs.put("data", jf);
                                requests.put(fs);


                            }


                            //      jsonArray.put(formItemAll);
//                            JSONObject record = new JSONObject();
//                            record.put("hemoglobintest", false);
//                            record.put("urinetest", false);


                            //request
//                            JSONObject request = new JSONObject();
//                           // request.put("type", add_update);
//                            request.put("form_type", "dh_antenantals");
//                            request.put("data", formItemAll);


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
                            data.put("username", "user_hb1");
                            data.put("password", "pass_hb1");
                            data.put("requests", requests);

                            params.put("data", data.toString());
                        } catch (Exception e) {

                        }

                        return params;
                    }

                };

// Adding request to request queue

                RequestQueue requestQueue = Volley.newRequestQueue(SupervisiorVerificationSickChild.this);
                requestQueue.add(stringRequest);


            }
        });

    }


    public void StorevaluesinVar() {


        ArrayList<SickChildItemSupervisor> sickChildItems;
        ArrayList<SickChildItemSupervisor> sickChildItems1;
        SickChildSupervisorTable sickChildTable = new SickChildSupervisorTable(SupervisiorVerificationSickChild.this);
        sickChildItems = sickChildTable.getSpecificItem(position);
        //sickChildItems=sickChildTable.getAllInfo();
        // sickChildItems1=sickChildTable.getAllInfo();
        Log.d(">>>>", "sickchildItem" + sickChildItems);

        for (SickChildItemSupervisor sickChildItem : sickChildItems) {
            if (sickChildItem.getFeed().equals("true"))
                feed.check(R.id.feed1);
            else
                feed.check(R.id.feed2);


            if (sickChildItem.getVomit().equals("true"))
                vomit.check(R.id.vomit1);
            else
                vomit.check(R.id.vomit2);


            if (sickChildItem.getStutter().equals("true"))
                stutter.check(R.id.stutter1);
            else
                stutter.check(R.id.stutter2);

            if (sickChildItem.getCough().equals("true"))
                cough.check(R.id.cough1);
            else
                cough.check(R.id.cough2);


            if (sickChildItem.getDiahorea().equals("true"))
                diahorea.check(R.id.diahorea1);
            else
                diahorea.check(R.id.diahorea2);


            if (sickChildItem.getFever().equals("true"))
                fever.check(R.id.fever1);
            else
                fever.check(R.id.fever2);

            if (sickChildItem.getMeasure_fever().equals("true"))
                measure_feaver.check(R.id.measure_fever1);
            else
                measure_feaver.check(R.id.measure_fever2);


            if (sickChildItem.getStethoscope().equals("true"))
                stethoscope.check(R.id.stethoscope1);
            else
                stethoscope.check(R.id.stethoscope2);


            if (sickChildItem.getBreathing_test().equals("true"))
                breathing_test.check(R.id.breathing_test1);
            else
                breathing_test.check(R.id.breathing_test2);


            if (sickChildItem.getEye_test().equals("true"))
                eye_test.check(R.id.eye_test1);
            else
                eye_test.check(R.id.eye_test2);


            if (sickChildItem.getInfected_mouth().equals("true"))
                infected_mouth.check(R.id.infected_mouth1);
            else
                infected_mouth.check(R.id.infected_mouth2);


            if (sickChildItem.getNeck().equals("true"))
                neck.check(R.id.neck1);
            else
                neck.check(R.id.neck2);


            if (sickChildItem.getEar().equals("true"))
                ear.check(R.id.ear1);
            else
                ear.check(R.id.ear2);


            if (sickChildItem.getHand().equals("true"))
                hand.check(R.id.hand1);
            else
                hand.check(R.id.hand2);


            if (sickChildItem.getDehydration().equals("true"))
                dehydration.check(R.id.dehydration1);
            else
                dehydration.check(R.id.dehydration2);

            if (sickChildItem.getWeight().equals("true"))
                weight.check(R.id.weight1);
            else
                weight.check(R.id.weight2);


            if (sickChildItem.getClinic_test().equals("true"))
                circle.check(R.id.circle1);
            else
                circle.check(R.id.circle2);


            if (sickChildItem.getBelly_button().equals("true"))
                belly.check(R.id.belly1);
            else
                belly.check(R.id.belly2);


            if (sickChildItem.getHeight().equals("true"))
                height.check(R.id.height1);
            else
                height.check(R.id.height2);


            if (sickChildItem.getHeight().equals("true"))
                bmi.check(R.id.bmi1);
            else
                bmi.check(R.id.bmi2);


            result = sickChildItem.getEnd_time();


        }



}



    public void boxText() {
        for (int i = 0; i < result.length(); i++) {
            int p = result.charAt(i);
            if (p == 0) {
                checkBox1.isChecked();
            } else if (p == 1)
                checkBox2.isChecked();
            else if (p == 2)
                checkBox3.isChecked();
            else if (p == 4)
                checkBox4.isChecked();
            else if (p == 5)
                checkBox5.isChecked();
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
