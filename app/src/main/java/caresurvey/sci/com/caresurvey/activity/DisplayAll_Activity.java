package caresurvey.sci.com.caresurvey.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.adapter.DisplayNamesWithStatusAdapter;
import caresurvey.sci.com.caresurvey.database.SickChildSupervisorTable;
import caresurvey.sci.com.caresurvey.model.ANCFormItem;
import caresurvey.sci.com.caresurvey.model.SickChildItemSupervisor;

public class DisplayAll_Activity extends AppCompatActivity {

    ListView listView;
    private String user;
    DisplayNamesWithStatusAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_);
        listView=(ListView)findViewById(R.id.user_list);
        user= "supervisor";
        Intent mIntent = getIntent();
        user = mIntent.getStringExtra("user");
        ArrayList<SickChildItemSupervisor> formItems;
        ANCFormItem formItem;

        final SickChildSupervisorTable formTable = new SickChildSupervisorTable(DisplayAll_Activity.this);
        formItems= formTable.getAllInfo();

        if(!formItems.isEmpty())
        {
            int k=0;
            int f= formItems.size();

            long[] id_admin=new long[f];
            String[] name_admin=new String[f];
            final int[] status_admin= new int[f];
            final String[] inS= new String[f];

            for(SickChildItemSupervisor ft: formItems)

            {
                id_admin[k]= ft.getServer_id();
                name_admin[k]=ft.getSp_client();
                status_admin[k]=Integer.parseInt(ft.getStatus());        ;
                inS[k]= String.valueOf(1);
                k++;
            }
            adapter=new DisplayNamesWithStatusAdapter(this,id_admin,name_admin,status_admin,inS);

            listView.setAdapter(adapter);

            //     Helpes.getListViewSize(courseListView);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d("Status.......OnResume", "response length" + status_admin[position]);
                    Log.d("Status.......OnResume", "response length");
                    if(status_admin[position]==2)
                    {
                        AlertMessage.showMessage(DisplayAll_Activity.this, getString(R.string.title),
                                getString(R.string.msg));
                    }
                    else {
                        Intent iiv = new Intent(DisplayAll_Activity.this,SupervisiorVerificationSickChild.class);
                        iiv.putExtra("position",position);
                        // iiv.putExtra("name",names);
                        startActivity(iiv);
                        finish();
                    }

                }
            });

        }

        else {
            new AlertDialog.Builder(this)
                    .setTitle("Alert")
                    .setMessage("No data found for review!")
                    .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    })

                    .show();

        }


    }
    private void saveForm(JSONArray formitem) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_all_, menu);
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
    protected void onResume() {

        super.onResume();
        ArrayList<SickChildItemSupervisor> formItems;
        ANCFormItem formItem;

        final SickChildSupervisorTable formTable = new SickChildSupervisorTable(DisplayAll_Activity.this);
        formItems= formTable.getAllInfo();

        if(!formItems.isEmpty()) {
            int k = 0;
            int f = formItems.size();

            long[] id_admin = new long[f];
            String[] name_admin = new String[f];
            final int[] status_admin = new int[f];
            final String[] inS = new String[f];

            for (SickChildItemSupervisor ft : formItems)

            {
                id_admin[k] = ft.getServer_id();
                name_admin[k] = ft.getSp_client();
                status_admin[k] = Integer.parseInt(ft.getStatus());
                ;
                inS[k] = String.valueOf(1);
                k++;
            }
            adapter = new DisplayNamesWithStatusAdapter(this, id_admin, name_admin, status_admin, inS);

            listView.setAdapter(adapter);

            //     Helpes.getListViewSize(courseListView);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Log.d("Status.......OnResume", "response length" + status_admin[position]);
                    Log.d("Status.......OnResume", "response length");
                    if (status_admin[position] == 2) {
                        AlertMessage.showMessage(DisplayAll_Activity.this, "You can not update until collector resubmit it.",
                                "Please wait until user submit");
                    } else {
                        Intent iiv = new Intent(DisplayAll_Activity.this, SupervisiorVerificationSickChild.class);
                        iiv.putExtra("position", position);
                        // iiv.putExtra("name",names);

                        startActivity(iiv);
                        finish();
                    }

                }


            });


        }


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