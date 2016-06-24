package caresurvey.sci.com.caresurvey.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import caresurvey.sci.com.caresurvey.database.ANCSupervisorTable;
import caresurvey.sci.com.caresurvey.database.ANCTable;
import caresurvey.sci.com.caresurvey.database.FPObservationSupervisorTable;
import caresurvey.sci.com.caresurvey.database.FormTable;
import caresurvey.sci.com.caresurvey.database.FpObservationTable;
import caresurvey.sci.com.caresurvey.database.InventorySupervisorTable;
import caresurvey.sci.com.caresurvey.database.InventoryTable;
import caresurvey.sci.com.caresurvey.database.SatelliteClinicSupervisorTable;
import caresurvey.sci.com.caresurvey.database.SatelliteClinicTable;
import caresurvey.sci.com.caresurvey.database.SickChildSupervisorTable;
import caresurvey.sci.com.caresurvey.database.SickChildSupervisorTable2;
import caresurvey.sci.com.caresurvey.database.SickChildTable;
import caresurvey.sci.com.caresurvey.model.ANCFormItem;
import caresurvey.sci.com.caresurvey.model.FpObservationFormItem;
import caresurvey.sci.com.caresurvey.model.InventoryItem;
import caresurvey.sci.com.caresurvey.model.SatelliteClinicItem;
import caresurvey.sci.com.caresurvey.model.SickChildItem;
import caresurvey.sci.com.caresurvey.model.SickChildItemSupervisor;
import caresurvey.sci.com.caresurvey.utils.AppUtils;

//import caresurvey.sci.com.caresurvey.activity.SurveyActivity;

public class LoginActivity extends AppCompatActivity {
    ProgressDialog pd;
    String p;
    String k;
    EditText username,password;
    Button login;
    TextView text;
    String user="",pass="";
    private Context con;
    private boolean flag = false;
    int increment;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        text=(TextView)findViewById(R.id.falsermal_text);


        con = this;
        username=(EditText)findViewById(R.id.us);
        flag = false;


        password=(EditText)findViewById(R.id.password);
        //    p=username.getText().toString();


        Log.d(".....>>>>>>>>>>", "response length      " + user);

        //      p= "admin";

        login =(Button)findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = username.getText().toString().trim();
                pass = password.getText().toString().trim();

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("username", user);
                editor.putString("password", pass);

                editor.commit();


                Log.d(".....>>>>>>>>>>", "response lengthcc   " + user);
                if (user.equalsIgnoreCase("") || pass.equalsIgnoreCase("")) {
                    AlertMessage.showMessage(con, getString(R.string.title),
                            getString(R.string.msg));
                } else if (user.equals("admin") && pass.equalsIgnoreCase("admin")) {
                    LoadDataSupervisor();
//                    LoadDataSupervisorChildSick();

                    flag = true;

                    //      k = "supervisor";
                } else if (user.equals("user_hb1") && pass.equalsIgnoreCase("pass_hb1")) {

                    LoadDataCollector();
                    flag = true;
                }


                else if (user.equals("user_hb2") && pass.equalsIgnoreCase("pass_hb2")) {

                    LoadDataCollector();
                    flag = true;
                }


                else if (user.equals("user_hb3") && pass.equalsIgnoreCase("pass_hb3")) {

                    LoadDataCollector();
                    flag = true;
                }

                else if (user.equals("user_hb4") && pass.equalsIgnoreCase("pass_hb4")) {

                    LoadDataCollector();
                    flag = true;
                }

                else if (user.equals("user_lk1") && pass.equalsIgnoreCase("pass_lk1")) {

                    LoadDataCollector();
                    flag = true;
                }
                else if (user.equals("user_lk2") && pass.equalsIgnoreCase("pass_lk2")) {

                    LoadDataCollector();
                    flag = true;
                }
                else if (user.equals("user_lk3") && pass.equalsIgnoreCase("pass_lk3")) {

                    LoadDataCollector();
                    flag = true;
                }
                else if (user.equals("user_nk1") && pass.equalsIgnoreCase("pass_nk1")) {

                    LoadDataCollector();
                    flag = true;
                }
                else if (user.equals("user_nk2") && pass.equalsIgnoreCase("pass_nk2")) {

                    LoadDataCollector();
                    flag = true;
                }
                else if (user.equals("user_nk3") && pass.equalsIgnoreCase("pass_nk3")) {

                    LoadDataCollector();
                    flag = true;
                }
                else if (user.equals("user_jk1") && pass.equalsIgnoreCase("pass_jk1")) {

                    LoadDataCollector();
                    flag = true;
                }
                else if (user.equals("user_jk2") && pass.equalsIgnoreCase("pass_jk2")) {

                    LoadDataCollector();
                    flag = true;
                }
                else if (user.equals("user_jk3") && pass.equalsIgnoreCase("pass_jk3")) {

                    LoadDataCollector();
                    flag = true;
                }
                //  k="collector";


