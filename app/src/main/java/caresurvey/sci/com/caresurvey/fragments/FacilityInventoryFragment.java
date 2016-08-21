package caresurvey.sci.com.caresurvey.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.activity.FacilityInventoryActivity;
import caresurvey.sci.com.caresurvey.model.InventoryItem;

/**
 * Created by shantanu on 5/30/16.
 */
public class FacilityInventoryFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private int resourceID;
    private int index;
    private View view;

    public static FacilityInventoryFragment newInstance(int index) {
        FacilityInventoryFragment f = new FacilityInventoryFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        index = bundle.getInt("index",-1);
        resourceID = FacilityInventoryActivity.resources[index];
    }

    public FacilityInventoryActivity getContext(){
        return (FacilityInventoryActivity) getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        View nextBtn = view.findViewById(R.id.next);
        if(nextBtn != null){
            nextBtn.setOnClickListener(this);
        }
        View prevBtn = view.findViewById(R.id.prev);
        if(prevBtn != null){
            prevBtn.setOnClickListener(this);
        }
        View insertBtn = view.findViewById(R.id.insert);
        if(insertBtn != null){
            insertBtn.setOnClickListener(this);
        }
        View submitBtn = view.findViewById(R.id.submit);
        if(submitBtn != null){
            if(getContext().isAdmin()){
                submitBtn.setVisibility(View.GONE);
            }
            else{
                submitBtn.setVisibility(View.VISIBLE);
            }
            submitBtn.setOnClickListener(this);
        }

        try{
            if(getContext().isAdmin()) {
                editable(false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(resourceID == R.layout.activity_facility_inventory1) {
            gRGi(R.id.fi_1_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_1_1).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_2_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_2_1).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_3_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_3_1).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_4_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_4_1).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_5_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_5_1).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_6_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_6_1).setOnCheckedChangeListener(this);
            updateRadioGroupState1();
        }
        else if(resourceID == R.layout.activity_facility_inventory3) {
            gRGi(R.id.fi_302_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_303_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_304_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_305_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_306_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_314_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_319_0).setOnCheckedChangeListener(this);
            updateRadioGroupState3();
        }
        else if(resourceID == R.layout.activity_facility_inventory4) {
            gRGi(R.id.fi_326_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_327_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_328_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_329_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_330_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_331_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_332_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_333_0).setOnCheckedChangeListener(this);
            updateRadioGroupState4();
        }
        else if(resourceID == R.layout.activity_facility_inventory5) {
            gRGi(R.id.fi_401_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_402_0).setOnCheckedChangeListener(this);
            gRGi(R.id.fi_403_0).setOnCheckedChangeListener(this);
            updateRadioGroupState5();
        }
        try {
            loadData(getContext().getItem());
        }catch(Exception e){
            e.printStackTrace();
//            Toast.makeText(getActivity(),"Form load failed",Toast.LENGTH_SHORT).show();
        }
    }
    int idx = -1;
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        idx = gIRGc(group,checkedId);
        if(resourceID == R.layout.activity_facility_inventory1) {
            updateRadioGroupState1();
        }
        else if(resourceID == R.layout.activity_facility_inventory3) {
            updateRadioGroupState3();
        }
        else if(resourceID == R.layout.activity_facility_inventory4){
            updateRadioGroupState4();
        }
        else if(resourceID == R.layout.activity_facility_inventory5){
            updateRadioGroupState5();
        }
    }

    void updateRadioGroupState1(){
        sRGu(R.id.fi_1_0, R.id.fi_1_1, R.id.fi_1_2);
        sRGu(R.id.fi_2_0, R.id.fi_2_1, R.id.fi_2_2);
        sRGu(R.id.fi_3_0, R.id.fi_3_1, R.id.fi_3_2);
        sRGu(R.id.fi_4_0, R.id.fi_4_1, R.id.fi_4_2);
        sRGu(R.id.fi_5_0, R.id.fi_5_1, R.id.fi_5_2);
        sRGu(R.id.fi_6_0, R.id.fi_6_1, R.id.fi_6_2);
    }

    void updateRadioGroupState3(){
        sRGu(R.id.fi_302_0, R.id.fi_302_1);
        sRGu(R.id.fi_303_0, R.id.fi_303_1);
        sRGu(R.id.fi_304_0, R.id.fi_304_1);
        sRGu(R.id.fi_305_0, R.id.fi_305_1);
        sRGu(R.id.fi_306_0, R.id.fi_306_1);
        sRGu(R.id.fi_314_0, R.id.fi_314_1);
        sRGu(R.id.fi_319_0, R.id.fi_319_1);
    }

    void updateRadioGroupState4(){
        sRGu(R.id.fi_326_0, R.id.fi_326_1);
        sRGu(R.id.fi_327_0, R.id.fi_327_1);
        sRGu(R.id.fi_328_0, R.id.fi_328_1);
        sRGu(R.id.fi_329_0, R.id.fi_329_1);
        sRGu(R.id.fi_330_0, R.id.fi_330_1);
        sRGu(R.id.fi_331_0, R.id.fi_331_1);
        sRGu(R.id.fi_332_0, R.id.fi_332_1);
        sRGu(R.id.fi_333_0, R.id.fi_333_1);

    }
    void updateRadioGroupState5(){
        sRGu(R.id.fi_401_0, R.id.fi_401_1);
        sRGu(R.id.fi_402_0, R.id.fi_402_1);
        sRGu(R.id.fi_403_0, R.id.fi_403_1);
    }

    private void sRGu(int id0,int id1,int id2){
        updateRGview(gRGi(id0), idx, gVBi(id1));
        updateRGview(gRGi(id1), idx, gVBi(id2));
    }
    private void sRGu(int id0,int id1){
        updateRGview(gRGi(id0),idx,gVBi(id1));
    }


    private View gVBi(int id){
        return view.findViewById(id);
    }
    private RadioGroup gRGi(int id){
        return (RadioGroup) view.findViewById(id);
    }
    //update next radio group visibility depends on current radio group state
    private void updateRGview(RadioGroup group,int index,View nextView){
        if(group.getVisibility() == View.VISIBLE) {
            View v = nextView;
            if (index == 0 && gRBv(group, index)) {
                v.setVisibility(View.VISIBLE);
            } else if ((index == 1 && gRBv(group, index)) || (index == 2 && gRBv(group, index))) {
                v.setVisibility(View.INVISIBLE);
            }
            else if(index == -1){
                v.setVisibility(View.INVISIBLE);
            }
        }
        else{
            nextView.setVisibility(View.INVISIBLE);
        }
    }

    private boolean gRBv(RadioGroup group,int index){
        RadioButton btn = (RadioButton) group.getChildAt(index);
        return btn.isChecked();
    }

    private int gIRGc(RadioGroup group,int id){
        int count = group.getChildCount();
        for(int i=0;i<count;i++){
            if(group.getChildAt(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(resourceID,container,false);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.next || v.getId() == R.id.insert || v.getId() == R.id.submit){
            try {
                if(!getContext().isAdmin()) {
                    collectData(getContext().getItem());
                    InventoryItem item = getContext().getItem();
                    if(item.status == 2){ //reverted
                        item.status = 4;
                    }
                    getContext().getTable().insert(getContext().getItem());
                }
                if(v.getId() == R.id.next) {
                    getContext().loadFragment(index + 1);
                }
                else if(v.getId() == R.id.insert){
                    Toast.makeText(getActivity(),"Form saved successfully",Toast.LENGTH_SHORT).show();
                }
                else{
                    getContext().submit();
                }
            } catch (Exception e) {
                Toast.makeText(getActivity(),"Form is not complete",Toast.LENGTH_SHORT).show();
            }

        }
        else if(v.getId() == R.id.prev){
            getContext().loadFragment(index - 1);
        }
    }


    private void collectData(InventoryItem item) throws Exception {
        if (resourceID == R.layout.activity_facility_inventory1) {
            collectData1(item);
        }
        else if(resourceID == R.layout.activity_facility_inventory2){
            collectData2(item);
        }
        else if(resourceID == R.layout.activity_facility_inventory3){
            collectData3(item);
        }
        else if(resourceID == R.layout.activity_facility_inventory4){
            collectData4(item);
        }
        else if(resourceID == R.layout.activity_facility_inventory5){
            collectData5(item);
        }
        else if(resourceID == R.layout.activity_facility_inventory6){
            collectData6(item);
        }
    }

    private void editable(boolean state){
        if(resourceID == R.layout.activity_facility_inventory1){
            editable1(state);
        }
        else if(resourceID == R.layout.activity_facility_inventory2){
            editable2(state);
        }
        else if(resourceID == R.layout.activity_facility_inventory3){
            editable3(state);
        }
        else if(resourceID == R.layout.activity_facility_inventory4){
            editable4(state);
        }
        else if(resourceID == R.layout.activity_facility_inventory5){
            editable5(state);
        }
        else if(resourceID == R.layout.activity_facility_inventory6){
            editable6(state);
        }
    }

    private void loadData(InventoryItem item){
        if(resourceID == R.layout.activity_facility_inventory1){
            loadData1(item);
        }
        else if(resourceID == R.layout.activity_facility_inventory2){
            loadData2(item);
        }
        else if(resourceID == R.layout.activity_facility_inventory3){
            loadData3(item);
        }
        else if(resourceID == R.layout.activity_facility_inventory4){
            loadData4(item);
        }
        else if(resourceID == R.layout.activity_facility_inventory5){
            loadData5(item);
        }
        else if(resourceID == R.layout.activity_facility_inventory6){
            loadData6(item);
        }
    }
    private void loadData5(InventoryItem item){
        String tmp = "";
        String tokens[];
        tmp = item.ch_wing_scale;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_401_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_401_1, ind);
            }
        }
        tmp = item.ch_infant_wing_scale;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_402_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_402_1, ind);
            }
        }
        tmp = item.ch_height_rod;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_403_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_403_1, ind);
            }
        }
        lRGv(R.id.fi_404_0, gRGI(item.ch_measuring_tip));
        lRGv(R.id.fi_405_0, gRGI(item.ch_water));
        lRGv(R.id.fi_406_0, gRGI(item.ch_growth_monitor_boy));
        lRGv(R.id.fi_407_0, gRGI(item.ch_growth_monitor_girl));
        lRGv(R.id.fi_408_0, gRGI(item.ch_hand_soap));
        lRGv(R.id.fi_409_0, gRGI(item.ch_spirit));
        lRGv(R.id.fi_410_0, gRGI(item.ch_wastage_recycle));
        lRGv(R.id.fi_411_0, gRGI(item.ch_sharp_waste));
        lRGv(R.id.fi_412_0, gRGI(item.ch_latex_gloves));
        lRGv(R.id.fi_413_0, gRGI(item.ch_ors));
        lRGv(R.id.fi_414_0, gRGI(item.ch_paediatric_drop));
        lRGv(R.id.fi_415_0, gRGI(item.ch_cotrimoxazole));
        lRGv(R.id.fi_416_0, gRGI(item.ch_paracetamol));
        lRGv(R.id.fi_417_0, gRGI(item.ch_zinc));
        lRGv(R.id.fi_418_0, gRGI(item.ch_mebandazole));
        lRGv(R.id.fi_419_0, gRGI(item.ch_ceftriaxone));
        lRGv(R.id.fi_420_0, gRGI(item.ch_vitamin));
        lRGv(R.id.fi_501_0, gRGI(item.fp_soap));
        lRGv(R.id.fi_502_0, gRGI(item.fp_spirit));
        lRGv(R.id.fi_503_0, gRGI(item.fp_waste_recycle));
        lRGv(R.id.fi_504_0, gRGI(item.fp_sharp_waste));
        lRGv(R.id.fi_505_0, gRGI(item.fp_latex_gloves));
    }

    private void editable5(boolean state){
        sRGs(R.id.fi_401_0, state);
        sRGs(R.id.fi_401_1, state);
        sRGs(R.id.fi_402_0, state);
        sRGs(R.id.fi_402_1, state);
        sRGs(R.id.fi_403_0, state);
        sRGs(R.id.fi_403_1, state);
        sRGs(R.id.fi_404_0, state);
        sRGs(R.id.fi_405_0, state);
        sRGs(R.id.fi_406_0, state);
        sRGs(R.id.fi_407_0, state);
        sRGs(R.id.fi_408_0, state);
        sRGs(R.id.fi_409_0, state);
        sRGs(R.id.fi_410_0, state);
        sRGs(R.id.fi_411_0, state);
        sRGs(R.id.fi_412_0, state);
        sRGs(R.id.fi_413_0, state);
        sRGs(R.id.fi_414_0, state);
        sRGs(R.id.fi_415_0, state);
        sRGs(R.id.fi_416_0, state);
        sRGs(R.id.fi_417_0, state);
        sRGs(R.id.fi_418_0, state);
        sRGs(R.id.fi_419_0, state);
        sRGs(R.id.fi_420_0, state);
        sRGs(R.id.fi_501_0, state);
        sRGs(R.id.fi_502_0, state);
        sRGs(R.id.fi_503_0, state);
        sRGs(R.id.fi_504_0, state);
        sRGs(R.id.fi_505_0, state);
    }

    private void loadData6(InventoryItem item){
        item.end_time = getTime();
        sETv(R.id.fi_612,item.end_time);
        String tokens[];
        tokens = item.r_healthy_newborn.split(",");
        for(int i=0;i<tokens.length;i++){
            if(i == 0){
                sETv(R.id.fi_601_1,tokens[i]);
            }
            else if(i == 1){
                sETv(R.id.fi_601_2,tokens[i]);
            }
            else if(i == 2){
                sETv(R.id.fi_601_3,tokens[i]);
            }
            else if(i == 3){
                sETv(R.id.fi_601_4,tokens[i]);
            }
        }
        tokens = item.r_newborn_death.split(",");
        for(int i=0;i<tokens.length;i++){
            if(i == 0){
                sETv(R.id.fi_602_1,tokens[i]);
            }
            else if(i == 1){
                sETv(R.id.fi_602_2,tokens[i]);
            }
            else if(i == 2){
                sETv(R.id.fi_602_3,tokens[i]);
            }
            else if(i == 3){
                sETv(R.id.fi_602_4,tokens[i]);
            }
        }
        tokens = item.r_mother_rate.split(",");
        for(int i=0;i<tokens.length;i++){
            if(i == 0){
                sETv(R.id.fi_603_1,tokens[i]);
            }
            else if(i == 1){
                sETv(R.id.fi_603_2,tokens[i]);
            }
            else if(i == 2){
                sETv(R.id.fi_603_3,tokens[i]);
            }
            else if(i == 3){
                sETv(R.id.fi_603_4,tokens[i]);
            }
        }
        tokens = item.r_elampsia.split(",");
        for(int i=0;i<tokens.length;i++){
            if(i == 0){
                sETv(R.id.fi_604_1,tokens[i]);
            }
            else if(i == 1){
                sETv(R.id.fi_604_2,tokens[i]);
            }
            else if(i == 2){
                sETv(R.id.fi_604_3,tokens[i]);
            }
            else if(i == 3){
                sETv(R.id.fi_604_4,tokens[i]);
            }
        }
        tokens = item.r_mang_sulfate.split(",");
        for(int i=0;i<tokens.length;i++){
            if(i == 0){
                sETv(R.id.fi_605_1,tokens[i]);
            }
            else if(i == 1){
                sETv(R.id.fi_605_2,tokens[i]);
            }
            else if(i == 2){
                sETv(R.id.fi_605_3,tokens[i]);
            }
            else if(i == 3){
                sETv(R.id.fi_605_4,tokens[i]);
            }
        }
        tokens = item.r_pneumonis.split(",");
        for(int i=0;i<tokens.length;i++){
            if(i == 0){
                sETv(R.id.fi_606_1,tokens[i]);
            }
            else if(i == 1){
                sETv(R.id.fi_606_2,tokens[i]);
            }
            else if(i == 2){
                sETv(R.id.fi_606_3,tokens[i]);
            }
            else if(i == 3){
                sETv(R.id.fi_606_4,tokens[i]);
            }
        }
        tokens = item.r_paracetamol.split(",");
        for(int i=0;i<tokens.length;i++){
            if(i == 0){
                sETv(R.id.fi_607_1,tokens[i]);
            }
            else if(i == 1){
                sETv(R.id.fi_607_2,tokens[i]);
            }
            else if(i == 2){
                sETv(R.id.fi_607_3,tokens[i]);
            }
            else if(i == 3){
                sETv(R.id.fi_607_4,tokens[i]);
            }
        }
        tokens = item.r_psbi.split(",");
        for(int i=0;i<tokens.length;i++){
            if(i == 0){
                sETv(R.id.fi_608_1,tokens[i]);
            }
            else if(i == 1){
                sETv(R.id.fi_608_2,tokens[i]);
            }
            else if(i == 2){
                sETv(R.id.fi_608_3,tokens[i]);
            }
            else if(i == 3){
                sETv(R.id.fi_608_4,tokens[i]);
            }
        }
        tokens = item.r_psbi_care.split(",");
        for(int i=0;i<tokens.length;i++){
            if(i == 0){
                sETv(R.id.fi_609_1,tokens[i]);
            }
            else if(i == 1){
                sETv(R.id.fi_609_2,tokens[i]);
            }
            else if(i == 2){
                sETv(R.id.fi_609_3,tokens[i]);
            }
            else if(i == 3){
                sETv(R.id.fi_609_4,tokens[i]);
            }
        }
        tokens = item.r_starving_child.split(",");
        for(int i=0;i<tokens.length;i++){
            if(i == 0){
                sETv(R.id.fi_610_1,tokens[i]);
            }
            else if(i == 1){
                sETv(R.id.fi_610_2,tokens[i]);
            }
            else if(i == 2){
                sETv(R.id.fi_610_3,tokens[i]);
            }
            else if(i == 3){
                sETv(R.id.fi_610_4,tokens[i]);
            }
        }
        tokens = item.r_starving_protocol.split(",");
        for(int i=0;i<tokens.length;i++){
            if(i == 0){
                sETv(R.id.fi_611_1,tokens[i]);
            }
            else if(i == 1){
                sETv(R.id.fi_611_2,tokens[i]);
            }
            else if(i == 2){
                sETv(R.id.fi_611_3,tokens[i]);
            }
            else if(i == 3){
                sETv(R.id.fi_611_4,tokens[i]);
            }
        }
    }
    private void editable6(boolean state){
        sVEs(R.id.fi_601_1,state);
        sVEs(R.id.fi_601_2,state);
        sVEs(R.id.fi_601_3,state);
        sVEs(R.id.fi_601_4,state);
        sVEs(R.id.fi_602_1,state);
        sVEs(R.id.fi_602_2,state);
        sVEs(R.id.fi_602_3,state);
        sVEs(R.id.fi_602_4,state);
        sVEs(R.id.fi_603_1,state);
        sVEs(R.id.fi_603_2,state);
        sVEs(R.id.fi_603_3,state);
        sVEs(R.id.fi_603_4,state);
        sVEs(R.id.fi_604_1,state);
        sVEs(R.id.fi_604_2,state);
        sVEs(R.id.fi_604_3,state);
        sVEs(R.id.fi_604_4,state);
        sVEs(R.id.fi_605_1,state);
        sVEs(R.id.fi_605_2,state);
        sVEs(R.id.fi_605_3,state);
        sVEs(R.id.fi_605_4,state);
        sVEs(R.id.fi_606_1,state);
        sVEs(R.id.fi_606_2,state);
        sVEs(R.id.fi_606_3,state);
        sVEs(R.id.fi_606_4,state);
        sVEs(R.id.fi_607_1,state);
        sVEs(R.id.fi_607_2,state);
        sVEs(R.id.fi_607_3,state);
        sVEs(R.id.fi_607_4,state);
        sVEs(R.id.fi_608_1,state);
        sVEs(R.id.fi_608_2,state);
        sVEs(R.id.fi_608_3,state);
        sVEs(R.id.fi_608_4,state);
        sVEs(R.id.fi_609_1,state);
        sVEs(R.id.fi_609_2,state);
        sVEs(R.id.fi_609_3,state);
        sVEs(R.id.fi_609_4,state);
        sVEs(R.id.fi_610_1,state);
        sVEs(R.id.fi_610_2,state);
        sVEs(R.id.fi_610_3,state);
        sVEs(R.id.fi_610_4,state);
        sVEs(R.id.fi_611_1,state);
        sVEs(R.id.fi_611_2,state);
        sVEs(R.id.fi_611_3,state);
        sVEs(R.id.fi_611_4,state);
        sVEs(R.id.fi_612,state);
        sVEs(R.id.fi_612,state);
    }
    private void loadData4(InventoryItem item){
        sETv(R.id.fi_325_0,item.delivery_sp_name);
        sSPi(R.id.fi_325_1,item.delivery_sp_designation);
        lRGv(R.id.fi_325_2, gRGI(item.d_delivery_service));
        String tmp = "";
        String tokens[];
        tmp = item.d_delivery_table;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_326_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_326_1, ind);
            }
        }
        tmp = item.d_pressure_mechine;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_327_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_327_1, ind);
            }
        }
        tmp = item.d_stethoscope;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_328_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_328_1, ind);
            }
        }
        tmp = item.d_filter_stethoscope;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_329_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_329_1, ind);
            }
        }
        tmp = item.d_newborn_recuscitation;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_330_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_330_1, ind);
            }
        }
        tmp = item.d_recuscitation_mask_0;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_331_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_331_1, ind);
            }
        }
        tmp = item.d_recuscitation_mask_1;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_332_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_332_1, ind);
            }
        }
        tmp = item.d_peguin_sucker;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_333_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_333_1, ind);
            }
        }
        lRGv(R.id.fi_334_0, gRGI(item.d_cord_cutter));
        lRGv(R.id.fi_335_0, gRGI(item.d_cord_clamp));
        lRGv(R.id.fi_336_0, gRGI(item.d_partograf_paper));
        lRGv(R.id.fi_337_0, gRGI(item.d_water));
        lRGv(R.id.fi_338_0, gRGI(item.d_hand_soap));
        lRGv(R.id.fi_339_0, gRGI(item.d_spirit));
        lRGv(R.id.fi_340_0, gRGI(item.d_waste_recycle));
        lRGv(R.id.fi_341_0, gRGI(item.d_waste_storage));
        lRGv(R.id.fi_342_0, gRGI(item.d_latex_gloves));
        lRGv(R.id.fi_343_0, gRGI(item.d_chlorine_sol));
        lRGv(R.id.fi_344_0, gRGI(item.d_detergent_water));
        lRGv(R.id.fi_345_0, gRGI(item.d_clean_water));
        lRGv(R.id.fi_346_0, gRGI(item.d_misoprostol));
        lRGv(R.id.fi_347_0, gRGI(item.d_oxytocin));
        lRGv(R.id.fi_348_0, gRGI(item.d_mang_sulfate));
        lRGv(R.id.fi_349_0, gRGI(item.d_chlorhexidine));
        lRGv(R.id.fi_350_0, gRGI(item.d_paediatric_drop));
        lRGv(R.id.fi_351_0, gRGI(item.d_gentamycin));


    }

    private void editable4(boolean state){
        sVEs(R.id.fi_325_0,state);
        sVEs(R.id.fi_325_1,state);
        sRGs(R.id.fi_325_2, state);
        sRGs(R.id.fi_326_0, state);
        sRGs(R.id.fi_326_1, state);
        sRGs(R.id.fi_327_0, state);
        sRGs(R.id.fi_327_1, state);
        sRGs(R.id.fi_328_0, state);
        sRGs(R.id.fi_328_1, state);
        sRGs(R.id.fi_329_0, state);
        sRGs(R.id.fi_329_1, state);
        sRGs(R.id.fi_330_0, state);
        sRGs(R.id.fi_330_1, state);
        sRGs(R.id.fi_331_0, state);
        sRGs(R.id.fi_331_1, state);
        sRGs(R.id.fi_332_0, state);
        sRGs(R.id.fi_332_1, state);
        sRGs(R.id.fi_333_0, state);
        sRGs(R.id.fi_333_1, state);
        sRGs(R.id.fi_334_0, state);
        sRGs(R.id.fi_335_0, state);
        sRGs(R.id.fi_336_0, state);
        sRGs(R.id.fi_337_0, state);
        sRGs(R.id.fi_338_0, state);
        sRGs(R.id.fi_339_0, state);
        sRGs(R.id.fi_340_0, state);
        sRGs(R.id.fi_341_0, state);
        sRGs(R.id.fi_342_0, state);
        sRGs(R.id.fi_343_0, state);
        sRGs(R.id.fi_344_0, state);
        sRGs(R.id.fi_345_0, state);
        sRGs(R.id.fi_346_0, state);
        sRGs(R.id.fi_347_0, state);
        sRGs(R.id.fi_348_0, state);
        sRGs(R.id.fi_349_0, state);
        sRGs(R.id.fi_350_0, state);
        sRGs(R.id.fi_351_0, state);


    }

    private void loadData3(InventoryItem item){
        sETv(R.id.fi_301_0,item.equipment_sp_name);
        sSPi(R.id.fi_301_1,item.equipment_sp_designation);
        String tmp = "";
        String tokens[];
        tmp = item.n_adult_wing_scale;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_302_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_302_1, ind);
            }
        }
        tmp = item.n_height_rod;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_303_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_303_1, ind);
            }
        }
        tmp = item.n_pressure_mechine;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_304_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_304_1, ind);
            }
        }
        tmp = item.n_stethoscope;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_305_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_305_1, ind);
            }
        }
        tmp = item.n_filter_stethoscope;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_306_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_306_1, ind);
            }
        }
        lRGv(R.id.fi_307_0, gRGI(item.n_water));
        lRGv(R.id.fi_308_0, gRGI(item.n_hand_soap));
        lRGv(R.id.fi_309_0, gRGI(item.n_spirit));
        lRGv(R.id.fi_310_0, gRGI(item.n_waste));
        lRGv(R.id.fi_311_0, gRGI(item.n_sharp_waste));
        lRGv(R.id.fi_312_0, gRGI(item.n_gloves));
        lRGv(R.id.fi_313_0, gRGI(item.n_iron_folate));
        tmp = item.n_urine_protien;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_314_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_314_1, ind);
            }
        }
        lRGv(R.id.fi_315_0, gRGI(item.n_urine_tester));
        lRGv(R.id.fi_316_0, gRGI(item.n_urine_testtube));
        lRGv(R.id.fi_317_0, gRGI(item.n_test_tube_rack));
        lRGv(R.id.fi_318_0, gRGI(item.n_dip_stick));
        tmp = item.n_hemoglobin;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_319_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_319_1, ind);

            }
