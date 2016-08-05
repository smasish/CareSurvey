package caresurvey.sci.com.caresurvey.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
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
import java.util.StringTokenizer;

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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    String p;
    String k;
    private EditText username,password;
    Button login;
   // TextView text;
    String user="",pass="";
    private Context con;
    private boolean flag = false;
    int increment;
    Handler handler;

    private static final String REGISTER_URL = "http://119.148.43.34/mamoni/survey/api/login";

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    private static ProgressDialog pd;
    private String userDistrict;
    private String userType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        con = this;
        username=(EditText)findViewById(R.id.user);
        password=(EditText)findViewById(R.id.password);
        login =(Button)findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    public void onClick(View v) {
        if(v == login){
            String title = "loading";
            String message = "Checking username \nPlease wait...";
            pd = ProgressDialog.show(con, title, message, true, true);
            loginUser();
        }
    }

    private void loginUser(){
        user= username.getText().toString().trim();
        pass = password.getText().toString().trim();
        AppUtils.setUserName(LoginActivity.this,user);
        AppUtils.setUserPassword(LoginActivity.this,pass);
        //  final String email = editTextEmail.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("response---", "********" + response.toString());
                        pd.dismiss();
                        String responseStr = response.toString();
                        responseStr = responseStr.replaceAll("\"","");
                        String tokens[] =  responseStr.split(",");

                        if(tokens.length != 3){ //invalid response
                            Toast.makeText(LoginActivity.this, "Invalid response", Toast.LENGTH_SHORT).show();
                            AppUtils.setUserType(LoginActivity.this,"");
                        }
                        else{
                            userDistrict = tokens[2].trim();
                            userType = tokens[0];
                            AppUtils.setUserType(LoginActivity.this,userType);
                            if("collector".equalsIgnoreCase(userType)){
                                LoadDataCollector();
                            }
                            else if("supervisor".equalsIgnoreCase(userType) || "admin".equalsIgnoreCase(userType) || "districtadmin".equalsIgnoreCase(userType)){
                                LoadDataSupervisor();
                            }

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.dismiss();
                        Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME,user);
                params.put(KEY_PASSWORD,pass);

                try {
                    JSONObject data = new JSONObject();
                    data.put("username", user);
                    data.put("password", pass);
                    Log.e("request",data.toString());
                    params.put("data", data.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                //params.put("data", "{'username':'"+username+"','password':'"+password+"'}");
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    public void LoadDataSupervisor()
    {
        pd.setMessage("Fetching The File....");
        pd.show();
        FormTable formTablec = new FormTable(LoginActivity.this);
        //  formTablec.dropTable();
        String tag_json_obj = "json_obj_req";

        String url = "http://119.148.43.34/mamoni/survey/api/sync";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("supervisor:", response);
                        pd.dismiss();
                        try {
                            JSONObject jo = new JSONObject(response);
                            JSONArray forms = jo.getJSONArray("forms");
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
                                    Log.e("Inventory table row","" + table.getRowSize());
                                }
                                else if(form.getString("form_type").equals("dh_antenantals")){
                                    ANCSupervisorTable table = new ANCSupervisorTable(LoginActivity.this);
                                    table.insert(ANCFormItem.getObject(form.toString()));
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this,"An error occurred during sync " + e.toString(),Toast.LENGTH_SHORT).show();
                            return;
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
                            e.printStackTrace();
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
                    data.put("username", AppUtils.getUserName(LoginActivity.this));
                    data.put("password", AppUtils.getPassword(LoginActivity.this));
                    data.put("get_all", true);
                    Log.e("sync supervisor request",data.toString());
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

    }

    private void finishActivity(){
        if("collector".equalsIgnoreCase(userType)){
            Intent intent = new Intent(LoginActivity.this, SelectionUserActivity.class);
            intent.putExtra(SelectionActivity.EXTRA_DISTRICT,userDistrict);
            startActivity(intent);
        }
        else if("supervisor".equalsIgnoreCase(userType) || "admin".equalsIgnoreCase(userType)  || "districtadmin".equalsIgnoreCase(userType)){
            Intent intent = new Intent(LoginActivity.this, FacilityAdminActivity.class);
            intent.putExtra(FacilityAdminActivity.EXTRA_DISTRICT,userDistrict);
            intent.putExtra(FacilityAdminActivity.EXTRA_USER_TYPE,userType);
            startActivity(intent);
        }
        else{
            Toast.makeText(LoginActivity.this,"Invalid user type",Toast.LENGTH_SHORT).show();
            return;
        }
        finish();
    }



    public void LoadDataCollector()
    {
        pd.setMessage("Fetching The File....");
        pd.show();
        String tag_json_obj = "json_obj_req";
        String u = AppUtils.getUserName(LoginActivity.this);
        String p = AppUtils.getPassword(LoginActivity.this);
        String url = "http://119.148.43.34/mamoni/survey/api/sync";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //        Toast.makeText(LoginActivity.this,response,Toast.LENGTH_SHORT).show();
                        pd.dismiss();
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


                            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("Timestamp", jo.getString("updated_at"));
                            editor.commit();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this,"An error occurred during sync " + e.toString(),Toast.LENGTH_SHORT).show();
                            return;
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
                    Log.e("sync collector request",data.toString());
                    params.put("data", data.toString());
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                return params;
            }

        };

// Adding request to request queue

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(stringRequest);
    }
}
