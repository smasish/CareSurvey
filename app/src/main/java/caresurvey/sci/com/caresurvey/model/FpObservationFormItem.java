package caresurvey.sci.com.caresurvey.model;

import caresurvey.sci.com.caresurvey.database.DatabaseHelper;

/**
 * Created by Shahin on 5/6/2016.
 */
public class FpObservationFormItem {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(int facility_id) {
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

    public int getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(int serial_no) {
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

    public boolean getCover() {
        return cover;
    }

    public void setCover(boolean cover) {
        this.cover = cover;
    }

    public boolean getSound_prove() {
        return sound_prove;
    }

    public void setSound_prove(boolean sound_prove) {
        this.sound_prove = sound_prove;
    }

    public boolean getDiscuss_fp() {
        return discuss_fp;
    }

    public void setDiscuss_fp(boolean discuss_fp) {
        this.discuss_fp = discuss_fp;
    }

    public boolean getDiscuss_fp_protocol() {
        return discuss_fp_protocol;
    }

    public void setDiscuss_fp_protocol(boolean discuss_fp_protocol) {
        this.discuss_fp_protocol = discuss_fp_protocol;
    }

    public boolean getQuestions() {
        return questions;
    }

    public void setQuestions(boolean questions) {
        this.questions = questions;
    }

    public boolean getJob_aid() {
        return job_aid;
    }

    public void setJob_aid(boolean job_aid) {
        this.job_aid = job_aid;
    }

    public boolean getFollowup() {
        return followup;
    }

    public void setFollowup(boolean followup) {
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
        return sub_district;
    }

    public void setSub_district(String sub_district) {
        this.sub_district = sub_district;
    }

    private int id;
    private int facility_id;
    private String sp_name;
    private String sp_designation;
    private String client_name;
    private int serial_no;
    private String date;
    private String start_time;
    private String concent;
    private boolean cover;
    private boolean sound_prove;
    private boolean discuss_fp;
    private boolean discuss_fp_protocol;
    private boolean questions;
    private boolean job_aid;
    private boolean followup;
    private String end_time;
    private String village;
    private String district;
    private String union;
    private String sub_district;

}
