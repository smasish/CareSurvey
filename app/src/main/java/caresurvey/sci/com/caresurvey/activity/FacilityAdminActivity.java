package caresurvey.sci.com.caresurvey.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

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
        if("admin".equalsIgnoreCase(userType)){
            mAdapter.addAll(Arrays.asList(COLLECTOR_HB));
            mAdapter.addAll(Arrays.asList(COLLECTOR_NK));
            mAdapter.addAll(Arrays.asList(COLLECTOR_LP));
            mAdapter.addAll(Arrays.asList(COLLECTOR_JK));
        }
        else if("supervisor".equalsIgnoreCase(userType)){
            if("Habiganj".equalsIgnoreCase(district)){
                mAdapter.addAll(Arrays.asList(COLLECTOR_HB));
            }
            else if("Lakshmipur".equalsIgnoreCase(district)){
                mAdapter.addAll(Arrays.asList(COLLECTOR_LP));
            }
            else if("Noakhali".equalsIgnoreCase(district)){
                mAdapter.addAll(Arrays.asList(COLLECTOR_NK));
            }
            else if("Jhalakati".equalsIgnoreCase(district)){
                mAdapter.addAll(Arrays.asList(COLLECTOR_JK));
            }
        }
        userSpinner.setAdapter(mAdapter);
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
