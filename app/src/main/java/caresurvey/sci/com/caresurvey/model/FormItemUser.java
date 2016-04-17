package caresurvey.sci.com.caresurvey.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mazharul.islam on 3/6/2016.
 */
public class FormItemUser {
    private int patientid;
    private String bloodpressure;
    private String hemoglobintest;
    private String urinetest;
    private String pregnancyfood;
    private String pregnancydanger;
    private String fourparts;
    private String delivery;
    private String feedbaby;
    private String sixmonths;
    private String familyplanning;
    private String folictablet;
    private String folictabletimportance;
    private int status;
    private String global_id;
    private String name;
    private String comments;
    private String fields;
    private String inS;
    private String timepick;
    private String datepick;
    private String collector_name;
    private String division;
    private String upozila;
    private String union;
    private String village;



    public FormItemUser(int patientid, String bloodpressure, String hemoglobintest, String urinetest,
                        String pregnancyfood, String pregnancydanger, String fourparts, String delivery,
                        String feedbaby, String sixmonths, String familyplanning, String folictablet, String folictabletimportance,
                        int status, String global_id, String name, String comments, String fields, String inS,String datepick, String timepick, String collector_name, String division, String upozila, String uniton, String village
    ) {
        this.patientid = patientid;
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

    }

    public FormItemUser(int patientid, String bloodpressure, String hemoglobintest, String urinetest, String pregnancyfood, String pregnancydanger, String fourparts, String delivery, String feedbaby, String sixmonths, String familyplanning, String folictablet, String folictabletimportance, String global_id) {
        this.patientid=patientid;
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

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
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

    public static FormItemUser parseFormItem(int patientid,String global_id,JSONObject jo) throws JSONException {
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


        return new FormItemUser(_patientId,_bloodpressure,_hemoglobintest,_urinetest,_pregnancyfood,_pregnancydanger,_fourparts,
                _delivery,_feedbaby,_sixmonths,_familyplanning,_folictablet,_folictabletimportance,_globalId);
    }
}
