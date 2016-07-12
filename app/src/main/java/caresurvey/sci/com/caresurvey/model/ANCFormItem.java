package caresurvey.sci.com.caresurvey.model;

import org.json.JSONException;
import org.json.JSONObject;

import caresurvey.sci.com.caresurvey.utils.AppUtils;

/**
 * Created by mazharul.islam on 3/6/2016.
 */
public class ANCFormItem extends DBRow{
    public String bloodpressure;
    public String hemoglobintest;
    public String urinetest;
    public String pregnancyfood;
    public String pregnancydanger;
    public String fourparts;
    public String delivery;
    public String feedbaby;
    public String sixmonths;
    public String familyplanning;
    public String folictablet;
    public String folictabletimportance;
    public String global_id;
    public String inS;
    public String serial_no;
    public String start_time;
    public String serviceDescription;
    public String weight;
    public String folicsideeffect;
    public String end_time;

    public ANCFormItem(){
        date = AppUtils.getDate();
        start_time = AppUtils.getTime();
        end_time = AppUtils.getTime();
        status = 7;
    }


    public ANCFormItem(int patientid, String bloodpressure, String hemoglobintest, String urinetest,
                       String pregnancyfood, String pregnancydanger, String fourparts, String delivery,
                       String feedbaby, String sixmonths, String familyplanning, String folictablet, String folictabletimportance,
                       int status, String global_id, String name, String comments, String fields, String inS, String datepick, String timepick, String collector_name, String division, String upozila, String uniton, String village, String obs_type
    ) {
        this.id = patientid;
        this.bloodpressure = bloodpressure;
        this.hemoglobintest = hemoglobintest;
        this.urinetest = urinetest;
        this.pregnancyfood = pregnancyfood;
        this.pregnancydanger = pregnancydanger;
        this.fourparts = fourparts;
        this.delivery = delivery;
        this.feedbaby = feedbaby;
        this.sixmonths = sixmonths;
        this.familyplanning = familyplanning;
        this.folictablet = folictablet;
        this.folictabletimportance = folictabletimportance;
        this.status=status;
        this.global_id=global_id;
        this.name=name;
        this.comments=comments;
        this.fields=fields;
        this.inS=inS;
        this.datepick=datepick;
        this.timepick=timepick;
        this.collector_name=collector_name;
        this.division=division;
        this.upozila=upozila;
        this.union=uniton;
        this.village=village;
        this.obs_type=obs_type;

    }

    public ANCFormItem(int patientid, String bloodpressure, String hemoglobintest, String urinetest, String pregnancyfood, String pregnancydanger, String fourparts, String delivery, String feedbaby, String sixmonths, String familyplanning, String folictablet, String folictabletimportance, String global_id) {
        this.id =patientid;
        this.bloodpressure = bloodpressure;
        this.hemoglobintest = hemoglobintest;
        this.urinetest = urinetest;
        this.pregnancyfood = pregnancyfood;
        this.pregnancydanger = pregnancydanger;
        this.fourparts = fourparts;
        this.delivery = delivery;
        this.feedbaby = feedbaby;
        this.sixmonths = sixmonths;
        this.familyplanning = familyplanning;
        this.folictablet = folictablet;
        this.folictabletimportance = folictabletimportance;
        this.global_id = global_id;
        this.obs_type=obs_type;
       }

    public String getComments() {
        return comments;
    }

    public String getFields() {
        return fields;
    }

    public int getStatus() {
        return status;
    }

    public String getGlobal_id() {
        return global_id;
    }

    public String getName() {
        return name;
    }

    public long getPatientid() {
        return id;
    }

    public void setPatientid(int patientid) {
        this.id = patientid;
    }

    public String getBloodpressure() {
        return bloodpressure;
    }

    public void setBloodpressure(String bloodpressure) {
        this.bloodpressure = bloodpressure;
    }

    public String getHemoglobintest() {
        return hemoglobintest;
    }

    public void setHemoglobintest(String hemoglobintest) {
        this.hemoglobintest = hemoglobintest;
    }

    public String getUrinetest() {
        return urinetest;
    }

    public void setUrinetest(String urinetest) {
        this.urinetest = urinetest;
    }

    public String getPregnancyfood() {
        return pregnancyfood;
    }

    public void setPregnancyfood(String pregnancyfood) {
        this.pregnancyfood = pregnancyfood;
    }

