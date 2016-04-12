package caresurvey.sci.com.caresurvey.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
//import caresurvey.sci.com.caresurvey.activity.SurveyActivity;
import caresurvey.sci.com.caresurvey.database.FormTable;
import caresurvey.sci.com.caresurvey.database.FormTableUser;
import caresurvey.sci.com.caresurvey.model.FormItem;
import caresurvey.sci.com.caresurvey.utils.AppConstants;

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
                user = username.getText().toString();
                pass = password.getText().toString();
                Log.d(".....>>>>>>>>>>", "response lengthcc   " + user);
                if (user.equalsIgnoreCase("") || pass.equalsIgnoreCase("")) {
                    AlertMessage.showMessage(con, getString(R.string.title),
                            getString(R.string.msg));
                } else if (user.equals("admin") && pass.equalsIgnoreCase("admin")) {
                    LoadDataSupervisor();
                    flag = true;

                    //      k = "supervisor";
                } else if (user.equals("user") && pass.equalsIgnoreCase("user")) {

                    LoadDataCollector();
                    flag = true;
                }
                //  k="collector";


                if (flag) {

                    handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                /* start the activity */
                            pd.dismiss();

                            if (user.equals("admin")) {
//                                Intent intent = new Intent(LoginActivity.this, DisplayAll_Activity.class);
//                                startActivity(intent);


                                Intent intent = new Intent(LoginActivity.this, PrepopSqliteDbActivity.class);
                                startActivity(intent);
                            } else if (user.equals("user")) {
                                Intent intentX = new Intent(LoginActivity.this, UserActivity.class);
                                startActivity(intentX);
                            }
                            //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            overridePendingTransition(0, 0);

                            finish();
                        }
                    }, 6000);

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
//        String url = "http://www.kolorob.net/mamoni/survey/api/login";
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


    public void LoadDataSupervisor()
    {

        FormTable formTablec = new FormTable(LoginActivity.this);
        //  formTablec.dropTable();
        String tag_json_obj = "json_obj_req";

        String url = "http://www.kolorob.net/mamoni/survey/api/sync";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //     Toast.makeText(DisplayAll_Activity.this,response,Toast.LENGTH_SHORT).show();

                        try {
                            JSONObject jo = new JSONObject(response);
                            JSONArray forms = jo.getJSONArray("forms");
//                                JSONObject joes = new JSONObject();
//                                joes= jo.getJSONObject("forms");
                            // saveForm(jo.getJSONArray(AppConstants.KEY_DATA));
                            FormTable formTable = new FormTable(LoginActivity.this);
                            // formTable.dropTable();
                            int formItemCount = forms.length();
                            for (int i = 0; i < formItemCount; i++) {
                                try {
                                    JSONObject record = forms.getJSONObject(i);
                                    String s;
                                    s=record.getString("submitted_by");
                                    Log.d(".....>>>>>>>>>>", "response length" + record);
                                    JSONObject fields = record.getJSONObject("data");
                                    FormItem et = FormItem.parseFormItem(i+1, record.getString("form_id"),record.getInt("status"), fields,record.getString("submitted_by"));
                                    int q;
                                    q=record.getInt("form_id");
                                    formTable.insertItem(et);
                                } catch (JSONException e) {
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
                        Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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



    public void LoadDataCollector()
    {
        String tag_json_obj = "json_obj_req";

        String url = "http://www.kolorob.net/mamoni/survey/api/sync";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(LoginActivity.this,response,Toast.LENGTH_SHORT).show();

                        try {
                            JSONObject jo = new JSONObject(response);
                            JSONArray forms = jo.getJSONArray("forms");
//                                JSONObject joes = new JSONObject();
//                                joes= jo.getJSONObject("forms");
                            // saveForm(jo.getJSONArray(AppConstants.KEY_DATA));
                            FormTableUser formTable = new FormTableUser(LoginActivity.this);
                            int formItemCount = forms.length();





                            for (int i = 0; i < formItemCount; i++) {
                                try {
                                    JSONObject record = forms.getJSONObject(i);
                                    JSONObject fields = record.getJSONObject("meta");
                                    //      FormItem et = FormItem.parseFormItem(i,record.getString("form_id"),fields);
                                    int status,global_id;
                                    String comments,fieldss;
                                    status=record.getInt("status");
                                    global_id=record.getInt("form_id");
                                    comments=fields.getString("comments");
                                    fieldss=fields.getString("fields");
                                    JSONObject data= record.getJSONObject("data");
                                    String name= data.getString("patient_name");
                                    long vfdf,vfdf1,vfdf2;
                                    //vfdf=  formTable.updatefieldforuser(global_id, status, comments, fieldss);
                                    vfdf2=formTable.updateglobalId(global_id, status, comments, fieldss,name);
                                  //  vfdf1=  formTable.updatefieldforuser(global_id, status, comments, fieldss);
                                //    Log.d(".....>>>>>>>>>>", "success" + vfdf);
                                    Log.d(".....>>>>>>>>>>", "success" + vfdf2);
                                //    Log.d(".....>>>>>>>>>>", "success" + vfdf1);

                                    //formTable.insertItem(et);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }







                            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("Timestamp", jo.getJSONObject("updated_at").toString());
                            editor.commit();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();

                try {
                    //data
                    JSONObject data = new JSONObject();
                    data.put("username", "collector");
                    data.put("password", "collector");
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
