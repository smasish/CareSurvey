package caresurvey.sci.com.caresurvey.model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Mazharul.Islam1 on 4/24/2016.
 */
public class SickChildItemSupervisor {

    private int id;

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
    private String fields;
    private String comments;
    private String status;
    private int server_id;


    public SickChildItemSupervisor(int id,int facility_id,String sp_client,String sp_designataion,
                                   String serial_no, String form_date, String start_time, String child_description,
                                   String age, String feed, String vomit, String stutter, String cough,
                                   String diahorea,String fever, String measure_fever, String stethoscope,
                                   String breathing_test, String eye_test, String infected_mouth,String neck,
                                   String ear, String hand, String dehydration, String weight, String clinic_test,
                                   String belly_button, String height, String end_time,String result, String village, String district,
                                   String union,String sub_district, String ct_client,String fields,String comments,String status,int server_id)
    {   this.id =id;

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
        this.fields= fields;
        this.comments=comments;
        this.status=status;
        this.server_id=server_id;


    }

    public SickChildItemSupervisor(int increment, String facility_id, String sp_client, String sp_designation, String seral_no, String child_description, String age, String feed, String vomit, String stutter, String cough, String diaria, String fever, int status, String measure_fever, String stethoscope, String breathing_test, String eye_test, String infected_mouth, String neck, String ear, String hand, String dehydration, String weight, String clinic_test, String belly_button, String height, String end_time, String village, String union, String district, String sub_district, String result, int status1, String server_id, String ct_client) {

        this.id =increment;

        this.facility_id = Integer.parseInt(facility_id);
        this.sp_client = sp_client;
        this.so_designation= sp_designation;
        this.serial_no = seral_no;
        this.child_description = child_description;
        this.age = age;
        this.feed =feed;
        this.vomit=  vomit;
        this.stutter =stutter;
        this.cough =cough;
        this.diahorea =diaria;
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

        this.status=String.valueOf(status1);
        this.server_id=Integer.parseInt(server_id);


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServer_id() {
        return server_id;
    }

    public void setServer_id(int server_id) {
        this.server_id = server_id;
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

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public static SickChildItemSupervisor parseSickChildItemSupervisor(int increment,String formId,int _status, JSONObject jo,String submitted_by) throws JSONException {
        int increments  = increment;
        String facility_id = jo.getString("facility_id");
        String sp_client = jo.getString("sp_client");
        String sp_designation = jo.getString("sp_designation");
        String seral_no = jo.getString("seral_no");
        String child_description = jo.getString("child_description");
        String age = jo.getString("age");
        String feed = jo.getString("feed");
        String vomit = jo.getString("vomit");
        String stutter = jo.getString("stutter");
        String cough = jo.getString("cough");
        String diaria = jo.getString("diaria");
        String fever = jo.getString("fever");
        String measure_fever = jo.getString("measure_fever");
        String stethoscope = jo.getString("stethoscope");
        String breathing_test = jo.getString("breathing_test");
        String eye_test = jo.getString("eye_test");
        String infected_mouth = jo.getString("infected_mouth");
        String neck = jo.getString("neck");
        String ear = jo.getString("ear");
        String hand = jo.getString("hand");
        String dehydration = jo.getString("dehydration");
        String weight = jo.getString("weight");
        String clinic_test = jo.getString("clinic_test");
        String belly_button = jo.getString("belly_button");
        String height = jo.getString("height");
        String end_time = jo.getString("end_time");
        String village = jo.getString("village");
        String union = jo.getString("union");
        String district = jo.getString("district");
        String sub_district = jo.getString("sub_district");
        String result = jo.getString("result");
        int status=_status;
        String server_id = formId;
        String ct_client =submitted_by;

        Log.d("...>>>","increments "+increments );
        return new SickChildItemSupervisor(increments,facility_id,sp_client,sp_designation,seral_no,child_description,age,
                feed,vomit,stutter,cough,diaria,fever,_status,measure_fever,stethoscope,breathing_test,
                eye_test,infected_mouth,neck,ear,hand,dehydration,weight,clinic_test,belly_button,height,
                end_time,village,union,district,sub_district,result,status,server_id,ct_client
        );
    }


}
