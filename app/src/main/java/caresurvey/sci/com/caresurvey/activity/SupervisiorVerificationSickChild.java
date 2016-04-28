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
    ArrayList<SickChildItemSupervisor> sickChildItemSupervisors;
    Button save, submit, update;
    EditText child_descriptions;
    ArrayList<SickChildItem> sickChildItems;
    RadioGroup feed, vomit, stutter, cough, diahorea, fever, measure_feaver, stethoscope, breathing_test,
            eye_test, infected_mouth, neck, ear, hand, dehydration, weight, circle, belly, height, bmi;
    String feedx, vomitx, stutterx, coughx, diahoreax, feverx, measure_feaverx, stethoscopex, breathing_testx, eye_testx, infected_mouthx, neckx, earx, handx, dehydrationx, weightx, circlex, bellyx, heightx, bmix, ChekboxText = null;
    EditText serial_no, form_date, start_time, child_description, age, endTime;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisior_verification_sick_child);


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


        submit = (Button) findViewById(R.id.saves);
        save = (Button) findViewById(R.id.Submits);


        child_descriptions=(EditText)findViewById(R.id.child_description);


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
        boxText();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "http://www.kolorob.net/mamoni/survey/api/form";

                //Log.d(".....>>>>>>>>>>", "ChekboxText " + ChekboxText);
                // Log.d(".....>>>>>>>>>>", "ChekboxText " + ChekboxText);

                SickChildSupervisorTable sickChildSupervisorTable = new SickChildSupervisorTable(SupervisiorVerificationSickChild.this);
                sickChildItemSupervisors=sickChildSupervisorTable.getSpecificItem(1);


                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {

                                    Toast.makeText(SupervisiorVerificationSickChild.this,response.toString(),Toast.LENGTH_LONG).show();

                                    Log.d(".....>>>>>>>>>>", "response length" +response);
                                    JSONObject jsonObject = new JSONObject(response);
                                    int status;
                                    status= jsonObject.getInt("status");
                                    Log.d(".....>>>>>>>>>>", "response length" +status);
                                    Log.d(".....>>>>>>>>>>nnn", "ChekboxText " +status);
                                    if (status==2){
                                        SickChildSupervisorTable sickChildSupervisorTable1= new SickChildSupervisorTable(SupervisiorVerificationSickChild.this);
                                        for(SickChildItemSupervisor Item1: sickChildItemSupervisors)
                                        {
//                                            long ts,vs,vs2;


//
//                                            vs=formTable1.updateglobalId("1",intValue);
//                                            Log.d(".....>>>>>>>>>>nnn", "ChekboxText "+vs);
//                                            // int intValue = Supervisor_verificationActivity.this.intValue;
//                                            String global_id= String.valueOf(intValue);
//                                            vs=formTable1.updateglobalId("1",intValue);
//                                            //  vs2=formTable1.updateglobalId("1",intValue);
//                                            //  ts= formTable1.updatefieldforuser(global_id,1,et1.getText().toString(), et2.getText().toString());
//                                            // Log.d(".....>>>>>>>>>>nnn", "ChekboxText ");
//                                            //     Log.d(".....>>>>>>>>>>", "ChekboxText " + ts);
                                        }
                                        // Log.d(".....>>>>>>>>>>", "ChekboxTextdddd ");
                                        Intent intent = new Intent(SupervisiorVerificationSickChild.this,SurveyActivity.class);
                                        startActivity(intent);
                                        finish();
                                        // Log.d(".....>>>>>>>>>>", "ChekboxText ");
                                    }
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
                                Toast.makeText(SupervisiorVerificationSickChild.this,error.toString(),Toast.LENGTH_LONG).show();
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
                            for(SickChildItemSupervisor sickChildItemSupervisor: sickChildItemSupervisors)
                            {
                                JSONObject jf= new JSONObject();
                                JSONObject meta=new JSONObject();
                                meta.put("comments","");
                                meta.put("fields", "");
                                requests.put("meta",meta);
                                requests.put("submitted_by", "user_hb1");
                                requests.put("form_id", sickChildItemSupervisor.getServer_id());
                               //og.d(".....>>>>>>>>>>", "response length      " + formItem1.getGlobal_id());
                                requests.put("form_type","dh_sickchild");
                                requests.put("status",1);
                                jsonArray.put(requests);
                            }


                            //      jsonArray.put(formItemAll);
//                            JSONObject record = new JSONObject();
//                            record.put("hemoglobintest", false);
//                            record.put("urinetest", false);








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

// Adding request to request queue

                RequestQueue requestQueue = Volley.newRequestQueue(SupervisiorVerificationSickChild.this);
                requestQueue.add(stringRequest);
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {







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

            child_description.setText(sickChildItem.getChild_description());


        }



}



    public void boxText() {
        for (int i = 0; i < result.length(); i++) {


           // Log.d(">>>>","result"+result);
            int p = result.charAt(i);
            if (p == 49) {
                Log.d(">>>>","result    "+p);
                checkBox1.setChecked(true);
            } else if (p == 50)
            {
                checkBox2.setChecked(true);
                Log.d(">>>>", "result    " + p);
            }

            else if (p == 51)
            {
                checkBox3.setChecked(true);
                Log.d(">>>>", "result    " + p);
            }

            else if (p == 52)
            {
                checkBox4.setChecked(true);
                Log.d(">>>>", "result    " + p);
            }

            else if (p == 53)
            {
                checkBox5.setChecked(true);
                Log.d(">>>>", "result    " + p);
            }

            //Log.d(">>>>","result    "+p);
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
