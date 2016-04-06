package caresurvey.sci.com.caresurvey.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.FormTable;
import caresurvey.sci.com.caresurvey.model.FormItem;

public class Supervisor_verificationActivity extends AppCompatActivity {

    int intValue;
    ArrayList<String> form;
    Button Save, Submit,revert1;
    EditText et1,et2;
    String point,comment;
    String ChekboxText;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12;
    Spinner com_incom;
    LinearLayout linearLayout;
    Boolean check=false;

    public String bl_status, hem_status, uri_status, pregfood_status, pregdan_status, four_status, del_status, feed_status, six_status, family_status, foltab_status, folimp_status;
    int i = 0;
    RadioGroup bloodpressure, hemoglobintest,
            urinetest, pregnancyfood, pregnancydanger,
            fourparts, delivery, feedbaby,
            sixmonths, familyplanning, folictablet,
            folictabletimportance;

    ArrayList<FormItem> formItemAll;
    ArrayList<FormItem> formItems;
    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_verification);


        Save = (Button) findViewById(R.id.Savebtn);
        Submit = (Button) findViewById(R.id.Submit);
        bloodpressure = (RadioGroup) findViewById(R.id.bloodpressure);

        hemoglobintest = (RadioGroup) findViewById(R.id.hemoglobintest);
        hemoglobintest.setClickable(false);
        urinetest = (RadioGroup) findViewById(R.id.urinetest);
        pregnancyfood = (RadioGroup) findViewById(R.id.pregnancyfood);
        pregnancydanger = (RadioGroup) findViewById(R.id.pregnancydanger);
        fourparts = (RadioGroup) findViewById(R.id.fourparts);
        delivery = (RadioGroup) findViewById(R.id.delivery);
        feedbaby = (RadioGroup) findViewById(R.id.feedbaby);
        sixmonths = (RadioGroup) findViewById(R.id.sixmonths);
        familyplanning = (RadioGroup) findViewById(R.id.familyplanning);
        folictablet = (RadioGroup) findViewById(R.id.folictablet);
        folictabletimportance = (RadioGroup) findViewById(R.id.folictabletimportance);
        com_incom = (Spinner)findViewById(R.id.spinner_com);
        linearLayout= (LinearLayout)findViewById(R.id.revertlayout);
        revert1= (Button)findViewById(R.id.Submit1);


        revert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(check) {
                    linearLayout.setVisibility(View.GONE);
                    check= false;
                    Log.d("......false", ">>>>>>>" + check);
                }
                else {
                    linearLayout.setVisibility(View.VISIBLE);
                    check = true;
                    Log.d("......true",">>>>>>>"+check);
                }



            }
        });


        ArrayList<String> com_incomList = new ArrayList<String>();

        com_incomList.add("Select Cause");
        com_incomList.add("Incomplete");
        com_incomList.add("Complete");


        ArrayAdapter<String> adapterissue = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,com_incomList);
        com_incom.setAdapter(adapterissue);

        tv1=(TextView)findViewById(R.id.textView3);

