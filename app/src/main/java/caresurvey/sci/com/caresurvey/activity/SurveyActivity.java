package caresurvey.sci.com.caresurvey.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import java.util.ArrayList;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.adapter.DisplayNamesWithStatusAdapter;
import caresurvey.sci.com.caresurvey.database.FormTable;
import caresurvey.sci.com.caresurvey.database.SickChildSupervisorTable;
import caresurvey.sci.com.caresurvey.model.FormItem;
import caresurvey.sci.com.caresurvey.model.SickChildItemSupervisor;

public class SurveyActivity extends AppCompatActivity {
    Button Survey;
    ListView listView;
    private String user;
    DisplayNamesWithStatusAdapter listadapter;
    Spinner facilityspinner,collector_name;
    String facilityname,username;
    int valuecount;
    ArrayList<FormItem> formItems;
    ProgressBar progressBar,progressBar1,progressBar2,progressBar3,progressBar4;
    private Context con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        con = this;

//        progressBar=(ProgressBar)findViewById(R.id.progressBar);
//        progressBar.setMax(5);
//        progressBar.setProgress(2);

//        progressBar1=(ProgressBar)findViewById(R.id.progressBar2);
//        progressBar1.setMax(5);
//        progressBar1.setProgress(2);

//        progressBar2=(ProgressBar)findViewById(R.id.progressBar3);
//        progressBar2.setMax(5);
//        progressBar2.setProgress(2);
//
//        progressBar3=(ProgressBar)findViewById(R.id.progressBar1);
//        progressBar3.setMax(5);
//        progressBar3.setProgress(2);
//        progressBar2.setScaleY(9f);
//        progressBar.setScaleY(9f);
//        progressBar1.setScaleY(9f);
//        progressBar3.setScaleY(9f);
//        progressBar2.getProgressDrawable().setColorFilter(
//                Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
//
//        progressBar.getProgressDrawable().setColorFilter(
//                Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);



//        progressBar1.getProgressDrawable().setColorFilter(
        //              Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
//
//        progressBar3.getProgressDrawable().setColorFilter(
//                Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);

        listView=(ListView)findViewById(R.id.antenatalList);

        Survey = (Button)findViewById(R.id.survey_button);
        Survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(SurveyActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });

        //progressBar3.getLayoutParams().height = 20;
        //  progressBar3.invalidate();

        username = "user_hb1";



        ArrayList<String> survey_result = new ArrayList<String>();
        survey_result.add("District Hospital");
        survey_result.add("Upazila Health Complex");
        survey_result.add("Union Health & Family Welfare Center");
        survey_result.add("Satellite Clinic");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.dropdown_text_survey, survey_result);
        facilityspinner = (Spinner)findViewById(R.id.spinner);
        facilityspinner.setAdapter(adapter);


        facilityspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                facilityname = facilityspinner.getSelectedItem().toString();
                FormTable formTable = new FormTable(SurveyActivity.this);
        //        ArrayList<FormItem> formItemArrayList;
          //      formItemArrayList=formTable.getAll();

                formItems = formTable.getListfromuser(username, facilityname);
                valuecount=formItems.size();
                //   facilityspinner.setAdapter(null);

//                adapter.notifyDataSetChanged();
//                adapter.notifyDataSetChanged();
//
//                adapter.notifyDataSetChanged();

                Log.d("...>>>>>>", "valuecount " + valuecount);
                if(valuecount ==0)
                    listView.setAdapter(null);

                if(!formItems.isEmpty())
                {
                    int k=0;
                    int f= formItems.size();

                    int[] id_admin=new int[f];
                    String[] name_admin=new String[f];
                    final int[] status_admin= new int[f];
                    final String[] inS= new String[f];

                    for(FormItem ft: formItems)
                    {
                        id_admin[k]= Integer.parseInt(ft.getGlobal_id());
                        name_admin[k]=ft.getName();
                        status_admin[k]=ft.getStatus();
                        inS[k]= ft.getInS();

                        Log.d(".....>>>>>>>>>>", "status" +ft.getStatus());

                        k++;
                    }
                    listadapter=new DisplayNamesWithStatusAdapter(SurveyActivity.this,id_admin,name_admin,status_admin,inS);

                    listView.setAdapter(listadapter);

                    //     Helpes.getListViewSize(courseListView);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Log.d("Status.......OnResume", "response length" + status_admin[position]);
                            Log.d("Status.......OnResume", "response length");
                            if(status_admin[position]==2)
                            {
                                AlertMessage.showMessage(SurveyActivity.this, getString(R.string.title),
                                        getString(R.string.msg));

                            }
                            else {
                                Intent iiv = new Intent(SurveyActivity.this,Supervisor_verificationActivity.class);
                                iiv.putExtra("position",position);
                                // iiv.putExtra("name",names);
                                startActivity(iiv);
                                finish();
                            }

                        }
                    });

                }

//                else {
//                    new AlertDialog.Builder(SurveyActivity.this)
//                            .setTitle("Alert")
//                            .setMessage("No data found for review!")
//                            .setPositiveButton("Close", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    finish();
//                                }
//
//                            })
//
//                            .show();
//
//                }









            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });





        ArrayList<String> Collector_name = new ArrayList<String>();
        Collector_name.add("user_hb1");
        Collector_name.add("user_hb2");
        Collector_name.add("user_hb3");
        Collector_name.add("user_hb4");
        ArrayAdapter<String> name_adapter = new ArrayAdapter<String>(this, R.layout.dropdown_text_survey, Collector_name);
        collector_name = (Spinner)findViewById(R.id.spinner1);
        collector_name.setAdapter(name_adapter);


        collector_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                username = collector_name.getSelectedItem().toString();


//                formItems = formTable.getListfromuser(username, facilityname);
//                valuecount=formItems.size();
                //facilityspinner.setAdapter(null);





            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });






    }



    @Override
    public void onBackPressed() {

        SickChildSupervisorTable sickChildSupervisorTable = new SickChildSupervisorTable(SurveyActivity.this);
        ArrayList<SickChildItemSupervisor> sickChildItemSupervisors;
        ArrayList<SickChildItemSupervisor> sickChildItemSupervisors1;
        sickChildItemSupervisors = sickChildSupervisorTable.getAllInfo();
        sickChildItemSupervisors1 = sickChildSupervisorTable.getAllInfo();



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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_survey, menu);
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
