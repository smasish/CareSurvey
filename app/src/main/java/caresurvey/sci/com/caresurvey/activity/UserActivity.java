package caresurvey.sci.com.caresurvey.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.FormTable;
import caresurvey.sci.com.caresurvey.database.FormTableUser;
import caresurvey.sci.com.caresurvey.model.FormItem;
import caresurvey.sci.com.caresurvey.model.FormItemUser;
import caresurvey.sci.com.caresurvey.model.SickChildItem;

public class UserActivity extends AppCompatActivity {
    Boolean firstRun;
    String b1_status, datepicker, timepicker, user_name, facility, upozila, union, village, obsname;
    int obs_position;
    EditText timepicker1, datepicker1;
    RadioButton radio1;
    String radioselection;
    String serial, caretaker;


    EditText user, user_caretaker;
    EditText collector_name, sp_designation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Button btn = (Button) findViewById(R.id.btn);
        user = (EditText) findViewById(R.id.user);
        collector_name = (EditText) findViewById(R.id.collector_name);

        RadioButton radioButton;
        radioButton = (RadioButton) findViewById(R.id.yes);
        radioButton.setChecked(true);
        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio1.setChecked(true);

        Intent intentx = getIntent();
        //   user = (EditText)findViewById(R.id.user);
        // datepicker= intentx.getStringExtra("datepicker");
        // timepicker = intentx.getStringExtra("timepicker");
        //     user_name = intentx.getStringExtra("name");
        obs_position = intentx.getIntExtra("positon", 0);
        facility = intentx.getStringExtra("facility");
        upozila = intentx.getStringExtra("upozila");
        union = intentx.getStringExtra("union");
        village = intentx.getStringExtra("village");
        obsname = intentx.getStringExtra("obstype");
        serial = intentx.getStringExtra("serial");
        user_caretaker = (EditText) findViewById(R.id.userCareTaker);
        sp_designation = (EditText) findViewById(R.id.sp_designation);
        //   user.setText(user_name);

        Log.d("..>>>>>>", "Username" + user_name);


        timepicker1 = (EditText) findViewById(R.id.timepicker);
        datepicker1 = (EditText) findViewById(R.id.datepicker);
        //  timepickerbutton=(Button)findViewById(R.id.timepickerbutton);
        //datepickerbutton=(Button)findViewById(R.id.datepickerbutton);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
        SimpleDateFormat df2 = new SimpleDateFormat("hh:mm:ss aa");


        Date p = c.getTime();

        Log.d(">>>", "data" + df.format(c.getTime()));


        datepicker1.setText("   " + df.format(c.getTime()));
        timepicker1.setText("   " + df2.format(c.getTime()));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor1 = pref.edit();
                int first_value = pref.getInt("id", 0);
                int child_sick_value = pref.getInt("cs_id", 0);


                FormTableUser formTable = new FormTableUser(UserActivity.this);


                SharedPreferences settings = getSharedPreferences("prefs", 0);
                firstRun = settings.getBoolean("firstRun", false);


                if (firstRun == false)//if running for first time
                {
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("firstRun", true);
                    editor.commit();


                    for (int i = 1; i <= 30; i++) {

                        FormItemUser formItem = new FormItemUser(i, "No", "No", "No", "No", "No", "No"
                                , "No", "No", "No", "No", "No", "No", 5, "", "", "", "", "3", "", "", "", "", "", "", "", "");

                        formTable.insertItem(formItem);


                    }


                }

                String username = user.getText().toString();

                RadioGroup radioGroup;


                radioGroup = (RadioGroup) findViewById(R.id.radios);


                int selectedq1 = radioGroup.getCheckedRadioButtonId();

                RadioButton rb1 = (RadioButton) findViewById(selectedq1);
                b1_status = rb1.getText().toString();

                RadioGroup radioGroup1;


                radioGroup1 = (RadioGroup) findViewById(R.id.yesOrNo);


                int selectedq11 = radioGroup1.getCheckedRadioButtonId();

                RadioButton rb11 = (RadioButton) findViewById(selectedq11);
                radioselection = rb11.getText().toString();

                if (radioselection.equals("না"))

                {

                    AlertMessage.showMessage(UserActivity.this, "You can not go to next step",
                            "");
                } else if (username.equals("")) {
                    AlertMessage.showMessage(UserActivity.this, "Please insert User name.",
                            "");

                } else if (b1_status.equals("না"))

                {

                    AlertMessage.showMessage(UserActivity.this, "You can not go to next step",
                            "");


                } else if (collector_name.getText().toString().equals(""))

                {
                    AlertMessage.showMessage(UserActivity.this, "Please insert Service provider name",
                            "");
                } else {

                    Log.d(">>>", "position_value" + obs_position);


                    if (obs_position == 0) {
                        Intent intent = new Intent(UserActivity.this, TestActivity.class);
                        intent.putExtra("name", username);
                        intent.putExtra("id", first_value);
                        intent.putExtra("c_name", collector_name.getText().toString());

                        intent.putExtra("mark", 1);
                        intent.putExtra("datepicker", datepicker);
                        intent.putExtra("timepicker", timepicker);

                        // Log.d(".....>>>>>>>>>>", "Id in address Insert Activity  " + id);

                        intent.putExtra("facility", facility);
                        intent.putExtra("upozila", upozila);
                        intent.putExtra("union", union);
                        intent.putExtra("village", village);
                        intent.putExtra("obstype", obsname);


                        startActivity(intent);
                        finish();
                    } else if (obs_position == 1) {
//                        Intent intent = new Intent(UserActivity.this, SateliteClinicInventoryActivity.class);
//                        startActivity(intent);
                        finish();
                    } else if (obs_position == 2) {
                        Intent intent = new Intent(UserActivity.this, TestActivity1.class);
                        intent.putExtra("caretaker", user_caretaker.getText().toString());
                        intent.putExtra("name", username);
                        intent.putExtra("id", child_sick_value);
                        intent.putExtra("c_name", collector_name.getText().toString());
                        intent.putExtra("designation", sp_designation.getText().toString());

                        intent.putExtra("mark", 1);
                        intent.putExtra("datepicker", datepicker);
                        intent.putExtra("timepicker", timepicker);
                        intent.putExtra("serial", serial);

                        // Log.d(".....>>>>>>>>>>", "Id in address Insert Activity  " + id);

                        intent.putExtra("facility", facility);
                        intent.putExtra("upozila", upozila);
                        intent.putExtra("union", union);
                        intent.putExtra("village", village);
                        intent.putExtra("obstype", obsname);


                        startActivity(intent);
                        finish();
                    } else if (obs_position == 3) {
                        Intent intent = new Intent(UserActivity.this, FacilityInventoryActivity.class);
                        startActivity(intent);
                        finish();
                    } else if (obs_position == 4) {
                        Intent intent = new Intent(UserActivity.this, FpObservationActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }


            }
        });


    }


    private void passvalue() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user, menu);
        return true;
    }


    @Override
    public void onBackPressed() {
        Intent intentv = new Intent(UserActivity.this, SelectionUserActivity.class);
        startActivity(intentv);
        finish();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
