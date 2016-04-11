package caresurvey.sci.com.caresurvey.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.DatabaseAccess;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessMouza;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessUnion;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessUpazila;
import caresurvey.sci.com.caresurvey.database.DatabaseAccessZilla;

/**
 * Created by israt.jahan on 4/10/2016.
 */
public class PrepopSqliteDbActivity  extends AppCompatActivity implements View.OnClickListener {


    //A good practice is to define database field names as constants
Context context;
    private ListView listView;
    private ArrayList<String> ciList ;
    private Spinner divspinner,zillaspinner,upzillaspinner,unionspinner,mouzaspinner;
    String divname,zillname,upazilname,unionname,mouzaname;
    String divid,zillaid,upzillaid,unionid=String.valueOf(10);
    String mouzaid=String.valueOf(10);
    List<String> divnames,zillanames,upazillanames,unionnames,mouzanames;
    public DatabaseAccess databaseAccess;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        databaseAccess = DatabaseAccess.getInstance(this);

        super.onCreate(savedInstanceState);
            setContentView(R.layout.main);


            upzillaspinner=(Spinner)findViewById(R.id.upzillaspinner);
          //  listView = (ListView) findViewById(R.id.listView);


callspinner1();



        }

public void callspinner1()
{
    divspinner=(Spinner)findViewById(R.id.divisionspinner);
    databaseAccess.open();
    divnames = databaseAccess.getDivisions();
    databaseAccess.close();
    ArrayAdapter<String> adapterr = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, divnames);
    divspinner.setAdapter(adapterr);
    divspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            divname = divspinner.getSelectedItem().toString();
            databaseAccess.open();
            divid = databaseAccess.GetDeptID(divname);
            databaseAccess.close();
            callspinner2(divid);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }


    });

}
   public void callspinner2(String divid)
    {
        zillaspinner=(Spinner)findViewById(R.id.zillaspinner);
        final DatabaseAccessZilla databaseAccessZilla=DatabaseAccessZilla.getInstance(this);
        databaseAccessZilla.open();
        zillanames = databaseAccessZilla.getZillaname(divid);
        databaseAccessZilla.close();
        ArrayAdapter<String> adapterzilla = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, zillanames);
        zillaspinner.setAdapter(adapterzilla);
        zillaspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                zillname = zillaspinner.getSelectedItem().toString();
                databaseAccessZilla.open();
                zillaid = databaseAccessZilla.GetzilaID(zillname);
                databaseAccessZilla.close();
callspinner3(zillaid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
    }
    public void callspinner3(String zillaid)
    {
        upzillaspinner=(Spinner)findViewById(R.id.upzillaspinner);
        final DatabaseAccessUpazila databaseAccessUpazila =DatabaseAccessUpazila.getInstance(this);
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
    public void callspinner4(String upzillaid)
    {
        unionspinner=(Spinner)findViewById(R.id.unionspinner);
        final DatabaseAccessUnion databaseAccessUnion =DatabaseAccessUnion.getInstance(this);
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
callspinner5(unionid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
    }
    public void callspinner5(String unionid)
    {
        mouzaspinner=(Spinner)findViewById(R.id.mouzaspinner);
        final DatabaseAccessMouza databaseAccessMouza =DatabaseAccessMouza.getInstance(this);
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
