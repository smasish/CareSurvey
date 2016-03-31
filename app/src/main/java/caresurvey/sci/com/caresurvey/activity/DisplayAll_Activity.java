package caresurvey.sci.com.caresurvey.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
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
import caresurvey.sci.com.caresurvey.adapter.DisplayNamesWithStatusAdapter;
import caresurvey.sci.com.caresurvey.database.FormTable;
import caresurvey.sci.com.caresurvey.model.FormItem;

public class DisplayAll_Activity extends AppCompatActivity {
    Button btn;
    ListView listView;
    private String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_);
        ListView listView=(ListView)findViewById(R.id.user_list);
        btn=(Button)findViewById(R.id.addForm);
        user= "collecter";


        if(user.equals("supervisor"))
        {
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
                                FormTable formTable = new FormTable(DisplayAll_Activity.this);
                                // formTable.dropTable();
                                int formItemCount = forms.length();
                                for (int i = 0; i < formItemCount; i++) {
                                    try {
                                        JSONObject record = forms.getJSONObject(i);
                                        JSONObject fields = record.getJSONObject("data");
                                        FormItem et = FormItem.parseFormItem(i, record.getString("form_id"), fields);
                                        int q;
                                        q=record.getInt("form_id");
                                        formTable.insertItem(et);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                                SharedPreferences.Editor editor = pref.edit();
                                editor.putString("Timestamp_supervisor", jo.getJSONObject("updated_at").toString());
                                editor.commit();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(DisplayAll_Activity.this,error.toString(),Toast.LENGTH_LONG).show();
                        }
                    }) {

                @Override
                protected Map<String, String> getParams() {

                    Map<String, String> params = new HashMap<>();

                    try {
                        //data
                        JSONObject data = new JSONObject();
                        data.put("username", "taw_khan1@yahoo.com");
                        data.put("password", "taw1994");
                        data.put("get_all", true);

                        params.put("data", data.toString());
                    }
                    catch (Exception e){

                    }

                    return params;
                }

            };

// Adding request to request queue

            RequestQueue requestQueue = Volley.newRequestQueue(DisplayAll_Activity.this);
            requestQueue.add(stringRequest);







            ArrayList<FormItem> formItems;
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(DisplayAll_Activity.this, FormActivity.class);
                    startActivity(in);
                }
            });

            FormItem formItem;

            final FormTable formTable = new FormTable(DisplayAll_Activity.this);
            formItems= formTable.getAll();


            int k=0;
            int f= formItems.size();

            int[] id=new int[f];
            String[] name=new String[f];
            final int[] status= new int[f];


            for(FormItem ft: formItems)

            {

                id[k]= Integer.parseInt(ft.getGlobal_id());
                name[k]=ft.getName();
                status[k]=ft.getStatus();

                k++;



            }
            DisplayNamesWithStatusAdapter adapter=new DisplayNamesWithStatusAdapter(this,id,name,status);

            listView.setAdapter(adapter);

            //     Helpes.getListViewSize(courseListView);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent iiv = new Intent(DisplayAll_Activity.this,Supervisor_verificationActivity.class);
                    iiv.putExtra("position",position);
                    startActivity(iiv);

                }
            });


        }



        else if(user.equals("collecter"))
        {

            String tag_json_obj = "json_obj_req";

            String url = "http://www.kolorob.net/mamoni/survey/api/sync";

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                             Toast.makeText(DisplayAll_Activity.this,response,Toast.LENGTH_SHORT).show();

                            try {
                                JSONObject jo = new JSONObject(response);
                                JSONArray forms = jo.getJSONArray("forms");
//                                JSONObject joes = new JSONObject();
//                                joes= jo.getJSONObject("forms");
                                // saveForm(jo.getJSONArray(AppConstants.KEY_DATA));
                                FormTable formTable = new FormTable(DisplayAll_Activity.this);
                                int formItemCount = forms.length();




                                for (int i = 0; i < formItemCount; i++) {
                                    try {
                                        JSONObject record = forms.getJSONObject(i);
                                        JSONObject fields = record.getJSONObject("meta");
                                  //      FormItem et = FormItem.parseFormItem(i,record.getString("form_id"),fields);
                                        int status;
                                        String global_id,comments,fieldss;
                                        status=record.getInt("status");
                                        global_id=record.getString("form_id");
                                        comments=fields.getString("comments");
                                        fieldss=fields.getString("fields");

                                        formTable.updatefieldforuser(global_id,status,comments,fieldss);

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
                            Toast.makeText(DisplayAll_Activity.this,error.toString(),Toast.LENGTH_LONG).show();
                        }
                    }) {

                @Override
                protected Map<String, String> getParams() {

                    Map<String, String> params = new HashMap<>();

                    try {
                        //data
                        JSONObject data = new JSONObject();
                        data.put("username", "taw_khan@yahoo.com");
                        data.put("password", "taw1994");
                        data.put("timestamp", "2016-03-24 11:20:29");

                        params.put("data", data.toString());
                    }
                    catch (Exception e){

                    }

                    return params;
                }

            };

// Adding request to request queue

            RequestQueue requestQueue = Volley.newRequestQueue(DisplayAll_Activity.this);
            requestQueue.add(stringRequest);







            ArrayList<FormItem> formItems;
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent in = new Intent(DisplayAll_Activity.this, FormActivity.class);
                    startActivity(in);


                }
            });

            FormItem formItem;

            final FormTable formTable = new FormTable(DisplayAll_Activity.this);
            formItems= formTable.getAll();


            int k=0;
            int f= formItems.size();

            int[] id=new int[f];
            String[] name=new String[f];
            final int[] status= new int[f];


//            for(FormItem ft: formItems)
//
//            {
//                id[k]= Integer.parseInt(ft.getGlobal_id());
//                name[k]=ft.getName();
//                status[k]=ft.getStatus();
//
//                k++;
//
//
//
//            }
            DisplayNamesWithStatusAdapter adapter=new DisplayNamesWithStatusAdapter(this,id,name,status);

            listView.setAdapter(adapter);

            //     Helpes.getListViewSize(courseListView);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent iiv = new Intent(DisplayAll_Activity.this,TestActivity.class);
                    iiv.putExtra("position",position);
                    startActivity(iiv);

                }
            });




        }




        }






    private void saveForm(JSONArray formitem) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_all_, menu);
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
