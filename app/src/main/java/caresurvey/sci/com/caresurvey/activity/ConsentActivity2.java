package caresurvey.sci.com.caresurvey.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import caresurvey.sci.com.caresurvey.R;

/**
 * Created by shantanu on 6/11/16.
 */
public class ConsentActivity2 extends AppCompatActivity implements View.OnClickListener {
    private String name;
    private String permitted;
    private String collectorName;
    private String collectorDesignation;
    private TextView pageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consent2);
        getSupportActionBar().setTitle(getIntent().getStringExtra("obs_name"));
        findViewById(R.id.cnt).setOnClickListener(this);
        pageName = (TextView) findViewById(R.id.page_name);
        loadData();
        findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private String getUser(){
        String district = getIntent().getStringExtra("district");
        if(TextUtils.isEmpty(district)) return "";
        if(district.equals("Lakshmipur")){
            return "Shrabani Ghatak";
        }
        else if(district.equals("Noakhali")){
            return "Shrabani Ghatak";
        }
        else if(district.equals("Jhalakati")){
            return "Salma Ummul Baraka";
        }
        else if(district.equals("Lakshmipur")){
            return "Mitu Samaddar";
        }
        else if(district.equals("Habiganj")){
            return "Shubhra Rani Roy";
        }
        return "";
    }

    private void loadData(){
        sETv(R.id.user, getUser());
        sETv(R.id.collector_name,collectorName);
        String[] designations = null;
        int formId = getIntent().getIntExtra(ConsentActivity1.FORM,0);
        switch (formId){
            case 0:
                designations = getResources().getStringArray(R.array.anc_designation);
                pageName.setText("CONSENT: SERVICE PROVIDER");
                break;
            case 1:
                designations = getResources().getStringArray(R.array.sci_designation);
                pageName.setText("CONSENT");
                break;
            case 2:
                designations = getResources().getStringArray(R.array.scuf_designation);
                pageName.setText("CONSENT: SERVICE PROVIDER");
                break;
            case 3:
                findViewById(R.id.collector_layout).setVisibility(View.GONE);
                pageName.setText("CONSENT");
                break;
            case 4:
                designations = getResources().getStringArray(R.array.scuf_designation);
                pageName.setText("CONSENT: SERVICE PROVIDER");
                break;
        }
        Spinner s = (Spinner) findViewById(R.id.sp_designation);
        if(designations != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, designations);
            s.setAdapter(adapter);
        }
        else{
            findViewById(R.id.designation_layout).setVisibility(View.GONE);
        }
        int position = getIntent().getIntExtra(ConsentActivity1.FORM, 0);
        switch (position){
            case 0:
                ((TextView)findViewById(R.id.des_text)).setText("cÖ`v‡bi gvb Dbœq‡b wewfbœ ¯^v¯’¨‡K‡›`ª GKwU Rwic cwiPvjbv KiwQ| GB Rwi‡ci Z_¨ mg~n ¯^v¯’¨ †mevi gvb Dbœqb I M‡elYvi Kv‡R e¨envi Kiv n‡e| GB ¯^v¯’¨‡K‡›`ª Mf©eZx gv‡qi †mev wKfv‡e †`qv nq Zv eySvi Rb¨ Avwg GB K¬v‡q‡›Ui mv‡_ Avcbvi Kbmvj‡UkbwU ch©‡e¶Y Ki‡Z PvB| Avcwb K¬v‡q›U‡K †h †mev cÖ`vb Ki‡Qb Zv g~j¨vqb Kiv Avgv‡`i D‡Ïk¨ bq Ges G e¨vcv‡i Avwg `¶I bB| GB ch©‡e¶‡Yi Z_¨ †Mvcb _vK‡e| Avcbvi ev K¬v‡q‡›Ui bvg wi‡cv‡U© mshy³ Kiv n‡e bv| hw` Avcwb †Kvb c‡q‡›U A¯^w¯Í‡eva K‡ib, Zvn‡j Avgv‡K GB ¯’vb Z¨vM Ki‡Z ej‡Z cv‡ib| hv †nvK, Avwg Avkv Kie †h, Avcbvi ÔwPwKrmv/civgk© cÖ`vbÕ ch©‡e¶Y Ki‡j Avcwb wKQy g‡b Ki‡eb  bv| Avgv‡K, Avcwb †Kvb cÖkœ wR‡Ám Ki‡Z Pvb wK?");
                break;
            case 1:
                ((TextView)findViewById(R.id.des_text)).setText("cÖ`v‡bi gvb Dbœq‡b wewfbœ ¯^v¯’¨‡K‡›`ª GKwU Rwic cwiPvjbv KiwQ| GB Rwi‡ci Z_¨ mg~n ¯^v¯’¨ †mevi gvb Dbœqb I M‡elYvi Kv‡R e¨envi Kiv n‡e| GB ¯^v¯’¨‡K‡›`ª †mev wKfv‡e †`qv nq Zv eySvi Rb¨ Avwg GB K¬v‡q‡›Ui mv‡_ Avcbvi Kbmvj‡UkbwU ch©‡e¶Y Ki‡Z PvB| Avcwb K¬v‡q›U‡K †h †mev cÖ`vb Ki‡Qb Zv g~j¨vqb Kiv Avgv‡`i D‡Ïk¨ bq Ges G e¨vcv‡i Avwg `¶I bB| GB ch©‡e¶‡Yi Z_¨ †Mvcb _vK‡e| Avcbvi ev K¬v‡q‡›Ui bvg wi‡cv‡U© mshy³ Kiv n‡e bv| hw` Avcwb †Kvb c‡q‡›U A¯^w¯Í‡eva K‡ib, Zvn‡j Avgv‡K GB ¯’vb Z¨vM Ki‡Z ej‡Z cv‡ib| hv †nvK, Avwg Avkv Kie †h, Avcbvi ÔwPwKrmv/civgk© cÖ`vbÕ ch©‡e¶Y Ki‡j Avcwb wKQy g‡b Ki‡eb  bv| Avgv‡K, Avcwb †Kvb cÖkœ wR‡Ám Ki‡Z Pvb wK?");
                break;
            case 2:
                ((TextView)findViewById(R.id.des_text)).setText("cÖ`v‡bi gvb Dbœq‡b wewfbœ ¯^v¯’¨‡K‡›`ª GKwU Rwic cwiPvjbv KiwQ| GB Rwi‡ci Z_¨ mg~n ¯^v¯’¨ †mevi gvb Dbœqb I M‡elYvi Kv‡R e¨envi Kiv n‡e| GB ¯^v¯’¨‡K‡›`ª Amy¯’ wkïi †mev wKfv‡e †`qv nq Zv eySvi Rb¨ Avwg GB K¬v‡q‡›Ui mv‡_ Avcbvi Kbmvj‡UkbwU ch©‡e¶Y Ki‡Z PvB| Avcwb K¬v‡q›U‡K †h †mev cÖ`vb Ki‡Qb Zv g~j¨vqb Kiv Avgv‡`i D‡Ïk¨ bq Ges G e¨vcv‡i Avwg `¶I bB| GB ch©‡e¶‡Yi Z_¨ †Mvcb _vK‡e| Avcbvi ev K¬v‡q‡›Ui bvg wi‡cv‡U© mshy³ Kiv n‡e bv| hw` Avcwb †Kvb c‡q‡›U A¯^w¯Í‡eva K‡ib, Zvn‡j Avgv‡K GB ¯’vb Z¨vM Ki‡Z ej‡Z cv‡ib| hv †nvK, Avwg Avkv Kie †h, Avcbvi ÔwPwKrmv/civgk© cÖ`vbÕ ch©‡e¶Y Ki‡j Avcwb wKQy g‡b Ki‡eb  bv| Avgv‡K, Avcwb †Kvb cÖkœ wR‡Ám Ki‡Z Pvb wK?");
                break;
            case 3:
                ((TextView)findViewById(R.id.des_text)).setText("cÖ`v‡bi gvb Dbœq‡b wewfbœ ¯^v¯’¨‡K‡›`ª GKwU Rwic cwiPvjbv KiwQ| GB Rwi‡ci Z_¨ mg~n ¯^v¯’¨ †mevi gvb Dbœqb I M‡elYvi Kv‡R e¨envi Kiv n‡e| GB ¯^v¯’¨‡K‡›`ª †mev wKfv‡e †`qv nq Zv eySvi Rb¨ Avwg GB K¬v‡q‡›Ui mv‡_ Avcbvi Kbmvj‡UkbwU ch©‡e¶Y Ki‡Z PvB| Avcwb K¬v‡q›U‡K †h †mev cÖ`vb Ki‡Qb Zv g~j¨vqb Kiv Avgv‡`i D‡Ïk¨ bq Ges G e¨vcv‡i Avwg `¶I bB| GB ch©‡e¶‡Yi Z_¨ †Mvcb _vK‡e| Avcbvi ev K¬v‡q‡›Ui bvg wi‡cv‡U© mshy³ Kiv n‡e bv| hw` Avcwb †Kvb c‡q‡›U A¯^w¯Í‡eva K‡ib, Zvn‡j Avgv‡K GB ¯’vb Z¨vM Ki‡Z ej‡Z cv‡ib| hv †nvK, Avwg Avkv Kie †h, Avcbvi ÔwPwKrmv/civgk© cÖ`vbÕ ch©‡e¶Y Ki‡j Avcwb wKQy g‡b Ki‡eb  bv| Avgv‡K, Avcwb †Kvb cÖkœ wR‡Ám Ki‡Z Pvb wK?");
                break;
            case 4:
                ((TextView)findViewById(R.id.des_text)).setText("cÖ`v‡bi gvb Dbœq‡b wewfbœ ¯^v¯’¨‡K‡›`ª GKwU Rwic cwiPvjbv KiwQ| GB Rwi‡ci Z_¨ mg~n ¯^v¯’¨ †mevi gvb Dbœqb I M‡elYvi Kv‡R e¨envi Kiv n‡e| GB ¯^v¯’¨‡K‡›`ª cwievi cwiKíbv †mev wKfv‡e †`qv nq Zv eySvi Rb¨ Avwg GB K¬v‡q‡›Ui mv‡_ Avcbvi Kbmvj‡UkbwU ch©‡e¶Y Ki‡Z PvB| Avcwb K¬v‡q›U‡K †h †mev cÖ`vb Ki‡Qb Zv g~j¨vqb Kiv Avgv‡`i D‡Ïk¨ bq Ges G e¨vcv‡i Avwg `¶I bB| GB ch©‡e¶‡Yi Z_¨ †Mvcb _vK‡e| Avcbvi ev K¬v‡q‡›Ui bvg wi‡cv‡U© mshy³ Kiv n‡e bv| Avgv‡K, Avcwb †Kvb cÖkœ wR‡Ám Ki‡Z Pvb wK? hw` Avcwb †Kvb c‡q‡›U A¯^w¯Í‡eva K‡ib, Zvn‡j Avgv‡K GB ¯’vb Z¨vM Ki‡Z ej‡Z cv‡ib| hv †nvK, Avwg Avkv Kie †h, Avcbvi ÔwPwKrmv/civgk© cÖ`vbÕ ch©‡e¶Y Ki‡j Avcwb wKQy g‡b Ki‡eb  bv|");
                break;
        }

    }

    private void sETv(int id,String val){
        EditText et = (EditText) findViewById(id);
        if(et != null){
            et.setText(val);
        }
    }

    private void collectData() throws Exception {
        name = gETv(R.id.user);
        permitted = gRGv(R.id.radios);
        if(findViewById(R.id.collector_layout).getVisibility() == View.VISIBLE) {
            collectorName = gETv(R.id.collector_name);
        }
        if(findViewById(R.id.designation_layout).getVisibility() == View.VISIBLE) {
            collectorDesignation = gSPi(R.id.sp_designation);
        }
    }

    private String gSPi(int id) throws Exception {
        Spinner sp = (Spinner) findViewById(id);
        int selection = sp.getSelectedItemPosition();
        if(selection == 0) throw new Exception();
        return Integer.toString(selection);
    }

    private String gETv(int id) throws Exception {
        Editable text = ((EditText) findViewById(id)).getText();
        if(TextUtils.isEmpty(text)){
            throw new Exception();
        }
        else{
            return text.toString();
        }
    }

    private String gRGv(int id) throws Exception {
        RadioGroup radioGroup = (RadioGroup) findViewById(id);
        int rbId = radioGroup.getCheckedRadioButtonId();
        if(rbId == -1) throw new Exception();
        if(radioGroup.getChildAt(0).getId() == rbId){
            return "true";
        }
        else{
            return "false";
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.cnt){
            try {
                collectData();
                if(permitted.equals("true")) {
                    Intent intent = getIntent();
                    intent.setClass(this,ConsentActivity1.class);
                    intent.putExtra("c_name",collectorName);
                    intent.putExtra("designation",collectorDesignation);
                    intent.putExtra("name",name);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(this,"You are not permitted to continue",Toast.LENGTH_SHORT).show();
                }
            }catch(Exception e){
                e.printStackTrace();
                Toast.makeText(this, "Form is not complete", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