//        et1=(EditText)findViewById(R.id.comment);
        et2=(EditText)findViewById(R.id.comment);



        cb1=(CheckBox)findViewById(R.id.checkBox);
        cb2=(CheckBox)findViewById(R.id.checkBox2);
        cb3=(CheckBox)findViewById(R.id.checkBox3);
        cb4=(CheckBox)findViewById(R.id.checkBox5);
        cb5=(CheckBox)findViewById(R.id.checkBox6);
        cb6=(CheckBox)findViewById(R.id.checkBox7);
        cb7=(CheckBox)findViewById(R.id.checkBox8);
        cb8=(CheckBox)findViewById(R.id.checkBox9);
        cb9=(CheckBox)findViewById(R.id.checkBox10);
        cb10=(CheckBox)findViewById(R.id.checkBox11);
        cb11=(CheckBox)findViewById(R.id.checkBox12);
        cb12=(CheckBox)findViewById(R.id.checkBox4);








        Intent mIntent = getIntent();
        intValue = mIntent.getIntExtra("position", 0)+1;


        final ArrayList<FormItem> formItems1;




        final FormTable formTable = new FormTable(Supervisor_verificationActivity.this);
        formItems= formTable.getSpecificItem(intValue);



        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                // Submit.setClickable(false);
                //Save.setClickable(false);


                //  if(!et1.equals(null))
                //      point=et1.getText().toString();
                //     if(!et2.equals(null))
                //    comment=et2.getText().toString();
                // Log.d(".....>>>>>>>>>>", "point1 " + point);
                // Log.d(".....>>>>>>>>>>", "comment1 " + et1.getText().toString().trim());
                //    Log.d(".....>>>>>>>>>>", "point2 " + et2.getText().toString().trim());


                String url = "http://www.kolorob.net/mamoni/survey/api/form";

                //Log.d(".....>>>>>>>>>>", "ChekboxText " + ChekboxText);
                // Log.d(".....>>>>>>>>>>", "ChekboxText " + ChekboxText);




                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    int status;
                                    status= jsonObject.getInt("status");
                                    Log.d(".....>>>>>>>>>>", "response length" + et1.getText().toString().trim());

                                    if (status==2){
                                        FormTable formTable1= new FormTable(Supervisor_verificationActivity.this);
                                        for(FormItem formItem1: formItems)
                                        {
                                            int intValue = Supervisor_verificationActivity.this.intValue;
                                            String global_id= String.valueOf(intValue);
                                            long ts;
                                            formTable.updateglobalId("1",intValue);
                                            ts= formTable1.updatefieldforuser(global_id,1,et1.getText().toString(), et2.getText().toString());
                                            Log.d(".....>>>>>>>>>>", "ChekboxText ");
                                            Log.d(".....>>>>>>>>>>"+global_id, "ChekboxText " + ts);

                                        }

                                        Log.d(".....>>>>>>>>>>", "ChekboxTextdddd ");
                                        Intent intent = new Intent(Supervisor_verificationActivity.this,DisplayAll_Activity.class);
                                        startActivity(intent);
                                        Log.d(".....>>>>>>>>>>", "ChekboxText ");
                                    }



                                }

                                catch (Exception e)
                                {

                                }
                                Toast.makeText(Supervisor_verificationActivity.this, response, Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Supervisor_verificationActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                            for(FormItem formItem1: formItems)
                            {
                                JSONObject jf= new JSONObject();
                                JSONObject meta=new JSONObject();
                                meta.put("comments","");
                                meta.put("fields", "");
                                requests.put("meta",meta);
                                requests.put("submitted_by","collector");
                                requests.put("form_id",formItem1.getGlobal_id());
                                Log.d(".....>>>>>>>>>>", "response length      " + formItem1.getGlobal_id());
                                requests.put("form_type","dh_antenantals");
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

                RequestQueue requestQueue = Volley.newRequestQueue(Supervisor_verificationActivity.this);
                requestQueue.add(stringRequest);


            }
        });


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                ChekboxText=com_incom.getSelectedItem().toString();
                if(cb1.isChecked()) {
                    String value= cb1.getText().toString();
                    ChekboxText = ChekboxText+", ";
                    ChekboxText = ChekboxText+""+value;
                }
                if(cb2.isChecked()) {
                    String value= cb2.getText().toString();
                    ChekboxText = ChekboxText+", ";
                    ChekboxText = ChekboxText+""+value;
                }
                if(cb3.isChecked()) {
                    String value= cb3.getText().toString();
                    ChekboxText = ChekboxText+", ";
                    ChekboxText = ChekboxText+""+value;
                }
                if(cb4.isChecked()) {
                    String value= cb4.getText().toString();
                    ChekboxText = ChekboxText+", ";
                    ChekboxText = ChekboxText+""+value;
                }
                if(cb5.isChecked()) {
                    String value= cb5.getText().toString();
                    ChekboxText = ChekboxText+", ";
                    ChekboxText = ChekboxText+""+value;
                }
                if(cb6.isChecked()) {
                    String value= cb6.getText().toString();
                    ChekboxText = ChekboxText+", ";
                    ChekboxText = ChekboxText+""+value;                }
                if(cb7.isChecked()) {
                    String value= cb7.getText().toString();
                    ChekboxText = ChekboxText+", ";
                    ChekboxText = ChekboxText+""+value;
                }
                if(cb8.isChecked()) {
                    String value= cb8.getText().toString();
                    ChekboxText = ChekboxText+", ";
                    ChekboxText = ChekboxText+""+value;
                }
                if(cb9.isChecked()) {
                    String value= cb9.getText().toString();
                    ChekboxText = ChekboxText+", ";
                    ChekboxText = ChekboxText+""+value;
                }
                if(cb10.isChecked()) {
                    String value= cb10.getText().toString();
                    ChekboxText = ChekboxText+", ";
                    ChekboxText = ChekboxText+""+value;
                }
                if(cb11.isChecked()) {
                    String value= cb11.getText().toString();
                    ChekboxText = ChekboxText+", ";
                    ChekboxText = ChekboxText+""+value;
                }
                if(cb12.isChecked()) {
                    String value= cb12.getText().toString();
                    ChekboxText = ChekboxText+", ";
                    ChekboxText = ChekboxText+""+value;
                }


                Log.d(".....>>>>>>>>>>", "ChekboxText " + ChekboxText);

                //  Submit.setClickable(false);
                // Save.setClickable(false);



                String url = "http://www.kolorob.net/mamoni/survey/api/form";



                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(Supervisor_verificationActivity.this, response, Toast.LENGTH_SHORT).show();

                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    int status;
                                    status= jsonObject.getInt("status");

                                    if (status==2){
                                        FormTable formTable1= new FormTable(Supervisor_verificationActivity.this);
                                        for(FormItem formItem1: formItems)
                                        {
                                            String global_id= String.valueOf(intValue);
                                            long vvs;
                                            formTable.updateglobalId("2",intValue);
                                            vvs=formTable1.updatefieldforuser(global_id,2,et1.getText().toString(), et2.getText().toString());
                                            Log.d(".....>>>>>>>>>>", "TestForUpdatingsupervisor " + vvs);



                                        }


                                        Log.d(".....>>>>>>>>>>", "ChekboxTextdddd ");
                                        Intent intent = new Intent(Supervisor_verificationActivity.this,DisplayAll_Activity.class);
                                        startActivity(intent);
                                        Log.d(".....>>>>>>>>>>", "ChekboxText ");

                                    }



                                }

                                catch (Exception e)
                                {

                                }


                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Supervisor_verificationActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                            for(FormItem formItem1: formItems)
                            {
                                JSONObject jf= new JSONObject();
                                JSONObject meta=new JSONObject();
                                meta.put("comments",formItem1.getComments());
                                meta.put("fields", formItem1.getFields());
                                requests.put("meta",meta);
                                requests.put("submitted_by","collector");
                                requests.put("form_id",formItem1.getGlobal_id());
                                Log.d(".....>>>>>>>>>>", "response length      " + formItem1.getGlobal_id());
                                requests.put("form_type","dh_antenantals");
                                requests.put("status",2);
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

                RequestQueue requestQueue = Volley.newRequestQueue(Supervisor_verificationActivity.this);
                requestQueue.add(stringRequest);

            }
        });







        //    ArrayList<FormItem> formItems;


