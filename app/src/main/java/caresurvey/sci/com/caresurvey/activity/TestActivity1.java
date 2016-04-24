package caresurvey.sci.com.caresurvey.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import caresurvey.sci.com.caresurvey.R;

public class TestActivity1 extends AppCompatActivity {
    RadioGroup feed,vomit,stutter,cough, diahorea, fever, measure_feaver, stethoscope, breathing_test,
                eye_test,infected_mouth, neck, ear, hand, dehydration, weight, circle, belly, height, bmi;
    EditText serial_no,form_date,start_time, child_description,age,endTime;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test12);



        checkBox1=(CheckBox)findViewById(R.id.checkBox1);
        checkBox2 =(CheckBox)findViewById(R.id.checkBox2);
        checkBox3= (CheckBox)findViewById(R.id.checkBox3);
        checkBox4= (CheckBox)findViewById(R.id.checkBox4);
        checkBox5= (CheckBox)findViewById(R.id.checkBox5);

        serial_no = (EditText)findViewById(R.id.serial_no);
        form_date = (EditText)findViewById(R.id.form_date);
        start_time = (EditText)findViewById(R.id.start_time);
        child_description = (EditText)findViewById(R.id.child_description);
        age = (EditText)findViewById(R.id.age);
        endTime = (EditText)findViewById(R.id.end_time);


        feed =(RadioGroup)findViewById(R.id.feed);
        vomit =(RadioGroup)findViewById(R.id.vomit);
        stutter =(RadioGroup)findViewById(R.id.stutter);
        cough =(RadioGroup)findViewById(R.id.cough);
        diahorea =(RadioGroup)findViewById(R.id.diahorea);
        fever =(RadioGroup)findViewById(R.id.fever);
        measure_feaver =(RadioGroup)findViewById(R.id.measure_fever);
        stethoscope =(RadioGroup)findViewById(R.id.stethoscope);
        breathing_test =(RadioGroup)findViewById(R.id.breathing_test);
        eye_test =(RadioGroup)findViewById(R.id.eye_test);
        infected_mouth =(RadioGroup)findViewById(R.id.infected_mouth);
        neck =(RadioGroup)findViewById(R.id.neck);
        ear =(RadioGroup)findViewById(R.id.ear);
        hand =(RadioGroup)findViewById(R.id.hand);
        dehydration =(RadioGroup)findViewById(R.id.dehydration);
        weight =(RadioGroup)findViewById(R.id.weight);
        circle =(RadioGroup)findViewById(R.id.circle);
        belly =(RadioGroup)findViewById(R.id.belly);
        height =(RadioGroup)findViewById(R.id.height);
        bmi =(RadioGroup)findViewById(R.id.bmi);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_activity1, menu);
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
