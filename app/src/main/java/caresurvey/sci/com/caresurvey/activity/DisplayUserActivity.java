package caresurvey.sci.com.caresurvey.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.adapter.DisplayNamesWithStatusAdapter;
import caresurvey.sci.com.caresurvey.database.FormTableUser;
import caresurvey.sci.com.caresurvey.model.FormItem;
import caresurvey.sci.com.caresurvey.model.FormItemUser;

public class DisplayUserActivity extends AppCompatActivity {

    String names;
    ListView listView;
    private String user;
    DisplayNamesWithStatusAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user);

        listView=(ListView)findViewById(R.id.user_list);


        Intent in= getIntent();
        names  = in.getStringExtra("name");



        Log.d(".....>>>>>>>>>>", "response length" + names);




        ArrayList<FormItemUser> formItemsUser;


        FormItem formItem;

        final FormTableUser formTable = new FormTableUser(DisplayUserActivity.this);
        formItemsUser= formTable.getAll();


        int k=0;
        int f= formItemsUser.size();

        int[] id=new int[f];
        String[] name=new String[f];

        final int[] status= new int[f];

        final String[] inS= new String[f];

        if(!formItemsUser.isEmpty()) {
            for (FormItemUser ft : formItemsUser)

            {
                id[k] = ft.getPatientid();
                name[k] = ft.getName();
                status[k] = ft.getStatus();
                inS[k]= ft.getInS();
                k++;


            }
        }
        adapter=new DisplayNamesWithStatusAdapter(this,id,name,status,inS);

        listView.setAdapter(adapter);
        //     Helpes.getListViewSize(courseListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent iiv = new Intent(DisplayUserActivity.this,TestActivity.class);


                iiv.putExtra("position",position);
                iiv.putExtra("name",names);

                startActivity(iiv);

            }
        });




    }


    @Override
    protected void onResume() {

        ArrayList<FormItemUser> formItemsUser;
        final FormTableUser formTable = new FormTableUser(DisplayUserActivity.this);
        formItemsUser= formTable.getAll();


        int k=0;
        int f= formItemsUser.size();

        int[] id=new int[f];
        String[] name=new String[f];

        final int[] status= new int[f];

        final String[] inS= new String[f];

        if(!formItemsUser.isEmpty()) {
            for (FormItemUser ft : formItemsUser)

            {
                id[k] = ft.getPatientid();
                name[k] = ft.getName();
                status[k] = ft.getStatus();
                inS[k]= ft.getInS();
                k++;


            }
        }
        adapter=new DisplayNamesWithStatusAdapter(this,id,name,status,inS);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent iiv = new Intent(DisplayUserActivity.this, TestActivity.class);
                iiv.putExtra("position", position);
                iiv.putExtra("name",names);
                startActivity(iiv);

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
