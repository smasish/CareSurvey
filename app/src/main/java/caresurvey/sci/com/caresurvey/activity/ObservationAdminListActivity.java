package caresurvey.sci.com.caresurvey.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.List;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.ANCSupervisorTable;
import caresurvey.sci.com.caresurvey.database.FPObservationSupervisorTable;
import caresurvey.sci.com.caresurvey.database.InventorySupervisorTable;
import caresurvey.sci.com.caresurvey.database.SatelliteClinicSupervisorTable;
import caresurvey.sci.com.caresurvey.database.SickChildSupervisorTable2;
import caresurvey.sci.com.caresurvey.model.ANCFormItem;
import caresurvey.sci.com.caresurvey.model.DBRow;

/**
 * Created by shantanu on 6/24/16.
 */

public class ObservationAdminListActivity extends AppCompatActivity implements View.OnClickListener {
    private String user;
    private String facility;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observation_list);
        user = getIntent().getStringExtra("user");
        facility = getIntent().getStringExtra("facility");
        if(facility.equals("Satellite Clinic")){
            findViewById(R.id.satellite_clinic).setVisibility(View.VISIBLE);
            findViewById(R.id.anc).setVisibility(View.VISIBLE);
            findViewById(R.id.sick_child).setVisibility(View.VISIBLE);
            findViewById(R.id.inventory).setVisibility(View.GONE);
            findViewById(R.id.famility).setVisibility(View.VISIBLE);
        }
        else{
            findViewById(R.id.satellite_clinic).setVisibility(View.GONE);
            findViewById(R.id.anc).setVisibility(View.VISIBLE);
            findViewById(R.id.sick_child).setVisibility(View.VISIBLE);
            findViewById(R.id.inventory).setVisibility(View.VISIBLE);
            findViewById(R.id.famility).setVisibility(View.VISIBLE);
        }

        findViewById(R.id.satellite_clinic).setOnClickListener(this);
        findViewById(R.id.anc).setOnClickListener(this);
        findViewById(R.id.sick_child).setOnClickListener(this);
        findViewById(R.id.inventory).setOnClickListener(this);
        findViewById(R.id.famility).setOnClickListener(this);

        loadData();
    }

    private void loadData(){
//        if(findViewById(R.id.satellite_clinic).getVisibility() == View.VISIBLE){
//            ((Button)findViewById(R.id.satellite_clinic)).setText("Inventory of satellite clinic " + new SatelliteClinicSupervisorTable(this).getList(user,facility).size() + "/30");;
//        }
//        else{
            ((Button)findViewById(R.id.satellite_clinic)).setText("Inventory of Satellite Clinic " + new SatelliteClinicSupervisorTable(this).getList(user,facility).size() + "/30");;
            ((Button)findViewById(R.id.anc)).setText("Observation of ANC " + new ANCSupervisorTable(this).getList(user,facility).size() + "/30");;
            ((Button)findViewById(R.id.inventory)).setText("Inventory of Facility " + new InventorySupervisorTable(this).getList(user,facility).size() + "/1");
            ((Button)findViewById(R.id.sick_child)).setText("Observation of Sick Child " + new SickChildSupervisorTable2(this).getList(user,facility).size() + "/30");
            ((Button)findViewById(R.id.famility)).setText("Observation of Family Planning " + new FPObservationSupervisorTable(this).getList(user,facility).size() + "/30");
//        }
    }

    String extractTitle(String title){
        String tokens[] = title.split("/");
        return tokens[0].substring(0,tokens[0].length()-2);
    }

    @Override
    public void onClick(View v) {
        Intent intent = getIntent();
        intent.setClass(this,SurveyActivity.class);
        switch (v.getId()){
            case R.id.anc:
                intent.putExtra("obs_type","anc");
                intent.putExtra(SurveyActivity.TITLE,extractTitle( ((Button)findViewById(R.id.anc)).getText().toString()));
                startActivity(intent);
                break;
            case R.id.inventory:
                intent.putExtra("obs_type","inv");
                intent.putExtra(SurveyActivity.TITLE,extractTitle( ((Button)findViewById(R.id.inventory)).getText().toString()));
                startActivity(intent);
                break;
            case R.id.sick_child:
                intent.putExtra("obs_type","sic");
                intent.putExtra(SurveyActivity.TITLE,extractTitle( ((Button)findViewById(R.id.sick_child)).getText().toString()));
                startActivity(intent);
                break;
            case R.id.famility:
                intent.putExtra("obs_type","fp");
                intent.putExtra(SurveyActivity.TITLE,extractTitle( ((Button)findViewById(R.id.famility)).getText().toString()));
                startActivity(intent);
                break;
            case R.id.satellite_clinic:
                intent.putExtra("obs_type","sc");
                intent.putExtra(SurveyActivity.TITLE,extractTitle( ((Button)findViewById(R.id.satellite_clinic)).getText().toString()));
                startActivity(intent);
                break;
        }
    }
}