                if (flag) {

                    handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                /* start the activity */
//                            pd.dismiss();
//
//                            if (user.equals("admin")) {
////                                Intent intent = new Intent(LoginActivity.this, DisplayAll_Activity.class);
////                                startActivity(intent);
//
//
//                                Intent intent = new Intent(LoginActivity.this, SurveyActivity.class);
//                                startActivity(intent);
//                            } else if (user.equals("user_hb1")) {
//                                Intent intentX = new Intent(LoginActivity.this, SelectionUserActivity.class);
//                                startActivity(intentX);
//                            }
//
//
//                            else if (user.equals("user_hb2")) {
//                                Intent intentX = new Intent(LoginActivity.this, SelectionUserActivity.class);
//                                startActivity(intentX);
//                            }
//
//                            else if (user.equals("user_hb3")) {
//                                Intent intentX = new Intent(LoginActivity.this, SelectionUserActivity.class);
//                                startActivity(intentX);
//                            }
//
//                            else if (user.equals("user_hb4")) {
//                                Intent intentX = new Intent(LoginActivity.this, SelectionUserActivity.class);
//                                startActivity(intentX);
//                            }
//                            //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                            overridePendingTransition(0, 0);
//
//                            finish();
//                        }
//                    }, 5000);

                }
                //
//              Intent in = new Intent(LoginActivity.this,DisplayAll_Activity.class);
//             startActivity(in);

            }
        });



        text.setText("MaMoni Health System Strengthening \n           (MaMoni HSS) Project");
        text.setTextSize(25);
    }
