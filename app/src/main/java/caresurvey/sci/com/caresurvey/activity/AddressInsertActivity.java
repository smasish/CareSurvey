package caresurvey.sci.com.caresurvey.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import caresurvey.sci.com.caresurvey.R;

public class AddressInsertActivity extends AppCompatActivity {
    Spinner sp1,sp2,sp3,sp4,sp5;
    String name;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_insert);

        sp1=(Spinner)findViewById(R.id.spinner2);
        sp2=(Spinner)findViewById(R.id.spinner3);
        sp3=(Spinner)findViewById(R.id.spinner4);
        sp4=(Spinner)findViewById(R.id.spinner5);
        sp5=(Spinner)findViewById(R.id.spinner6);

        Intent intent= getIntent();
        name= intent.getStringExtra("name");
        id= intent.getIntExtra("id",1);
        EditText user= (EditText)findViewById(R.id.user);
        user.setText(name);
        ArrayList<String> sub_district = new ArrayList<String>();
        sub_district.add("District Hospital");
        sub_district.add("Upozila Health Complex");
        sub_district.add("Union health and family welfare center");
        sub_district.add("Satellite Clinic");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, sub_district);
        sp1.setAdapter(adapter);
        ArrayList<String> sub_district1 = new ArrayList<String>();
        sub_district1.add("District Hospital");
        sub_district1.add("Upozila Health Complex");
        sub_district1.add("Union health and family welfare center");
        sub_district1.add("Satellite Clinic");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, sub_district1);
        sp2.setAdapter(adapter1);


        ArrayList<String> sub_district2 = new ArrayList<String>();
        sub_district2.add("District Hospital");
        sub_district2.add("Upozila Health Complex");
        sub_district2.add("Union health and family welfare center");
        sub_district2.add("Satellite Clinic");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, sub_district2);
        sp3.setAdapter(adapter2);


        ArrayList<String> sub_district3 = new ArrayList<String>();
        sub_district3.add("District Hospital");
        sub_district3.add("Upozila Health Complex");
        sub_district3.add("Union health and family welfare center");
        sub_district3.add("Satellite Clinic");
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, sub_district3);
        sp4.setAdapter(adapter3);



        ArrayList<String> sub_district4 = new ArrayList<String>();
        sub_district4.add("District Hospital");
        sub_district4.add("Upozila Health Complex");
        sub_district4.add("Union health and family welfare center");
        sub_district4.add("Satellite Clinic");
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, R.layout.drop_down_list_addrees, sub_district4);
        sp5.setAdapter(adapter4);


        Button button =(Button)findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(".....>>>>>>>>>>", "response length" + name);
                Intent intent = new Intent(AddressInsertActivity.this,TestActivity.class);
                intent.putExtra("name",name);
                Log.d(".....>>>>>>>>>>", "Id in address Insert Activity  " + id);
                intent.putExtra("id",id);
                intent.putExtra("mark",1);
                startActivity(intent);
            }
        });






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_address_insert, menu);
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
