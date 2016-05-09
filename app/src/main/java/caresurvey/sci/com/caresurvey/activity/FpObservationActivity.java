package caresurvey.sci.com.caresurvey.activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.utils.AppUtils;

/**
 * Created by Shahin on 5/4/2016.
 */
public class FpObservationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp_observation);

        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_01), getString(R.string.fp_ques_01));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_02), getString(R.string.fp_ques_02));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_03), getString(R.string.fp_ques_03));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_04), getString(R.string.fp_ques_04));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_05), getString(R.string.fp_ques_05));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_06), getString(R.string.fp_ques_06));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_07), getString(R.string.fp_ques_07));
        AppUtils.setTextWithFonts(this, findViewById(R.id.include_fb_ques_08), getString(R.string.fp_ques_08));
    }
}
