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
import caresurvey.sci.com.caresurvey.database.DatabaseAccessZilla;

/**
 * Created by israt.jahan on 4/10/2016.
 */
public class PrepopSqliteDbActivity  extends AppCompatActivity implements View.OnClickListener {


    //A good practice is to define database field names as constants
Context context;
    private ListView listView;
    private ArrayList<String> ciList ;
    private Spinner divspinner,zillaspinner,upzillaspinner;
    String divname,zillname;
    String divid,zillaid=String.valueOf(10);
    List<String> divnames,zillanames;
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

        ArrayAdapter<String> adapterzilla = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, zillanames);
        zillaspinner.setAdapter(adapterzilla);
        zillaspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                zillname = zillaspinner.getSelectedItem().toString();

                zillaid = databaseAccessZilla.GetzilaID(zillname);
                databaseAccess.close();

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
