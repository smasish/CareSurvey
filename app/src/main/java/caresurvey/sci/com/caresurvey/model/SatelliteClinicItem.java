package caresurvey.sci.com.caresurvey.model;

import org.json.JSONObject;

import caresurvey.sci.com.caresurvey.utils.AppUtils;

/**
 * Created by shantanu on 5/26/16.
 */
public class SatelliteClinicItem extends DBRow{
    public int mark;

    public SatelliteClinicItem(){
        date = AppUtils.getDate();
        startTime = AppUtils.getTime();
        endTime = AppUtils.getTime();
        status = 3;
    }
    public String csi101;
    public String csi102;
    public String csi103;
    public String csi104;
    public String csi105;
    public String csi106;
    public String csi107;
    public String csi201;
    public String csi202;
    public String csi203;
    public String csi204;
    public String csi205;
    public String csi206;
    public String csi207;
    public String csi208;
    public String csi209;
    public String csi210;
    public String csi211;
    public String csi212;
    public String csi213;
    public String csi214;
    public String csi215;
    public String csi216;
    public String csi217;
    public String csi218;
    public String csi219;
    public String csi220;
    public String csi221;
    public String csi222;
    public String csi223;
    public String csi224;
    public String csi225;
    public String csi226;
    public String csi227;
    public String csi228;
    public String csi229;
    public String csi230_1;
    public String csi230_2;
    public String csi231;
    public String csi232;
    public String csi233;
    public String csi234;

    public String date;
    public String startTime;
    public String clientName;
    public String designation;
    public String endTime;

