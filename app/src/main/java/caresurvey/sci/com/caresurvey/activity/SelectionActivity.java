package caresurvey.sci.com.caresurvey.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import caresurvey.sci.com.caresurvey.R;

public class SelectionActivity extends AppCompatActivity {

    public static final String EXTRA_DISTRICT = "user_district";
    Button anc,cs;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        anc= (Button)findViewById(R.id.anc);
        cs=(Button)findViewById(R.id.cs);


        anc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SelectionActivity.this,SurveyActivity.class);
                startActivity(intent);
            }
        });

        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intents= new Intent(SelectionActivity.this,DisplayAll_Activity.class);
                startActivity(intents);
            }
        });




    }
}
