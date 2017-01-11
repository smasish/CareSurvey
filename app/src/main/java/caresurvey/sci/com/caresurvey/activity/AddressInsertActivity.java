package caresurvey.sci.com.caresurvey.activity;

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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.ANCTable;
import caresurvey.sci.com.caresurvey.database.DatabaseAccess;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessUnion;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessUpazila;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessVillage;
import caresurvey.sci.com.caresurvey.database.FpObservationTable;
import caresurvey.sci.com.caresurvey.database.InventoryTable;
import caresurvey.sci.com.caresurvey.database.SatelliteClinicTable;
import caresurvey.sci.com.caresurvey.database.SickChildTable;

public class AddressInsertActivity extends AppCompatActivity {
    Spinner sp1,sp2,sp3,sp4,obsSpinner;
    EditText timepicker,datepicker;
    TextView facility_id_number;
    Button timepickerbutton, datepickerbutton;
    String name,datespicker,timespicker,radioselection,Obsname;
    int id;
    String c_name, upozila, union1,village1;

    int positions;
    int oservationPosition;

    static final int TIME_DIALOG_ID = 1111;
    private TextView output;
    public Button btnClick;
    EditText user;
    private int hour;
    private int minute;


    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private Spinner facilityspinner,zillaspinner,upzillaspinner,unionspinner,mouzaspinner,villagespinner;
    private Spinner districtSpinner;
    String divname,zillname,upazilname="",unionname="",mouzaname,vilname="";
    String divid=String.valueOf(10);
    String mouzaid,vilid,zillaid,upzillaid,unionid=null;
    List<String> divnames,zillanames,upazillanames,unionnames,mouzanames,vilnames;
    public DatabaseAccess databaseAccess;
    TextView upazila,union,village;

    private LinearLayout anc_lay;

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
        id= intent.getIntExtra("id", 1);
        c_name=intent.getStringExtra("c_name");



        //user.setText(name);
        districtSpinner = (Spinner) findViewById(R.id.districtspinner);
        ArrayList<String> dList = new ArrayList<>();
        dList.add("Habiganj");
        dList.add("Lakshmipur");
        dList.add("Noakhali");
        dList.add("Jhalakati");

        ArrayAdapter<String> districtAdapter = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, dList);
        districtSpinner.setAdapter(districtAdapter);
        districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setDivname(districtSpinner.getSelectedItem().toString());//string from the other activity
                if (divname.equals("Habiganj"))
                {
                    setZillaid(String.valueOf(36));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        facilityspinner =(Spinner)findViewById(R.id.divisionspinner);
        villagespinner=(Spinner)findViewById(R.id.villagespinner);
        upzillaspinner=(Spinner)findViewById(R.id.upzillaspinner);
        unionspinner=(Spinner)findViewById(R.id.unionspinner);
        facility_id_number=(TextView)findViewById(R.id.facility_id_number);
        //  listView = (ListView) findViewById(R.id.listView);



        anc_lay = (LinearLayout)findViewById(R.id.anc_layout);

        callspinner1();

//

        obsSpinner=(Spinner)findViewById(R.id.obsSpinner);

        ArrayList<String> observations = new ArrayList<String>();
        observations.add("Observations of Antenatal Care Consultation");
        observations.add("Inventory of Satellite clinic");
        observations.add("Observatios of Sick Child Under Five");
        observations.add("Inventory of facility");
        observations.add("FP Observation");
        ArrayAdapter<String> obs_adapter = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, observations);

        obsSpinner.setAdapter(obs_adapter);


        obsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Obsname = obsSpinner.getSelectedItem().toString();
                oservationPosition=position;


//                formItems = formTable.getListfromuser(username, facilityname);
//                valuecount=formItems.size();
                //facilityspinner.setAdapter(null);
                long lastId = 0;
                if(position == 0){
                    // define layout here...visible or invisible
                    Log.d(">>>>>>>>>0", "=============sp position=========" );
                    lastId = new ANCTable(AddressInsertActivity.this).getLastId();
                }
                else if(position == 1){
                    ///define layout here...visible or invisible
                 //   anc_lay.setVisibility(View.GONE);
                    lastId = new SatelliteClinicTable(AddressInsertActivity.this).getLastId();
                    Log.d(">>>>>>>>>1", "=============sp position=========");
                }
                else if(position == 2){
                    ///define layout here...visible or invisible
                    lastId = new SickChildTable(AddressInsertActivity.this).getLastId();
                }
                else if(position == 3){
                    ///define layout here...visible or invisible
                    lastId = new InventoryTable(AddressInsertActivity.this).getLastId();
                }
                else if(position == 4){
                    lastId = new FpObservationTable(AddressInsertActivity.this).getLastId();
                }
                facility_id_number.setText(""+(++lastId));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });






//        datepickerbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dateView = (TextView) findViewById(R.id.textView3);
//                calendar = Calendar.getInstance();
//                year = calendar.get(Calendar.YEAR);
//
//                month = calendar.get(Calendar.MONTH);
//                day = calendar.get(Calendar.DAY_OF_MONTH);
//                showDialog(999);
//                showDate(year, month + 1, day);
//
//
//            }
//        });


