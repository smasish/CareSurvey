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
import caresurvey.sci.com.caresurvey.model.FormItem;

public class DisplayAll_Activity extends AppCompatActivity {
    Button btn;
    ListView listView;
    private String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_);
        listView=(ListView)findViewById(R.id.user_list);
        btn=(Button)findViewById(R.id.addForm);
        user= "supervisor";

        Intent mIntent = getIntent();
        user = mIntent.getStringExtra("user");


        //   user= "collecter";


        if(user.equals("admin"))
        {









            ArrayList<FormItem> formItems;

            FormItem formItem;

            final FormTable formTable = new FormTable(DisplayAll_Activity.this);
            formItems= formTable.getAll();


            int k=0;
            int f= formItems.size();

            int[] id=new int[f];
            String[] name=new String[f];
            final int[] status= new int[f];


            for(FormItem ft: formItems)

            {

                id[k]= Integer.parseInt(ft.getGlobal_id());
                name[k]=ft.getName();
                status[k]=ft.getStatus();

                k++;



            }
            DisplayNamesWithStatusAdapter adapter=new DisplayNamesWithStatusAdapter(this,id,name,status);

            listView.setAdapter(adapter);

            //     Helpes.getListViewSize(courseListView);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent iiv = new Intent(DisplayAll_Activity.this,Supervisor_verificationActivity.class);
                    iiv.putExtra("position",position);
                    startActivity(iiv);

                }
            });


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(DisplayAll_Activity.this, FormActivity.class);
                    startActivity(in);
                }
            });



        }



        else if(user.equals("user"))
        {






            ArrayList<FormItem> formItems;
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent in = new Intent(DisplayAll_Activity.this, FormActivity.class);
                    startActivity(in);


                }
            });

            FormItem formItem;

            final FormTable formTable = new FormTable(DisplayAll_Activity.this);
            formItems= formTable.getAll();


            int k=0;
            int f= formItems.size();

            int[] id=new int[f];
            String[] name=new String[f];

            final int[] status= new int[f];

            if(!formItems.isEmpty()) {
                for (FormItem ft : formItems)

                {
                    id[k] = ft.getPatientid();
                    name[k] = ft.getName();
                    status[k] = ft.getStatus();
                    k++;


                }
            }
            DisplayNamesWithStatusAdapter adapter=new DisplayNamesWithStatusAdapter(this,id,name,status);

            listView.setAdapter(adapter);

            //     Helpes.getListViewSize(courseListView);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent iiv = new Intent(DisplayAll_Activity.this,TestActivity.class);
                    iiv.putExtra("position",position);
                    startActivity(iiv);

                }
            });




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
        listView.invalidate();
        Log.d("......",">>>>>>>"+listView);



    }
}