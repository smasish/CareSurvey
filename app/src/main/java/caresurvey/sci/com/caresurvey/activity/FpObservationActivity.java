package caresurvey.sci.com.caresurvey.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.utils.AppUtils;

/**
 * Created by Shahin on 5/4/2016.
 */
public class FpObservationActivity extends Activity {
    private TextView mFp101TextView, mFp102TextView, mFp103TextView, mFp104TextView;
    private EditText mFp101EditText,mFp102EditText,mFp103EditText,mFp104EditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp_observation);

        initQuestion();
    }

    private void initQuestion() {
        AppUtils.setTextWithFonts(this, (TextView) findViewById(R.id.tv_fp_101), getString(R.string.fp_ques_101));
        AppUtils.setTextWithFonts(this, (TextView) findViewById(R.id.tv_fp_102), getString(R.string.fp_ques_102));
        AppUtils.setTextWithFonts(this, (TextView) findViewById(R.id.tv_fp_103), getString(R.string.fp_ques_103));
        AppUtils.setTextWithFonts(this, (TextView) findViewById(R.id.tv_fp_104), getString(R.string.fp_ques_104));
        AppUtils.setTextWithFonts(this, (TextView) findViewById(R.id.tv_fp_105), getString(R.string.fp_ques_105));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_01), getString(R.string.fp_ques_01));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_02), getString(R.string.fp_ques_02));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_03), getString(R.string.fp_ques_03));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_04), getString(R.string.fp_ques_04));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_05), getString(R.string.fp_ques_05));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_06), getString(R.string.fp_ques_06));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_07), getString(R.string.fp_ques_07));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_08), getString(R.string.fp_ques_08));
        AppUtils.setTextWithFonts(this, (TextView) findViewById(R.id.tv_fp_109), getString(R.string.fp_ques_09));
    }

    public void onClickBtn(View view) {
        switch (view.getId()) {
            case R.id.back:
                startActivity(new Intent(FpObservationActivity.this, DisplayUserFormActivity.class));
                finish();
                break;
            case R.id.Savebtn:
                Intent start = new Intent(FpObservationActivity.this, DisplayUserFormActivity.class);
                start.putExtra("fp", "fp");
                startActivity(start);
                finish();
                break;
            case R.id.Submit:
                Intent start1 = new Intent(FpObservationActivity.this, DisplayUserFormActivity.class);
                start1.putExtra("fp", "fp");
                startActivity(start1);
                finish();
                break;
        }
    }
}