//        timepickerbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//                final Calendar c = Calendar.getInstance();
//                // Current Hour
//                hour = c.get(Calendar.HOUR_OF_DAY);
//                // Current Minute
//                minute = c.get(Calendar.MINUTE);
//
//                // set current time into output textview
//                updateTime(hour, minute);
//
//                /********* display current time on screen End ********/
//
//                // Add Button Click Listener
//                showDialog(TIME_DIALOG_ID);
//
//            }
//        });


        Button button =(Button)findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(".....>>>>>>>>>>", "response length" + name);










                    if(positions==0&&upazilname.equals("")&&unionname.equals("")&&vilname.equals(""))
                    {
                        passActivity();
                        finish();
                    }

                    else if(positions==1&&!upazilname.equals("")&&unionname.equals("")&&vilname.equals(""))
                    {
                        passActivity();
                        finish();
                    }

                    else if(positions==2&&!upazilname.equals("")&&!unionname.equals("")&&!vilname.equals(""))

                    {
                        passActivity();
                        finish();
                    }

                    else if(positions==3&&!upazilname.equals("")&&!unionname.equals("")&&!vilname.equals(""))
                    {
                        passActivity();
                        finish();
                    }

                    else
                        AlertMessage.showMessage(AddressInsertActivity.this, "Please enter the locations carefully",
                                "");




            }
        });

        //init
//        long lastId = new FormTable(AddressInsertActivity.this).getLastId();
//        facility_id_number.setText("" + (++lastId));




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

    public void passActivity()
    {
        int formId = Integer.parseInt(facility_id_number.getText().toString());
        if(formId > 30){
            Toast.makeText(AddressInsertActivity.this,"Maximum observation has been completed",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(AddressInsertActivity.this, ConsentActivity1.class);
    //    name= user.getText().toString();
      //  intent.putExtra("name", name);
        //datespicker = datepicker.getText().toString();
        //timespicker = timepicker.getText().toString();
        //intent.putExtra("datepicker", datespicker);
        //intent.putExtra("timepicker", timespicker);
       // intent.putExtra("c_name", c_name);

        Log.d(".....>>>>>>>>>>", "Id in address Insert Activity  " + id);
     //   intent.putExtra("id", id);

        intent.putExtra("facility",divname);
        intent.putExtra("upozila", upazilname);
        intent.putExtra("union", unionname);
        intent.putExtra("village", vilname);
        intent.putExtra("district",districtSpinner.getSelectedItem().toString());
       // intent.putExtra("obstype",Obsname);
        intent.putExtra("serial",facility_id_number.getText().toString());
        intent.putExtra(ConsentActivity1.FORM,oservationPosition);
        startActivity(intent);
        finish();
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {

        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();
    }
    public void callspinner1()
    {

        facilityspinner =(Spinner)findViewById(R.id.facility);
        databaseAccess.open();
        ArrayList<String> issue = new ArrayList<String>();

        issue.add("District Hospital");
        issue.add("Upazila Health Complex");
        issue.add("Union Health & Family Welfare Center");
        issue.add("Satellite Clinic");

        ArrayAdapter<String> adapterr = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, issue);
        facilityspinner.setAdapter(adapterr);




        facilityspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                divname = facilityspinner.getSelectedItem().toString();
                if (position == 0) {

                    // upazila.setVisibility(View.GONE);
                    // village.setVisibility(View.GONE);
                    // union.setVisibility(View.GONE);
                    villagespinner.setVisibility(View.GONE);
                    unionspinner.setVisibility(View.GONE);
                    upzillaspinner.setVisibility(View.GONE);
                    obsSpinner.setEnabled(true);
                } else if (position == 1) {
                    upzillaspinner.setVisibility(View.VISIBLE);
                    //   upazila.setVisibility(View.VISIBLE);
                    //  village.setVisibility(View.VISIBLE);
                    //union.setVisibility(View.VISIBLE);
                    villagespinner.setVisibility(View.GONE);
                    unionspinner.setVisibility(View.GONE);
                    //  upzillaspinner.setVisibility(View.VISIBLE);
                    callspinner3(getZillaid());
                    obsSpinner.setEnabled(true);
                } else if (position == 2) {
                    //   upazila.setVisibility(View.GONE);
                    //   village.setVisibility(View.VISIBLE);
                    //  union.setVisibility(View.VISIBLE);
                    villagespinner.setVisibility(View.VISIBLE);
                    unionspinner.setVisibility(View.VISIBLE);
                    upzillaspinner.setVisibility(View.VISIBLE);
                    callspinner3(getZillaid());
                    obsSpinner.setEnabled(true);
                }


                else if ( position == 3) {
                    upzillaspinner.setVisibility(View.VISIBLE);
                    //   upazila.setVisibility(View.VISIBLE);
                    //  village.setVisibility(View.VISIBLE);
                    //union.setVisibility(View.VISIBLE);
                    villagespinner.setVisibility(View.VISIBLE);
                    unionspinner.setVisibility(View.VISIBLE);
                    //  upzillaspinner.setVisibility(View.VISIBLE);
                    callspinner3(getZillaid());
                    obsSpinner.setSelection(1);
                    obsSpinner.setEnabled(false);
                }

                positions=position;




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

}
