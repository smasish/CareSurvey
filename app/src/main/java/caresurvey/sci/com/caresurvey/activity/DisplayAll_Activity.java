package caresurvey.sci.com.caresurvey.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.adapter.DisplayNamesWithStatusAdapter;
import caresurvey.sci.com.caresurvey.database.FormTable;
import caresurvey.sci.com.caresurvey.database.FormTableUser;
import caresurvey.sci.com.caresurvey.model.FormItem;
import caresurvey.sci.com.caresurvey.model.FormItemUser;

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
        ArrayList<FormItem> formItems;
        FormItem formItem;

        final FormTable formTable = new FormTable(DisplayAll_Activity.this);
        formItems= formTable.getAll();

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
                    Intent iiv = new Intent(DisplayAll_Activity.this,Supervisor_verificationActivity.class);
                    iiv.putExtra("position",position);
                    // iiv.putExtra("name",names);
                    startActivity(iiv);
                }

            }
        });


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
        ArrayList<FormItem> formItems;

        FormItem formItem;

        final FormTable formTable = new FormTable(DisplayAll_Activity.this);
        formItems= formTable.getAll();


        int k=0;
        int f= formItems.size();
        final String[] inS= new String[f];
        int[] id_admin=new int[f];
        String[] name_admin=new String[f];
        final int[] status_admin= new int[f];


        for(FormItem ft: formItems)

        {

            id_admin[k]= Integer.parseInt(ft.getGlobal_id());
            name_admin[k]=ft.getName();
            status_admin[k]=ft.getStatus();
            inS[k]= ft.getInS();

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
                    AlertMessage.showMessage(DisplayAll_Activity.this, "You can not update until collector resubmit it.",
                            "Please wait until user submit");
                }
                else {
                    Intent iiv = new Intent(DisplayAll_Activity.this,Supervisor_verificationActivity.class);
                    iiv.putExtra("position",position);
                    // iiv.putExtra("name",names);

                    startActivity(iiv);
                }

            }


        });











    }
}