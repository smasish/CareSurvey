package caresurvey.sci.com.caresurvey.model;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import caresurvey.sci.com.caresurvey.utils.AppUtils;

/**
 * Created by Shahin on 5/6/2016.
 */
public class FpObservationFormItem extends DBRow{

    public int mark;
    public String description;

    public FpObservationFormItem(){
        date = AppUtils.getDate();
        start_time = AppUtils.getTime();
        end_time = AppUtils.getTime();
    }

    public String sp_client;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(String facility_id) {
        this.facility_id = facility_id;
    }

    public String getSp_name() {
        return sp_name;
    }

    public void setSp_name(String sp_name) {
        this.sp_name = sp_name;
    }

    public String getSp_designation() {
        return sp_designation;
    }

    public void setSp_designation(String sp_designation) {
        this.sp_designation = sp_designation;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getConcent() {
        return concent;
    }

    public void setConcent(String concent) {
        this.concent = concent;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSound_prove() {
        return sound_prove;
    }

    public void setSound_prove(String sound_prove) {
        this.sound_prove = sound_prove;
    }

    public String getDiscuss_fp() {
        return discuss_fp;
    }

    public void setDiscuss_fp(String discuss_fp) {
        this.discuss_fp = discuss_fp;
    }

    public String getDiscuss_fp_protocol() {
        return discuss_fp_protocol;
    }

    public void setDiscuss_fp_protocol(String discuss_fp_protocol) {
        this.discuss_fp_protocol = discuss_fp_protocol;
    }

    public String getWhat_to_do() {
        return what_to_do;
    }

    public void setWhat_to_do(String what_to_do) {
        this.what_to_do = what_to_do;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getJob_aid() {
        return job_aid;
    }

    public void setJob_aid(String job_aid) {
        this.job_aid = job_aid;
    }

    public String getFollowup() {
        return followup;
    }

    public void setFollowup(String followup) {
        this.followup = followup;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
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

    public String getSub_district() {
        return subdistrict;
    }

    public void setSub_district(String sub_district) {
        this.subdistrict = sub_district;
    }

    public String facility_id;
    public String sp_name;
    public String sp_designation;
    public String client_name;
    public String serial_no;
    public String date;
    public String start_time;
    public String concent;
    public String cover;
    public String sound_prove;
    public String discuss_fp;
    public String discuss_fp_protocol;
    public String what_to_do;
    public String questions;
    public String job_aid;
    public String followup;
    public String end_time;

    public void setSp_client(String sp_client) {
        this.sp_client = sp_client;
    }

    public static FpObservationFormItem getObject(String json){//supervisor json
        FpObservationFormItem item = new FpObservationFormItem();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject data = object.getJSONObject("data");

            item.id = object.getInt("form_id");
            item.status = object.getInt("status");
            item.user_id = Integer.toString(object.getInt("user_id"));
            if(object.has("meta")){
                try {
                    boolean b = object.getBoolean("meta");
                    if(b){
                        item.meta = "true";
                    }
                    else{
                        item.meta = "false";
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            item.submittedBy = object.getString("submitted_by");
            item.form_type = object.getString("form_type");

            item.subdistrict = AppUtils.getString(data,"sub_district");
            item.concent = AppUtils.getString(data,"concent");
            item.cover = AppUtils.btos(AppUtils.getBoolean(data,"cover"));
            item.sound_prove = AppUtils.btos(AppUtils.getBoolean(data,"sound_prove"));
            item.collector_name = item.sp_name = AppUtils.getString(data,"sp_name");
            item.questions = AppUtils.btos(AppUtils.getBoolean(data,"questions"));
            item.discuss_fp = AppUtils.btos(AppUtils.getBoolean(data,"discuss_fp"));
            item.discuss_fp_protocol = AppUtils.btos(AppUtils.getBoolean(data,"discuss_fp_protocol"));
            item.date = AppUtils.getString(data,"date");
            item.facility_id = AppUtils.itos(AppUtils.getInt(data,"facility_id"));
            item.sp_designation = AppUtils.getString(data,"sp_designation");
            item.serial_no = AppUtils.itos(AppUtils.getInt(data,"serial_no"));
            item.village = AppUtils.getString(data,"village");
            item.union = AppUtils.getString(data,"union");
            item.start_time = AppUtils.getString(data,"start_time");
            item.end_time = AppUtils.getString(data,"end_time");
            item.followup = AppUtils.btos(AppUtils.getBoolean(data,"followup"));
            item.job_aid = AppUtils.btos(AppUtils.getBoolean(data,"job_aid"));
            item.what_to_do = AppUtils.btos(AppUtils.getBoolean(data,"w_to_do"));
            item.district = AppUtils.getString(data,"district");
            item.client_name = AppUtils.getString(data,"client_name");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return item;
    }

    public static FpObservationFormItem getUserObjct(String json){//supervisor json
        FpObservationFormItem item = new FpObservationFormItem();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject data = object.getJSONObject("data");
            JSONObject meta = object.getJSONObject("meta");
            item.id = object.getInt("form_id");
            item.status = object.getInt("status");

            item.subdistrict = AppUtils.getString(data,"sub_district");
            item.concent = AppUtils.getString(data,"concent");
            item.cover = AppUtils.btos(AppUtils.getBoolean(data,"cover"));
            item.sound_prove = AppUtils.btos(AppUtils.getBoolean(data,"sound_prove"));
            item.collector_name = item.sp_name = AppUtils.getString(data,"sp_name");
            item.questions = AppUtils.btos(AppUtils.getBoolean(data,"questions"));
            item.discuss_fp = AppUtils.btos(AppUtils.getBoolean(data,"discuss_fp"));
            item.discuss_fp_protocol = AppUtils.btos(AppUtils.getBoolean(data,"discuss_fp_protocol"));
            item.date = AppUtils.getString(data,"date");
            item.facility_id = AppUtils.itos(AppUtils.getInt(data,"facility_id"));
            item.sp_designation = AppUtils.getString(data,"sp_designation");
            item.serial_no = AppUtils.itos(AppUtils.getInt(data,"serial_no"));
            item.village = AppUtils.getString(data,"village");
            item.union = AppUtils.getString(data,"union");
            item.start_time = AppUtils.getString(data,"start_time");
            item.end_time = AppUtils.getString(data,"end_time");
            item.followup = AppUtils.btos(AppUtils.getBoolean(data,"followup"));
            item.job_aid = AppUtils.btos(AppUtils.getBoolean(data,"job_aid"));
            item.what_to_do = AppUtils.btos(AppUtils.getBoolean(data,"w_to_do"));
            item.district = AppUtils.getString(data,"district");
            item.client_name = AppUtils.getString(data,"client_name");


            item.checkedBy = AppUtils.getString(object,"checked_by");
            item.fields = AppUtils.getString(meta,"fields");
            item.comments = AppUtils.getString(meta,"comments");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return item;
    }

}
