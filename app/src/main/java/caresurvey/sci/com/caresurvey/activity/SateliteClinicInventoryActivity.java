package caresurvey.sci.com.caresurvey.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.SatelliteClinicTable;
import caresurvey.sci.com.caresurvey.model.SatelliteClinicItem;
import caresurvey.sci.com.caresurvey.utils.AppUtils;
import utils.Utils;

import static android.widget.Toast.*;

/**
 * Created by Shahin on 5/3/2016.
 */
public class SateliteClinicInventoryActivity extends Activity implements View.OnClickListener {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satelite_clinic_inventory);
//        AppUtils.setTextWithFonts(this, (TextView) (findViewById(R.id.include_query_101)).findViewById(R.id.tv_fb_observ_question),
//                getString(R.string.query_101));
        findViewById(R.id.insert).setOnClickListener(this);
        table = new SatelliteClinicTable(this);

        Intent mIntent = getIntent();
        names = mIntent.getStringExtra("name");
        mark = mIntent.getIntExtra("mark", 0);
        collector_name = mIntent.getStringExtra("c_name");
        upozila = mIntent.getStringExtra("upozila");
        union = mIntent.getStringExtra("union");
        village = mIntent.getStringExtra("village");


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
        return item;
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
                    makeText(this,"Form submitted successfully.",LENGTH_SHORT).show();
                }
                Log.e("table row id: ","" + id);
            }
        }
    }
}