//
        }
        lRGv(R.id.fi_320_0, gRGI(item.n_telecoil_book));
        lRGv(R.id.fi_321_0, gRGI(item.n_telecoil_landset));
        lRGv(R.id.fi_322_0, gRGI(item.n_kolori_meter));
        lRGv(R.id.fi_323_0, gRGI(item.n_litmus_paper));


    }
    private void editable3(boolean state){
        sVEs(R.id.fi_301_0,state);
        sVEs(R.id.fi_301_1,state);
        sRGs(R.id.fi_302_0, state);
        sRGs(R.id.fi_302_1, state);
        sRGs(R.id.fi_303_0, state);
        sRGs(R.id.fi_303_1, state);
        sRGs(R.id.fi_304_0, state);
        sRGs(R.id.fi_304_1, state);
        sRGs(R.id.fi_305_0, state);
        sRGs(R.id.fi_305_1, state);
        sRGs(R.id.fi_306_0, state);
        sRGs(R.id.fi_306_1, state);
        sRGs(R.id.fi_307_0, state);
        sRGs(R.id.fi_308_0, state);
        sRGs(R.id.fi_309_0, state);
        sRGs(R.id.fi_310_0, state);
        sRGs(R.id.fi_311_0, state);
        sRGs(R.id.fi_312_0, state);
        sRGs(R.id.fi_313_0, state);
        sRGs(R.id.fi_314_0, state);
        sRGs(R.id.fi_314_1, state);
        sRGs(R.id.fi_315_0, state);
        sRGs(R.id.fi_316_0, state);
        sRGs(R.id.fi_317_0, state);
        sRGs(R.id.fi_318_0, state);
        sRGs(R.id.fi_319_0, state);
        sRGs(R.id.fi_319_1, state);
        sRGs(R.id.fi_320_0, state);
        sRGs(R.id.fi_321_0, state);
        sRGs(R.id.fi_322_0, state);
        sRGs(R.id.fi_323_0, state);


    }
    private String gSPi(int id) throws Exception {
        Spinner sp = (Spinner) view.findViewById(id);
        int selection = sp.getSelectedItemPosition();
        if(selection == 0) throw new Exception();
        return Integer.toString(selection);
    }
    private void sSPi(int id,String val){
        Spinner sp = (Spinner) view.findViewById(id);
        try{
            sp.setSelection(Integer.parseInt(val));
        }catch(Exception e){
            e.printStackTrace();
            sp.setSelection(0);
        }
    }

    private void loadData1(InventoryItem item){
        sETv(R.id.fi_101_0,item.instrument_sp_name);
        sSPi(R.id.fi_101_1,item.instrument_sp_designation);
        String tmp = "";
        String tokens[] = new String[0];
        tmp = item.i_electronic_autoclev;
        if(tmp != null) {
            tokens = tmp.split(",");
        }
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_1_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_1_1, ind);
            }
            else if(i == 2){
                lRGv(R.id.fi_1_2, ind);
            }
        }

        tmp = item.i_non_electronic_autoclev;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_2_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_2_1, ind);
            }
            else if(i == 2){
                lRGv(R.id.fi_2_2, ind);
            }
        }

        tmp = item.i_electric_sterilizer;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_3_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_3_1, ind);
            }
            else if(i == 2){
                lRGv(R.id.fi_3_2, ind);
            }
        }

        tmp = item.i_electric_steamer;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_4_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_4_1, ind);
            }
            else if(i == 2){
                lRGv(R.id.fi_4_2, ind);
            }
        }

        tmp = item.i_non_electric_pot;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_5_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_5_1, ind);
            }
            else if(i == 2){
                lRGv(R.id.fi_5_2, ind);
            }
        }

        tmp = item.i_stove;
        tokens = tmp.split(",");
        for(int i=0;i<tokens.length;i++){
            int ind = gRGI(tokens[i]);
            if(i == 0) {
                lRGv(R.id.fi_6_0, ind);
            }
            else if(i == 1){
                lRGv(R.id.fi_6_1, ind);
            }
            else if(i == 2){
                lRGv(R.id.fi_6_2, ind);
            }
        }

    }

    private void sVEs(int id, boolean state){
        view.findViewById(id).setEnabled(state);
    }

    private void sRGs(int id,boolean state){
        RadioGroup radioGroup = (RadioGroup) view.findViewById(id);
        for(int i=0;i<radioGroup.getChildCount();i++){
            RadioButton btn = (RadioButton) radioGroup.getChildAt(i);
            btn.setEnabled(state);
        }
    }

    private void editable1(boolean state){
        sVEs(R.id.fi_101_0,state);
        sVEs(R.id.fi_101_1,state);
        sRGs(R.id.fi_1_0, state);
        sRGs(R.id.fi_1_1, state);
        sRGs(R.id.fi_1_2, state);
        sRGs(R.id.fi_2_0, state);
        sRGs(R.id.fi_2_1, state);
        sRGs(R.id.fi_2_2, state);
        sRGs(R.id.fi_3_0, state);
        sRGs(R.id.fi_3_1, state);
        sRGs(R.id.fi_3_2, state);
        sRGs(R.id.fi_4_0, state);
        sRGs(R.id.fi_4_1, state);
        sRGs(R.id.fi_4_2, state);
        sRGs(R.id.fi_5_0, state);
        sRGs(R.id.fi_5_1, state);
        sRGs(R.id.fi_5_2, state);
        sRGs(R.id.fi_6_0, state);
        sRGs(R.id.fi_6_1, state);
        sRGs(R.id.fi_6_2, state);
    }

    private void collectData6(InventoryItem item){
        item.r_healthy_newborn = gETv(R.id.fi_601_1)+ "," + gETv(R.id.fi_601_2) +"," + gETv(R.id.fi_601_3)+ "," +gETv(R.id.fi_601_4);
        item.r_newborn_death = gETv(R.id.fi_602_1)+ "," + gETv(R.id.fi_602_2) +"," + gETv(R.id.fi_602_3)+ "," +gETv(R.id.fi_602_4);
        item.r_mother_rate = gETv(R.id.fi_603_1)+ "," + gETv(R.id.fi_603_2) +"," + gETv(R.id.fi_603_3)+ "," +gETv(R.id.fi_603_4);

        item.r_elampsia = gETv(R.id.fi_604_1)+ "," + gETv(R.id.fi_604_2) +"," + gETv(R.id.fi_604_3)+ "," +gETv(R.id.fi_604_4);
        item.r_mang_sulfate = gETv(R.id.fi_605_1)+ "," + gETv(R.id.fi_605_2) +"," + gETv(R.id.fi_605_3)+ "," +gETv(R.id.fi_605_4);

        item.r_pneumonis = gETv(R.id.fi_606_1)+ "," + gETv(R.id.fi_606_2) +"," + gETv(R.id.fi_606_3)+ "," +gETv(R.id.fi_606_4);
        item.r_paracetamol = gETv(R.id.fi_607_1)+ "," + gETv(R.id.fi_607_2) +"," + gETv(R.id.fi_607_3)+ "," +gETv(R.id.fi_607_4);
        item.r_psbi = gETv(R.id.fi_608_1)+ "," + gETv(R.id.fi_608_2) +"," + gETv(R.id.fi_608_3)+ "," +gETv(R.id.fi_608_4);
        item.r_psbi_care = gETv(R.id.fi_609_1)+ "," + gETv(R.id.fi_609_2) +"," + gETv(R.id.fi_609_3)+ "," +gETv(R.id.fi_609_4);
        item.r_starving_child = gETv(R.id.fi_610_1)+ "," + gETv(R.id.fi_610_2) +"," + gETv(R.id.fi_610_3)+ "," +gETv(R.id.fi_610_4);
        item.r_starving_protocol = gETv(R.id.fi_611_1)+ "," + gETv(R.id.fi_611_2) +"," + gETv(R.id.fi_611_3)+ "," +gETv(R.id.fi_611_4);
        item.end_time = gETv(R.id.fi_612);
    }

    private void collectData1(InventoryItem item) throws Exception {
        if( (item.instrument_sp_name = gETv(R.id.fi_101_0)) == null){
            throw new Exception();
        }
        if( (item.instrument_sp_designation = gSPi(R.id.fi_101_1)) == null){
            throw new Exception();
        }
        String tmp = "";
        tmp = gRGv(R.id.fi_1_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_1_1);
            tmp += ("," + v);
            if(v.equals("1")){
                tmp += ("," + gRGv(R.id.fi_1_2)) ;
            }
        }
        item.i_electronic_autoclev = tmp;

        tmp = gRGv(R.id.fi_2_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_2_1);
            tmp += ("," + v);
            if(v.equals("1")){
                tmp += ("," + gRGv(R.id.fi_2_2)) ;
            }
        }
        item.i_non_electronic_autoclev = tmp;

        tmp = gRGv(R.id.fi_3_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_3_1);
            tmp += ("," + v);
            if(v.equals("1")){
                tmp += ("," + gRGv(R.id.fi_3_2)) ;
            }
        }
        item.i_electric_sterilizer = tmp;

        tmp = gRGv(R.id.fi_4_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_4_1);
            tmp += ("," + v);
            if(v.equals("1")){
                tmp += ("," + gRGv(R.id.fi_4_2)) ;
            }
        }
        item.i_electric_steamer = tmp;

        tmp = gRGv(R.id.fi_5_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_5_1);
            tmp += ("," + v);
            if(v.equals("1")){
                tmp += ("," + gRGv(R.id.fi_5_2)) ;
            }
        }
        item.i_non_electric_pot = tmp;

        tmp = gRGv(R.id.fi_6_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_6_1);
            tmp += ("," + v);
            if(v.equals("1")){
                tmp += ("," + gRGv(R.id.fi_6_2)) ;
            }
        }
        item.i_stove = tmp;

    }
    private void collectData3(InventoryItem item) throws Exception {
        if( (item.equipment_sp_name = gETv(R.id.fi_301_0)) == null){
            throw new Exception();
        }
        if( (item.equipment_sp_designation = gSPi(R.id.fi_301_1)) == null){
            throw new Exception();
        }
        String tmp = "";
        tmp = gRGv(R.id.fi_302_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_302_1);
            tmp += ("," + v);
        }
        item.n_adult_wing_scale = tmp;
        tmp = gRGv(R.id.fi_303_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_303_1);
            tmp += ("," + v);
        }
        item.n_height_rod = tmp;
        tmp = gRGv(R.id.fi_304_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_304_1);
            tmp += ("," + v);
        }
        item.n_pressure_mechine = tmp;
        tmp = gRGv(R.id.fi_305_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_305_1);
            tmp += ("," + v);
        }
        item.n_stethoscope = tmp;
        tmp = gRGv(R.id.fi_306_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_306_1);
            tmp += ("," + v);
        }
        item.n_filter_stethoscope = tmp;
        item.n_water = gRGv(R.id.fi_307_0);
        item.n_hand_soap = gRGv(R.id.fi_308_0);
        item.n_spirit = gRGv(R.id.fi_309_0);
        item.n_waste = gRGv(R.id.fi_310_0);
        item.n_sharp_waste = gRGv(R.id.fi_311_0);
        item.n_gloves = gRGv(R.id.fi_312_0);
        item.n_iron_folate = gRGv(R.id.fi_313_0);
        tmp = gRGv(R.id.fi_314_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_314_1);
            tmp += ("," + v);
        }
        item.n_urine_protien = tmp;
        item.n_urine_tester = gRGv(R.id.fi_315_0);
        item.n_urine_testtube = gRGv(R.id.fi_316_0);
        item.n_test_tube_rack = gRGv(R.id.fi_317_0);
        item.n_dip_stick = gRGv(R.id.fi_318_0);
        tmp = gRGv(R.id.fi_319_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_319_1);
            tmp += ("," + v);


        }
        item.n_hemoglobin = tmp;
        item.n_telecoil_book = gRGv(R.id.fi_320_0);
        item.n_telecoil_landset = gRGv(R.id.fi_321_0);
        item.n_kolori_meter = gRGv(R.id.fi_322_0);
        item.n_litmus_paper = gRGv(R.id.fi_323_0);
    }
    private void collectData4(InventoryItem item) throws Exception {
        if( (item.delivery_sp_name = gETv(R.id.fi_325_0)) == null){
            throw new Exception();
        }
        if( (item.delivery_sp_designation = gSPi(R.id.fi_325_1)) == null){
            throw new Exception();
        }
        item.d_delivery_service = gRGv(R.id.fi_325_2);
        String tmp = "";
        tmp = gRGv(R.id.fi_326_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_326_1);
            tmp += ("," + v);
        }
        item.d_delivery_table = tmp;
        tmp = gRGv(R.id.fi_327_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_327_1);
            tmp += ("," + v);
        }
        item.d_pressure_mechine = tmp;
        tmp = gRGv(R.id.fi_328_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_328_1);
            tmp += ("," + v);
        }
        item.d_stethoscope = tmp;
        tmp = gRGv(R.id.fi_329_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_329_1);
            tmp += ("," + v);
        }
        item.d_filter_stethoscope = tmp;
        tmp = gRGv(R.id.fi_330_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_330_1);
            tmp += ("," + v);
        }
        item.d_newborn_recuscitation = tmp;
        tmp = gRGv(R.id.fi_331_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_331_1);
            tmp += ("," + v);
        }
        item.d_recuscitation_mask_0 = tmp;
        tmp = gRGv(R.id.fi_332_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_332_1);
            tmp += ("," + v);
        }
        item.d_recuscitation_mask_1 = tmp;
        tmp = gRGv(R.id.fi_333_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_333_1);
            tmp += ("," + v);
        }
        item.d_peguin_sucker = tmp;
        item.d_cord_cutter = gRGv(R.id.fi_334_0);
        item.d_cord_clamp = gRGv(R.id.fi_335_0);
        item.d_partograf_paper = gRGv(R.id.fi_336_0);
        item.d_water = gRGv(R.id.fi_337_0);
        item.d_hand_soap = gRGv(R.id.fi_338_0);
        item.d_spirit = gRGv(R.id.fi_339_0);
        item.d_waste_recycle = gRGv(R.id.fi_340_0);
        item.d_waste_storage = gRGv(R.id.fi_341_0);
        item.d_latex_gloves = gRGv(R.id.fi_342_0);
        item.d_chlorine_sol = gRGv(R.id.fi_343_0);
        item.d_detergent_water = gRGv(R.id.fi_344_0);
        item.d_clean_water = gRGv(R.id.fi_345_0);
        item.d_misoprostol = gRGv(R.id.fi_346_0);
        item.d_oxytocin = gRGv(R.id.fi_347_0);
        item.d_mang_sulfate = gRGv(R.id.fi_348_0);
        item.d_chlorhexidine = gRGv(R.id.fi_349_0);
        item.d_paediatric_drop = gRGv(R.id.fi_350_0);
        item.d_gentamycin = gRGv(R.id.fi_351_0);

    }
    private void collectData5(InventoryItem item){
        String tmp = "";
        tmp = gRGv(R.id.fi_401_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_401_1);
            tmp += ("," + v);
        }
        item.ch_wing_scale = tmp;
        tmp = gRGv(R.id.fi_402_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_402_1);
            tmp += ("," + v);
        }
        item.ch_infant_wing_scale = tmp;
        tmp = gRGv(R.id.fi_403_0);
        if(tmp.equals("1")){
            String v = gRGv(R.id.fi_403_1);
            tmp += ("," + v);
        }
        item.ch_height_rod = tmp;
        item.ch_measuring_tip = gRGv(R.id.fi_404_0);
        item.ch_water = gRGv(R.id.fi_405_0);
        item.ch_growth_monitor_boy = gRGv(R.id.fi_406_0);
        item.ch_growth_monitor_girl = gRGv(R.id.fi_407_0);
        item.ch_hand_soap = gRGv(R.id.fi_408_0);
        item.ch_spirit = gRGv(R.id.fi_409_0);
        item.ch_wastage_recycle = gRGv(R.id.fi_410_0);
        item.ch_sharp_waste = gRGv(R.id.fi_411_0);
        item.ch_latex_gloves = gRGv(R.id.fi_412_0);
        item.ch_ors = gRGv(R.id.fi_413_0);
        item.ch_paediatric_drop = gRGv(R.id.fi_414_0);
        item.ch_cotrimoxazole = gRGv(R.id.fi_415_0);
        item.ch_paracetamol = gRGv(R.id.fi_416_0);
        item.ch_zinc = gRGv(R.id.fi_417_0);
        item.ch_mebandazole = gRGv(R.id.fi_418_0);
        item.ch_ceftriaxone = gRGv(R.id.fi_419_0);
        item.ch_vitamin = gRGv(R.id.fi_420_0);
        item.fp_soap = gRGv(R.id.fi_501_0);
        item.fp_spirit = gRGv(R.id.fi_502_0);
        item.fp_waste_recycle = gRGv(R.id.fi_503_0);
        item.fp_sharp_waste = gRGv(R.id.fi_504_0);
        item.fp_latex_gloves = gRGv(R.id.fi_505_0);

    }
    private void collectData2(InventoryItem item) throws Exception {
        if( (item.i_waste_sp_name = gETv(R.id.fi_201_0)) == null){
            throw new Exception();
        }
        if( (item.i_waste_sp_designation = gSPi(R.id.fi_201_1)) == null){
            throw new Exception();
        }
        item.w_waste_option = gCBv(R.id.fi_202_1) + "," + gCBv(R.id.fi_202_2) + "," +gCBv(R.id.fi_202_3);
        item.w_waste_dispose_how = gCBv(R.id.fi_203_1) + "," + gCBv(R.id.fi_203_2) + ","+
                gCBv(R.id.fi_203_3) + "," + gCBv(R.id.fi_203_4) + "," + gCBv(R.id.fi_203_5) + "," + gCBv(R.id.fi_203_6) + "," + gCBv(R.id.fi_203_7) + "," + gCBv(R.id.fi_203_8) + "," + gCBv(R.id.fi_203_9);
        if(view.findViewById(R.id.fi_204_1).isEnabled()) {
            item.w_pointy_waste = gCBv(R.id.fi_204_1) + "," + gCBv(R.id.fi_204_2) + "," + gCBv(R.id.fi_204_3) + "," + gCBv(R.id.fi_204_4);
        }
        item.w_liquid_waste = gCBv(R.id.fi_205_1) + "," + gCBv(R.id.fi_205_2) + ","+ gCBv(R.id.fi_205_3) + "," + gCBv(R.id.fi_205_4)+ "," + gCBv(R.id.fi_205_5)+ "," + gCBv(R.id.fi_205_6)+ "," + gCBv(R.id.fi_205_7)+ "," + gCBv(R.id.fi_205_8)+ "," + gCBv(R.id.fi_205_9);
        if(view.findViewById(R.id.fi_206_1).isEnabled()) {
            item.w_liquid_waste_store = gCBv(R.id.fi_206_1) + "," + gCBv(R.id.fi_206_2) + "," + gCBv(R.id.fi_206_3) + "," + gCBv(R.id.fi_206_4);
        }
        item.w_plastic_waste = gCBv(R.id.fi_207_1) + "," + gCBv(R.id.fi_207_2) + ","+ gCBv(R.id.fi_207_3) + "," + gCBv(R.id.fi_207_4);
        item.w_waste_normal = gCBv(R.id.fi_208_1) + "," + gCBv(R.id.fi_208_2) + ","+ gCBv(R.id.fi_208_3) + "," + gCBv(R.id.fi_208_4);
        item.w_incinerator_seen = gCBv(R.id.fi_210_1) + "," + gCBv(R.id.fi_210_2);
        item.w_dumping_pit_seen = gCBv(R.id.fi_212_1) + "," + gCBv(R.id.fi_212_2);
    }

    private void loadData2(InventoryItem item){
        ((CheckBox)view.findViewById(R.id.fi_203_9)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sVEs(R.id.fi_204_1,!isChecked);
                sVEs(R.id.fi_204_2,!isChecked);
                sVEs(R.id.fi_204_3,!isChecked);
                sVEs(R.id.fi_204_4,!isChecked);
            }
        });
        ((CheckBox)view.findViewById(R.id.fi_205_9)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sVEs(R.id.fi_206_1,!isChecked);
                sVEs(R.id.fi_206_2,!isChecked);
                sVEs(R.id.fi_206_3,!isChecked);
                sVEs(R.id.fi_206_4,!isChecked);
            }
        });
        String tokens[];
        sETv(R.id.fi_201_0,item.i_waste_sp_name);
        sSPi(R.id.fi_201_1,item.i_waste_sp_designation);
        tokens = item.w_waste_option.split(",");
        for(int i=0;i<tokens.length;i++){
            switch(i){
                case 0:
                    sCBv(R.id.fi_202_1,tokens[i]);
                    break;
                case 1:
                    sCBv(R.id.fi_202_2,tokens[i]);
                    break;
                case 2:
                    sCBv(R.id.fi_202_3,tokens[i]);
                    break;
            }
        }
        tokens = item.w_waste_dispose_how.split(",");
        for(int i=0;i<tokens.length;i++){
            switch(i){
                case 0:
                    sCBv(R.id.fi_203_1,tokens[i]);
                    break;
                case 1:
                    sCBv(R.id.fi_203_2,tokens[i]);
                    break;
                case 2:
                    sCBv(R.id.fi_203_3,tokens[i]);
                    break;
                case 3:
                    sCBv(R.id.fi_203_4,tokens[i]);
                    break;
                case 4:
                    sCBv(R.id.fi_203_5,tokens[i]);
                    break;
                case 5:
                    sCBv(R.id.fi_203_6,tokens[i]);
                    break;
                case 6:
                    sCBv(R.id.fi_203_7,tokens[i]);
                    break;
                case 7:
                    sCBv(R.id.fi_203_8,tokens[i]);
                    break;
                case 8:
                    sCBv(R.id.fi_203_9,tokens[i]);
                    break;
            }
        }
        tokens = item.w_pointy_waste.split(",");
        for(int i=0;i<tokens.length;i++){
            switch(i){
                case 0:
                    sCBv(R.id.fi_204_1,tokens[i]);
                    break;
                case 1:
                    sCBv(R.id.fi_204_2,tokens[i]);
                    break;
                case 2:
                    sCBv(R.id.fi_204_3,tokens[i]);
                    break;
                case 3:
                    sCBv(R.id.fi_204_4,tokens[i]);
                    break;
            }
        }
        tokens = item.w_liquid_waste.split(",");
        for(int i=0;i<tokens.length;i++){
            switch(i){
                case 0:
                    sCBv(R.id.fi_205_1,tokens[i]);
                    break;
                case 1:
                    sCBv(R.id.fi_205_2,tokens[i]);
                    break;
                case 2:
                    sCBv(R.id.fi_205_3,tokens[i]);
                    break;
                case 3:
                    sCBv(R.id.fi_205_4,tokens[i]);
                    break;
                case 4:
                    sCBv(R.id.fi_205_5,tokens[i]);
                    break;
                case 5:
                    sCBv(R.id.fi_205_6,tokens[i]);
                    break;
                case 6:
                    sCBv(R.id.fi_205_7,tokens[i]);
                    break;
                case 7:
                    sCBv(R.id.fi_205_8,tokens[i]);
                    break;
                case 8:
                    sCBv(R.id.fi_205_9,tokens[i]);
                    break;
            }
        }
        tokens = item.w_liquid_waste_store.split(",");
        for(int i=0;i<tokens.length;i++){
            switch(i){
                case 0:
                    sCBv(R.id.fi_206_1,tokens[i]);
                    break;
                case 1:
                    sCBv(R.id.fi_206_2,tokens[i]);
                    break;
                case 2:
                    sCBv(R.id.fi_206_3,tokens[i]);
                    break;
                case 3:
                    sCBv(R.id.fi_206_4,tokens[i]);
                    break;
            }
        }
        tokens = item.w_plastic_waste.split(",");
        for(int i=0;i<tokens.length;i++){
            switch(i){
                case 0:
                    sCBv(R.id.fi_207_1,tokens[i]);
                    break;
                case 1:
                    sCBv(R.id.fi_207_2,tokens[i]);
                    break;
                case 2:
                    sCBv(R.id.fi_207_3,tokens[i]);
                    break;
                case 3:
                    sCBv(R.id.fi_207_4,tokens[i]);
                    break;
            }
        }
        tokens = item.w_waste_normal.split(",");
        for(int i=0;i<tokens.length;i++){
            switch(i){
                case 0:
                    sCBv(R.id.fi_208_1,tokens[i]);
                    break;
                case 1:
                    sCBv(R.id.fi_208_2,tokens[i]);
                    break;
                case 2:
                    sCBv(R.id.fi_208_3,tokens[i]);
                    break;
                case 3:
                    sCBv(R.id.fi_208_4,tokens[i]);
                    break;
            }
        }
        tokens = item.w_incinerator_seen.split(",");
        for(int i=0;i<tokens.length;i++){
            switch(i){
                case 0:
                    sCBv(R.id.fi_210_1,tokens[i]);
                    break;
                case 1:
                    sCBv(R.id.fi_210_2,tokens[i]);
                    break;
            }
        }
        tokens = item.w_dumping_pit_seen.split(",");
        for(int i=0;i<tokens.length;i++){
            switch(i){
                case 0:
                    sCBv(R.id.fi_212_1,tokens[i]);
                    break;
                case 1:
                    sCBv(R.id.fi_212_2,tokens[i]);
                    break;
            }
        }
    }

    private void editable2(boolean state){
        sVEs(R.id.fi_201_0,state);
        sVEs(R.id.fi_201_1,state);
        sVEs(R.id.fi_202_1,state);
        sVEs(R.id.fi_202_2,state);
        sVEs(R.id.fi_202_3,state);
        sVEs(R.id.fi_203_1,state);
        sVEs(R.id.fi_203_2,state);
        sVEs(R.id.fi_203_3,state);
        sVEs(R.id.fi_203_4,state);
        sVEs(R.id.fi_203_5,state);
        sVEs(R.id.fi_203_6,state);
        sVEs(R.id.fi_203_7,state);
        sVEs(R.id.fi_203_8,state);
        sVEs(R.id.fi_203_9,state);
        sVEs(R.id.fi_204_1,state);
        sVEs(R.id.fi_204_2,state);
        sVEs(R.id.fi_204_3,state);
        sVEs(R.id.fi_204_4,state);
        sVEs(R.id.fi_205_1,state);
        sVEs(R.id.fi_205_2,state);
        sVEs(R.id.fi_205_3,state);
        sVEs(R.id.fi_205_4,state);
        sVEs(R.id.fi_205_5,state);
        sVEs(R.id.fi_205_6,state);
        sVEs(R.id.fi_205_7,state);
        sVEs(R.id.fi_205_8,state);
        sVEs(R.id.fi_205_9,state);
        sVEs(R.id.fi_206_1,state);
        sVEs(R.id.fi_206_2,state);
        sVEs(R.id.fi_206_3,state);
        sVEs(R.id.fi_206_4,state);
        sVEs(R.id.fi_207_1,state);
        sVEs(R.id.fi_207_2,state);
        sVEs(R.id.fi_207_3,state);
        sVEs(R.id.fi_207_4,state);
        sVEs(R.id.fi_208_1,state);
        sVEs(R.id.fi_208_2,state);
        sVEs(R.id.fi_208_3,state);
        sVEs(R.id.fi_208_4,state);
        sVEs(R.id.fi_210_1,state);
        sVEs(R.id.fi_210_2,state);
        sVEs(R.id.fi_212_1,state);
        sVEs(R.id.fi_212_2,state);
    }

    private int gRGI(String value){//radio group index
        if(TextUtils.isEmpty(value)) return -1;
        if(value.equals("1")){
            return 0;//yes
        }
        else if(value.equals("0")){
            return 1;// no
        }
        else if(value.equals("8")){
            return 2;//don't know
        }
        else{//uknown value
            return 1;
        }
    }
    private String gETv(int id){
        EditText eText = (EditText) view.findViewById(id);
        if(TextUtils.isEmpty(eText.getText())){
            throw  new NullPointerException();
        }
        else{
            return eText.getText().toString();
        }
    }
    private void sETv(int id,String value){
        if(value != null){
            ((EditText)view.findViewById(id)).setText(value);
        }
    }
    private void sCBv(int id,String check){
        boolean checked = false;
        if(check != null && check.equals("1")){
            checked = true;
        }
        ((CheckBox)view.findViewById(id)).setChecked(checked);
    }
    private static final String radioValue[] = new String[]{"1","0","8"};//yes,no, don't know
    private String gCBv(int id){
        CheckBox chbox = (CheckBox) view.findViewById(id);
        if(chbox.isChecked()){
            return "1";
        }
        else{
            return "0";
        }
    }
    private String gRGv(int id){
        RadioGroup group = (RadioGroup) view.findViewById(id);
        int radioId = group.getCheckedRadioButtonId();
        int index = group.indexOfChild(view.findViewById(radioId));
        return radioValue[index];
    }

    private void lRGv(int id,int index){
        RadioGroup group = (RadioGroup) view.findViewById(id);
        RadioButton btn = (RadioButton) group.getChildAt(index);
        btn.setChecked(true);
    }

    private void lRGvDisable(int id,int index){
        RadioGroup group = (RadioGroup) view.findViewById(id);
        RadioButton btn = (RadioButton) group.getChildAt(index);
        btn.setChecked(false);
    }

    public String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
        return dateFormat.format(new Date()).toString();
    }

}
