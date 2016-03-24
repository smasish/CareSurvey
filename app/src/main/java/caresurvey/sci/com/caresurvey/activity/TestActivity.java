package caresurvey.sci.com.caresurvey.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.FormTable;
import caresurvey.sci.com.caresurvey.model.FormItem;

public class TestActivity extends AppCompatActivity {


    Button Save, Submit;
    public String bl_status, hem_status, uri_status, pregfood_status, pregdan_status, four_status, del_status, feed_status, six_status, family_status, foltab_status, folimp_status;
    int i = 0;
    RadioGroup bloodpressure, hemoglobintest,
            urinetest, pregnancyfood, pregnancydanger,
            fourparts, delivery, feedbaby,
            sixmonths, familyplanning, folictablet,
            folictabletimportance;


    TextView tv1,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);



        Save = (Button) findViewById(R.id.Savebtn);
        Submit = (Button) findViewById(R.id.Submitbtn);
        bloodpressure = (RadioGroup) findViewById(R.id.bloodpressure);
        hemoglobintest = (RadioGroup) findViewById(R.id.hemoglobintest);
        urinetest = (RadioGroup) findViewById(R.id.urinetest);
        pregnancyfood = (RadioGroup) findViewById(R.id.pregnancyfood);
        pregnancydanger = (RadioGroup) findViewById(R.id.pregnancydanger);
        fourparts = (RadioGroup) findViewById(R.id.fourparts);
        delivery = (RadioGroup) findViewById(R.id.delivery);
        feedbaby = (RadioGroup) findViewById(R.id.feedbaby);
        sixmonths = (RadioGroup) findViewById(R.id.sixmonths);
        familyplanning = (RadioGroup) findViewById(R.id.familyplanning);
        folictablet = (RadioGroup) findViewById(R.id.folictablet);
        folictabletimportance = (RadioGroup) findViewById(R.id.folictabletimportance);

        tv1=(TextView)findViewById(R.id.textView3);





        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StorevaluesinVar();

                FormItem formItem = new FormItem(1, bl_status, hem_status, uri_status, pregfood_status, pregdan_status, four_status
                        , del_status, feed_status, six_status, family_status, foltab_status, folimp_status);
                FormTable formTable = new FormTable(TestActivity.this);


                try {


                    if ((formTable.updateItem(1, bl_status, hem_status, uri_status, pregfood_status, pregdan_status, four_status
                            , del_status, feed_status, six_status, family_status, foltab_status, folimp_status)) == 1) {

                        Toast.makeText(getApplicationContext(), "Data updated successfully for patient_id " + 1, Toast.LENGTH_SHORT).show();

                    }








                } catch (Exception e) {

                }




            }
        });







        ArrayList<FormItem> formItems;

        FormItem formItem;

        FormTable formTable = new FormTable(TestActivity.this);
        formItems= formTable.getSpecificItem(1);





        for(FormItem ft: formItems)

        {

            tv1.setText("" + ft.getDelivery());
            if(ft.getBloodpressure().equals("Yes"))
                bloodpressure.check(R.id.ques1rad1);
            else
                bloodpressure.check(R.id.ques1rad2);

            if(ft.getHemoglobintest().equals("Yes"))
                hemoglobintest.check(R.id.radioButton3);
                   else
                hemoglobintest.check(R.id.radioButton4);

            if(ft.getUrinetest().equals("Yes"))
                urinetest.check(R.id.radioButton);
            else
                urinetest.check(R.id.radioButton2);




            if(ft.getPregnancyfood().equals("Yes"))
                pregnancyfood.check(R.id.radioButton5);
            else
                pregnancyfood.check(R.id.radioButton6);

            if(ft.getPregnancydanger().equals("Yes"))
                pregnancydanger.check(R.id.radioButton7);
            else
                pregnancydanger.check(R.id.radioButton8);

            if(ft.getFourparts().equals("Yes"))
                fourparts.check(R.id.radioButton9);
            else
                fourparts.check(R.id.radioButton10);

            if(ft.getDelivery().equals("Yes"))
                delivery.check(R.id.radioButton11);
            else
                delivery.check(R.id.radioButton12);

            if(ft.getFeedbaby().equals("Yes"))
                feedbaby.check(R.id.radioButton13);
            else
                feedbaby.check(R.id.radioButton14);

            if(ft.getSixmonths().equals("Yes"))
                sixmonths.check(R.id.radioButton15);
            else
                sixmonths.check(R.id.radioButton16);

            if(ft.getFamilyplanning().equals("Yes"))
                familyplanning.check(R.id.radioButton17);
            else
                familyplanning.check(R.id.radioButton18);

            if(ft.getFolictablet().equals("Yes"))
                folictablet.check(R.id.radioButton19);
            else
                folictablet.check(R.id.radioButton20);

            if(ft.getFolictabletimportance().equals("Yes"))
                folictabletimportance.check(R.id.radioButton21);
            else
                folictabletimportance.check(R.id.radioButton22);

        }







    }


    public void StorevaluesinVar() {

        int selectedq1 = bloodpressure.getCheckedRadioButtonId();
        int selectedq2 = hemoglobintest.getCheckedRadioButtonId();
        int selectedq3 = urinetest.getCheckedRadioButtonId();
        int selectedq4 = pregnancyfood.getCheckedRadioButtonId();
        int selectedq5 = pregnancydanger.getCheckedRadioButtonId();
        int selectedq6 = fourparts.getCheckedRadioButtonId();
        int selectedq7 = delivery.getCheckedRadioButtonId();
        int selectedq8 = feedbaby.getCheckedRadioButtonId();
        int selectedq9 = sixmonths.getCheckedRadioButtonId();
        int selectedq10 = familyplanning.getCheckedRadioButtonId();
        int selectedq12 = folictabletimportance.getCheckedRadioButtonId();
        int selectedq11 = folictablet.getCheckedRadioButtonId();






            RadioButton rb1 = (RadioButton) findViewById(selectedq1);
            bl_status = rb1.getText().toString();
            bloodpressure.clearCheck();


            RadioButton rb2 = (RadioButton) findViewById(selectedq2);
            hem_status = rb2.getText().toString();

            hemoglobintest.clearCheck();


            RadioButton rb3 = (RadioButton) findViewById(selectedq3);

            uri_status = rb3.getText().toString();
            urinetest.clearCheck();


            RadioButton rb4 = (RadioButton) findViewById(selectedq4);

            pregfood_status = rb4.getText().toString();
            pregnancyfood.clearCheck();


            RadioButton rb5 = (RadioButton) findViewById(selectedq5);

            pregdan_status = rb5.getText().toString();
            pregnancydanger.clearCheck();


            RadioButton rb6 = (RadioButton) findViewById(selectedq6);

            four_status = rb6.getText().toString();
            fourparts.clearCheck();


            RadioButton rb7 = (RadioButton) findViewById(selectedq7);

            del_status = rb7.getText().toString();
            delivery.clearCheck();


            RadioButton rb8 = (RadioButton) findViewById(selectedq8);
            feed_status = rb8.getText().toString();
            feedbaby.clearCheck();


            RadioButton rb9 = (RadioButton) findViewById(selectedq9);
            six_status = rb9.getText().toString();
            sixmonths.clearCheck();


            RadioButton rb10 = (RadioButton) findViewById(selectedq10);
            family_status = rb10.getText().toString();
            familyplanning.clearCheck();

            RadioButton rb11 = (RadioButton) findViewById(selectedq11);

            foltab_status = rb11.getText().toString();
            folictablet.clearCheck();


            RadioButton rb12 = (RadioButton) findViewById(selectedq12);
            folimp_status = rb12.getText().toString();
            folictabletimportance.clearCheck();


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
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