    public String getPregnancydanger() {
        return pregnancydanger;
    }

    public void setPregnancydanger(String pregnancydanger) {
        this.pregnancydanger = pregnancydanger;
    }

    public String getFourparts() {
        return fourparts;
    }

    public void setFourparts(String fourparts) {
        this.fourparts = fourparts;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getFeedbaby() {
        return feedbaby;
    }

    public void setFeedbaby(String feedbaby) {
        this.feedbaby = feedbaby;
    }

    public String getSixmonths() {
        return sixmonths;
    }

    public void setSixmonths(String sixmonths) {
        this.sixmonths = sixmonths;
    }

    public String getFamilyplanning() {
        return familyplanning;
    }

    public void setFamilyplanning(String familyplanning) {
        this.familyplanning = familyplanning;
    }

    public String getFolictablet() {
        return folictablet;
    }

    public void setFolictablet(String folictablet) {
        this.folictablet = folictablet;
    }

    public String getFolictabletimportance() {
        return folictabletimportance;
    }

    public void setFolictabletimportance(String folictabletimportance) {
        this.folictabletimportance = folictabletimportance;
    }

    public String getInS() {
        return inS;
    }

    public String getTimepick() {
        return timepick;
    }

    public String getDatepick() {
        return datepick;
    }

    public String getCollector_name() {
        return collector_name;
    }


    public String getDivision() {
        return division;
    }

    public String getUpozila() {
        return upozila;
    }

    public String getUnion() {
        return union;
    }

    public String getVillage() {
        return village;
    }


    public String getObs_type() {
        return obs_type;
    }

    public static ANCFormItem parseFormItem(int patientid, String global_id, JSONObject jo) throws JSONException {
        int _patientId=patientid;
        String _bloodpressure = jo.getString("bloodpressure");
        String _hemoglobintest = jo.getString("hemoglobintest");
        String _urinetest = jo.getString("urinetest");
        String _pregnancyfood = jo.getString("pregnancyfood");

        String _pregnancydanger = jo.getString("pregnancydanger");
        String _fourparts = jo.getString("fourparts");

        String _delivery = jo.getString("delivery");
        String _feedbaby = jo.getString("feedbaby");
        String _sixmonths = jo.getString("sixmonths");
        String _familyplanning = jo.getString("familyplanning");
        String _folictablet = jo.getString("folictablet");
        String _folictabletimportance = jo.getString("folictabletimportance");
        String _globalId = global_id;


        return new ANCFormItem(_patientId,_bloodpressure,_hemoglobintest,_urinetest,_pregnancyfood,_pregnancydanger,_fourparts,
                _delivery,_feedbaby,_sixmonths,_familyplanning,_folictablet,_folictabletimportance,_globalId);
    }

    public static ANCFormItem getObject(String json){
        ANCFormItem item = new ANCFormItem();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject data = object.getJSONObject("data");

            item.id = object.getInt("form_id");
            item.status = object.getInt("status");
            item.user_id = Integer.toString(object.getInt("user_id"));
            if (object.has("meta")) {
                try {
                    boolean b = object.getBoolean("meta");
                    if (b) {
                        item.meta = "true";
                    } else {
                        item.meta = "false";
                    }
                } catch (Exception e) {
                    JSONObject meta = null;
                    try {
                        meta = object.getJSONObject("meta");
                    }catch(Exception ex){

                    }
                    item.fields = AppUtils.getString(meta,"fields");
                    item.comments = AppUtils.getString(meta,"comments");
                }
            }
            item.submittedBy = object.getString("submitted_by");
            item.form_type = object.getString("form_type");

            item.date = AppUtils.getString(data,"date");
            item.start_time = AppUtils.getString(data,"start_time");
            item.serviceDescription = AppUtils.getString(data,"description");
            item.bloodpressure = AppUtils.btos(AppUtils.getBoolean(data,"bloodpressure"));
            item.weight = AppUtils.btos(AppUtils.getBoolean(data,"weight"));
            item.hemoglobintest = AppUtils.btos(AppUtils.getBoolean(data,"hemoglobintest"));
            item.urinetest = AppUtils.btos(AppUtils.getBoolean(data,"urinetest"));
            item.pregnancyfood = AppUtils.btos(AppUtils.getBoolean(data,"pregnancyfood"));
            item.pregnancydanger = AppUtils.btos(AppUtils.getBoolean(data,"pregnancydanger"));
            item.fourparts = AppUtils.btos(AppUtils.getBoolean(data,"fourparts"));
            item.delivery = AppUtils.btos(AppUtils.getBoolean(data,"delivery"));
            item.feedbaby = AppUtils.btos(AppUtils.getBoolean(data,"feedbaby"));
            item.sixmonths = AppUtils.btos(AppUtils.getBoolean(data,"sixmonths"));
            item.familyplanning = AppUtils.btos(AppUtils.getBoolean(data,"familyplanning"));
            item.folictablet = AppUtils.btos(AppUtils.getBoolean(data,"folictablet"));
            item.folictabletimportance = AppUtils.btos(AppUtils.getBoolean(data,"folictabletimportance"));
            item.folicsideeffect = AppUtils.btos(AppUtils.getBoolean(data,"folicacidsideeffect"));
            item.designation = AppUtils.getString(data,"doc_designation");
            item.end_time = AppUtils.getString(data,"end_time");//gETv(R.id.end_time);
            item.district = AppUtils.getString(data,"district");
            item.weight = AppUtils.btos(AppUtils.getBoolean(data,"weight"));
            item.facility = AppUtils.getString(data,"facility");

        }catch (Exception e){
            e.printStackTrace();
        }
        return item;
    }

