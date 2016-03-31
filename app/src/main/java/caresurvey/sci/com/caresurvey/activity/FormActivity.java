package caresurvey.sci.com.caresurvey.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.FormTable;
import caresurvey.sci.com.caresurvey.model.FormItem;

public class FormActivity extends AppCompatActivity {
    Button Save, Submit,sub;
    Boolean vs;
    public String bl_status, hem_status, uri_status, pregfood_status, pregdan_status, four_status, del_status, feed_status, six_status, family_status, foltab_status, folimp_status;
    int i = 0;
    RadioGroup bloodpressure, hemoglobintest,
            urinetest, pregnancyfood, pregnancydanger,
            fourparts, delivery, feedbaby,
            sixmonths, familyplanning, folictablet,
            folictabletimportance;

    TextView t1, t2;
    private int p=0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        addListenerOnButton();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void addListenerOnButton() {
        Save = (Button) findViewById(R.id.Savebtn);
        //Submit = (Button) findViewById(R.id.Submitbtn);
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



        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                StorevaluesinVar();
                int status =1;
                String global_id="";
                String name = "";
                String comments="";
                String fields = "";
                FormItem formItem = new FormItem(i, bl_status, hem_status, uri_status, pregfood_status, pregdan_status, four_status
                        , del_status, feed_status, six_status, family_status, foltab_status, folimp_status,status,global_id,name,comments,fields);



                FormTable formTable = new FormTable(FormActivity.this);

                try {


                    if ((formTable.insertItem(formItem)) == 1&&p==1) {

                        Toast.makeText(getApplicationContext(), "Data inserted successfully for patient_id " + i, Toast.LENGTH_SHORT).show();

                    }








                } catch (Exception e) {

                }


//                Intent in =new Intent(FormActivity.this, TestActivity.class);
//                startActivity(in);


            }
        });
    }


    public void wrongData()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(FormActivity.this).create();
        alertDialog.setTitle("");
        alertDialog.setMessage("অনুগ্রহ পূর্বক সব ডেটা ইনপুট দিন");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
        alertDialog.show();
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


        if(selectedq1<0||selectedq2<0||selectedq3<0||selectedq4<0||selectedq5<0||selectedq6<0||selectedq7<0||
                selectedq8<0||selectedq9<0||selectedq10<0||selectedq11<0||selectedq12<0) {
            wrongData();
            p=0;
        }

        else {
            p=1;
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

    }





}



