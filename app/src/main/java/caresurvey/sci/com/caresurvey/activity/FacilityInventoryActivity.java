package caresurvey.sci.com.caresurvey.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.utils.AppUtils;

import static caresurvey.sci.com.caresurvey.utils.AppUtils.setTextWithFonts;

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

        setTextWithFonts(this, (TextView) mQuesO1View.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_01));
        setTextWithFonts(this, (TextView) mQuesO2View.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_02));
        setTextWithFonts(this, (TextView) mQuesO3View.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_03));
        setTextWithFonts(this, (TextView) mQuesO4View.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_04));
        setTextWithFonts(this, (TextView) mQuesO5View.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_05));
        setTextWithFonts(this, (TextView) mQuesO6View.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_06));
    }

    private void prepareAnswerView(View view) {
        AppUtils.selectRadioBtn(this, getRadioGroup(view, R.id.yes_no_radiogroup_a), view, R.id.yes_no_radiogroup_b, true);
        AppUtils.selectRadioBtn(this, getRadioGroup(view, R.id.yes_no_radiogroup_b), view, R.id.yes_no_radiogroup_c, true);
    }

    private RadioGroup getRadioGroup(View view, int yes_no_radiogroup) {
        return (RadioGroup) view.findViewById(yes_no_radiogroup);
    }

    private void init() {
        //Section 1 title
        setTextWithFonts(this, ((TextView) findViewById(R.id.tv_section_1_title)), getString(R.string.title_invetory_section_1));
        showInfoProviderView(findViewById(R.id.include_info_provider_inventory_1), R.string.info_provider_name_lbl_101);
        setTextWithFonts(this, ((TextView) findViewById(R.id.tv_102_title)), getString(R.string.inventory_title_102));
        showRadioTitle(findViewById(R.id.facility_inventory_question_102_subtitle_include));
        //Section 2 title
        setTextWithFonts(this, ((TextView) findViewById(R.id.tv_section_2_title)), getString(R.string.title_invetory_section_2));
        showInfoProviderView(findViewById(R.id.include_info_provider_inventory_2), R.string.info_provider_name_lbl_201);
        //Section 3 title
        setTextWithFonts(this, ((TextView) findViewById(R.id.tv_section_3_title)), getString(R.string.title_invetory_section_3));
        showInfoProviderView(findViewById(R.id.include_info_provider_inventory_3), R.string.info_provider_name_lbl_301);

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
        prepareSec3QuesAns();
    }

    private void prepareSec3QuesAns() {
        View view302 = findViewById(R.id.include_inventory_sec3_302);
        View view303 = findViewById(R.id.include_inventory_sec3_303);
        View view304 = findViewById(R.id.include_inventory_sec3_304);
        View view305 = findViewById(R.id.include_inventory_sec3_305);
        View view306 = findViewById(R.id.include_inventory_sec3_306);
        View view307 = findViewById(R.id.include_inventory_sec3_307);
        View view308 = findViewById(R.id.include_inventory_sec3_308);
        View view309 = findViewById(R.id.include_inventory_sec3_309);
        View view310 = findViewById(R.id.include_inventory_sec3_310);
        View view311 = findViewById(R.id.include_inventory_sec3_311);
        View view312 = findViewById(R.id.include_inventory_sec3_312);
        View view313 = findViewById(R.id.include_inventory_sec3_313);
        View view314 = findViewById(R.id.include_inventory_sec3_314);
        View view315 = findViewById(R.id.include_inventory_sec3_315);
        View view316 = findViewById(R.id.include_inventory_sec3_316);
        View view317 = findViewById(R.id.include_inventory_sec3_317);
        View view318 = findViewById(R.id.include_inventory_sec3_318);
        View view319 = findViewById(R.id.include_inventory_sec3_329);
        View view320 = findViewById(R.id.include_inventory_sec3_320);
        View view321 = findViewById(R.id.include_inventory_sec3_321);
        View view322= findViewById(R.id.include_inventory_sec3_322);
        View view323 = findViewById(R.id.include_inventory_sec3_323);
        View view324 = findViewById(R.id.include_inventory_sec3_324);
        View view325 = findViewById(R.id.include_inventory_sec3_325);
        View view326 = findViewById(R.id.include_inventory_sec3_326);
        View view327 = findViewById(R.id.include_inventory_sec3_327);
        View view328 = findViewById(R.id.include_inventory_sec3_328);
        View view329 = findViewById(R.id.include_inventory_sec3_329);
        View view330 = findViewById(R.id.include_inventory_sec3_330);
        View view331 = findViewById(R.id.include_inventory_sec3_331);
        View view332 = findViewById(R.id.include_inventory_sec3_332);
        View view333 = findViewById(R.id.include_inventory_sec3_333);
        View view334 = findViewById(R.id.include_inventory_sec3_334);
        View view335 = findViewById(R.id.include_inventory_sec3_335);
        View view336 = findViewById(R.id.include_inventory_sec3_336);
        View view337 = findViewById(R.id.include_inventory_sec3_337);
        View view338 = findViewById(R.id.include_inventory_sec3_338);
        View view339 = findViewById(R.id.include_inventory_sec3_339);
        View view340 = findViewById(R.id.include_inventory_sec3_340);
        View view341 = findViewById(R.id.include_inventory_sec3_341);
        View view342 = findViewById(R.id.include_inventory_sec3_342);
        View view343 = findViewById(R.id.include_inventory_sec3_343);
        View view344 = findViewById(R.id.include_inventory_sec3_344);
        View view345 = findViewById(R.id.include_inventory_sec3_345);
        View view346 = findViewById(R.id.include_inventory_sec3_346);
        View view347 = findViewById(R.id.include_inventory_sec3_347);
        View view348 = findViewById(R.id.include_inventory_sec3_348);


        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_302));
        setTextWithFonts(this, (TextView) view303.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_303));
        setTextWithFonts(this, (TextView) view304.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_304));
        setTextWithFonts(this, (TextView) view305.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_305));
        setTextWithFonts(this, (TextView) view306.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_306));
        setTextWithFonts(this, (TextView) view307.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_307));
        setTextWithFonts(this, (TextView) view308.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_308));
        setTextWithFonts(this, (TextView) view319.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_309));
        setTextWithFonts(this, (TextView) view310.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_310));
        setTextWithFonts(this, (TextView) view311.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_311));
        setTextWithFonts(this, (TextView) view312.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_312));
        setTextWithFonts(this, (TextView) view313.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_313));
        setTextWithFonts(this, (TextView) view314.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_314));
        setTextWithFonts(this, (TextView) view315.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_315));
        setTextWithFonts(this, (TextView) view316.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_316));
        setTextWithFonts(this, (TextView) view317.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_317));
        setTextWithFonts(this, (TextView) view318.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_318));
        setTextWithFonts(this, (TextView) view319.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_319));
        setTextWithFonts(this, (TextView) view320.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_320));
        setTextWithFonts(this, (TextView) view321.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_321));
        setTextWithFonts(this, (TextView) view322.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_322));
        setTextWithFonts(this, (TextView) view323.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_323));
        setTextWithFonts(this, (TextView) view324.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_324));
        setTextWithFonts(this, (TextView) view325.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_325));
        setTextWithFonts(this, (TextView) view326.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_326));
        setTextWithFonts(this, (TextView) view327.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_327));
        setTextWithFonts(this, (TextView) view328.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_328));
        setTextWithFonts(this, (TextView) view329.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_329));
        setTextWithFonts(this, (TextView) view330.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_330));
        setTextWithFonts(this, (TextView) view331.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_331));
        setTextWithFonts(this, (TextView) view332.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_332));
        setTextWithFonts(this, (TextView) view333.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_333));
        setTextWithFonts(this, (TextView) view334.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_334));
        setTextWithFonts(this, (TextView) view335.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_335));
        setTextWithFonts(this, (TextView) view336.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_336));
        setTextWithFonts(this, (TextView) view337.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_337));
        setTextWithFonts(this, (TextView) view338.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_338));
        setTextWithFonts(this, (TextView) view339.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_339));
        setTextWithFonts(this, (TextView) view340.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_340));
        setTextWithFonts(this, (TextView) view341.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_341));
        setTextWithFonts(this, (TextView) view342.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_342));
        setTextWithFonts(this, (TextView) view343.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_343));
        setTextWithFonts(this, (TextView) view344.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_344));
        setTextWithFonts(this, (TextView) view345.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_345));
        setTextWithFonts(this, (TextView) view346.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_346));
        setTextWithFonts(this, (TextView) view347.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_347));
        setTextWithFonts(this, (TextView) view348.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_348));


        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_302));
        prepareSec3AnswerView(view302);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_303));
        prepareSec3AnswerView(view303);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_304));
        prepareSec3AnswerView(view304);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_305));
        prepareSec3AnswerView(view305);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_306));
        prepareSec3AnswerView(view306);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_307));
        prepareSec3AnswerView(view307);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_308));
        prepareSec3AnswerView(view308);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_309));
        prepareSec3AnswerView(view309);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_310));
        prepareSec3AnswerView(view310);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_311));
        prepareSec3AnswerView(view311);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_312));
        prepareSec3AnswerView(view312);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_313));
        prepareSec3AnswerView(view313);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_314));
        prepareSec3AnswerView(view314);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_315));
        prepareSec3AnswerView(view315);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_316));
        prepareSec3AnswerView(view316);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_317));
        prepareSec3AnswerView(view317);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_318));
        prepareSec3AnswerView(view318);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_319));
        prepareSec3AnswerView(view319);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_320));
        prepareSec3AnswerView(view320);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_321));
        prepareSec3AnswerView(view321);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_322));
        prepareSec3AnswerView(view322);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_323));
        prepareSec3AnswerView(view323);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_324));
        prepareSec3AnswerView(view324);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_325));
        prepareSec3AnswerView(view325);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_326));
        prepareSec3AnswerView(view326);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_327));
        prepareSec3AnswerView(view327);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_328));
        prepareSec3AnswerView(view328);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_329));
        prepareSec3AnswerView(view329);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_330));
        prepareSec3AnswerView(view330);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_331));
        prepareSec3AnswerView(view331);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_332));
        prepareSec3AnswerView(view332);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_333));
        prepareSec3AnswerView(view333);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_334));
        prepareSec3AnswerView(view334);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_335));
        prepareSec3AnswerView(view335);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_336));
        prepareSec3AnswerView(view336);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_337));
        prepareSec3AnswerView(view337);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_338));
        prepareSec3AnswerView(view338);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_339));
        prepareSec3AnswerView(view339);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_340));
        prepareSec3AnswerView(view340);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_341));
        prepareSec3AnswerView(view341);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_342));
        prepareSec3AnswerView(view342);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_343));
        prepareSec3AnswerView(view343);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_344));
        prepareSec3AnswerView(view344);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_345));
        prepareSec3AnswerView(view345);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_346));
        prepareSec3AnswerView(view346);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_347));
        prepareSec3AnswerView(view347);
        setTextWithFonts(this, (TextView) view302.findViewById(R.id.tv_inventory_question), getString(R.string.inventory_ques_348));
        prepareSec3AnswerView(view348);

    }

    private void prepareSec3AnswerView(View view) {
        AppUtils.selectRadioBtn(this, getRadioGroup(view, R.id.yes_no_radiogroup_a), view, R.id.yes_no_radiogroup_b, true);
//        AppUtils.selectRadioBtn(this, getRadioGroup(view, R.id.yes_no_radiogroup_b), view, R.id.yes_no_radiogroup_c, true);
    }

    private void showRadioTitle(View view) {
        setTextWithFonts(this, (TextView) view.findViewById(R.id.tv_inventory_102_title_sub), getString(R.string.tv_inventory_102_title_sub));

        setTextWithFonts(this, (TextView) view.findViewById(R.id.tv_inventory_102_sub_1), getString(R.string.equipment_102_title1));
        setTextWithFonts(this, (TextView) view.findViewById(R.id.tv_inventory_102_sub_2), getString(R.string.equipment_102_title2));
        setTextWithFonts(this, (TextView) view.findViewById(R.id.tv_inventory_102_sub_3), getString(R.string.equipment_102_title3));

    }

    private void showInfoProviderView(View view, int name) {
        setTextWithFonts(this, (TextView) view.findViewById(R.id.tv_info_provider_name), getString(name));
        setTextWithFonts(this, (TextView) view.findViewById(R.id.tv_info_provider_post), getString(R.string.info_provider_post_lbl));
    }

    private void initializeDustRemovalView() {
        mDustRemovalView = findViewById(R.id.include_inventory_dust_layout);
//        AppUtils.setTextWithFonts(this, (TextView) mDustRemovalView.findViewById(R.id.tv_inventory_dust_title), getString(R.string.inventory_dust_title));
        //Question 202
        setTextWithFonts(this, (TextView) mDustRemovalView.findViewById(R.id.tv_inventory_dust_ques_202), getString(R.string.inventory_dust_ques_202));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_202_ans_1), getString(R.string.inventory_dust_ques_202_ans_1));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_202_ans_2), getString(R.string.inventory_dust_ques_202_ans_2));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_202_ans_3), getString(R.string.inventory_dust_ques_202_ans_3));
        //Question 203
        setTextWithFonts(this, (TextView) mDustRemovalView.findViewById(R.id.tv_inventory_dust_ques_203), getString(R.string.inventory_dust_ques_203));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_203_ans_1), getString(R.string.inventory_dust_ques_203_ans_1));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_203_ans_2), getString(R.string.inventory_dust_ques_203_ans_2));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_203_ans_3), getString(R.string.inventory_dust_ques_203_ans_3));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_203_ans_4), getString(R.string.inventory_dust_ques_203_ans_4));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_203_ans_5), getString(R.string.inventory_dust_ques_203_ans_5));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_203_ans_6), getString(R.string.inventory_dust_ques_203_ans_6));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_203_ans_7), getString(R.string.inventory_dust_ques_203_ans_7));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_203_ans_8), getString(R.string.inventory_dust_ques_203_ans_8));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_203_ans_9), getString(R.string.inventory_dust_ques_203_ans_9));
        //Question 204
        setTextWithFonts(this, (TextView) mDustRemovalView.findViewById(R.id.tv_inventory_dust_ques_204), getString(R.string.inventory_dust_ques_204));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_204_ans_1), getString(R.string.inventory_dust_ques_204_ans_1));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_204_ans_2), getString(R.string.inventory_dust_ques_204_ans_2));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_204_ans_3), getString(R.string.inventory_dust_ques_204_ans_3));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_204_ans_4), getString(R.string.inventory_dust_ques_204_ans_4));
        //Question 205
        setTextWithFonts(this, (TextView) mDustRemovalView.findViewById(R.id.tv_inventory_dust_ques_205), getString(R.string.inventory_dust_ques_205));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_205_ans_1), getString(R.string.inventory_dust_ques_205_ans_1));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_205_ans_2), getString(R.string.inventory_dust_ques_205_ans_2));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_205_ans_3), getString(R.string.inventory_dust_ques_205_ans_3));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_205_ans_4), getString(R.string.inventory_dust_ques_205_ans_4));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_205_ans_5), getString(R.string.inventory_dust_ques_205_ans_5));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_205_ans_6), getString(R.string.inventory_dust_ques_205_ans_6));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_205_ans_7), getString(R.string.inventory_dust_ques_205_ans_7));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_205_ans_8), getString(R.string.inventory_dust_ques_205_ans_8));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_205_ans_9), getString(R.string.inventory_dust_ques_205_ans_9));
        //Question 206
        setTextWithFonts(this, (TextView) mDustRemovalView.findViewById(R.id.tv_inventory_dust_ques_206), getString(R.string.inventory_dust_ques_206));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_206_ans_1), getString(R.string.inventory_dust_ques_206_ans_1));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_206_ans_2), getString(R.string.inventory_dust_ques_206_ans_2));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_206_ans_3), getString(R.string.inventory_dust_ques_206_ans_3));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_206_ans_4), getString(R.string.inventory_dust_ques_206_ans_4));
        //Question 207
        setTextWithFonts(this, (TextView) mDustRemovalView.findViewById(R.id.tv_inventory_dust_ques_207), getString(R.string.inventory_dust_ques_207));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_207_ans_1), getString(R.string.inventory_dust_ques_207_ans_1));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_207_ans_2), getString(R.string.inventory_dust_ques_207_ans_2));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_207_ans_3), getString(R.string.inventory_dust_ques_207_ans_3));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_207_ans_4), getString(R.string.inventory_dust_ques_207_ans_4));
        //Question 208
        setTextWithFonts(this, (TextView) mDustRemovalView.findViewById(R.id.tv_inventory_dust_ques_208), getString(R.string.inventory_dust_ques_208));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_208_ans_1), getString(R.string.inventory_dust_ques_208_ans_1));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_208_ans_2), getString(R.string.inventory_dust_ques_208_ans_2));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_208_ans_3), getString(R.string.inventory_dust_ques_208_ans_3));
        setTextWithFonts(this, (CheckBox) mDustRemovalView.findViewById(R.id.cb_inventory_ques_208_ans_4), getString(R.string.inventory_dust_ques_208_ans_4));
    }
}
