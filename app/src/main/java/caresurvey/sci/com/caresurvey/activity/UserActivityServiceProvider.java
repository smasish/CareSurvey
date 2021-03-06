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

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.ANCTable;
import caresurvey.sci.com.caresurvey.model.ANCFormItem;

public class UserActivityServiceProvider extends AppCompatActivity {
    Boolean  firstRun;
    String b1_status,datepicker,timepicker,user_name,facility,upozila,union, village, obsname;
    int first_value;
    EditText user;
    EditText collector_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Button btn = (Button)findViewById(R.id.btn);
        user = (EditText)findViewById(R.id.user);
        collector_name=(EditText)findViewById(R.id.collector_name);

        RadioButton radioButton;
        radioButton=(RadioButton)findViewById(R.id.yes);
        radioButton.setChecked(true);


        Intent intentx =getIntent();

        datepicker= intentx.getStringExtra("datepicker");
        timepicker = intentx.getStringExtra("timepicker");
        user_name = intentx.getStringExtra("name");
        facility = intentx.getStringExtra("facility");
        upozila = intentx.getStringExtra("upozila");
        union = intentx.getStringExtra("union");
        village = intentx.getStringExtra("village");
        obsname = intentx.getStringExtra("obstype");
        user.setText(user_name);

        Log.d("..>>>>>>","Username"+user_name);







        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor1 = pref.edit();
                int first_value = pref.getInt("id", 0);


                ANCTable formTable = new ANCTable(UserActivityServiceProvider.this);


                SharedPreferences settings = getSharedPreferences("prefs", 0);
                firstRun = settings.getBoolean("firstRun", false);


                if (firstRun == false)//if running for first time
                {
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("firstRun", true);
                    editor.commit();

                    for (int i = 1; i <= 30; i++) {

                        ANCFormItem formItem = new ANCFormItem(i, "No", "No", "No", "No", "No", "No"
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


                if (username.equals("")) {
                    AlertMessage.showMessage(UserActivityServiceProvider.this, "Please insert User name.",
                            "");

                } else if (b1_status.equals("না"))

                {

                    AlertMessage.showMessage(UserActivityServiceProvider.this, "You can not go to next step",
                            "");


                } else if (collector_name.getText().toString().equals(""))

                {
                    AlertMessage.showMessage(UserActivityServiceProvider.this, "Please insert Service provider name",
                            "");
                } else {

                    Intent intent = new Intent(UserActivityServiceProvider.this, TestActivity.class);
                    intent.putExtra("name", username);
                    intent.putExtra("id", first_value);
                    intent.putExtra("c_name", collector_name.getText().toString());

                    intent.putExtra("mark",1);
                    intent.putExtra("datepicker", datepicker);
                    intent.putExtra("timepicker", timepicker);

                    // Log.d(".....>>>>>>>>>>", "Id in address Insert Activity  " + id);

                    intent.putExtra("facility",facility);
                    intent.putExtra("upozila", upozila);
                    intent.putExtra("union", union);
                    intent.putExtra("village", village);
                    intent.putExtra("obstype",obsname);


                    startActivity(intent);
                    finish();
                }


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user, menu);
        return true;
    }


    @Override
    public void onBackPressed() {
        Intent intentv= new Intent(UserActivityServiceProvider.this,SelectionUserActivity.class);
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
