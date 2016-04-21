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
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.FormTableUser;
import caresurvey.sci.com.caresurvey.model.FormItemUser;

public class SelectionUserActivity extends AppCompatActivity {


    Button home,insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_user);


        home=(Button)findViewById(R.id.home);
        insert=(Button)findViewById(R.id.addForm);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<FormItemUser> formItemUsers;
                FormTableUser formTableUser = new FormTableUser(SelectionUserActivity.this);

                formItemUsers=formTableUser.getAll();
                if(!formItemUsers.isEmpty()) {
                    Intent intent = new Intent(SelectionUserActivity.this, DisplayUserActivity.class);
                    startActivity(intent);
                    finish();
                }

                else
                    AlertMessage.showMessage(SelectionUserActivity.this, "Alert",
                            "No data is Inserted yet");
            }
        });


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor1 = pref.edit();
                int first_value = pref.getInt("id", 0);

                if(first_value<31) {
                    Intent intent1 = new Intent(SelectionUserActivity.this, AddressInsertActivity.class);
                    startActivity(intent1);
                    finish();
                }
                else
                    AlertMessage.showMessage(SelectionUserActivity.this, "You can not insert new form",
                            "You have already inserted 30 form for this session");

            }
        });
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