//    private void submitFeedback(){
//        String url = "http://119.148.43.34/mamoni/survey/api/login";
//
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                      //  Toast.makeText(LoginActivity.this, response, Toast.LENGTH_LONG).show();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG).show();
//                    }
//                }){
//            @Override
//            protected Map<String,String> getParams(){
//                Map<String,String> params = new HashMap<String, String>();
//
//                try {
//
//               JSONObject data = new JSONObject();
//
//
//               data.put("username",username.toString().trim());
//               data.put("password",password.toString().trim());
//               params.put("data",data.toString());
//
//
//
//               }
//
//
//              catch (Exception e)
//                  {
//
//                     }
//                return params;
//            }
//
//        };
//
//
//
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//    }









    public void LoadDataSupervisorChildSick()
    {

        FormTable formTablec = new FormTable(LoginActivity.this);
        //  formTablec.dropTable();
        String tag_json_obj = "json_obj_req";

        String url = "http://119.148.43.34/mamoni/survey/api/sync";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //     Toast.makeText(DisplayAll_Activity.this,response,Toast.LENGTH_SHORT).show();
                        Log.e("supervisor child:",response);
                        try {
                            JSONObject jo = new JSONObject(response);
                            JSONArray forms = jo.getJSONArray("forms");
//                                JSONObject joes = new JSONObject();
//                                joes= jo.getJSONObject("forms");
                            // saveForm(jo.getJSONArray(AppConstants.KEY_DATA));

                            SickChildSupervisorTable sickChildSupervisorTable= new SickChildSupervisorTable(LoginActivity.this);
                            // formTable.dropTable();
                            int formItemCount = forms.length();
                            Log.d(".....>>>>>>>>>>", "formItemCount    " + formItemCount);
                            increment=1;
                            for (int i = 0; i < formItemCount; i++) {
                                try {

                                    JSONObject record = forms.getJSONObject(i);
                                    String s;
                                    s=record.getString("submitted_by");
                                    Log.d(".....>>>>>>>>>>", "i    " + i);
                                    JSONObject fields = record.getJSONObject("data");

                                    SickChildItemSupervisor sickChildItemSupervisor = SickChildItemSupervisor.parseSickChildItemSupervisor(increment, record.getString("form_id"), record.getInt("status"), fields, record.getString("submitted_by"));

                                    long success;
                                    success=sickChildSupervisorTable.insertItem(sickChildItemSupervisor);
                                    if(success==1)
                                        increment++;

                                }
                                catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }




                        try
                        {
                            JSONObject jox = new JSONObject(response);
                            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("Timestamp_supervisor", jox.getJSONObject("updated_at").toString());
                            editor.commit();
                        }
                        catch (Exception e)
                        {

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //  Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        pd.dismiss();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();

                try {
                    //data
                    JSONObject data = new JSONObject();
                    data.put("username", "supervisor");
                    data.put("password", "supervisor");
                    data.put("get_all", true);
                    params.put("data", data.toString());
                }
                catch (Exception e){

                }

                return params;
            }
        };

// Adding request to request queue

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(stringRequest);
        pd = new ProgressDialog(this);
        pd.setMessage("Fetching The File....");
        pd.show();
    }







    public void LoadDataSupervisor()
    {

        FormTable formTablec = new FormTable(LoginActivity.this);
        //  formTablec.dropTable();
        String tag_json_obj = "json_obj_req";

        String url = "http://119.148.43.34/mamoni/survey/api/sync";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //     Toast.makeText(DisplayAll_Activity.this,response,Toast.LENGTH_SHORT).show();
                        Log.e("supervisor:", response);
                        try {
                            JSONObject jo = new JSONObject(response);
                            JSONArray forms = jo.getJSONArray("forms");
////                                JSONObject joes = new JSONObject();
////                                joes= jo.getJSONObject("forms");
//                            // saveForm(jo.getJSONArray(AppConstants.KEY_DATA));
//                            FormTable formTable = new FormTable(LoginActivity.this);
//                            // formTable.dropTable();
                            int formItemCount = forms.length();
                            for(int i=0;i<formItemCount;i++){
                                JSONObject form = forms.getJSONObject(i);
                                if(form.getString("form_type").equals("dh_familyplan")){
                                    FPObservationSupervisorTable table = new FPObservationSupervisorTable(LoginActivity.this);
                                    table.insert(FpObservationFormItem.getObject(form.toString()));
                                }
                                else if(form.getString("form_type").equals("dh_satelliteclinic")){
                                    SatelliteClinicSupervisorTable table = new SatelliteClinicSupervisorTable(LoginActivity.this);
                                    table.insert(SatelliteClinicItem.getObject(form.toString()));
                                }
                                else if(form.getString("form_type").equals("dh_sickchild")){
                                    SickChildSupervisorTable2 table = new SickChildSupervisorTable2(LoginActivity.this);
                                    table.insert(SickChildItem.getObject(form.toString()));
                                }
                                else if(form.getString("form_type").equals("dh_inventory")){
                                    InventorySupervisorTable table = new InventorySupervisorTable(LoginActivity.this);
                                    table.insert(InventoryItem.getObject(form.toString()));
                                }
                                else if(form.getString("form_type").equals("dh_antenantals")){
                                    ANCSupervisorTable table = new ANCSupervisorTable(LoginActivity.this);
                                    table.insert(ANCFormItem.getObject(form.toString()));
                                }
                            }
//                            for (int i = 0; i < formItemCount; i++) {
//                                try {
//                                    JSONObject record = forms.getJSONObject(i);
//                                    String s;
//                                    s=record.getString("submitted_by");
//                                    Log.d(".....>>>>>>>>>>", "response length" + record);
//                                    JSONObject fields = record.getJSONObject("data");
//                                    FormItem et = FormItem.parseFormItem(i+1, record.getString("form_id"),record.getInt("status"), fields,record.getString("submitted_by"));
//                                    int q;
//                                    q=record.getInt("form_id");
//                                    formTable.insertItem(et);
//                                }
//                                catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }




                        try
                        {
                            JSONObject jox = new JSONObject(response);
                            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("Timestamp_supervisor", jox.getJSONObject("updated_at").toString());
                            editor.commit();
                        }
                        catch (Exception e)
                        {

                        }
                        finishActivity();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                          Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        pd.dismiss();
//                        finishActivity();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();

                try {
                    //data
                    JSONObject data = new JSONObject();
                    data.put("username", "supervisor");
                    data.put("password", "supervisor");
                    data.put("get_all", true);
                    params.put("data", data.toString());
                }
                catch (Exception e){

                }

                return params;
            }
        };

