package caresurvey.sci.com.caresurvey.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
import java.util.List;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.DatabaseAccess;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessUnion;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessUpazila;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessVillage;

public class AddressInsertActivity extends AppCompatActivity {
    Spinner sp1,sp2,sp3,sp4,sp5;
    EditText timepicker,datepicker;
    Button timepickerbutton, datepickerbutton;
    String name,datespicker,timespicker;
    int id;
    String c_name, upozila, union1,village1;

    static final int TIME_DIALOG_ID = 1111;
    private TextView output;
    public Button btnClick;

    private int hour;
    private int minute;


    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private Spinner divspinner,zillaspinner,upzillaspinner,unionspinner,mouzaspinner,villagespinner;
    String divname,zillname,upazilname,unionname,mouzaname,vilname;
    String divid=String.valueOf(10);
    String mouzaid,vilid,zillaid,upzillaid,unionid=null;
    List<String> divnames,zillanames,upazillanames,unionnames,mouzanames,vilnames;
    public DatabaseAccess databaseAccess;
    TextView upazila,union,village;

    public String getDivname() {
        return divname;
    }

    public void setDivname(String divname) {
        this.divname = divname;
    }

    public String getZillaid() {
        return zillaid;
    }

    public void setZillaid(String zillaid) {
        this.zillaid = zillaid;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_insert);
        databaseAccess = DatabaseAccess.getInstance(this);


        //sp5=(Spinner)findViewById(R.id.spinner6);

        Intent intent= getIntent();
        name= intent.getStringExtra("name");
        id= intent.getIntExtra("id",1);
        c_name=intent.getStringExtra("c_name");

        EditText user= (EditText)findViewById(R.id.user);
        user.setText(name);

        divspinner=(Spinner)findViewById(R.id.divisionspinner);
        villagespinner=(Spinner)findViewById(R.id.villagespinner);
        upzillaspinner=(Spinner)findViewById(R.id.upzillaspinner);
        unionspinner=(Spinner)findViewById(R.id.unionspinner);
        //  listView = (ListView) findViewById(R.id.listView);
        setDivname("HABIGANJ");//string from the other activity

        if (divname.equals("HABIGANJ"))
        {
            setZillaid(String.valueOf(36));
        }
        callspinner1();

//
        timepicker=(EditText)findViewById(R.id.timepicker);
        datepicker= (EditText)findViewById(R.id.datepicker);
        timepickerbutton=(Button)findViewById(R.id.timepickerbutton);
        datepickerbutton=(Button)findViewById(R.id.datepickerbutton);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
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
                intent.putExtra("id", id);
                intent.putExtra("mark",1);
                intent.putExtra("upozila",upazilname);
                intent.putExtra("union",unionname);
                intent.putExtra("village",vilname);
                startActivity(intent);
            }
        });






    }
    public void callspinner3(String zillaid)
    {

        final DatabaseAccessUpazila databaseAccessUpazila =DatabaseAccessUpazila.getInstance(this);
        databaseAccessUpazila.open();
        upazillanames = databaseAccessUpazila.getUpaZillaname(zillaid);
        databaseAccessUpazila.close();
        ArrayAdapter<String> adapterupazila = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, upazillanames);
        upzillaspinner.setAdapter(adapterupazila);
        upzillaspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                upazilname = upzillaspinner.getSelectedItem().toString();
                databaseAccessUpazila.open();
                upzillaid = databaseAccessUpazila.GetupazilaID(upazilname);
                databaseAccessUpazila.close();
                callspinner4(upzillaid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
    }
    public void callspinner4(String upzillaid)
    {

        final DatabaseAccessUnion databaseAccessUnion =DatabaseAccessUnion.getInstance(this);
        databaseAccessUnion.open();
        unionnames = databaseAccessUnion.getunionname(upzillaid);
        databaseAccessUnion.close();
        ArrayAdapter<String> adapterupauni = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, unionnames);
        unionspinner.setAdapter(adapterupauni);
        unionspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unionname = unionspinner.getSelectedItem().toString();
                databaseAccessUnion.open();
                unionid = databaseAccessUnion.GetUnionID(unionname);
                databaseAccessUnion.close();
                callspinner6(unionid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
    }
    public void callspinner6(String unionid)
    {

        final DatabaseAccessVillage databaseAccessVillage =DatabaseAccessVillage.getInstance(this);
        databaseAccessVillage.open();
        vilnames = databaseAccessVillage.getvilname(unionid);
        databaseAccessVillage.close();
        ArrayAdapter<String> adaptervil = new ArrayAdapter<String>(this,R.layout.drop_down_list_addrees, vilnames);
        villagespinner.setAdapter(adaptervil);
        villagespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vilname = villagespinner.getSelectedItem().toString();
                databaseAccessVillage.open();
                vilid = databaseAccessVillage.GetvillageID(vilname);
                databaseAccessVillage.close();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {

        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();
    }
    public void callspinner1()
    {

        divspinner=(Spinner)findViewById(R.id.divisionspinner);
        databaseAccess.open();
        ArrayList<String> issue = new ArrayList<String>();

        issue.add("District Hospital");
        issue.add("Upazila Health Complex");
        issue.add("Union Health & Family Welfare Center");
        issue.add("Satellite Clinic");

        ArrayAdapter<String> adapterr = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, issue);
        divspinner.setAdapter(adapterr);
        divspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                divname = divspinner.getSelectedItem().toString();
                if (position == 0) {

                    // upazila.setVisibility(View.GONE);
                    // village.setVisibility(View.GONE);
                    // union.setVisibility(View.GONE);
                    // villagespinner.setVisibility(View.GONE);
                    // unionspinner.setVisibility(View.GONE);
                    // upzillaspinner.setVisibility(View.GONE);
                } else if (position == 1 || position == 3) {
                    upzillaspinner.setVisibility(View.VISIBLE);
                    // upazila.setVisibility(View.VISIBLE);
                    //  village.setVisibility(View.VISIBLE);
                    //  union.setVisibility(View.VISIBLE);
                    //  villagespinner.setVisibility(View.VISIBLE);
                    //  unionspinner.setVisibility(View.VISIBLE);
                    //  upzillaspinner.setVisibility(View.VISIBLE);
                    callspinner3(getZillaid());
                } else if (position == 2) {
                    //   upazila.setVisibility(View.GONE);
                    //   village.setVisibility(View.VISIBLE);
                    //  union.setVisibility(View.VISIBLE);
                    //  villagespinner.setVisibility(View.VISIBLE);
                    //  unionspinner.setVisibility(View.VISIBLE);
                    upzillaspinner.setVisibility(View.GONE);
                    callspinner4(getZillaid());
                }
            }


            //Toast.makeText(getApplicationContext(), position, Toast.LENGTH_SHORT);
            // databaseAccess.open();
            //  divid = databaseAccess.GetDeptID(divname);
            //  databaseAccess.close();
            //callspinner2(divid);


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

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
