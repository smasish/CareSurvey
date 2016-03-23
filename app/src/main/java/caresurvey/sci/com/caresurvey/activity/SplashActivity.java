package caresurvey.sci.com.caresurvey;

/**
 * Created by asish on 4/03/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.widget.Spinner;
import android.widget.TextView;

import caresurvey.sci.com.caresurvey.activity.LoginActivity1;

public class SplashActivity extends ActionBarActivity {

    Context context;
    Spinner spinner2,spinner3,spinner4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context = this;
        //getActionBar().setBackgroundDrawable((getResources().getDrawable(R.drawable.actionbar)));

        TextView text = (TextView)findViewById(R.id.notice_id);




        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /* start the activity */
                startActivity(new Intent(context, LoginActivity.class));
                //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                overridePendingTransition(0,0);
                finish();
            }
        }, 3000);

    }

}
