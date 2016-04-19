package caresurvey.sci.com.caresurvey.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.FormTable;
import caresurvey.sci.com.caresurvey.database.FormTableUser;
import caresurvey.sci.com.caresurvey.model.FormItem;
import caresurvey.sci.com.caresurvey.model.FormItemUser;

public class TestActivity extends AppCompatActivity {


    String add_update,names,datespicker,timepicker,upozila,union,village;
    int intValue,mark;
    ArrayList<String> form;
    Button Save, Submit;
    LinearLayout test;
    String collector_name,username,password;

    String date;
    public String bl_status, hem_status, uri_status, pregfood_status, pregdan_status, four_status, del_status, feed_status, six_status, family_status, foltab_status, folimp_status;
    int i = 0;
    RadioGroup bloodpressure, hemoglobintest,
            urinetest, pregnancyfood, pregnancydanger,
            fourparts, delivery, feedbaby,
            sixmonths, familyplanning, folictablet,
            folictabletimportance;

    int id=intValue;
    String global_ida;

    ArrayList<FormItemUser> formItemAll;

    TextView tv1,tv2,tv3,comment,field;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        test= (LinearLayout)findViewById(R.id.commentSection);
        Save = (Button) findViewById(R.id.Savebtn);
        Submit = (Button) findViewById(R.id.Submit);
        bloodpressure = (RadioGroup) findViewById(R.id.bloodpressure);
        hemoglobintest = (RadioGroup) findViewById(R.id.hemoglobintest);
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
        comment=(TextView)findViewById(R.id.comment);
        field = (TextView)findViewById(R.id.field);
        tv1=(TextView)findViewById(R.id.textView3);
        Intent mIntent = getIntent();
        intValue = mIntent.getIntExtra("id", 0);
        names=mIntent.getStringExtra("name");
        mark=mIntent.getIntExtra("mark", 0);
        collector_name= mIntent.getStringExtra("c_name");
        upozila=mIntent.getStringExtra("upozila");
        union=mIntent.getStringExtra("union");
        village=mIntent.getStringExtra("village");

        datespicker= mIntent.getStringExtra("datepicker");
        timepicker=mIntent.getStringExtra("timepicker");


        SharedPreferences pref = this.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        // Toast.makeText(getApplicationContext(), "Now I am in onResume ", Toast.LENGTH_SHORT).show();

        username = pref.getString("username", null);
        password = pref.getString("password", null);




        Log.d("Status.......", "response length" + intValue);
        if(mark==1) {
            test.setVisibility(View.GONE);
            Save.setText("Insert");
        }
        // names = mIntent.getStringExtra("name");
        Log.d(".....>>>>>>>>>>", "Id in TestActivity  " + intValue);
        Log.d(".....>>>>>>>>>>", "response length" + names);
        ArrayList<FormItemUser> formItems;
        ArrayList<FormItemUser> formItems1;
        ArrayList<FormItemUser> formItems2;
        final FormTableUser formTable = new FormTableUser(TestActivity.this);
        formItems= formTable.getSpecificItem(intValue);
        formItems1= formTable.getSpecificItem(intValue);
        FormItemUser formItem;
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StorevaluesinVar();

                int status = 6;
                String global_id= "1";
                String name = names;
                String comments= "";
                String fields= "";
//                FormItemUser formItem = new FormItemUser(1, bl_status, hem_status, uri_status, pregfood_status, pregdan_status, four_status
//                        , del_status, feed_status, six_status, family_status, foltab_status, folimp_status,status,global_id,name,comments,fields);