    public static SatelliteClinicItem getObject(String json){//supervisor json
        SatelliteClinicItem item = new SatelliteClinicItem();
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
                    e.printStackTrace();
                }
            }
            item.submittedBy = object.getString("submitted_by");
            item.form_type = object.getString("form_type");

            //data
            item.facilityID = AppUtils.getInt(data,"facility_id");
            item.collector_name = AppUtils.getString(data,"sp_name");
            item.designation = AppUtils.getString(data,"sp_designation");
            item.clientName = AppUtils.getString(data,"client_name");
            item.date = AppUtils.getString(data,"form_date");
            item.startTime = AppUtils.getString(data,"start_time");

            item.csi101 = AppUtils.btos(AppUtils.getBoolean(data,"waiting_place"));
            item.csi102 = AppUtils.btos(AppUtils.getBoolean(data,"furniture"));
            item.csi103 = AppUtils.btos(AppUtils.getBoolean(data,"test_place"));
            item.csi104 = AppUtils.btos(AppUtils.getBoolean(data,"privacy"));
            item.csi105 = AppUtils.btos(AppUtils.getBoolean(data,"testing_bed"));
            item.csi106 = AppUtils.btos(AppUtils.getBoolean(data,"testing_chair"));
            item.csi107 = AppUtils.btos(AppUtils.getBoolean(data,"toilet"));
            item.csi201 = AppUtils.btos(AppUtils.getBoolean(data,"adult_wing"));
            item.csi202 = AppUtils.btos(AppUtils.getBoolean(data,"child_wing"));
            item.csi203 = AppUtils.btos(AppUtils.getBoolean(data,"infant_wing"));
            item.csi204 = AppUtils.btos(AppUtils.getBoolean(data,"height_rod"));
            item.csi205 = AppUtils.btos(AppUtils.getBoolean(data,"measuring_tip"));
            item.csi206 = AppUtils.btos(AppUtils.getBoolean(data,"blood_pressure_mechine"));
            item.csi207 = AppUtils.btos(AppUtils.getBoolean(data,"stethoscope"));
            item.csi208 = AppUtils.btos(AppUtils.getBoolean(data,"filter_stethoscope"));
            item.csi209 = AppUtils.btos(AppUtils.getBoolean(data,"thermometer"));
            item.csi210 = AppUtils.btos(AppUtils.getBoolean(data,"chart_line"));
            item.csi211 = AppUtils.btos(AppUtils.getBoolean(data,"vaginal_speculum"));
            item.csi212 = AppUtils.btos(AppUtils.getBoolean(data,"cotton_ball"));
            item.csi213 = AppUtils.btos(AppUtils.getBoolean(data,"disposable_syringe"));
            item.csi214 = AppUtils.btos(AppUtils.getBoolean(data,"water"));
            item.csi215 = AppUtils.btos(AppUtils.getBoolean(data,"hand_spoap"));
            item.csi216 = AppUtils.btos(AppUtils.getBoolean(data,"spirit"));
            item.csi217 = AppUtils.btos(AppUtils.getBoolean(data,"waste_receptacle"));
            item.csi218 = AppUtils.btos(AppUtils.getBoolean(data,"sharp_waste"));
            item.csi219 = AppUtils.btos(AppUtils.getBoolean(data,"gloves"));
            item.csi220 = AppUtils.btos(AppUtils.getBoolean(data,"test_tube"));
            item.csi221 = AppUtils.btos(AppUtils.getBoolean(data,"test_tube_holder"));
            item.csi222 = AppUtils.btos(AppUtils.getBoolean(data,"test_tube_rack"));
            item.csi223 = AppUtils.btos(AppUtils.getBoolean(data,"dipstick"));
            item.csi224 = AppUtils.btos(AppUtils.getBoolean(data,"telecoet_book"));
            item.csi225 = AppUtils.btos(AppUtils.getBoolean(data,"telecoet_lanstet"));
            item.csi226 = AppUtils.btos(AppUtils.getBoolean(data,"iron_folate"));
            item.csi227 = AppUtils.btos(AppUtils.getBoolean(data,"calcium"));
            item.csi228 = AppUtils.btos(AppUtils.getBoolean(data,"misoprostol"));
            item.csi229 = AppUtils.btos(AppUtils.getBoolean(data,"amoxycillin"));
            item.csi230_1 = AppUtils.btos(AppUtils.getBoolean(data,"sukhi"));
            item.csi230_2 = AppUtils.btos(AppUtils.getBoolean(data,"apon"));
            item.csi231 = AppUtils.btos(AppUtils.getBoolean(data,"condom"));
            item.csi232 = AppUtils.btos(AppUtils.getBoolean(data,"injectable"));
            item.csi233 = AppUtils.btos(AppUtils.getBoolean(data,"card"));
            item.csi234 = AppUtils.btos(AppUtils.getBoolean(data,"pictured_items"));

            item.endTime = AppUtils.getString(data,"end_time");
            item.village = AppUtils.getString(data,"village");
            item.district = AppUtils.getString(data,"district");
            item.union = AppUtils.getString(data,"union");
            item.subdistrict = AppUtils.getString(data,"sub_district");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return item;
    }

    public static SatelliteClinicItem getUserObject(String json){//supervisor json
        SatelliteClinicItem item = new SatelliteClinicItem();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject data = object.getJSONObject("data");

            item.id = object.getInt("form_id");
            item.status = object.getInt("status");

            //data
            item.facilityID = AppUtils.getInt(data,"facility_id");
            item.collector_name = AppUtils.getString(data,"sp_name");
            item.designation = AppUtils.getString(data,"sp_designation");
            item.clientName = AppUtils.getString(data,"client_name");
            item.date = AppUtils.getString(data,"form_date");
            item.startTime = AppUtils.getString(data,"start_time");

            item.csi101 = AppUtils.btos(AppUtils.getBoolean(data,"waiting_place"));
            item.csi102 = AppUtils.btos(AppUtils.getBoolean(data,"furniture"));
            item.csi103 = AppUtils.btos(AppUtils.getBoolean(data,"test_place"));
            item.csi104 = AppUtils.btos(AppUtils.getBoolean(data,"privacy"));
            item.csi105 = AppUtils.btos(AppUtils.getBoolean(data,"testing_bed"));
            item.csi106 = AppUtils.btos(AppUtils.getBoolean(data,"testing_chair"));
            item.csi107 = AppUtils.btos(AppUtils.getBoolean(data,"toilet"));
            item.csi201 = AppUtils.btos(AppUtils.getBoolean(data,"adult_wing"));
            item.csi202 = AppUtils.btos(AppUtils.getBoolean(data,"child_wing"));
            item.csi203 = AppUtils.btos(AppUtils.getBoolean(data,"infant_wing"));
            item.csi204 = AppUtils.btos(AppUtils.getBoolean(data,"height_rod"));
            item.csi205 = AppUtils.btos(AppUtils.getBoolean(data,"measuring_tip"));
            item.csi206 = AppUtils.btos(AppUtils.getBoolean(data,"blood_pressure_mechine"));
            item.csi207 = AppUtils.btos(AppUtils.getBoolean(data,"stethoscope"));
            item.csi208 = AppUtils.btos(AppUtils.getBoolean(data,"filter_stethoscope"));
            item.csi209 = AppUtils.btos(AppUtils.getBoolean(data,"thermometer"));
            item.csi210 = AppUtils.btos(AppUtils.getBoolean(data,"chart_line"));
            item.csi211 = AppUtils.btos(AppUtils.getBoolean(data,"vaginal_speculum"));
            item.csi212 = AppUtils.btos(AppUtils.getBoolean(data,"cotton_ball"));
            item.csi213 = AppUtils.btos(AppUtils.getBoolean(data,"disposable_syringe"));
            item.csi214 = AppUtils.btos(AppUtils.getBoolean(data,"water"));
            item.csi215 = AppUtils.btos(AppUtils.getBoolean(data,"hand_spoap"));
            item.csi216 = AppUtils.btos(AppUtils.getBoolean(data,"spirit"));
            item.csi217 = AppUtils.btos(AppUtils.getBoolean(data,"waste_receptacle"));
            item.csi218 = AppUtils.btos(AppUtils.getBoolean(data,"sharp_waste"));
            item.csi219 = AppUtils.btos(AppUtils.getBoolean(data,"gloves"));
            item.csi220 = AppUtils.btos(AppUtils.getBoolean(data,"test_tube"));
            item.csi221 = AppUtils.btos(AppUtils.getBoolean(data,"test_tube_holder"));
            item.csi222 = AppUtils.btos(AppUtils.getBoolean(data,"test_tube_rack"));
            item.csi223 = AppUtils.btos(AppUtils.getBoolean(data,"dipstick"));
            item.csi224 = AppUtils.btos(AppUtils.getBoolean(data,"telecoet_book"));
            item.csi225 = AppUtils.btos(AppUtils.getBoolean(data,"telecoet_lanstet"));
            item.csi226 = AppUtils.btos(AppUtils.getBoolean(data,"iron_folate"));
            item.csi227 = AppUtils.btos(AppUtils.getBoolean(data,"calcium"));
            item.csi228 = AppUtils.btos(AppUtils.getBoolean(data,"misoprostol"));
            item.csi229 = AppUtils.btos(AppUtils.getBoolean(data,"amoxycillin"));
            item.csi230_1 = AppUtils.btos(AppUtils.getBoolean(data,"sukhi"));
            item.csi230_2 = AppUtils.btos(AppUtils.getBoolean(data,"apon"));
            item.csi231 = AppUtils.btos(AppUtils.getBoolean(data,"condom"));
            item.csi232 = AppUtils.btos(AppUtils.getBoolean(data,"injectable"));
            item.csi233 = AppUtils.btos(AppUtils.getBoolean(data,"card"));
            item.csi234 = AppUtils.btos(AppUtils.getBoolean(data,"pictured_items"));

            item.endTime = AppUtils.getString(data,"end_time");
            item.village = AppUtils.getString(data,"village");
            item.district = AppUtils.getString(data,"district");
            item.union = AppUtils.getString(data,"union");
            item.subdistrict = AppUtils.getString(data,"sub_district");

            JSONObject meta = object.getJSONObject("meta");
            item.checkedBy = AppUtils.getString(object,"checked_by");
            item.fields = AppUtils.getString(meta,"fields");
            item.comments = AppUtils.getString(meta,"comments");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return item;
    }
}
