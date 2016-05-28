package caresurvey.sci.com.caresurvey.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
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

import java.util.HashMap;
import java.util.Map;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.SatelliteClinicTable;
import caresurvey.sci.com.caresurvey.model.FpObservationFormItem;
import caresurvey.sci.com.caresurvey.model.SatelliteClinicItem;
import caresurvey.sci.com.caresurvey.utils.AppUtils;
import utils.Utils;

import static android.widget.Toast.*;

/**
 * Created by Shahin on 5/3/2016.
 */
public class SateliteClinicInventoryActivity extends AppCompatActivity implements View.OnClickListener {
    private SatelliteClinicTable table;
    private String names;
    private int mark;
    private String collector_name;
    private String upozila;
    private String union;
    private String village;
    private String datespicker;
    private String timepicker;
    private String facility;
    private String obsType;
    private long formID = 0;
    private int facilityID;
    private String designation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satelite_clinic_inventory);
//        AppUtils.setTextWithFonts(this, (TextView) (findViewById(R.id.include_query_101)).findViewById(R.id.tv_fb_observ_question),
//                getString(R.string.query_101));
        findViewById(R.id.insert).setOnClickListener(this);
        findViewById(R.id.submit).setOnClickListener(this);
        table = new SatelliteClinicTable(this);

        Intent mIntent = getIntent();
        names = mIntent.getStringExtra("name");
        mark = mIntent.getIntExtra("mark", 0);
        collector_name = mIntent.getStringExtra("c_name");
        upozila = mIntent.getStringExtra("upozila");
        union = mIntent.getStringExtra("union");
        village = mIntent.getStringExtra("village");
        designation = mIntent.getStringExtra("designation");
        try{
            facilityID = Integer.parseInt(mIntent.getStringExtra("serial"));
        }
        catch(Exception e){
            facilityID = 0;
        }

        datespicker = mIntent.getStringExtra("datepicker");
        timepicker = mIntent.getStringExtra("timepicker");
        facility = mIntent.getStringExtra("facility");
        obsType = mIntent.getStringExtra("obstype");

    }

    boolean isTrue(int id){
        return ((RadioButton)findViewById(id)).isChecked();
    }
    String getRGValue(int id_y,int id_n){
        String val =
        (isVRG(id_y,id_n) == true) ?
                (isTrue(id_y)? "true" : "false") : "";
        return val;
    }
    private SatelliteClinicItem genSatelliteClinicItem(){
        SatelliteClinicItem item = new SatelliteClinicItem();
        if( TextUtils.isEmpty(item.csi101 = getRGValue(R.id.csi_101_y, R.id.csi_101_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show();
            return null;
        }
        if( TextUtils.isEmpty(item.csi102 = getRGValue(R.id.csi_102_y, R.id.csi_102_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show();
            return null;
        }
        if( TextUtils.isEmpty(item.csi103 = getRGValue(R.id.csi_103_y, R.id.csi_103_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show();
            return null;
        }
        if( TextUtils.isEmpty(item.csi104 = getRGValue(R.id.csi_104_y, R.id.csi_104_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show();
            return null;
        }
        if( TextUtils.isEmpty(item.csi105 = getRGValue(R.id.csi_105_y, R.id.csi_105_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi106 = getRGValue(R.id.csi_106_y, R.id.csi_106_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi107 = getRGValue(R.id.csi_107_y, R.id.csi_107_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi201 = getRGValue(R.id.csi_201_y, R.id.csi_201_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi202 = getRGValue(R.id.csi_202_y, R.id.csi_202_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi203 = getRGValue(R.id.csi_203_y, R.id.csi_203_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi204 = getRGValue(R.id.csi_204_y, R.id.csi_204_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi205 = getRGValue(R.id.csi_205_y, R.id.csi_205_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi206 = getRGValue(R.id.csi_206_y, R.id.csi_206_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi207 = getRGValue(R.id.csi_207_y, R.id.csi_207_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi208 = getRGValue(R.id.csi_208_y, R.id.csi_208_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi209 = getRGValue(R.id.csi_209_y, R.id.csi_209_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi210 = getRGValue(R.id.csi_210_y, R.id.csi_210_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi211 = getRGValue(R.id.csi_211_y, R.id.csi_211_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi212 = getRGValue(R.id.csi_212_y, R.id.csi_212_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi213 = getRGValue(R.id.csi_213_y, R.id.csi_213_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi214 = getRGValue(R.id.csi_214_y, R.id.csi_214_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi215 = getRGValue(R.id.csi_215_y, R.id.csi_215_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi216 = getRGValue(R.id.csi_216_y, R.id.csi_216_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi217 = getRGValue(R.id.csi_217_y, R.id.csi_217_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi218 = getRGValue(R.id.csi_218_y, R.id.csi_218_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi219 = getRGValue(R.id.csi_219_y, R.id.csi_219_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi220 = getRGValue(R.id.csi_220_y, R.id.csi_220_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi221 = getRGValue(R.id.csi_222_y, R.id.csi_222_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi222 = getRGValue(R.id.csi_222_y, R.id.csi_222_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi223 = getRGValue(R.id.csi_223_y, R.id.csi_223_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi224 = getRGValue(R.id.csi_224_y, R.id.csi_224_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi225 = getRGValue(R.id.csi_225_y, R.id.csi_225_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi226 = getRGValue(R.id.csi_226_y, R.id.csi_226_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi227 = getRGValue(R.id.csi_227_y, R.id.csi_227_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi228 = getRGValue(R.id.csi_228_y, R.id.csi_228_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi229 = getRGValue(R.id.csi_229_y, R.id.csi_229_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi230_1 = getRGValue(R.id.csi_230_1_y, R.id.csi_230_1_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi230_2 = getRGValue(R.id.csi_230_2_y, R.id.csi_230_2_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi231 = getRGValue(R.id.csi_231_y, R.id.csi_231_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi232 = getRGValue(R.id.csi_232_y, R.id.csi_232_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi233 = getRGValue(R.id.csi_233_y, R.id.csi_233_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if( TextUtils.isEmpty(item.csi234 = getRGValue(R.id.csi_234_y, R.id.csi_234_n)) ){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }

        if(TextUtils.isEmpty(( item.date = getEString(R.id.date) ))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty(( item.startTime = getEString(R.id.start_time) ))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty(( item.clientName = getEString(R.id.client_name) ))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty(( item.designation = getEString(R.id.designation) ))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }
        if(TextUtils.isEmpty(( item.endTime = getEString(R.id.end_time) ))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }

        item.status = 3; //pending
        item.name = names;
        item.collector_name = collector_name;
        item.upozila = upozila;
        item.union = union;
        item.village = village;
        item.datepick = datespicker;
        item.timepick = timepicker;
        item.facility = facility;
        item.obs_type = obsType;
        item.facilityID = facilityID;
        return item;
    }

    private String getEString(int id){
        Editable text = ((EditText) findViewById(id)).getText();
        if(TextUtils.isEmpty(text)){
            return null;
        }
        else{
            return text.toString();
        }
    }

    boolean isVRG(int... id){ //valid radio group
        int len = id.length;
        boolean value = false;
        for(int i=0;i<len;i++){
            value |= ((RadioButton)findViewById(id[i])).isChecked();
        }
        return value;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.insert){
            SatelliteClinicItem item = genSatelliteClinicItem();
            if(item != null){
                long id = table.insert(item);
                if(id != -1){
                    makeText(this,"Form saved successfully.",LENGTH_SHORT).show();
                    formID = id;
                }
                Log.e("table row id: ","" + id);
            }
        }
        else if(v.getId() == R.id.submit){
            final SatelliteClinicItem fpItem = genSatelliteClinicItem();
            final ProgressDialog dialog = new ProgressDialog(this);
            dialog.setMessage("Please wait...");
            final AlertDialog.Builder alert = new AlertDialog.Builder(SateliteClinicInventoryActivity.this);
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            String url = "http://www.kolorob.net/mamoni/survey/api/form";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            dialog.dismiss();

                            try {
                                JSONObject jo = new JSONObject(response);
                                Log.e("response:",response);
                                if(jo.has("errorCount")){
                                    alert.setMessage(jo.getString("message"));
                                }
                                else{
                                    alert.setMessage("Invalid response");
                                }
                                alert.show();

                            } catch (Exception e) {
                                e.printStackTrace();
                                alert.setMessage("An error occurred")   ;
                                alert.show();
                            }
//                              Toast.makeText(SateliteClinicInventoryActivity.this,response,Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            dialog.dismiss();
//                            Toast.makeText(SateliteClinicInventoryActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                            alert.setMessage("An error occurred");
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
                        finalRequest.put("username","collector");
                        finalRequest.put("password","collector");
                        JSONArray requests = new JSONArray();
                        JSONObject object = new JSONObject();
                        object.put("form_id",formID);
                        object.put("form_type","dh_satelliteclinic");
                        JSONObject data = new JSONObject();
                        data.put("facility_id",fpItem.facilityID);
                        data.put("sp_name",toQStr(collector_name));
                        data.put("sp_designation",toQStr(designation));
                        data.put("client_name",toQStr(fpItem.clientName));
                        data.put("form_date",toQStr(fpItem.date));
                        data.put("date",toQStr(fpItem.date));
                        data.put("start_time",toQStr(fpItem.startTime));

                        data.put("waiting_place",toBool(fpItem.csi101));
                        data.put("furniture",toBool(fpItem.csi102));
                        data.put("test_place",toBool(fpItem.csi103));
                        data.put("privacy",toBool(fpItem.csi104));
                        data.put("testing_bed",toBool(fpItem.csi105));
                        data.put("testing_chair",toBool(fpItem.csi106));
                        data.put("toilet",toBool(fpItem.csi107));
                        data.put("adult_wing",toBool(fpItem.csi201));
                        data.put("child_wing",toBool(fpItem.csi202));
                        data.put("infant_wing",toBool(fpItem.csi203));
                        data.put("height_rod",toBool(fpItem.csi204));
                        data.put("measuring_tip",toBool(fpItem.csi205));
                        data.put("blood_pressure_mechine",toBool(fpItem.csi206));
                        data.put("stethoscope",toBool(fpItem.csi207));
                        data.put("filter_stethoscope",toBool(fpItem.csi208));
                        data.put("thermometer",toBool(fpItem.csi209));
                        data.put("chart_line",toBool(fpItem.csi210));
                        data.put("vaginal_speculum",toBool(fpItem.csi211));
                        data.put("cotton_ball",toBool(fpItem.csi212));
                        data.put("disposable_syringe",toBool(fpItem.csi213));
                        data.put("water",toBool(fpItem.csi214));
                        data.put("hand_spoap",toBool(fpItem.csi215));
                        data.put("spirit",toBool(fpItem.csi216));
                        data.put("waste_receptacle",toBool(fpItem.csi217));
                        data.put("sharp_waste",toBool(fpItem.csi218));
                        data.put("gloves",toBool(fpItem.csi219));
                        data.put("test_tube",toBool(fpItem.csi220));
                        data.put("test_tube_holder",toBool(fpItem.csi221));
                        data.put("test_tube_rack",toBool(fpItem.csi222));
                        data.put("dipstick",toBool(fpItem.csi223));
                        data.put("telecoet_book",toBool(fpItem.csi224));
                        data.put("telecoet_lanstet",toBool(fpItem.csi225));
                        data.put("iron_folate",toBool(fpItem.csi226));
                        data.put("calcium",toBool(fpItem.csi227));
                        data.put("misoprostol",toBool(fpItem.csi228));
                        data.put("amoxycillin",toBool(fpItem.csi229));
                        data.put("sukhi",toBool(fpItem.csi230_1));
                        data.put("apon",toBool(fpItem.csi230_2));
                        data.put("condom",toBool(fpItem.csi231));
                        data.put("injectable",toBool(fpItem.csi232));
                        data.put("card",toBool(fpItem.csi233));
                        data.put("pictured_items",toBool(fpItem.csi234));

                        data.put("end_time",toQStr(fpItem.endTime));
                        data.put("village",toQStr(fpItem.village));
                        data.put("district",toQStr(fpItem.district));
                        data.put("union",toQStr(fpItem.union));
                        data.put("sub_district",toQStr(fpItem.subdistrict));

                        object.put("data",data);
                        requests.put(object);
                        finalRequest.put("requests",requests);


                        params.put("data", finalRequest.toString());
                        Log.e("request: ",finalRequest.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return params;
                }

            };
            dialog.show();
            RequestQueue requestQueue = Volley.newRequestQueue(SateliteClinicInventoryActivity.this);
            requestQueue.add(stringRequest);
        }
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
}
