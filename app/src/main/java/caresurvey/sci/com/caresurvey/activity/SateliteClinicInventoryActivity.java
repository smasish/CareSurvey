package caresurvey.sci.com.caresurvey.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.utils.AppUtils;
import utils.Utils;

/**
 * Created by Shahin on 5/3/2016.
 */
public class SateliteClinicInventoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satelite_clinic_inventory);

        AppUtils.setTextWithFonts(this, (TextView) (findViewById(R.id.include_query_101)).findViewById(R.id.tv_fb_observ_question),
                getString(R.string.query_101));

    }
}
