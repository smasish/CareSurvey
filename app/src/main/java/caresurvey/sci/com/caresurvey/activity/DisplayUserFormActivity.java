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

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.adapter.DisplayNamesWithStatusAdapter;
import caresurvey.sci.com.caresurvey.database.SickChildTable;
import caresurvey.sci.com.caresurvey.model.ANCFormItem;
import caresurvey.sci.com.caresurvey.model.SickChildItem;

public class DisplayUserFormActivity extends AppCompatActivity {

    String names;
    ListView listView;
    private String user;
    DisplayNamesWithStatusAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user);

        listView = (ListView) findViewById(R.id.user_list);
        Intent in = getIntent();
        names = in.getStringExtra("name");
        //     Log.d(".....>>>>>>>>>>", "response length" + names);

        ArrayList<SickChildItem> sickChildItems;
        ANCFormItem formItem;

        SickChildTable sickChildTable = new SickChildTable(DisplayUserFormActivity.this);
        sickChildItems = sickChildTable.getAllInfo();
        int k = 0;
        int f = sickChildItems.size();
        long[] id = new long[f];
        String[] name = new String[f];
        final int[] status = new int[f];
        final String[] inS = new String[f];
        if (!sickChildItems.isEmpty()) {
            for (SickChildItem ft : sickChildItems) {
                id[k] = ft.getId();
                name[k] = ft.getSp_client();
                status[k] = ft.getStatus();
                inS[k] = ft.getFields();
                k++;


            }
        }
        adapter = new DisplayNamesWithStatusAdapter(this, id, name, status, inS);

        listView.setAdapter(adapter);
        //     Helpes.getListViewSize(courseListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Status.......ONClick", "response length");
                Log.d("Status.......", "response length" + status[position]);
                if (status[position + 1] == 3) {

                    AlertMessage.showMessage(DisplayUserFormActivity.this, "You can not edit until supervisor review it",
                            "");

                } else {
                    Intent iiv = new Intent(DisplayUserFormActivity.this, SickChildUnderFiveActivity.class);
                    iiv.putExtra("position", position + 1);
                    iiv.putExtra("name", names);
                    startActivity(iiv);
                    finish();
                }
            }
        });
    }


    @Override
    protected void onResume() {

        ArrayList<SickChildItem> sickChildItems;
        ANCFormItem formItem;

        SickChildTable sickChildTable = new SickChildTable(DisplayUserFormActivity.this);
        sickChildItems = sickChildTable.getAllInfo();
        int k = 0;
        int f = sickChildItems.size();

        long[] id = new long[f];
        String[] name = new String[f];

        final int[] status = new int[f];

        final String[] inS = new String[f];

        if (!sickChildItems.isEmpty()) {
            for (SickChildItem ft : sickChildItems)

            {
                id[k] = ft.getId();
                name[k] = ft.getSp_client();
                status[k] = ft.getStatus();
                inS[k] = ft.getFields();
                k++;


            }
        }
        adapter = new DisplayNamesWithStatusAdapter(this, id, name, status, inS);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Status.......OnResume", "response length" + status[position]);
                if (status[position] == 3) {
                    AlertMessage.showMessage(DisplayUserFormActivity.this, "You can not edit until supervisor review it",
                            "");
                } else if (status[position] == 5) {
                    AlertMessage.showMessage(DisplayUserFormActivity.this, "Form is empty",
                            "At first insert data");
                } else {
                    Intent iiv = new Intent(DisplayUserFormActivity.this, TestActivity.class);
                    iiv.putExtra("id", position + 1);
                    iiv.putExtra("name", names);
                    iiv.putExtra("mark", 2);

                    startActivity(iiv);
                    finish();
                }


            }
        });


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

    @Override
    public void onBackPressed() {

        Intent intents = new Intent(DisplayUserFormActivity.this, SelectionUserActivity.class);
        startActivity(intents);
        finish();
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
