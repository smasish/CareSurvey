package caresurvey.sci.com.caresurvey.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.FormTable;
import caresurvey.sci.com.caresurvey.database.FormTableUser;
import caresurvey.sci.com.caresurvey.model.FormItem;
import caresurvey.sci.com.caresurvey.model.FormItemUser;

public class UserActivity extends AppCompatActivity {
    Boolean  firstRun;
    int first_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Button btn = (Button)findViewById(R.id.btn);
        final EditText user = (EditText)findViewById(R.id.user);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username= user.getText().toString();





                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor1 = pref.edit();

                int first_value = pref.getInt("id", 0);

                first_value++;
                editor1.putInt("id",first_value);
                editor1.commit();

                FormTableUser formTable = new FormTableUser(UserActivity.this);


                SharedPreferences settings = getSharedPreferences("prefs", 0);
                firstRun = settings.getBoolean("firstRun", false);








                if (firstRun == false)//if running for first time
                {
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("firstRun", true);
                    editor.commit();

                    for(int i=1;i<=30;i++) {

                        FormItemUser formItem = new FormItemUser(i, "No", "No", "No", "No", "No", "No"
                                , "No", "No", "No", "No", "No", "No", 5, "", "", "", "", "3");

                        formTable.insertItem(formItem);


                    }


                }



                Intent intent = new Intent(UserActivity.this,AddressInsertActivity.class);
                intent.putExtra("name",username);
                intent.putExtra("id",first_value);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user, menu);
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
