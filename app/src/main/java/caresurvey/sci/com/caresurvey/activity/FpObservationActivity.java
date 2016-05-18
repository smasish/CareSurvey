package caresurvey.sci.com.caresurvey.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.model.FpObservationFormItem;
import caresurvey.sci.com.caresurvey.utils.AppUtils;

/**
 * Created by Shahin on 5/4/2016.
 */
public class FpObservationActivity extends Activity {
    private TextView mFp101TextView, mFp102TextView, mFp103TextView, mFp104TextView;
    private EditText mFp101EditText, mFp102EditText, mFp103EditText, mFp104EditText;
    private View mFpQuesView1, mFpQuesView2, mFpQuesView3, mFpQuesView4, mFpQuesView5, mFpQuesView6, mFpQuesView7, mFpQuesView8;
    private FpObservationFormItem mFpObservationFormItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp_observation);

        mFpObservationFormItem = new FpObservationFormItem();

        initIncludedViews();
        initQuestion();
    }

    private void initIncludedViews() {
        mFpQuesView1 = findViewById(R.id.include_fb_ques_01);
        mFpQuesView2 = findViewById(R.id.include_fb_ques_02);
        mFpQuesView3 = findViewById(R.id.include_fb_ques_03);
        mFpQuesView4 = findViewById(R.id.include_fb_ques_04);
        mFpQuesView5 = findViewById(R.id.include_fb_ques_05);
        mFpQuesView6 = findViewById(R.id.include_fb_ques_06);
        mFpQuesView7 = findViewById(R.id.include_fb_ques_07);
        mFpQuesView8 = findViewById(R.id.include_fb_ques_08);
    }

    private void collectAnswers() {
        mFpObservationFormItem.setCover(getRadioSelectionAns(mFpQuesView1));
        mFpObservationFormItem.setSound_prove(getRadioSelectionAns(mFpQuesView2));
        mFpObservationFormItem.setDiscuss_fp(getRadioSelectionAns(mFpQuesView3));
        mFpObservationFormItem.setDiscuss_fp_protocol(getRadioSelectionAns(mFpQuesView4));
        mFpObservationFormItem.setQuestions(getRadioSelectionAns(mFpQuesView5));
        mFpObservationFormItem.setJob_aid(getRadioSelectionAns(mFpQuesView6));
        mFpObservationFormItem.setFollowup(getRadioSelectionAns(mFpQuesView7));
        mFpObservationFormItem.setFollowup(getRadioSelectionAns(mFpQuesView7));
    }

    private boolean getRadioSelectionAns(View radioGroupHolder) {
        RadioGroup radioGroup = (RadioGroup) radioGroupHolder.findViewById(R.id.fp_yes_no_radiogroup);
        int selectedRadioBtnId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioBtn = (RadioButton) findViewById(selectedRadioBtnId);
        return selectedRadioBtn.isChecked();
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
                Intent start = new Intent(FpObservationActivity.this, DisplayUserActivity.class);
                start.putExtra("fp", "fp");
                startActivity(start);
                finish();
                break;
            case R.id.Savebtn:
                Intent start1 = new Intent(FpObservationActivity.this, DisplayUserActivity.class);
                start1.putExtra("fp", "fp");
                startActivity(start1);
                finish();
                break;
            case R.id.Submit:
                Intent start2 = new Intent(FpObservationActivity.this, DisplayUserActivity.class);
                start2.putExtra("fp", "fp");
                startActivity(start2);
                finish();
                break;
        }
    }
}
