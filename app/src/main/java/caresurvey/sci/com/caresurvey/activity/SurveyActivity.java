package caresurvey.sci.com.caresurvey.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import java.util.ArrayList;

import caresurvey.sci.com.caresurvey.R;

public class SurveyActivity extends AppCompatActivity {
    Button Survey;
    ProgressBar progressBar,progressBar1,progressBar2,progressBar3,progressBar4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);


        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(5);
        progressBar.setProgress(2);

        progressBar1=(ProgressBar)findViewById(R.id.progressBar2);
        progressBar1.setMax(5);
        progressBar1.setProgress(2);

        progressBar2=(ProgressBar)findViewById(R.id.progressBar3);
        progressBar2.setMax(5);
        progressBar2.setProgress(2);

        progressBar3=(ProgressBar)findViewById(R.id.progressBar1);
        progressBar3.setMax(5);
        progressBar3.setProgress(2);
        progressBar2.setScaleY(9f);
        progressBar.setScaleY(9f);
        progressBar1.setScaleY(9f);
        progressBar3.setScaleY(9f);
        progressBar2.getProgressDrawable().setColorFilter(
                Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);

        progressBar.getProgressDrawable().setColorFilter(
                Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);


        progressBar1.getProgressDrawable().setColorFilter(
                Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);

        progressBar3.getProgressDrawable().setColorFilter(
                Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);

        Survey = (Button)findViewById(R.id.survey_button);
        Survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(SurveyActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });

        //progressBar3.getLayoutParams().height = 20;
        //  progressBar3.invalidate();




        ArrayList<String> survey_result = new ArrayList<String>();
        survey_result.add("District Hospital");
        survey_result.add("Upozila Health Complex");
        survey_result.add("Union health and family welfare center");
        survey_result.add("Satellite Clinic");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.dropdown_text_survey, survey_result);
        Spinner spin = (Spinner)findViewById(R.id.spinner);
        spin.setAdapter(adapter);






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_survey, menu);
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
