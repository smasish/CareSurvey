package caresurvey.sci.com.caresurvey.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.utils.AppUtils;

/**
 * Created by shantanu on 6/24/16.
 */

public class FacilityAdminActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_DISTRICT = "user_district";
    public static final String EXTRA_USER_TYPE = "user_type";
    private Spinner userSpinner;
    private Spinner facilitySpinner;
    private ArrayAdapter<String> mAdapter;
    private static final String COLLECTOR_HB[] = {"Shubhra"};
    private static final String COLLECTOR_NK[] = {"Salma"};
    private static final String COLLECTOR_LP[] = {"Shrabani"};
    private static final String COLLECTOR_JK[] = {"Mitu"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_admin);
        findViewById(R.id.next).setOnClickListener(this);
        userSpinner = (Spinner) findViewById(R.id.user_spinner);
        facilitySpinner = (Spinner) findViewById(R.id.facility_spinner);
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//        String username = AppUtils.getUserName(this);
        String district = getIntent().getStringExtra(EXTRA_DISTRICT);
        String userType = getIntent().getStringExtra(EXTRA_USER_TYPE);
        mAdapter.add("Select user");
//        if("admin".equalsIgnoreCase(userType)){
//            mAdapter.addAll(Arrays.asList(COLLECTOR_HB));
//            mAdapter.addAll(Arrays.asList(COLLECTOR_NK));
//            mAdapter.addAll(Arrays.asList(COLLECTOR_LP));
//            mAdapter.addAll(Arrays.asList(COLLECTOR_JK));
//        }
//        else if("supervisor".equalsIgnoreCase(userType) || "districtadmin".equalsIgnoreCase(userType)){
//            if("Habiganj".equalsIgnoreCase(district)){
//                mAdapter.addAll(Arrays.asList(COLLECTOR_HB));
//            }
//            else if("Lakshmipur".equalsIgnoreCase(district)){
//                mAdapter.addAll(Arrays.asList(COLLECTOR_LP));
//            }
//            else if("Noakhali".equalsIgnoreCase(district)){
//                mAdapter.addAll(Arrays.asList(COLLECTOR_NK));
//            }
//            else if("Jhalakati".equalsIgnoreCase(district)){
//                mAdapter.addAll(Arrays.asList(COLLECTOR_JK));
//            }
//        }
        userSpinner.setAdapter(mAdapter);
        loadUser();
    }

    private void loadUser(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching user list...");
        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.POST, "http://119.148.43.34/mamoni/survey/api/getusers", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                response = response.replaceAll("\"","");
                String tokens[] = response.split("\n");
                if(tokens.length > 0){
                    for(int i=0;i<tokens.length;i++) {
                        String userInfo[] = tokens[i].split(",");
                        if(userInfo.length >= 1) {
                            mAdapter.add(userInfo[1].trim());
                        }
                    }
                }
                else{
                    Toast.makeText(FacilityAdminActivity.this,"No user found",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("username",AppUtils.getUserName(FacilityAdminActivity.this));
                params.put("password",AppUtils.getPassword(FacilityAdminActivity.this));

                try {
                    JSONObject data = new JSONObject();
                    data.put("username", AppUtils.getUserName(FacilityAdminActivity.this));
                    data.put("password", AppUtils.getPassword(FacilityAdminActivity.this));
                    params.put("data", data.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                //params.put("data", "{'username':'"+username+"','password':'"+password+"'}");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.next){
            if(userSpinner.getSelectedItemPosition() == 0 || facilitySpinner.getSelectedItemPosition() == 0){
                Toast.makeText(this,"Form is not complete",Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent = new Intent(this,ObservationAdminListActivity.class);
                intent.putExtra("user",userSpinner.getSelectedItem().toString());
                intent.putExtra("facility",facilitySpinner.getSelectedItem().toString());
                startActivity(intent);
            }
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        new AlertDialog.Builder(this)
                .setTitle("Close")
                .setMessage("Are you sure you want to close CareSuvey")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}
