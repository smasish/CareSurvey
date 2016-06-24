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
import caresurvey.sci.com.caresurvey.utils.AppUtils;

/**
 * Created by shantanu on 6/11/16.
 */
public class ConsentActivity1 extends AppCompatActivity implements View.OnClickListener {
    public static final String FORM = "_form_number";
    private String username;
    private String permitted;
    private String startTime;
    private String date;
    private String description;
    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concent_1);
        getSupportActionBar().setTitle(getIntent().getStringExtra("obs_name"));
        findViewById(R.id.cnt).setOnClickListener(this);
        username = getIntent().getStringExtra("name");
        loadData();
        findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void loadData(){
        sETv(R.id.userCareTaker,username);
        date = AppUtils.getDate();
        sETv(R.id.datepicker,date);
        startTime = AppUtils.getTime();
        sETv(R.id.timepicker,startTime);
        int formId = getIntent().getIntExtra(FORM,0);
        String[] descriptions = null;
        switch(formId){
            case 0:
                sTvv(R.id.description, getResources().getString(R.string.anc_description_text));
                descriptions = getResources().getStringArray(R.array.anc_service_description);
                break;
            case 1:
                //not applicable
                break;
            case 2:
                sTvv(R.id.description, getResources().getString(R.string.sc_description));
                descriptions = getResources().getStringArray(R.array.child_sick_description);
                break;
            case 3:
                //no applicable
                break;
            case 4:
                sTvv(R.id.description, getResources().getString(R.string.fp_description));
                descriptions = getResources().getStringArray(R.array.fp_service_description);
                break;
        }
        Spinner s = (Spinner) findViewById(R.id.description_value);
        if(descriptions != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, descriptions);
            s.setAdapter(adapter);
        }
        else{
            s.setVisibility(View.GONE);
            findViewById(R.id.description).setVisibility(View.GONE);
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
    private void sTvv(int id,String val){
        TextView tv = (TextView) findViewById(id);
        tv.setText(val);
    }
    private void sETv(int id,String val){
        EditText et = (EditText) findViewById(id);
        if(et != null){
            et.setText(val);
        }
    }

    private void collectData() throws Exception {
        username = gETv(R.id.userCareTaker);
        permitted = gRGv(R.id.yesOrNo);
        date = gETv(R.id.datepicker);
        startTime = gETv(R.id.timepicker);
        if(findViewById(R.id.description_value).getVisibility() == View.VISIBLE) {
            description = gSPi(R.id.description_value);
        }
        try {
            phoneNumber = gETv(R.id.phone_number);
        }catch (Exception e){
            phoneNumber = "";
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
            try{
                collectData();
                if(permitted.equals("false")){
                    Toast.makeText(this,"You are not permitted to continue",Toast.LENGTH_SHORT).show();
                }
                else if(permitted.equals("true")){
                    Intent intent = getIntent();
//                    intent.setClass(this, ConsentActivity2.class);
                    intent.putExtra("name", username);
                    intent.putExtra("datepicker",date);
                    intent.putExtra("timepicker",startTime);
                    intent.putExtra("description",description);
                    intent.putExtra("phone",phoneNumber);

                    int position = getIntent().getIntExtra(ConsentActivity1.FORM, 0);
                    switch (position) {
                        case 0:
                            intent.setClass(this,TestActivity.class);
                            break;
                        case 1:
                            intent.setClass(this,SateliteClinicInventoryActivity.class);
                            break;
                        case 2:
                            intent.setClass(this,SickChildUnderFiveActivity.class);
                            break;
                        case 3:
                            intent.setClass(this,FacilityInventoryActivity.class);
                            break;
                        case 4:
                            intent.setClass(this,FpObservationActivity.class);
                            break;
                    }
                    startActivity(intent);
                    finish();
                }
            }catch(Exception e){
                e.printStackTrace();
                Toast.makeText(this,"Form is not complete",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