// Adding request to request queue

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(stringRequest);
        pd = new ProgressDialog(this);
        pd.setMessage("Fetching The File....");
        pd.show();
    }

    private void finishActivity(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /* start the activity */
                pd.dismiss();

                if (user.equals("admin")) {
//                                Intent intent = new Intent(LoginActivity.this, DisplayAll_Activity.class);
//                                startActivity(intent);


//                    Intent intent = new Intent(LoginActivity.this, SurveyActivity.class);
                    Intent intent = new Intent(LoginActivity.this, FacilityAdminActivity.class);
                    startActivity(intent);
                } else if (user.equals("user_hb1")) {
                    Intent intentX = new Intent(LoginActivity.this, SelectionUserActivity.class);
                    startActivity(intentX);
                }


                else if (user.equals("user_hb2")) {
                    Intent intentX = new Intent(LoginActivity.this, SelectionUserActivity.class);
                    startActivity(intentX);
                }

                else if (user.equals("user_hb3")) {
                    Intent intentX = new Intent(LoginActivity.this, SelectionUserActivity.class);
                    startActivity(intentX);
                }

                else if (user.equals("user_hb4")) {
                    Intent intentX = new Intent(LoginActivity.this, SelectionUserActivity.class);
                    startActivity(intentX);
                }
                //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                overridePendingTransition(0, 0);

                finish();
            }
        }, 1000);

    }



    public void LoadDataCollector()
    {
        String tag_json_obj = "json_obj_req";

        String url = "http://119.148.43.34/mamoni/survey/api/sync";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //        Toast.makeText(LoginActivity.this,response,Toast.LENGTH_SHORT).show();
                        Log.e("response: ", response);
                        try {
                            JSONObject jo = new JSONObject(response);
                            JSONArray forms = jo.getJSONArray("forms");

                            for(int i=0;i<forms.length();i++){
                                JSONObject object = forms.getJSONObject(i);
                                String formType = AppUtils.getString(object,"form_type");
                                if(formType.equals("dh_familyplan")){
                                    FpObservationTable table = new FpObservationTable(LoginActivity.this);
                                    table.insert(FpObservationFormItem.getUserObjct(object.toString()));
                                }
                                else if(formType.equals("dh_satelliteclinic")){
                                    SatelliteClinicTable table = new SatelliteClinicTable(LoginActivity.this);
                                    table.insert(SatelliteClinicItem.getUserObject(object.toString()));
                                }
                                else if(formType.equals("dh_sickchild")){
                                    SickChildTable table = new SickChildTable(LoginActivity.this);
                                    table.insert(SickChildItem.getUserObject(object.toString()));
                                }
                                else if(formType.equals("dh_antenantals")){
                                    ANCTable table = new ANCTable(LoginActivity.this);
                                    table.insert(ANCFormItem.getUserObject(object.toString()));
                                }
                                else if(formType.equals("dh_inventory")){
                                    InventoryTable table = new InventoryTable(LoginActivity.this);
                                    table.insert(InventoryItem.getUserObject(object.toString()));
                                }
                            }

//                                JSONObject joes = new JSONObject();
//                                joes= jo.getJSONObject("forms");
                            // saveForm(jo.getJSONArray(AppConstants.KEY_DATA));
//                            FormTableUser formTable = new FormTableUser(LoginActivity.this);
//                            int formItemCount = forms.length();
//
//
//
//
//
//                            for (int i = 0; i < formItemCount; i++) {
//                                try {
//                                    JSONObject record = forms.getJSONObject(i);
//                                    JSONObject fields = record.getJSONObject("meta");
//                                    //      FormItem et = FormItem.parseFormItem(i,record.getString("form_id"),fields);
//                                    int status,global_id;
//                                    String comments,fieldss;
//                                    status=record.getInt("status");
//                                    global_id=record.getInt("form_id");
//                                    comments=fields.getString("comments");
//                                    fieldss=fields.getString("fields");
//                                    JSONObject data= record.getJSONObject("data");
//                                    String name= data.getString("patient_name");
//                                    long vfdf,vfdf1,vfdf2;
//                                    //vfdf=  formTable.updatefieldforuser(global_id, status, comments, fieldss);
//                                    vfdf2=formTable.updateglobalId(global_id, status, comments, fieldss,name);
//                                    //  vfdf1=  formTable.updatefieldforuser(global_id, status, comments, fieldss);
//                                    //    Log.d(".....>>>>>>>>>>", "success" + vfdf);
//                                    Log.d(".....>>>>>>>>>>", "success" + vfdf2);
//                                    //    Log.d(".....>>>>>>>>>>", "success" + vfdf1);
//
//                                    //formTable.insertItem(et);
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }







                            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("Timestamp", jo.getString("updated_at"));
                            editor.commit();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        finishActivity();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG).show();
//                        finishActivity();
                        pd.dismiss();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();

                try {
                    //data
                    JSONObject data = new JSONObject();
                    data.put("username", username.getText().toString().trim());
                    data.put("password", password.getText().toString().trim());
                    data.put("get_all", true);

                    params.put("data", data.toString());
                }
                catch (Exception e){

                }

                return params;
            }

        };

// Adding request to request queue

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(stringRequest);


        pd = new ProgressDialog(this);
        pd.setMessage("Fetching The File....");
        pd.show();


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_activity1, menu);
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