//        FormItem formItem;
//
//        final FormTable formTable = new FormTable(Supervisor_verificationActivity.this);
//        formItems= formTable.getSpecificItem(1);





        for(FormItem ft: formItems)

        {


            if(ft.getBloodpressure().equals("true"))
                bloodpressure.check(R.id.ques1rad1);
            else
                bloodpressure.check(R.id.ques1rad2);

            if(ft.getHemoglobintest().equals("true"))
                hemoglobintest.check(R.id.radioButton3);
            else
                hemoglobintest.check(R.id.radioButton4);

            if(ft.getUrinetest().equals("true"))
                urinetest.check(R.id.radioButton);
            else
                urinetest.check(R.id.radioButton2);




            if(ft.getPregnancyfood().equals("true"))
                pregnancyfood.check(R.id.radioButton5);
            else
                pregnancyfood.check(R.id.radioButton6);

            if(ft.getPregnancydanger().equals("true"))
                pregnancydanger.check(R.id.radioButton7);
            else
                pregnancydanger.check(R.id.radioButton8);

            if(ft.getFourparts().equals("true"))
                fourparts.check(R.id.radioButton9);
            else
                fourparts.check(R.id.radioButton10);

            if(ft.getDelivery().equals("true"))
                delivery.check(R.id.radioButton11);
            else
                delivery.check(R.id.radioButton12);

            if(ft.getFeedbaby().equals("true"))
                feedbaby.check(R.id.radioButton13);
            else
                feedbaby.check(R.id.radioButton14);

            if(ft.getSixmonths().equals("true"))
                sixmonths.check(R.id.radioButton15);
            else
                sixmonths.check(R.id.radioButton16);

            if(ft.getFamilyplanning().equals("true"))
                familyplanning.check(R.id.radioButton17);
            else
                familyplanning.check(R.id.radioButton18);

            if(ft.getFolictablet().equals("true"))
                folictablet.check(R.id.radioButton19);
            else
                folictablet.check(R.id.radioButton20);

            if(ft.getFolictabletimportance().equals("true"))
                folictabletimportance.check(R.id.radioButton21);
            else
                folictabletimportance.check(R.id.radioButton22);

        }







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_supervisor_verification, menu);
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
