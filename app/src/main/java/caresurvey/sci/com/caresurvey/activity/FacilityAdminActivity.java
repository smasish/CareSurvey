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

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.utils.AppUtils;

/**
 * Created by shantanu on 6/24/16.
 */

public class FacilityAdminActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner userSpinner;
    private Spinner facilitySpinner;
    private ArrayAdapter<String> mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_admin);
        findViewById(R.id.next).setOnClickListener(this);
        userSpinner = (Spinner) findViewById(R.id.user_spinner);
        facilitySpinner = (Spinner) findViewById(R.id.facility_spinner);
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        String username = AppUtils.getUserName(this);
        mAdapter.add("Select user");
        if("supervisor_hb".equals(username)){
            mAdapter.add("user_hb1");
            mAdapter.add("user_hb2");
            mAdapter.add("user_hb3");
        }
        else if("supervisor_jk".equals(username)){
            mAdapter.add("user_jk1");
            mAdapter.add("user_jk2");
            mAdapter.add("user_jk3");
        }
        else if("supervisor_lp".equals(username)){
            mAdapter.add("user_lp1");
            mAdapter.add("user_lp2");
            mAdapter.add("user_lp3");
        }
        else if("admin".equals(username)){
            mAdapter.add("user_hb1");
            mAdapter.add("user_hb2");
            mAdapter.add("user_hb3");

            mAdapter.add("user_jk1");
            mAdapter.add("user_jk2");
            mAdapter.add("user_jk3");

            mAdapter.add("user_lp1");
            mAdapter.add("user_lp2");
            mAdapter.add("user_lp3");
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
