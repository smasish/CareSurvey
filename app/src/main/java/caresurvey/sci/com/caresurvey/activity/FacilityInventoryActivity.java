package caresurvey.sci.com.caresurvey.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.utils.AppUtils;

public class FacilityInventoryActivity extends AppCompatActivity {

    private View mQuesO1View;
    private View mQuesO2View;
    private View mQuesO3View;
    private View mQuesO4View;
    private View mQuesO5View;
    private View mQuesO6View;
    private View mDustRemovalView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_inventory);

        init();

        AppUtils.setTextWithFonts(this, (TextView) mQuesO1View.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_01));
        AppUtils.setTextWithFonts(this, (TextView) mQuesO2View.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_02));
        AppUtils.setTextWithFonts(this, (TextView) mQuesO3View.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_03));
        AppUtils.setTextWithFonts(this, (TextView) mQuesO4View.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_04));
        AppUtils.setTextWithFonts(this, (TextView) mQuesO5View.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_05));
        AppUtils.setTextWithFonts(this, (TextView) mQuesO6View.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_06));
    }

    private void prepareAnswerView(View view) {
        AppUtils.selectRadioBtn(this, getRadioGroup(view, R.id.yes_no_radiogroup_a), view, R.id.yes_no_radiogroup_b);
        AppUtils.selectRadioBtn(this, getRadioGroup(view, R.id.yes_no_radiogroup_b), view, R.id.yes_no_radiogroup_c);
    }

    private RadioGroup getRadioGroup(View view, int yes_no_radiogroup) {
        return (RadioGroup) view.findViewById(yes_no_radiogroup);
    }

    private void init() {
        mQuesO1View = findViewById(R.id.include_inventory_ques_01);
        mQuesO2View = findViewById(R.id.include_inventory_ques_02);
        mQuesO3View = findViewById(R.id.include_inventory_ques_03);
        mQuesO4View = findViewById(R.id.include_inventory_ques_04);
        mQuesO5View = findViewById(R.id.include_inventory_ques_05);
        mQuesO6View = findViewById(R.id.include_inventory_ques_06);

        prepareAnswerView(mQuesO1View);
        prepareAnswerView(mQuesO2View);
        prepareAnswerView(mQuesO3View);
        prepareAnswerView(mQuesO4View);
        prepareAnswerView(mQuesO5View);
        prepareAnswerView(mQuesO6View);

        initializeDustRemovalView();
    }

    private void initializeDustRemovalView() {
        mDustRemovalView = findViewById(R.id.include_inventory_dust_layout);
        AppUtils.setTextWithFonts(this, (TextView) mDustRemovalView.findViewById(R.id.tv_inventory_dust_title), getString(R.string.inventory_dust_title));
        //Question 202
        AppUtils.setTextWithFonts(this, (TextView) mDustRemovalView.findViewById(R.id.tv_inventory_dust_ques_202), getString(R.string.inventory_dust_ques_202));
        AppUtils.setTextWithFonts(this, (RadioButton) mDustRemovalView.findViewById(R.id.rb_inventory_ques_202_ans_1), getString(R.string.inventory_dust_ques_202_ans_1));
        AppUtils.setTextWithFonts(this, (RadioButton) mDustRemovalView.findViewById(R.id.rb_inventory_ques_202_ans_2), getString(R.string.inventory_dust_ques_202_ans_2));
        AppUtils.setTextWithFonts(this, (RadioButton) mDustRemovalView.findViewById(R.id.rb_inventory_ques_202_ans_3), getString(R.string.inventory_dust_ques_202_ans_3));
        //Question 203
        AppUtils.setTextWithFonts(this, (TextView) mDustRemovalView.findViewById(R.id.tv_inventory_dust_ques_203), getString(R.string.inventory_dust_ques_203));
        AppUtils.setTextWithFonts(this, (RadioButton) mDustRemovalView.findViewById(R.id.rb_inventory_ques_203_ans_1), getString(R.string.inventory_dust_ques_203_ans_1));
        AppUtils.setTextWithFonts(this, (RadioButton) mDustRemovalView.findViewById(R.id.rb_inventory_ques_203_ans_2), getString(R.string.inventory_dust_ques_203_ans_2));
        AppUtils.setTextWithFonts(this, (RadioButton) mDustRemovalView.findViewById(R.id.rb_inventory_ques_203_ans_3), getString(R.string.inventory_dust_ques_203_ans_3));
        AppUtils.setTextWithFonts(this, (RadioButton) mDustRemovalView.findViewById(R.id.rb_inventory_ques_203_ans_4), getString(R.string.inventory_dust_ques_203_ans_4));
        AppUtils.setTextWithFonts(this, (RadioButton) mDustRemovalView.findViewById(R.id.rb_inventory_ques_203_ans_5), getString(R.string.inventory_dust_ques_203_ans_5));
        AppUtils.setTextWithFonts(this, (RadioButton) mDustRemovalView.findViewById(R.id.rb_inventory_ques_203_ans_6), getString(R.string.inventory_dust_ques_203_ans_6));
        AppUtils.setTextWithFonts(this, (RadioButton) mDustRemovalView.findViewById(R.id.rb_inventory_ques_203_ans_7), getString(R.string.inventory_dust_ques_203_ans_7));
        AppUtils.setTextWithFonts(this, (RadioButton) mDustRemovalView.findViewById(R.id.rb_inventory_ques_203_ans_8), getString(R.string.inventory_dust_ques_203_ans_8));
        AppUtils.setTextWithFonts(this, (RadioButton) mDustRemovalView.findViewById(R.id.rb_inventory_ques_203_ans_9), getString(R.string.inventory_dust_ques_203_ans_9));
    }
}
