package caresurvey.sci.com.caresurvey.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.DatabaseAccess;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessMouza;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessUnion;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessUpazila;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessVillage;

/**
 * Created by israt.jahan on 4/10/2016.
 */
public class PrepopSqliteDbActivity extends AppCompatActivity implements View.OnClickListener {


    //A good practice is to define database field names as constants
    Context context;
    private ListView listView;
    private ArrayList<String> ciList;
    private Spinner divspinner, zillaspinner, upzillaspinner, unionspinner, mouzaspinner, villagespinner;
    String divname, zillname, upazilname, unionname, mouzaname, vilname;
    String divid = String.valueOf(10);
    String mouzaid, vilid, zillaid, upzillaid, unionid = null;
    List<String> divnames, zillanames, upazillanames, unionnames, mouzanames, vilnames;
    public DatabaseAccess databaseAccess;
    TextView upazila, union, village;

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
        databaseAccess = DatabaseAccess.getInstance(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_insert);
        // upazila=(TextView)findViewById(R.id.upzillatview);
        // village=(TextView)findViewById(R.id.villagetview);
        // union=(TextView)findViewById(R.id.uniontview);

        divspinner = (Spinner) findViewById(R.id.divisionspinner);
        villagespinner = (Spinner) findViewById(R.id.villagespinner);
        upzillaspinner = (Spinner) findViewById(R.id.upzillaspinner);
        unionspinner = (Spinner) findViewById(R.id.unionspinner);
        //  listView = (ListView) findViewById(R.id.listView);
        setDivname("HABIGANJ");//string from the other activity

        if (divname.equals("HABIGANJ")) {
            setZillaid(String.valueOf(36));
        }
        callspinner1();


    }

    public void callspinner1() {

        divspinner = (Spinner) findViewById(R.id.divisionspinner);
        databaseAccess.open();
        ArrayList<String> issue = new ArrayList<String>();

        issue.add("District Hospital");
        issue.add("Upazila Health Complex");
        issue.add("Union Health & Family Welfare Center");
        issue.add("Satellite Clinic");

        ArrayAdapter<String> adapterr = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, issue);
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

    public void callspinner2(String divid) {

        //   final DatabaseAccessZilla databaseAccessZilla=DatabaseAccessZilla.getInstance(this);

        // zillaid = databaseAccessZilla.GetzilaID(zillname);
        //   databaseAccessZilla.close();
//callspinner3(zillaid);
    }


    public void callspinner3(String zillaid) {

        final DatabaseAccessUpazila databaseAccessUpazila = DatabaseAccessUpazila.getInstance(this);
        databaseAccessUpazila.open();
        upazillanames = databaseAccessUpazila.getUpaZillaname(zillaid);
        databaseAccessUpazila.close();
        ArrayAdapter<String> adapterupazila = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, upazillanames);
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

    public void callspinner4(String upzillaid) {

        final DatabaseAccessUnion databaseAccessUnion = DatabaseAccessUnion.getInstance(this);
        databaseAccessUnion.open();
        unionnames = databaseAccessUnion.getunionname(upzillaid);
        databaseAccessUnion.close();
        ArrayAdapter<String> adapterupauni = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, unionnames);
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

    public void callspinner5(String unionid) {

        final DatabaseAccessMouza databaseAccessMouza = DatabaseAccessMouza.getInstance(this);
        databaseAccessMouza.open();
        mouzanames = databaseAccessMouza.getMouzaname(unionid);
        databaseAccessMouza.close();
        ArrayAdapter<String> adapterupamou = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mouzanames);
        mouzaspinner.setAdapter(adapterupamou);
        mouzaspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mouzaname = mouzaspinner.getSelectedItem().toString();
                databaseAccessMouza.open();
                mouzaid = databaseAccessMouza.GetmouzaID(mouzaname);
                databaseAccessMouza.close();
                callspinner6(mouzaid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
    }

    public void callspinner6(String unionid) {

        final DatabaseAccessVillage databaseAccessVillage = DatabaseAccessVillage.getInstance(this);
        databaseAccessVillage.open();
        vilnames = databaseAccessVillage.getvilname(unionid);
        databaseAccessVillage.close();
        ArrayAdapter<String> adaptervil = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vilnames);
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

    @Override
    public void onClick(View v) {

    }
}
