package caresurvey.sci.com.caresurvey.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
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
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.SatelliteClinicSupervisorTable;
import caresurvey.sci.com.caresurvey.database.SatelliteClinicTable;
import caresurvey.sci.com.caresurvey.model.SatelliteClinicItem;
import caresurvey.sci.com.caresurvey.utils.AppUtils;
import caresurvey.sci.com.caresurvey.widgets.QCheckBox;

import static android.widget.Toast.*;

/**
 * Created by Shahin on 5/3/2016.
 */
public class SateliteClinicInventoryActivity extends AppCompatActivity implements View.OnClickListener {
    private SatelliteClinicTable table;
    private long formID = 0;
    private SatelliteClinicItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satelite_clinic_inventory);
//        AppUtils.setTextWithFonts(this, (TextView) (findViewById(R.id.include_query_101)).findViewById(R.id.tv_fb_observ_question),
//                getString(R.string.query_101));
        findViewById(R.id.insert).setOnClickListener(this);
        findViewById(R.id.submit).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
        table = new SatelliteClinicTable(this);
        Intent mIntent = getIntent();
        if(mIntent.hasExtra(DisplayUserActivity.FORM_ID)){ //alreay have one
            if(mIntent.hasExtra(SurveyActivity.FROM_ADMIN)){
                editable(false);
                findViewById(R.id.admin_btn_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.user_btn_layout).setVisibility(View.GONE);
                SatelliteClinicSupervisorTable supervisorTable = new SatelliteClinicSupervisorTable(this);
                item = supervisorTable.get(mIntent.getLongExtra(DisplayUserActivity.FORM_ID,0L));
            }
            else {
                findViewById(R.id.user_btn_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.admin_btn_layout).setVisibility(View.GONE);
                item = table.get(mIntent.getLongExtra(DisplayUserActivity.FORM_ID, 0));
            }
        }
        else{
            item = new SatelliteClinicItem();
            item.name = mIntent.getStringExtra("name");
            item.designation = mIntent.getStringExtra("designation");
            item.mark = mIntent.getIntExtra("mark", 0);
            item.collector_name = mIntent.getStringExtra("c_name");
            item.upozila = mIntent.getStringExtra("upozila");
            item.union = mIntent.getStringExtra("union");
            item.village = mIntent.getStringExtra("village");
            item.district = mIntent.getStringExtra("district");
            try {
                item.facilityID = Integer.parseInt(mIntent.getStringExtra("serial"));
            }catch(Exception e){
                item.facilityID = 0;
            }
            item.date = item.datepick = mIntent.getStringExtra("datepicker");
            item.startTime = item.timepick = mIntent.getStringExtra("timepicker");
            item.facility = mIntent.getStringExtra("facility");
            item.obs_type = mIntent.getStringExtra("obstype");
            item.lat = mIntent.getStringExtra("lat");
            item.lon = mIntent.getStringExtra("lon");
        }
        findViewById(R.id.accept).setOnClickListener(this);
        findViewById(R.id.revert).setOnClickListener(this);
        loadForm();


    }

    private void loadForm() {
        if(item.status == 2){ //reverted
            EditText comment = (EditText) findViewById(R.id.comment);
            comment.setText(item.comments);
            comment.setFocusable(false);
            findViewById(R.id.revert_submit).setVisibility(View.GONE);
            LinearLayout fieldLayout = (LinearLayout) findViewById(R.id.fields);
            fieldLayout.removeAllViews();
            TextView textView = new TextView(this);
            textView.setTextSize(25f);
            textView.setText(item.fields);
            fieldLayout.addView(textView);
            findViewById(R.id.commentSection).setVisibility(View.VISIBLE);
            findViewById(R.id.revert_cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    findViewById(R.id.commentSection).setVisibility(View.GONE);
                }
            });
        }
        sETv(R.id.date, item.date);
        sETv(R.id.start_time, item.startTime);
        sETv(R.id.end_time,item.endTime);
