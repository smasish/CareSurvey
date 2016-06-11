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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consent2);
        findViewById(R.id.cnt).setOnClickListener(this);
        loadData();
    }

    private void loadData(){
        sETv(R.id.user, name);
        sETv(R.id.collector_name,collectorName);
        String[] designations = null;
        int formId = getIntent().getIntExtra(ConsentActivity1.FORM,0);
        switch (formId){
            case 0:
                designations = getResources().getStringArray(R.array.anc_designation);
                break;
            case 1:
                designations = getResources().getStringArray(R.array.sci_designation);
                break;
            case 2:
                designations = getResources().getStringArray(R.array.scuf_designation);
                break;
            case 3:
                findViewById(R.id.collector_layout).setVisibility(View.GONE);
                break;
            case 4:
                designations = getResources().getStringArray(R.array.scuf_designation);
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
                    int position = getIntent().getIntExtra(ConsentActivity1.FORM, 0);
                    Intent intent = getIntent();
                    intent.putExtra("c_name",collectorName);
                    intent.putExtra("designation",collectorDesignation);
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