                FormTableUser formTable = new FormTableUser(TestActivity.this);
                try {
                    if(mark==1) {
                        if ((formTable.updateItemq(intValue, bl_status, hem_status, uri_status, pregfood_status, pregdan_status, four_status
                                , del_status, feed_status, six_status, family_status, foltab_status, folimp_status, status, names,datespicker,timepicker,collector_name)) == 1) {

                            Toast.makeText(getApplicationContext(), "Data Inserted successfully for patient  " + name, Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(TestActivity.this, DisplayUserActivity.class);
                            startActivity(intent);
                        }
                    }
                    else {




                        ArrayList<FormItemUser> formTableUsers;
                        FormTableUser formTableUser= new FormTableUser(TestActivity.this);

                        formTableUsers=formTableUser.dateconcate(intValue);

                        for(FormItemUser formItemUser:formTableUsers)
                        {
                            date = formItemUser.getDatepick();
                        }
                        Calendar c = Calendar.getInstance();
                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                        String current_date=df.format(c.getTime());
                      //  String current_date1= current_date.toString();

                        String addspace=date.concat(" ");
                        String dateconcate= addspace.concat(String.valueOf(current_date));


                        Log.d(">>>>>","calender "+c);
                        Log.d(">>>>>","Current Date1 "+current_date);
                        Log.d(">>>>>","add space "+addspace);
                        Log.d(">>>>>","dateconcate "+dateconcate);
                        Log.d(">>>>>","calender "+c);





                        if ((formTable.updatefor(intValue, bl_status, hem_status, uri_status, pregfood_status, pregdan_status, four_status
                                , del_status, feed_status, six_status, family_status, foltab_status, folimp_status, status, dateconcate,upozila,union,village)) == 1) {

                            Toast.makeText(getApplicationContext(), "Data Updated successfully for patient  " + name, Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(TestActivity.this, DisplayUserActivity.class);
                            startActivity(intent);
                        }
                    }
                } catch (Exception e) {

                }
            }
        });

        for(FormItemUser ft: formItems)
        {
            if(ft.getBloodpressure().equals("Yes"))
                bloodpressure.check(R.id.ques1rad1);
            else
                bloodpressure.check(R.id.ques1rad2);

            if(ft.getHemoglobintest().equals("Yes"))
                hemoglobintest.check(R.id.radioButton3);
            else
                hemoglobintest.check(R.id.radioButton4);

            if(ft.getUrinetest().equals("Yes"))
                urinetest.check(R.id.radioButton);
            else
                urinetest.check(R.id.radioButton2);
            if(ft.getPregnancyfood().equals("Yes"))
                pregnancyfood.check(R.id.radioButton5);
            else
                pregnancyfood.check(R.id.radioButton6);

            if(ft.getPregnancydanger().equals("Yes"))
                pregnancydanger.check(R.id.radioButton7);
            else
                pregnancydanger.check(R.id.radioButton8);

            if(ft.getFourparts().equals("Yes"))
                fourparts.check(R.id.radioButton9);
            else
                fourparts.check(R.id.radioButton10);

            if(ft.getDelivery().equals("Yes"))
                delivery.check(R.id.radioButton11);
            else
                delivery.check(R.id.radioButton12);

            if(ft.getFeedbaby().equals("Yes"))
                feedbaby.check(R.id.radioButton13);
            else
                feedbaby.check(R.id.radioButton14);

            if(ft.getSixmonths().equals("Yes"))
                sixmonths.check(R.id.radioButton15);
            else
                sixmonths.check(R.id.radioButton16);

            if(ft.getFamilyplanning().equals("Yes"))
                familyplanning.check(R.id.radioButton17);
            else
                familyplanning.check(R.id.radioButton18);

            if(ft.getFolictablet().equals("Yes"))
                folictablet.check(R.id.radioButton19);
            else
                folictablet.check(R.id.radioButton20);
            if(!ft.getComments().equals(""))
            {
                comment.setVisibility(View.VISIBLE);
                comment.setText(ft.getComments());

            }

            if(ft.getStatus()==1)
                test.setVisibility(View.INVISIBLE);

            if(!ft.getFields().equals(""))
            {
                field.setVisibility(View.VISIBLE);
                field.setText(ft.getFields());

            }

            if(ft.getFolictabletimportance().equals("Yes"))
                folictabletimportance.check(R.id.radioButton21);
            else
                folictabletimportance.check(R.id.radioButton22);
        }
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FormTableUser formTableUser = new FormTableUser(TestActivity.this);
                formTableUser.updateIns("2",intValue);
                formItemAll=formTable.getSpecificItem(intValue);
                String tag_json_obj = "json_obj_req";
                String url = "http://www.kolorob.net/mamoni/survey/api/form";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jo = new JSONObject(response);
                                    Log.d(".....>>>>>>>>>>", "Status " + jo);
                                    String status = jo.getString("status");
                                    if(status.equals("2"))
                                    {
                                        FormTableUser formtableuser= new FormTableUser(TestActivity.this);
                                        formtableuser.updateglobalI(intValue,3);
                                        Save.setVisibility(View.GONE);
                                        Intent intent = new Intent(TestActivity.this,DisplayUserActivity.class);
                                        startActivity(intent);
                                    }

                                }

                                catch(Exception e)
                                {
                                }
                                Toast.makeText(TestActivity.this,response,Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(TestActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                            for(FormItemUser formItem1: formItemAll)
                            {
                                JSONObject jf= new JSONObject();
                                JSONObject fs=new JSONObject();



                                fs.put("form_type", "dh_antenantals");
                                fs.put("form_id",intValue);
                                jf.put("hemoglobintest",formItem1.getHemoglobintest());
                                jf.put("bloodpressure",formItem1.getBloodpressure());
                                jf.put("urinetest",formItem1.getUrinetest());
                                jf.put("pregnancyfood",formItem1.getPregnancyfood());
                                jf.put("pregnancydanger",formItem1.getPregnancydanger());
                                jf.put("fourparts",formItem1.getFourparts());
                                jf.put("delivery",formItem1.getDelivery());
                                jf.put("feedbaby",formItem1.getFeedbaby());
                                jf.put("sixmonths",formItem1.getSixmonths());
                                jf.put("familyplanning",formItem1.getFamilyplanning());
                                jf.put("folictablet",formItem1.getFolictablet());
                                jf.put("folictabletimportance",formItem1.getFolictabletimportance());
                                jf.put("patient_name",formItem1.getName());
                                jf.put("district",formItem1.getDivision());
                                jf.put("sub_district",formItem1.getUpozila());
                                jf.put("union",formItem1.getUnion());
                                jf.put("village",formItem1.getVillage());






                                fs.put("data",jf);





                                requests.put(fs);



                            }


                            //      jsonArray.put(formItemAll);
//                            JSONObject record = new JSONObject();
//                            record.put("hemoglobintest", false);
//                            record.put("urinetest", false);


                            //request
                            JSONObject request = new JSONObject();
                            request.put("type", add_update);
                            request.put("form_type", "dh_antenantals");
                            request.put("data", formItemAll);





                            //record ====================================2
                            //record
                            JSONObject record2 = new JSONObject();
                            record2.put("hemoglobintest", true);
                            record2.put("urinetest", true);


                            //request
                            JSONObject request2 = new JSONObject();
                            request2.put("type", add_update);
                            request2.put("form_type", "dh_antenantals");
                            //       request2.put("data", record);


                            //requests


                            //data
                            JSONObject data = new JSONObject();
                            data.put("username", username);
                            data.put("password", password);
                            data.put("requests", requests);

                            params.put("data", data.toString());
                        }
                        catch (Exception e){

                        }

                        return params;
                    }

                };

// Adding request to request queue

                RequestQueue requestQueue = Volley.newRequestQueue(TestActivity.this);
                requestQueue.add(stringRequest);
            }
        });
    }
    public void StorevaluesinVar() {
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


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
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