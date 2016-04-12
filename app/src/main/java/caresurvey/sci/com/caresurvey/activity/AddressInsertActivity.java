package caresurvey.sci.com.caresurvey.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import caresurvey.sci.com.caresurvey.R;

public class AddressInsertActivity extends AppCompatActivity {
    Spinner sp1,sp2,sp3,sp4,sp5;
    EditText timepicker,datepicker;
    Button timepickerbutton, datepickerbutton;
    String name,datespicker,timespicker;
    int id;
    String c_name;

    static final int TIME_DIALOG_ID = 1111;
    private TextView output;
    public Button btnClick;

    private int hour;
    private int minute;


    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_insert);


        Intent intent= getIntent();
        name= intent.getStringExtra("name");
        id= intent.getIntExtra("id",1);
        c_name=intent.getStringExtra("c_name");
        EditText user= (EditText)findViewById(R.id.user);
        user.setText(name);
        ArrayList<String> sub_district = new ArrayList<String>();
        sub_district.add("District Hospital");
        sub_district.add("Upozila Health Complex");
        sub_district.add("Union health and family welfare center");
        sub_district.add("Satellite Clinic");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, sub_district);
        sp1.setAdapter(adapter);
        ArrayList<String> sub_district1 = new ArrayList<String>();
        sub_district1.add("District Hospital");
        sub_district1.add("Upozila Health Complex");
        sub_district1.add("Union health and family welfare center");
        sub_district1.add("Satellite Clinic");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, sub_district1);
        sp2.setAdapter(adapter1);


        ArrayList<String> sub_district2 = new ArrayList<String>();
        sub_district2.add("District Hospital");
        sub_district2.add("Upozila Health Complex");
        sub_district2.add("Union health and family welfare center");
        sub_district2.add("Satellite Clinic");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, sub_district2);
        sp3.setAdapter(adapter2);


        ArrayList<String> sub_district3 = new ArrayList<String>();
        sub_district3.add("District Hospital");
        sub_district3.add("Upozila Health Complex");
        sub_district3.add("Union health and family welfare center");
        sub_district3.add("Satellite Clinic");
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, sub_district3);
        sp4.setAdapter(adapter3);



        ArrayList<String> sub_district4 = new ArrayList<String>();
        sub_district4.add("District Hospital");
        sub_district4.add("Upozila Health Complex");
        sub_district4.add("Union health and family welfare center");
        sub_district4.add("Satellite Clinic");
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, sub_district4);
        sp5.setAdapter(adapter4);


        timepicker=(EditText)findViewById(R.id.timepicker);
        datepicker= (EditText)findViewById(R.id.datepicker);
        timepickerbutton=(Button)findViewById(R.id.timepickerbutton);
        datepickerbutton=(Button)findViewById(R.id.datepickerbutton);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat df2 = new SimpleDateFormat("hh:mm:ss aa");


        Date p=c.getTime();

        Log.d(">>>","data"+ df.format(c.getTime()));


        datepicker.setText("   " + df.format(c.getTime()));
        timepicker.setText("   "+df2.format(c.getTime()));



        datepickerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dateView = (TextView) findViewById(R.id.textView3);
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);

                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                showDialog(999);
                showDate(year, month + 1, day);


            }
        });


        timepickerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final Calendar c = Calendar.getInstance();
                // Current Hour
                hour = c.get(Calendar.HOUR_OF_DAY);
                // Current Minute
                minute = c.get(Calendar.MINUTE);

                // set current time into output textview
                updateTime(hour, minute);

                /********* display current time on screen End ********/

                // Add Button Click Listener
                showDialog(TIME_DIALOG_ID);

            }
        });


        Button button =(Button)findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(".....>>>>>>>>>>", "response length" + name);
                Intent intent = new Intent(AddressInsertActivity.this,TestActivity.class);
                intent.putExtra("name",name);
                datespicker=datepicker.getText().toString();
                timespicker=timepicker.getText().toString();
                intent.putExtra("datepicker",datespicker);
                intent.putExtra("timepicker",timespicker);
                intent.putExtra("c_name",c_name);
                Log.d(".....>>>>>>>>>>", "Id in address Insert Activity  " + id);
                intent.putExtra("id",id);
                intent.putExtra("mark",1);
                startActivity(intent);
            }
        });






    }



    @SuppressWarnings("deprecation")
    public void setDate(View view) {

        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {

            Log.d(">>>","datepicker "+id);
            return new DatePickerDialog(this, myDateListener, year, month, day);

        }
        else {
            return new TimePickerDialog(this, timePickerListener, hour, minute,
                    false);
        }









    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        datepicker.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }







    private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {


        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {
            // TODO Auto-generated method stub
            hour   = hourOfDay;
            minute = minutes;

            updateTime(hour, minute);

        }

    };

    private static String utilTime(int value) {

        if (value < 10)
            return "0" + String.valueOf(value);
        else
            return String.valueOf(value);
    }

    // Used to convert 24hr format to 12hr format with AM/PM values
    private void updateTime(int hours, int mins) {

        String timeSet = "";
        if (hours > 12) {
            hours -= 12;
            timeSet = "PM";
        } else if (hours == 0) {
            hours += 12;
            timeSet = "AM";
        } else if (hours == 12)
            timeSet = "PM";
        else
            timeSet = "AM";


        String minutes = "";
        if (mins < 10)
            minutes = "0" + mins;
        else
            minutes = String.valueOf(mins);

        // Append in a StringBuilder
        String aTime = new StringBuilder().append(hours).append(':')
                .append(minutes).append(" ").append(timeSet).toString();

        timepicker.setText(aTime);
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_address_insert, menu);
        return true;
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
