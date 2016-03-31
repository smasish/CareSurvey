package caresurvey.sci.com.caresurvey.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import caresurvey.sci.com.caresurvey.database.FormTable;
import caresurvey.sci.com.caresurvey.model.FormItem;

public class Supervisor_verificationActivity extends AppCompatActivity {

    int intValue;
    ArrayList<String> form;
    Button Save, Submit;
    EditText et1,et2;
    String point,comment;

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

        tv1=(TextView)findViewById(R.id.textView3);

        et1=(EditText)findViewById(R.id.et1);
        et1=(EditText)findViewById(R.id.et2);


     //   point=et1.getText().toString();
       // comment=et2.getText().toString();



        Intent mIntent = getIntent();
        intValue = mIntent.getIntExtra("position", 0)+1;


        ArrayList<FormItem> formItems1;




        final FormTable formTable = new FormTable(Supervisor_verificationActivity.this);
        formItems= formTable.getSpecificItem(intValue);



        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Submit.setClickable(false);
                //Save.setClickable(false);



                String url = "http://www.kolorob.net/mamoni/survey/api/form";



                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
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

                                meta.put("comments", "");
                                meta.put("fields", "");

                                requests.put("meta",meta);
                                requests.put("form_id",formItem1.getGlobal_id());
                                requests.put("type","update");
                                requests.put("status",1);

                                jsonArray.put(requests);






                            }


                            //      jsonArray.put(formItemAll);
//                            JSONObject record = new JSONObject();
//                            record.put("hemoglobintest", false);
//                            record.put("urinetest", false);








                            //data
                            JSONObject data = new JSONObject();
                            data.put("username", "taw_khan1@yahoo.com");
                            data.put("password", "taw1994");
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


              //  Submit.setClickable(false);
               // Save.setClickable(false);



                String url = "http://www.kolorob.net/mamoni/survey/api/form";



                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
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

                                meta.put("comments", et1.getText().toString());
                                meta.put("fields", et2.getText().toString());

                                requests.put("meta",meta);
                                requests.put("form_id",formItem1.getGlobal_id());
                                requests.put("type","update");
                                requests.put("status",2);

                                jsonArray.put(requests);






                            }


                            //      jsonArray.put(formItemAll);
//                            JSONObject record = new JSONObject();
//                            record.put("hemoglobintest", false);
//                            record.put("urinetest", false);








                            //data
                            JSONObject data = new JSONObject();
                            data.put("username", "taw_khan1@yahoo.com");
                            data.put("password", "taw1994");
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
