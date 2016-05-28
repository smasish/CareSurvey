package caresurvey.sci.com.caresurvey.model;

import caresurvey.sci.com.caresurvey.database.DatabaseHelper;

/**
 * Created by Shahin on 5/6/2016.
 */
public class FpObservationFormItem extends DBRow{
    public String sp_client;

    public int getId() {
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

    public int id;
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

}
