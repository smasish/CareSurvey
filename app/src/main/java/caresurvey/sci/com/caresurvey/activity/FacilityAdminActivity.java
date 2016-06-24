package caresurvey.sci.com.caresurvey.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import caresurvey.sci.com.caresurvey.R;

/**
 * Created by shantanu on 6/24/16.
 */

public class FacilityAdminActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner userSpinner;
    private Spinner facilitySpinner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_admin);
        findViewById(R.id.next).setOnClickListener(this);
        userSpinner = (Spinner) findViewById(R.id.user_spinner);
        facilitySpinner = (Spinner) findViewById(R.id.facility_spinner);
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
