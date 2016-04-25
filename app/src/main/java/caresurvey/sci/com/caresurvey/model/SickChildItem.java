package caresurvey.sci.com.caresurvey.model;

import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Mazharul.Islam1 on 4/24/2016.
 */
public class SickChildItem {

    private int facility_id;
    private String sp_client;
    private String so_designation;
    private String serial_no;
    private String form_date;
    private String start_time;
    private String child_description;
    private String age;
    private String feed;
    private String vomit;
    private String stutter;
    private String cough;
    private String diahorea;
    private String fever;
    private String measure_fever;
    private String stethoscope;
    private String breathing_test;
    private String eye_test;
    private String infected_mouth;
    private String neck;
    private String ear;
    private String hand;
    private String dehydration;
    private String weight;
    private String clinic_test;
    private String belly_button;
    private String height;
    private String result;
    private String end_time;
    private String village;
    private String district;
    private String union;
    private String sub_district;
    private String ct_client;


    public SickChildItem(int facility_id,String sp_client,String sp_designataion,
                         String serial_no, String form_date, String start_time, String child_description,
                         String age, String feed, String vomit, String stutter, String cough,
                         String diahorea,String fever, String measure_fever, String stethoscope,
                         String breathing_test, String eye_test, String infected_mouth,String neck,
                         String ear, String hand, String dehydration, String weight, String clinic_test,
                         String belly_button, String height, String end_time,String result, String village, String district,
                         String union,String sub_district, String ct_client)
    {
        this.facility_id =facility_id;
        this.sp_client = sp_client;
        this.so_designation= sp_designataion;
        this.serial_no = serial_no;
        this.form_date =form_date;
        this.start_time = start_time;
        this.child_description = child_description;
        this.age = age;
        this.feed =feed;
        this.vomit=  vomit;
        this.stutter =stutter;
        this.cough =cough;
        this.diahorea =diahorea;
        this.fever = fever;
        this.measure_fever =measure_fever;
        this.stethoscope = stethoscope;
        this.breathing_test = breathing_test;
        this.eye_test = eye_test;
        this.infected_mouth = infected_mouth;
        this.neck = neck;
        this.ear =ear;
        this.hand= hand;
        this.dehydration = dehydration;
        this.weight = weight;
        this.clinic_test = clinic_test;
        this.belly_button = belly_button;
        this.height = height;
        this.end_time =end_time;
        this.result= result;
        this.village = village;
        this.district =district;
        this.union = union;
        this.sub_district = sub_district;
        this.ct_client = ct_client;


    }

    public int getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(int facility_id) {
        this.facility_id = facility_id;
    }

    public String getSp_client() {
        return sp_client;
    }

    public void setSp_client(String sp_client) {
        this.sp_client = sp_client;
    }

    public String getSo_designation() {
        return so_designation;
    }

    public void setSo_designation(String so_designation) {
        this.so_designation = so_designation;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getForm_date() {
        return form_date;
    }

    public void setForm_date(String form_date) {
        this.form_date = form_date;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getChild_description() {
        return child_description;
    }

    public void setChild_description(String child_description) {
        this.child_description = child_description;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public String getVomit() {
        return vomit;
    }

    public void setVomit(String vomit) {
        this.vomit = vomit;
    }

    public String getStutter() {
        return stutter;
    }

    public void setStutter(String stutter) {
        this.stutter = stutter;
    }

    public String getDiahorea() {
        return diahorea;
    }

    public void setDiahorea(String diahorea) {
        this.diahorea = diahorea;
    }

    public String getCough() {
        return cough;
    }

    public void setCough(String cough) {
        this.cough = cough;
    }

    public String getFever() {
        return fever;
    }

    public void setFever(String fever) {
        this.fever = fever;
    }

    public String getStethoscope() {
        return stethoscope;
    }

    public void setStethoscope(String stethoscope) {
        this.stethoscope = stethoscope;
    }

    public String getMeasure_fever() {
        return measure_fever;
    }

    public void setMeasure_fever(String measure_fever) {
        this.measure_fever = measure_fever;
    }

    public String getBreathing_test() {
        return breathing_test;
    }

    public void setBreathing_test(String breathing_test) {
        this.breathing_test = breathing_test;
    }

    public String getEye_test() {
        return eye_test;
    }

    public void setEye_test(String eye_test) {
        this.eye_test = eye_test;
    }

    public String getInfected_mouth() {
        return infected_mouth;
    }

    public void setInfected_mouth(String infected_mouth) {
        this.infected_mouth = infected_mouth;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public String getEar() {
        return ear;
    }

    public void setEar(String ear) {
        this.ear = ear;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public String getDehydration() {
        return dehydration;
    }

    public void setDehydration(String dehydration) {
        this.dehydration = dehydration;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getClinic_test() {
        return clinic_test;
    }

    public void setClinic_test(String clinic_test) {
        this.clinic_test = clinic_test;
    }

    public String getBelly_button() {
        return belly_button;
    }

    public void setBelly_button(String belly_button) {
        this.belly_button = belly_button;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUnion() {
        return union;
    }

    public void setUnion(String union) {
        this.union = union;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getSub_district() {
        return sub_district;
    }

    public void setSub_district(String sub_district) {
        this.sub_district = sub_district;
    }

    public String getCt_client() {
        return ct_client;
    }

    public void setCt_client(String ct_client) {
        this.ct_client = ct_client;
    }
}