//        sETv(R.id.client_name,item.clientName);
//        sETv(R.id.designation, item.designation);
        sRGv(R.id.csi_101_y, R.id.csi_101_n, item.csi101);
        sRGv(R.id.csi_102_y, R.id.csi_102_n, item.csi102);
        sRGv(R.id.csi_103_y, R.id.csi_103_n, item.csi103);
        sRGv(R.id.csi_104_y, R.id.csi_104_n, item.csi104);
        sRGv(R.id.csi_105_y, R.id.csi_105_n, item.csi105);
        sRGv(R.id.csi_106_y, R.id.csi_106_n, item.csi106);
        sRGv(R.id.csi_107_y, R.id.csi_107_n, item.csi107);
        sRGv(R.id.csi_201_y, R.id.csi_201_n, item.csi201);
        sRGv(R.id.csi_202_y, R.id.csi_202_n, item.csi202);
        sRGv(R.id.csi_203_y, R.id.csi_203_n, item.csi203);
        sRGv(R.id.csi_204_y, R.id.csi_204_n, item.csi204);
        sRGv(R.id.csi_205_y, R.id.csi_205_n, item.csi205);
        sRGv(R.id.csi_206_y, R.id.csi_206_n, item.csi206);
        sRGv(R.id.csi_207_y, R.id.csi_207_n, item.csi207);
        sRGv(R.id.csi_208_y, R.id.csi_208_n, item.csi208);
        sRGv(R.id.csi_209_y, R.id.csi_209_n, item.csi209);
        sRGv(R.id.csi_210_y, R.id.csi_210_n, item.csi210);
        sRGv(R.id.csi_211_y, R.id.csi_211_n, item.csi211);
        sRGv(R.id.csi_212_y, R.id.csi_212_n, item.csi212);
        sRGv(R.id.csi_213_y, R.id.csi_213_n, item.csi213);
        sRGv(R.id.csi_214_y, R.id.csi_214_n, item.csi214);
        sRGv(R.id.csi_215_y, R.id.csi_215_n, item.csi215);
        sRGv(R.id.csi_216_y, R.id.csi_216_n, item.csi216);
        sRGv(R.id.csi_217_y, R.id.csi_217_n, item.csi217);
        sRGv(R.id.csi_218_y, R.id.csi_218_n, item.csi218);
        sRGv(R.id.csi_219_y, R.id.csi_219_n, item.csi219);
        sRGv(R.id.csi_220_y, R.id.csi_220_n, item.csi220);
        sRGv(R.id.csi_221_y, R.id.csi_221_n, item.csi221);
        sRGv(R.id.csi_222_y, R.id.csi_222_n, item.csi222);
        sRGv(R.id.csi_223_y, R.id.csi_223_n, item.csi223);
        sRGv(R.id.csi_224_y, R.id.csi_224_n, item.csi224);
        sRGv(R.id.csi_225_y, R.id.csi_225_n, item.csi225);
        sRGv(R.id.csi_226_y, R.id.csi_226_n, item.csi226);
        sRGv(R.id.csi_227_y, R.id.csi_227_n, item.csi227);
        sRGv(R.id.csi_228_y, R.id.csi_228_n, item.csi228);
        sRGv(R.id.csi_229_y, R.id.csi_229_n, item.csi229);
        sRGv(R.id.csi_230_1_y, R.id.csi_230_1_n, item.csi230_1);
        sRGv(R.id.csi_230_2_y, R.id.csi_230_2_n, item.csi230_2);
        sRGv(R.id.csi_231_y, R.id.csi_231_n, item.csi231);
        sRGv(R.id.csi_232_y, R.id.csi_232_n, item.csi232);
        sRGv(R.id.csi_233_y, R.id.csi_233_n, item.csi233);
        sRGv(R.id.csi_234_y, R.id.csi_234_n, item.csi234);
    }

    private void editable(boolean state){
        sVEs(R.id.date, state);
        sVEs(R.id.start_time, state);
        sVEs(R.id.end_time,state);
//        sVEs(R.id.client_name,state);
//        sVEs(R.id.designation, state);
        sRGs(R.id.csi_101_y,state); sRGs(R.id.csi_101_n,state);
        sRGs(R.id.csi_102_y,state); sRGs(R.id.csi_102_n,state);
        sRGs(R.id.csi_103_y,state); sRGs(R.id.csi_103_n,state);
        sRGs(R.id.csi_104_y,state); sRGs(R.id.csi_104_n,state);
        sRGs(R.id.csi_105_y,state); sRGs(R.id.csi_105_n,state);
        sRGs(R.id.csi_106_y,state); sRGs(R.id.csi_106_n,state);
        sRGs(R.id.csi_107_y,state); sRGs(R.id.csi_107_n,state);
        sRGs(R.id.csi_201_y,state); sRGs(R.id.csi_201_n,state);
        sRGs(R.id.csi_202_y,state); sRGs(R.id.csi_202_n,state);
        sRGs(R.id.csi_203_y,state); sRGs(R.id.csi_203_n,state);
        sRGs(R.id.csi_204_y,state); sRGs(R.id.csi_204_n,state);
        sRGs(R.id.csi_205_y,state); sRGs(R.id.csi_205_n,state);
        sRGs(R.id.csi_206_y,state); sRGs(R.id.csi_206_n,state);
        sRGs(R.id.csi_207_y,state); sRGs(R.id.csi_207_n,state);
        sRGs(R.id.csi_208_y,state); sRGs(R.id.csi_208_n,state);
        sRGs(R.id.csi_209_y,state); sRGs(R.id.csi_209_n,state);
        sRGs(R.id.csi_210_y,state); sRGs(R.id.csi_210_n,state);
        sRGs(R.id.csi_211_y,state); sRGs(R.id.csi_211_n,state);
        sRGs(R.id.csi_212_y,state); sRGs(R.id.csi_212_n,state);
        sRGs(R.id.csi_213_y,state); sRGs(R.id.csi_213_n,state);
        sRGs(R.id.csi_214_y,state); sRGs(R.id.csi_214_n,state);
        sRGs(R.id.csi_215_y,state); sRGs(R.id.csi_215_n,state);
        sRGs(R.id.csi_216_y,state); sRGs(R.id.csi_216_n,state);
        sRGs(R.id.csi_217_y,state); sRGs(R.id.csi_217_n,state);
        sRGs(R.id.csi_218_y,state); sRGs(R.id.csi_218_n,state);
        sRGs(R.id.csi_219_y,state); sRGs(R.id.csi_219_n,state);
        sRGs(R.id.csi_220_y,state); sRGs(R.id.csi_220_n,state);
        sRGs(R.id.csi_221_y,state); sRGs(R.id.csi_221_n,state);
        sRGs(R.id.csi_222_y,state); sRGs(R.id.csi_222_n,state);
        sRGs(R.id.csi_223_y,state); sRGs(R.id.csi_223_n,state);
        sRGs(R.id.csi_224_y,state); sRGs(R.id.csi_224_n,state);
        sRGs(R.id.csi_225_y,state); sRGs(R.id.csi_225_n,state);
        sRGs(R.id.csi_226_y,state); sRGs(R.id.csi_226_n,state);
        sRGs(R.id.csi_227_y,state); sRGs(R.id.csi_227_n,state);
        sRGs(R.id.csi_228_y,state); sRGs(R.id.csi_228_n,state);
        sRGs(R.id.csi_229_y,state); sRGs(R.id.csi_229_n,state);
        sRGs(R.id.csi_230_1_y,state); sRGs(R.id.csi_230_1_n,state);
        sRGs(R.id.csi_230_2_y,state); sRGs(R.id.csi_230_2_n,state);
        sRGs(R.id.csi_231_y,state); sRGs(R.id.csi_231_n,state);
        sRGs(R.id.csi_232_y,state); sRGs(R.id.csi_232_n,state);
        sRGs(R.id.csi_233_y,state); sRGs(R.id.csi_233_n,state);
        sRGs(R.id.csi_234_y,state); sRGs(R.id.csi_234_n,state);
    }

    private void sVEs(int id, boolean state){
        findViewById(id).setEnabled(state);
    }

    private void sRGs(int id,boolean state){
//        RadioGroup radioGroup = (RadioGroup) findViewById(id);
//        for(int i=0;i<radioGroup.getChildCount();i++){
            RadioButton btn = (RadioButton) findViewById(id);
            btn.setEnabled(state);
//        }
    }

    private void sETv(int id,String val){
        EditText et = (EditText) findViewById(id);
        if(et != null){
            et.setText(val);
        }
    }

    private void sRGv(int id_y,int id_n,String value){
        if(TextUtils.isEmpty(value)) return;
        if(value.equals("true")){
            ((RadioButton)findViewById(id_y)).setChecked(true);
        }
        else if(value.equals("false")){
            ((RadioButton)findViewById(id_n)).setChecked(true);
        }
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

//        if(TextUtils.isEmpty(( item.date = getEString(R.id.date) ))){
//            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
//        }
//        if(TextUtils.isEmpty(( item.startTime = getEString(R.id.start_time) ))){
//            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
//        }
//        if(TextUtils.isEmpty(( item.clientName = getEString(R.id.client_name) ))){
//            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
//        }
//        if(TextUtils.isEmpty(( item.designation = getEString(R.id.designation) ))){
//            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
//        }
        if(TextUtils.isEmpty(( item.endTime = getEString(R.id.end_time) ))){
            makeText(this, "Form is not complete.", LENGTH_SHORT).show(); return null;
        }

        item.endTime = AppUtils.getTime();
        sETv(R.id.end_time,item.endTime);

//        item.status = 3; //pending
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
        else if(v.getId() == R.id.back){
            finish();
        }
        else if(v.getId() == R.id.submit){
            final SatelliteClinicItem fpItem = genSatelliteClinicItem();
            if(fpItem == null){
                return;
            }
            if(item.status == 2){ //reverted
                item.status = 4;
            }
            table.insert(fpItem);
            final ProgressDialog dialog = new ProgressDialog(this);
            dialog.setMessage("Please wait...");
            final AlertDialog.Builder alert = new AlertDialog.Builder(SateliteClinicInventoryActivity.this);
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            String url = "http://119.148.43.34/mamoni/survey/api/form";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            dialog.dismiss();

                            try {
                                final JSONObject jo = new JSONObject(response);
                                Log.e("response:",response);
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
                                            if(jo.getInt("errorCount") == 0){
                                                if(item.status == 7) //incomplete
                                                {
                                                    item.status = 3;//pending
                                                    table.insert(item);
                                                }
                                                finish();
                                            }
                                        } catch (JSONException e) {
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
                        finalRequest.put("username",AppUtils.getUserName(SateliteClinicInventoryActivity.this));
                        finalRequest.put("password",AppUtils.getPassword(SateliteClinicInventoryActivity.this));
                        JSONArray requests = new JSONArray();
                        JSONObject object = new JSONObject();
                        object.put("form_id",fpItem.id);
                        object.put("form_type","dh_satelliteclinic");
                        JSONObject data = new JSONObject();
                        data.put("facility_id",fpItem.facilityID);
                        data.put("sp_name",toQStr(item.collector_name));
                        data.put("sp_designation",toQStr(item.designation));
                        data.put("client_name",toQStr(fpItem.clientName));
                        data.put("form_date",toQStr(fpItem.date));
//                        data.put("date",toQStr(fpItem.date));
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
                        data.put("facility",fpItem.facility);
                        data.put("lat",fpItem.lat);
                        data.put("lon",fpItem.lon);

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
        else if(v.getId() == R.id.accept){
            final ProgressDialog progressDialog = new ProgressDialog(SateliteClinicInventoryActivity.this);
            progressDialog.setMessage("Please wait...");
            String url = "http://119.148.43.34/mamoni/survey/api/form";
            final  SatelliteClinicItem fItem = SateliteClinicInventoryActivity.this.item;
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
                                SatelliteClinicSupervisorTable t = new SatelliteClinicSupervisorTable(SateliteClinicInventoryActivity.this);
                                fItem.status =1;
                                t.insert(fItem); //update db
                                Toast.makeText(SateliteClinicInventoryActivity.this,"Successfully submitted",Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(SateliteClinicInventoryActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                        requests.put("form_type","dh_satelliteclinic");
                        requests.put("status",1);
                        jsonArray.put(requests);

                        //data
                        JSONObject data = new JSONObject();
                        data.put("username", AppUtils.getUserName(SateliteClinicInventoryActivity.this));
                        data.put("password", AppUtils.getPassword(SateliteClinicInventoryActivity.this));
                        data.put("requests", jsonArray);
                        params.put("data", data.toString());
                    }
                    catch (Exception e){

                    }

                    return params;
                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(SateliteClinicInventoryActivity.this);
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
            final ProgressDialog progressDialog = new ProgressDialog(SateliteClinicInventoryActivity.this);
            progressDialog.setMessage("Please wait...");
            String url = "http://119.148.43.34/mamoni/survey/api/form";
            final SatelliteClinicItem fItem = SateliteClinicInventoryActivity.this.item;
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
                                SatelliteClinicSupervisorTable t = new SatelliteClinicSupervisorTable(SateliteClinicInventoryActivity.this);
                                fItem.status =2;
                                t.insert(fItem); //update db
                                Toast.makeText(SateliteClinicInventoryActivity.this,"Successfully submitted",Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(SateliteClinicInventoryActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                        requests.put("form_type","dh_satelliteclinic");
                        requests.put("status",2);
                        jsonArray.put(requests);

                        //data
                        JSONObject data = new JSONObject();
                        data.put("username", AppUtils.getUserName(SateliteClinicInventoryActivity.this));
                        data.put("password", AppUtils.getPassword(SateliteClinicInventoryActivity.this));
                        data.put("requests", jsonArray);
                        params.put("data", data.toString());
                    }
                    catch (Exception e){

                    }

                    return params;
                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(SateliteClinicInventoryActivity.this);
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
    private static String FIELDS[] = {"101","102","103","104","105","106","107","201","202","203","204"
            ,"205","206","207","208","209","210","211","212","213","214","215","216","217","218"
            ,"219","220","221","222","223","224","225","226","227","228","229","230-1","230-2","231","232","233","234"};
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