    public String getDistrict(){
        return district;
    }
    public String getSubdistrict(){
        return subdistrict;
    }
    public String getC_name(){
        return "";
    }

    public static ANCFormItem getUserObject(String json){
        ANCFormItem item = new ANCFormItem();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject data = object.getJSONObject("data");

            item.id = object.getInt("form_id");
            item.status = object.getInt("status");
            item.date = AppUtils.getString(data,"date");
            item.start_time = AppUtils.getString(data,"start_time");
            item.serviceDescription = AppUtils.getString(data,"description");
            item.bloodpressure = AppUtils.btos(AppUtils.getBoolean(data,"bloodpressure"));
            item.weight = AppUtils.btos(AppUtils.getBoolean(data,"weight"));
            item.hemoglobintest = AppUtils.btos(AppUtils.getBoolean(data,"hemoglobintest"));
            item.urinetest = AppUtils.btos(AppUtils.getBoolean(data,"urinetest"));
            item.pregnancyfood = AppUtils.btos(AppUtils.getBoolean(data,"pregnancyfood"));
            item.pregnancydanger = AppUtils.btos(AppUtils.getBoolean(data,"pregnancydanger"));
            item.fourparts = AppUtils.btos(AppUtils.getBoolean(data,"fourparts"));
            item.delivery = AppUtils.btos(AppUtils.getBoolean(data,"delivery"));
            item.feedbaby = AppUtils.btos(AppUtils.getBoolean(data,"feedbaby"));
            item.sixmonths = AppUtils.btos(AppUtils.getBoolean(data,"sixmonths"));
            item.familyplanning = AppUtils.btos(AppUtils.getBoolean(data,"familyplanning"));
            item.folictablet = AppUtils.btos(AppUtils.getBoolean(data,"folictablet"));
            item.folictabletimportance = AppUtils.btos(AppUtils.getBoolean(data,"folictabletimportance"));
            item.folicsideeffect = AppUtils.btos(AppUtils.getBoolean(data,"folicacidsideeffect"));
            item.designation = AppUtils.getString(data,"doc_designation");
            item.end_time = AppUtils.getString(data,"end_time");//gETv(R.id.end_time);
            item.district = AppUtils.getString(data,"district");
            item.weight = AppUtils.btos(AppUtils.getBoolean(data,"weight"));
            item.facility = AppUtils.getString(data,"facility");

            if (object.has("meta")) {
                try {
                    boolean b = object.getBoolean("meta");
                    if (b) {
                        item.meta = "true";
                    } else {
                        item.meta = "false";
                    }
                } catch (Exception e) {
                    JSONObject meta = null;
                    try {
                        meta = object.getJSONObject("meta");
                    }catch(Exception ex){

                    }
                    item.fields = AppUtils.getString(meta,"fields");
                    item.comments = AppUtils.getString(meta,"comments");
                }
            }
            item.checkedBy = AppUtils.getString(object,"checked_by");

        }catch (Exception e){
            e.printStackTrace();
        }
        return item;
    }
}
