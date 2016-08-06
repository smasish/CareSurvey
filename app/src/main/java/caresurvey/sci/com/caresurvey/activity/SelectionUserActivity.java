package caresurvey.sci.com.caresurvey.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.ANCTable;
import caresurvey.sci.com.caresurvey.database.FpObservationTable;
import caresurvey.sci.com.caresurvey.database.InventoryTable;
import caresurvey.sci.com.caresurvey.database.SatelliteClinicTable;
import caresurvey.sci.com.caresurvey.database.SickChildTable;
import caresurvey.sci.com.caresurvey.utils.AppUtils;

public class SelectionUserActivity extends AppCompatActivity {


    Button home,insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_user);


        home=(Button)findViewById(R.id.home);
        insert=(Button)findViewById(R.id.addForm);
        ((TextView)findViewById(R.id.username)).setText("Welcome " + AppUtils.getFullName(this));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                FormTableUser formTableUser = new FormTableUser(SelectionUserActivity.this);
//
//                long rowSize =formTableUser.getRowSize();
//                if( rowSize > 0) {
//                    Intent intent = new Intent(SelectionUserActivity.this, DisplayUserActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//
//                else
//                    AlertMessage.showMessage(SelectionUserActivity.this, "Alert",
//                            "No data is Inserted yet");
                choose();
            }
        });



        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor1 = pref.edit();
                int first_value = pref.getInt("id", 0);

                if(first_value<31) {
                    Intent intent1 = getIntent();
                    intent1.setClass(SelectionUserActivity.this,AddressInsertActivity2.class);
                    startActivity(intent1);
//                    finish();
                }
                else {
                    AlertMessage.showMessage(SelectionUserActivity.this, "You can not insert new form",
                            "You have already inserted 30 form for this session");
                }

            }
        });
    }

    private void choose(){
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(this);
        builderSingle.setTitle("Select One");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("Inventory of Facility"); //0
        arrayAdapter.add("Inventory of Satellite Clinic"); //1
        arrayAdapter.add("Observation of ANC"); //2
        arrayAdapter.add("Observation of Sick Child"); //3
        arrayAdapter.add("Observation of Family Planning"); // 4


        builderSingle.setNegativeButton(
                "cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        builderSingle.setAdapter(
                arrayAdapter,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if(which == 2){
                            ANCTable formTableUser = new ANCTable(SelectionUserActivity.this);

                            long rowSize =formTableUser.getRowSize();
                            if( rowSize > 0) {
                                Intent intent = new Intent(SelectionUserActivity.this, DisplayUserActivity.class);
                                intent.putExtra(DisplayUserActivity.FORM, which);
                                intent.putExtra(DisplayUserActivity.TITLE,arrayAdapter.getItem(which));
                                startActivity(intent);
                            }
                            else {
                                AlertMessage.showMessage(SelectionUserActivity.this, "Alert",
                                        "No data is Inserted yet");
                            }

                        }
                        else if(which == 1){
                            SatelliteClinicTable table = new SatelliteClinicTable(SelectionUserActivity.this);
                            long rowSize = table.getRowSize();
                            if(rowSize > 0) {
                                Intent intent = new Intent(SelectionUserActivity.this, DisplayUserActivity.class);
                                intent.putExtra(DisplayUserActivity.FORM, which);
                                intent.putExtra(DisplayUserActivity.TITLE,arrayAdapter.getItem(which));
                                startActivity(intent);
                            }
                            else{
                                AlertMessage.showMessage(SelectionUserActivity.this, "Alert",
                                        "No data is Inserted yet");
                            }
                        }
                        else if(which == 3){

                            SickChildTable table = new SickChildTable(SelectionUserActivity.this);
                            long rowSize = table.getRowSize();
                            if(rowSize > 0) {
                                Intent intent = new Intent(SelectionUserActivity.this, DisplayUserActivity.class);
                                intent.putExtra(DisplayUserActivity.FORM, which);
                                intent.putExtra(DisplayUserActivity.TITLE,arrayAdapter.getItem(which));
                                startActivity(intent);
                            }
                            else{
                                AlertMessage.showMessage(SelectionUserActivity.this, "Alert",
                                        "No data is Inserted yet");
                            }
                        }
                        else if(which == 0){
                            InventoryTable table = new InventoryTable(SelectionUserActivity.this);
                            long rowSize = table.getRowSize();
                            if(rowSize > 0) {
                                Intent intent = new Intent(SelectionUserActivity.this, DisplayUserActivity.class);
                                intent.putExtra(DisplayUserActivity.FORM, which);
                                intent.putExtra(DisplayUserActivity.TITLE,arrayAdapter.getItem(which));
                                startActivity(intent);
                            }
                            else{
                                AlertMessage.showMessage(SelectionUserActivity.this, "Alert",
                                        "No data is Inserted yet");
                            }
                        }
                        else if(which == 4){
                            FpObservationTable table = new FpObservationTable(SelectionUserActivity.this);
                            long rowSize = table.getRowSize();
                            if(rowSize > 0) {
                                Intent intent = new Intent(SelectionUserActivity.this, DisplayUserActivity.class);
                                intent.putExtra(DisplayUserActivity.FORM, which);
                                intent.putExtra(DisplayUserActivity.TITLE,arrayAdapter.getItem(which));
                                startActivity(intent);
                            }
                            else{
                                AlertMessage.showMessage(SelectionUserActivity.this, "Alert",
                                        "No data is Inserted yet");
                            }
                        }
                    }
                });
        builderSingle.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selection_user, menu);
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
    @Override
    public void onBackPressed() {
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
