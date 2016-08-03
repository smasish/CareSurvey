package caresurvey.sci.com.caresurvey.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.InventorySupervisorTable;
import caresurvey.sci.com.caresurvey.database.InventoryTable;
import caresurvey.sci.com.caresurvey.fragments.FacilityInventoryFragment;
import caresurvey.sci.com.caresurvey.model.InventoryItem;
import caresurvey.sci.com.caresurvey.utils.AppUtils;
import caresurvey.sci.com.caresurvey.widgets.QCheckBox;

import static caresurvey.sci.com.caresurvey.utils.AppUtils.setTextWithFonts;

public class FacilityInventoryActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int resources[] = new int[]{R.layout.activity_facility_inventory1,
    R.layout.activity_facility_inventory2,R.layout.activity_facility_inventory3,R.layout.activity_facility_inventory4,
            R.layout.activity_facility_inventory5,R.layout.activity_facility_inventory6};
    private InventoryItem item;
    private InventoryTable table;
    private int mark;
    private String datespicker;
    private String timepicker;
    private String obsType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp_inventory);
        table = new InventoryTable(this);
        Intent mIntent = getIntent();
        if(mIntent.hasExtra(DisplayUserActivity.FORM_ID)){ //alreay have one
            if(mIntent.hasExtra(SurveyActivity.FROM_ADMIN)){
                findViewById(R.id.admin_btn_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.accept).setOnClickListener(this);
                findViewById(R.id.revert).setOnClickListener(this);
//                findViewById(R.id.user_btn_layout).setVisibility(View.GONE);
                InventorySupervisorTable supervisorTable = new InventorySupervisorTable(this);
                item = supervisorTable.get(mIntent.getLongExtra(DisplayUserActivity.FORM_ID,0L));
            }
            else {
//                findViewById(R.id.user_btn_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.admin_btn_layout).setVisibility(View.GONE);
                item = table.get(mIntent.getLongExtra(DisplayUserActivity.FORM_ID, 0));
            }
        }
        else{
            item = new InventoryItem();
        }
        item.name = mIntent.getStringExtra("name");
        item.designation = mIntent.getStringExtra("designation");
        mark = mIntent.getIntExtra("mark", 0);
        item.collector_name = mIntent.getStringExtra("c_name");
        item.upozila = mIntent.getStringExtra("upozila");
        item.union = mIntent.getStringExtra("union");
        item.village = mIntent.getStringExtra("village");
        item.facility = mIntent.getStringExtra("facility");
        item.district = mIntent.getStringExtra("district");
        item.lat = mIntent.getStringExtra("lat");
        item.lon = mIntent.getStringExtra("lon");

        datespicker = mIntent.getStringExtra("datepicker");
        item.start_time = timepicker = mIntent.getStringExtra("timepicker");
        obsType = mIntent.getStringExtra("obstype");
        item.facility_id = mIntent.getIntExtra("serial",0);
        loadFragment(0);

    }

    public boolean isAdmin(){
        if(getIntent().hasExtra(SurveyActivity.FROM_ADMIN)){
            return true;
        }
        return false;
    }

    public InventoryTable getTable(){
        return table;
    }

    public InventoryItem getItem(){
        return this.item;
    }

    public void loadFragment(int index){
        if(index < 0 && index >= resources.length) return;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,FacilityInventoryFragment.newInstance(index)).commit();
    }

    public void submit(){
        final InventoryItem item = getItem();
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait...");
        final AlertDialog.Builder alert = new AlertDialog.Builder(FacilityInventoryActivity.this);
        if(item != null) {
            String url = "http://119.148.43.34/mamoni/survey/api/form";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            dialog.dismiss();

                            try {
                                final JSONObject jo = new JSONObject(response);
                                if(jo.has("errorCount")){
                                    alert.setMessage(jo.getString("message"));
                                }
                                else{
                                    alert.setMessage("Invalid response");
                                }
                                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        try {
                                            if (jo.getInt("errorCount") == 0) {
                                                if(item.status == 7) //incomplete
                                                {
                                                    item.status = 3;//pending
                                                    table.insert(item);
                                                }
                                                finish();
                                            }
                                        }catch(Exception e){
                                            e.printStackTrace();
                                        }
                                    }
                                });
                                alert.show();

                            } catch (Exception e) {
                                e.printStackTrace();
                                alert.setMessage("An error occurred")   ;
                                alert.show();
                            }
                            //  Toast.makeText(TestActivity.this,response,Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            dialog.dismiss();
                            //    Toast.makeText(TestActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                            alert.setMessage("An error occurred");
                            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            alert.show();
                            error.printStackTrace();
                        }
                    }) {

                @Override
                protected Map<String, String> getParams() {

                    Map<String, String> params = new HashMap<>();

                    try {
                        //record ====================================1
                        //record
                        JSONObject finalRequest = new JSONObject();
                        finalRequest.put("username", AppUtils.getUserName(FacilityInventoryActivity.this));
                        finalRequest.put("password",AppUtils.getPassword(FacilityInventoryActivity.this));
                        JSONArray requests = new JSONArray();
                        JSONObject object = new JSONObject();
                        object.put("form_id",item.id);
                        object.put("form_type","dh_inventory");
                        JSONObject data = new JSONObject();

                        data.put("facility_id",item.facility_id);
                        data.put(InventoryTable.client_name,item.client_name);
                        data.put(InventoryTable.start_time,item.start_time);
                        data.put(InventoryTable.instrument_sp_name,item.instrument_sp_name);
                        data.put(InventoryTable.instrument_sp_designation,item.instrument_sp_designation);
                        data.put(InventoryTable.i_electronic_autoclev,gJAv(item.i_electronic_autoclev));
                        data.put(InventoryTable.i_non_electronic_autoclev,gJAv(item.i_non_electronic_autoclev));
                        data.put(InventoryTable.i_electric_sterilizer,gJAv(item.i_electric_sterilizer));
                        data.put(InventoryTable.i_electric_steamer,gJAv(item.i_electric_steamer));
                        data.put(InventoryTable.i_non_electric_pot,gJAv(item.i_non_electric_pot));
                        data.put(InventoryTable.i_stove,gJAv(item.i_stove));
                        data.put(InventoryTable.i_waste_sp_name,item.i_waste_sp_name);
                        data.put(InventoryTable.i_waste_sp_designation,item.i_waste_sp_designation);
                        data.put(InventoryTable.w_waste_option,gJAv(item.w_waste_option));
                        data.put(InventoryTable.w_waste_dispose_how,gJAv(item.w_waste_dispose_how));
                        data.put(InventoryTable.w_pointy_waste,gJAv(item.w_pointy_waste));
                        data.put(InventoryTable.w_liquid_waste,gJAv(item.w_liquid_waste));
                        data.put(InventoryTable.w_liquid_waste_store,gJAv(item.w_liquid_waste_store));
                        data.put(InventoryTable.w_plastic_waste,gJAv(item.w_plastic_waste));
                        data.put(InventoryTable.w_waste_normal,gJAv(item.w_waste_normal));
                        data.put(InventoryTable.w_incinerator_seen,gJAv(item.w_incinerator_seen));
                        data.put(InventoryTable.w_dumping_pit_seen,gJAv(item.w_dumping_pit_seen));
                        data.put(InventoryTable.equipment_sp_name,item.equipment_sp_name);
                        data.put(InventoryTable.equipment_sp_designation,item.equipment_sp_designation);
                        data.put(InventoryTable.w_incinerator,toInt(item.w_incinerator));
                        data.put(InventoryTable.w_dumping_pit,toInt(item.w_dumping_pit));
                        data.put(InventoryTable.n_adult_wing_scale,gJAv(item.n_adult_wing_scale));
                        data.put(InventoryTable.n_height_rod,gJAv(item.n_height_rod));
                        data.put(InventoryTable.n_pressure_mechine,gJAv(item.n_pressure_mechine));
                        data.put(InventoryTable.n_stethoscope,gJAv(item.n_stethoscope));
                        data.put(InventoryTable.n_filter_stethoscope,gJAv(item.n_filter_stethoscope));
                        data.put(InventoryTable.n_water,toInt(item.n_water));
                        data.put(InventoryTable.n_hand_soap,toInt(item.n_hand_soap));
                        data.put(InventoryTable.n_spirit,toInt(item.n_spirit));
                        data.put(InventoryTable.n_waste,toInt(item.n_waste));
                        data.put(InventoryTable.n_sharp_waste,toInt(item.n_sharp_waste));
                        data.put(InventoryTable.n_gloves,toInt(item.n_gloves));
                        data.put(InventoryTable.n_iron_folate,toInt(item.n_iron_folate));
                        data.put(InventoryTable.n_urine_protien,toInt(item.n_urine_protien));
                        data.put(InventoryTable.n_urine_tester,toInt(item.n_urine_tester));
                        data.put(InventoryTable.n_urine_testtube,toInt(item.n_urine_testtube));
                        data.put(InventoryTable.n_test_tube_rack,toInt(item.n_test_tube_rack));
                        data.put(InventoryTable.n_dip_stick,toInt(item.n_dip_stick));
                        data.put(InventoryTable.n_hemoglobin,gJAv(item.n_hemoglobin));
                        data.put(InventoryTable.n_telecoil_book,toInt(item.n_telecoil_book));
                        data.put(InventoryTable.n_telecoil_landset,toInt(item.n_telecoil_landset));
                        data.put(InventoryTable.n_kolori_meter,toInt(item.n_kolori_meter));
                        data.put(InventoryTable.n_litmus_paper,toInt(item.n_litmus_paper));
                        data.put(InventoryTable.delivery_sp_name,item.delivery_sp_name);
                        data.put(InventoryTable.delivery_sp_designation,item.delivery_sp_designation);
                        data.put(InventoryTable.d_delivery_service,item.d_delivery_service);
                        data.put(InventoryTable.d_delivery_table,gJAv(item.d_delivery_table));
                        data.put(InventoryTable.d_pressure_mechine,gJAv(item.d_pressure_mechine));
                        data.put(InventoryTable.d_stethoscope,gJAv(item.d_stethoscope));
                        data.put(InventoryTable.d_filter_stethoscope,gJAv(item.d_filter_stethoscope));
                        data.put(InventoryTable.d_newborn_recuscitation,gJAv(item.d_newborn_recuscitation));
                        data.put(InventoryTable.d_recuscitation_mask_0,gJAv(item.d_recuscitation_mask_0));
                        data.put(InventoryTable.d_recuscitation_mask_1,gJAv(item.d_recuscitation_mask_1));
                        data.put(InventoryTable.d_peguin_sucker,gJAv(item.d_peguin_sucker));
                        data.put(InventoryTable.d_cord_cutter,toInt(item.d_cord_cutter));
                        data.put(InventoryTable.d_cord_clamp,toInt(item.d_cord_clamp));
                        data.put(InventoryTable.d_partograf_paper,toInt(item.d_partograf_paper));
                        data.put(InventoryTable.d_water,toInt(item.d_water));
                        data.put(InventoryTable.d_hand_soap,toInt(item.d_hand_soap));
                        data.put(InventoryTable.d_spirit,toInt(item.d_spirit));
                        data.put(InventoryTable.d_waste_recycle,toInt(item.d_waste_recycle));
                        data.put(InventoryTable.d_waste_storage,toInt(item.d_waste_storage));
                        data.put(InventoryTable.d_latex_gloves,toInt(item.d_latex_gloves));
                        data.put(InventoryTable.d_chlorine_sol,toInt(item.d_chlorine_sol));
                        data.put(InventoryTable.d_detergent_water,toInt(item.d_detergent_water));
                        data.put(InventoryTable.d_clean_water,toInt(item.d_clean_water));
                        data.put(InventoryTable.d_misoprostol,toInt(item.d_misoprostol));
                        data.put(InventoryTable.d_oxytocin,toInt(item.d_oxytocin));
                        data.put(InventoryTable.d_mang_sulfate,toInt(item.d_mang_sulfate));
                        data.put(InventoryTable.d_chlorhexidine,toInt(item.d_chlorhexidine));
                        data.put(InventoryTable.d_paediatric_drop,toInt(item.d_paediatric_drop));
                        data.put(InventoryTable.d_gentamycin,toInt(item.d_gentamycin));
                        data.put(InventoryTable.ch_wing_scale,gJAv(item.ch_wing_scale));
                        data.put(InventoryTable.ch_infant_wing_scale,gJAv(item.ch_infant_wing_scale));
                        data.put(InventoryTable.ch_height_rod,gJAv(item.ch_height_rod));
                        data.put(InventoryTable.ch_measuring_tip,toInt(item.ch_measuring_tip));
                        data.put(InventoryTable.ch_water,toInt(item.ch_water));
                        data.put(InventoryTable.ch_growth_monitor_boy,toInt(item.ch_growth_monitor_boy));
                        data.put(InventoryTable.ch_growth_monitor_girl,toInt(item.ch_growth_monitor_girl));
                        data.put(InventoryTable.ch_hand_soap,toInt(item.ch_hand_soap));
                        data.put(InventoryTable.ch_spirit,toInt(item.ch_spirit));
                        data.put(InventoryTable.ch_wastage_recycle,toInt(item.ch_wastage_recycle));
                        data.put(InventoryTable.ch_sharp_waste,toInt(item.ch_sharp_waste));
                        data.put(InventoryTable.ch_latex_gloves,toInt(item.ch_latex_gloves));
                        data.put(InventoryTable.ch_ors,toInt(item.ch_ors));
                        data.put(InventoryTable.ch_paediatric_drop,toInt(item.ch_paediatric_drop));
                        data.put(InventoryTable.ch_cotrimoxazole,toInt(item.ch_cotrimoxazole));
                        data.put(InventoryTable.ch_paracetamol,toInt(item.ch_paracetamol));
                        data.put(InventoryTable.ch_zinc,toInt(item.ch_zinc));
                        data.put(InventoryTable.ch_mebandazole,toInt(item.ch_mebandazole));
                        data.put(InventoryTable.ch_ceftriaxone,toInt(item.ch_ceftriaxone));
                        data.put(InventoryTable.ch_vitamin,toInt(item.ch_vitamin));
                        data.put(InventoryTable.fp_soap,toInt(item.fp_soap));
                        data.put(InventoryTable.fp_spirit,toInt(item.fp_spirit));
                        data.put(InventoryTable.fp_waste_recycle,toInt(item.fp_waste_recycle));
                        data.put(InventoryTable.fp_sharp_waste,toInt(item.fp_sharp_waste));
                        data.put(InventoryTable.fp_latex_gloves,toInt(item.fp_latex_gloves));
                        data.put(InventoryTable.r_healthy_newborn,gJAsv(item.r_healthy_newborn));
                        data.put(InventoryTable.r_newborn_death,gJAsv(item.r_newborn_death));
                        data.put(InventoryTable.r_mother_rate,gJAsv(item.r_mother_rate));
                        data.put(InventoryTable.r_elampsia,gJAsv(item.r_elampsia));
                        data.put(InventoryTable.r_mang_sulfate,gJAsv(item.r_mang_sulfate));
                        data.put(InventoryTable.r_pneumonis,gJAsv(item.r_pneumonis));
                        data.put(InventoryTable.r_paracetamol,gJAsv(item.r_paracetamol));
                        data.put(InventoryTable.r_psbi,gJAsv(item.r_psbi));
                        data.put(InventoryTable.r_psbi_care,gJAsv(item.r_psbi_care));
                        data.put(InventoryTable.r_starving_child,gJAsv(item.r_starving_child));
                        data.put(InventoryTable.r_starving_protocol,gJAsv(item.r_starving_protocol));
                        data.put(InventoryTable.end_time,item.end_time);
                        data.put("village",item.village);
                        data.put("district",item.district);
                        data.put("union",item.union);
                        data.put("sub_district",item.subdistrict);
                        data.put("facility",item.facility);
                        data.put("lat",item.lat);
                        data.put("lon",item.lon);


                        object.put("data",data);
                        requests.put(object);
                        finalRequest.put("requests",requests);


                        params.put("data", finalRequest.toString());
                        Log.e("request: ", finalRequest.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return params;
                }

            };
            dialog.show();
            RequestQueue requestQueue = Volley.newRequestQueue(FacilityInventoryActivity.this);
            requestQueue.add(stringRequest);

        }

    }

    private JSONArray gJAv(String str) {
        JSONArray array = new JSONArray();
        if(!TextUtils.isEmpty(str)){
            String tokens[] = str.split(",");
            for(int i=0;i<tokens.length;i++){
                array.put(Integer.parseInt(tokens[i]));
            }
        }
        return array;
    }

    private JSONArray gJAsv(String str) {
        JSONArray array = new JSONArray();
        if(!TextUtils.isEmpty(str)){
            String tokens[] = str.split(",");
            for(int i=0;i<tokens.length;i++){
                array.put(tokens[i]);
            }
        }
        return array;
    }

    private String toQStr(String str){
        if(TextUtils.isEmpty(str)){
            return "";
        }
        return str;
    }


    private int toInt(String str){
        try{
            return Integer.parseInt(str);
        }catch(Exception e){
            return 0;
        }
    }

    private boolean toBool(String str){
        if(TextUtils.isEmpty(str)) return false;
        if(str.equals("true")){
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.accept){
            final ProgressDialog progressDialog = new ProgressDialog(FacilityInventoryActivity.this);
            progressDialog.setMessage("Please wait...");
            String url = "http://119.148.43.34/mamoni/survey/api/form";
            final InventoryItem fItem = FacilityInventoryActivity.this.item;
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                progressDialog.dismiss();
                                Log.d(".....>>>>>>>>>>", "response length" +response);
                                JSONObject jsonObject = new JSONObject(response);
                                int status;
                                status= jsonObject.getInt("status");
                                Log.d(".....>>>>>>>>>>", "response length" +status);
                                InventorySupervisorTable t = new InventorySupervisorTable(FacilityInventoryActivity.this);
                                fItem.status =1;
                                t.insert(fItem); //update db
                                Toast.makeText(FacilityInventoryActivity.this,"Successfully submitted",Toast.LENGTH_SHORT).show();
                                finish();
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
                            progressDialog.dismiss();
                            Toast.makeText(FacilityInventoryActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                        JSONObject jf= new JSONObject();
                        JSONObject meta=new JSONObject();
                        meta.put("comments","");
                        meta.put("fields", "");
                        requests.put("meta",meta);
                        requests.put("submitted_by", fItem.submittedBy);
                        requests.put("form_id", fItem.id);
                        //og.d(".....>>>>>>>>>>", "response length      " + formItem1.getGlobal_id());
                        requests.put("form_type","dh_inventory");
                        requests.put("status",1);
                        jsonArray.put(requests);

                        //data
                        JSONObject data = new JSONObject();
                        data.put("username", AppUtils.getUserName(FacilityInventoryActivity.this));
                        data.put("password", AppUtils.getPassword(FacilityInventoryActivity.this));
                        data.put("requests", jsonArray);
                        params.put("data", data.toString());
                    }
                    catch (Exception e){

                    }

                    return params;
                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(FacilityInventoryActivity.this);
            requestQueue.add(stringRequest);
            progressDialog.show();
        }
        else if(v.getId() == R.id.revert){
            generateFieldsBox();
            findViewById(R.id.commentSection).setVisibility(View.VISIBLE);
        }
        else if(v.getId() == R.id.revert_cancel){
            findViewById(R.id.commentSection).setVisibility(View.GONE);
        }
        else if(v.getId() == R.id.revert_submit){
            final ProgressDialog progressDialog = new ProgressDialog(FacilityInventoryActivity.this);
            progressDialog.setMessage("Please wait...");
            String url = "http://119.148.43.34/mamoni/survey/api/form";
            final InventoryItem fItem = FacilityInventoryActivity.this.item;
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                progressDialog.dismiss();
                                Log.d(".....>>>>>>>>>>", "response length" +response);
                                JSONObject jsonObject = new JSONObject(response);
                                int status;
                                status= jsonObject.getInt("status");
                                Log.d(".....>>>>>>>>>>", "response length" +status);
                                InventorySupervisorTable t = new InventorySupervisorTable(FacilityInventoryActivity.this);
                                fItem.status =2;
                                t.insert(fItem); //update db
                                Toast.makeText(FacilityInventoryActivity.this,"Successfully submitted",Toast.LENGTH_SHORT).show();
                                finish();
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
                            progressDialog.dismiss();
                            Toast.makeText(FacilityInventoryActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                        JSONObject jf= new JSONObject();
                        JSONObject meta=new JSONObject();
                        meta.put("comments",getComments());
                        meta.put("fields", getFields());
                        requests.put("meta",meta);
                        requests.put("submitted_by", fItem.submittedBy);
                        requests.put("form_id", fItem.id);
                        //og.d(".....>>>>>>>>>>", "response length      " + formItem1.getGlobal_id());
                        requests.put("form_type","dh_inventory");
                        requests.put("status",2);
                        jsonArray.put(requests);

                        //data
                        JSONObject data = new JSONObject();
                        data.put("username", AppUtils.getUserName(FacilityInventoryActivity.this));
                        data.put("password", AppUtils.getPassword(FacilityInventoryActivity.this));
                        data.put("requests", jsonArray);
                        params.put("data", data.toString());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }

                    return params;
                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(FacilityInventoryActivity.this);
            requestQueue.add(stringRequest);
            progressDialog.show();
        }
    }

    private String getFields(){
        LinearLayout fieldLayout = (LinearLayout) findViewById(R.id.fields);
        int len = fieldLayout.getChildCount();
        String str = "";
        for(int i=0;i<len;i++){
            QCheckBox checkBox = (QCheckBox) fieldLayout.getChildAt(i);
            if(checkBox.isChecked()){
                if(str.length() > 0){
                    str += ",";
                }
                str += checkBox.getText();
            }
        }
        return str;
    }
    private String getComments(){
        return ((EditText)findViewById(R.id.comment)).getText().toString();
    }
    private static String FIELDS[] = {"01","02","03","04","05","06",
            "202","203","204","205","206","207","208","209","210","211","212",
            "202","203","304","305","306","307","308","309","310","311","312","313","314","315","316","317","318","319","320","321","322","323",
            "326","327","328","329","330","331","332","333","334","335","336","337","338","339","340","341","342","343","344","345","346","347",
            "348","349","350","351","401","402","403","404","405","406","407","408","409","410","411",
            "412","413","414","415","416","417","418","419","420","501","502","503","504","505",
            "601","602","603","604","605","606","607","608","609","610","611","612","613","614"};
    private void generateFieldsBox(){
        LinearLayout fieldLayout = (LinearLayout) findViewById(R.id.fields);
        fieldLayout.removeAllViews();
        findViewById(R.id.revert_submit).setOnClickListener(this);
        findViewById(R.id.revert_cancel).setOnClickListener(this);
        for(int i=0;i<FIELDS.length;i++){
            QCheckBox checkBox = new QCheckBox(this);
            checkBox.setTextSize(25f);
            checkBox.setPadding(10,10,10,10);
            checkBox.setText(FIELDS[i]);
            fieldLayout.addView(checkBox);
        }
    }
}
