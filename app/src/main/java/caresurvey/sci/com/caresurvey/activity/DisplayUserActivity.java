package caresurvey.sci.com.caresurvey.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.adapter.DisplayNamesWithStatusAdapter2;
import caresurvey.sci.com.caresurvey.database.ANCTable;
import caresurvey.sci.com.caresurvey.database.FpObservationTable;
import caresurvey.sci.com.caresurvey.database.InventoryTable;
import caresurvey.sci.com.caresurvey.database.SatelliteClinicTable;
import caresurvey.sci.com.caresurvey.database.SickChildTable;
import caresurvey.sci.com.caresurvey.model.DBRow;
import caresurvey.sci.com.caresurvey.model.ANCFormItem;
import caresurvey.sci.com.caresurvey.model.FpObservationFormItem;
import caresurvey.sci.com.caresurvey.model.InventoryItem;
import caresurvey.sci.com.caresurvey.model.SatelliteClinicItem;
import caresurvey.sci.com.caresurvey.model.SickChildItem;

public class DisplayUserActivity extends AppCompatActivity {

    public static final String FORM = "from_name";
    String names;
    ListView listView;
    public static final String FORM_ID = "form_id";
    private String user;
    DisplayNamesWithStatusAdapter2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user);

        listView = (ListView) findViewById(R.id.user_list);
        Intent in = getIntent();
        names = in.getStringExtra("name");
        //     Log.d(".....>>>>>>>>>>", "response length" + names);


//        int k = 0;
//        int f = formItemsUser.size();
//        int[] id = new int[f];
//        String[] name = new String[f];
//        final int[] status = new int[f];
//        final String[] inS = new String[f];
//        if (!formItemsUser.isEmpty()) {
//            for (FormItemUser ft : formItemsUser)
//
//            {
//                id[k] = ft.getPatientid();
//                name[k] = ft.getName();
//                status[k] = ft.getStatus();
//                inS[k] = ft.getInS();
//                k++;
//
//
//            }
//        }
        adapter = new DisplayNamesWithStatusAdapter2(this,R.layout.display_an_item);

        listView.setAdapter(adapter);
        //     Helpes.getListViewSize(courseListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Status.......ONClick", "response length");
                Log.d("Status.......", "response length" + adapter.getItem(position).status);
                if(adapter.getItem(position).status == 2) {
                    if ((getIntent().getIntExtra(FORM, -1)) == 0) {
                        Intent iiv = new Intent(DisplayUserActivity.this, TestActivity.class);
                        iiv.putExtra("position", position + 1);
                        iiv.putExtra("name", names);
                        iiv.putExtra(FORM_ID,adapter.getItem(position).id);
                        startActivity(iiv);
                    } else if ((getIntent().getIntExtra(FORM, -1)) == 1) {
                        Intent iiv = new Intent(DisplayUserActivity.this, SateliteClinicInventoryActivity.class);
                        iiv.putExtra("position", position + 1);
                        iiv.putExtra("name", names);
                        iiv.putExtra(FORM_ID,adapter.getItem(position).id);
                        startActivity(iiv);
                    } else if ((getIntent().getIntExtra(FORM, -1)) == 2) {
                        Intent iiv = new Intent(DisplayUserActivity.this, SickChildUnderFiveActivity.class);
                        iiv.putExtra("position", position + 1);
                        iiv.putExtra("name", names);
                        iiv.putExtra(FORM_ID,adapter.getItem(position).id);
                        startActivity(iiv);
                    } else if ((getIntent().getIntExtra(FORM, -1)) == 3) {
                        Intent iiv = new Intent(DisplayUserActivity.this, FacilityInventoryActivity.class);
                        iiv.putExtra("position", position + 1);
                        iiv.putExtra("name", names);
                        iiv.putExtra(FORM_ID,adapter.getItem(position).id);
                        startActivity(iiv);
                    } else if ((getIntent().getIntExtra(FORM, -1)) == 4) {
                        Intent iiv = new Intent(DisplayUserActivity.this, FpObservationActivity.class);
                        iiv.putExtra("position", position + 1);
                        iiv.putExtra("name", names);
                        iiv.putExtra(FORM_ID,adapter.getItem(position).id);
                        startActivity(iiv);
                    }
                }
                else{
                    AlertMessage.showMessage(DisplayUserActivity.this, "You can not edit until supervisor review it",
                            "");
                }
            }
        });
    }




    @Override
    protected void onResume() {

//        ArrayList<ANCFormItem> formItemsUser;
//        final ANCTable formTable = new ANCTable(DisplayUserActivity.this);
//        formItemsUser = formTable.getAll();
//
//
//        int k = 0;
//        int f = formItemsUser.size();
//
//        long[] id = new long[f];
//        String[] name = new String[f];
//
//        final int[] status = new int[f];
//
//        final String[] inS = new String[f];
//
//        if (!formItemsUser.isEmpty()) {
//            for (ANCFormItem ft : formItemsUser)
//
//            {
//                id[k] = ft.getPatientid();
//                name[k] = ft.getName();
//                status[k] = ft.getStatus();
//                inS[k] = ft.getInS();
//                k++;
//
//
//            }
//        }

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("Status.......OnResume", "response length" + status[position]);
//                if (status[position] == 3) {
//                    AlertMessage.showMessage(DisplayUserActivity.this, "You can not edit until supervisor review it",
//                            "");
//                } else if (status[position] == 5) {
//                    AlertMessage.showMessage(DisplayUserActivity.this, "Form is empty",
//                            "At first insert data");
//                } else {
//                    Intent iiv = new Intent(DisplayUserActivity.this, TestActivity.class);
//                    iiv.putExtra("id", position + 1);
//                    iiv.putExtra("name", names);
//                    iiv.putExtra("mark", 2);
//
//                    startActivity(iiv);
//                    finish();
//                }
//
//
//            }
//        });

        List<DBRow> dbrows = new ArrayList<>();

        if(getIntent().getIntExtra(FORM,-1) == 0){
            final ANCTable formTable = new ANCTable(DisplayUserActivity.this);
            ArrayList<ANCFormItem> formItemsUser = formTable.getAll();
            for(ANCFormItem ft : formItemsUser){
                dbrows.add(ft);
            }
        }
        else if(getIntent().getIntExtra(FORM,-1) == 1){
            final SatelliteClinicTable table = new SatelliteClinicTable(this);
            ArrayList<SatelliteClinicItem> list = table.getAll();
            for(SatelliteClinicItem item : list){
                dbrows.add(item);
            }
        }
        else if(getIntent().getIntExtra(FORM,-1) == 2){
            final SickChildTable table = new SickChildTable(this);
            ArrayList<SickChildItem> list = table.getAllInfo();
            for(SickChildItem item : list){
                dbrows.add(item);
            }
        }
        else if(getIntent().getIntExtra(FORM,-1) == 3){
            final InventoryTable table = new InventoryTable(this);
            ArrayList<InventoryItem> list = table.getAllInfo();
            for(InventoryItem item : list){
                dbrows.add(item);
            }
        }
        else if(getIntent().getIntExtra(FORM,-1) == 4){
            final FpObservationTable table = new FpObservationTable(this);
            ArrayList<FpObservationFormItem> list = table.getAll();
            for(FpObservationFormItem item : list){
                dbrows.add(item);
            }
        }
        adapter.clear();
        adapter.addAll(dbrows);
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_user, menu);
        return true;
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

//    @Override
//    public void onBackPressed() {
//
//        Intent intents = new Intent(DisplayUserActivity.this, SelectionUserActivity.class);
//        startActivity(intents);
//        finish();
//    }

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
