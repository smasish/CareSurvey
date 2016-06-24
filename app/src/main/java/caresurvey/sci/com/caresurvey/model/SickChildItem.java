package caresurvey.sci.com.caresurvey.model;

import org.json.JSONObject;

import caresurvey.sci.com.caresurvey.utils.AppUtils;

/**
 * Created by Mazharul.Islam1 on 4/24/2016.
 */
public class SickChildItem extends DBRow{

    public String facility_id;
    public String sp_client;
    public String so_designation;
    public String serial_no;
    public String form_date;
    public String start_time;
    public String child_description;
    public String age;
    public String feed;
    public String vomit;
    public String stutter;
    public String cough;
    public String diahorea;
    public String fever;
    public String measure_fever;
    public String stethoscope;
    public String breathing_test;
    public String eye_test;
    public String infected_mouth;
    public String neck;
    public String ear;
    public String hand;
    public String dehydration;
    public String weight;
    public String clinic_test;
    public String belly_button;
    public String height;
    public String result;
    public String end_time;
    public String ct_client;
    public String facilityId;
    public String bmi;
    public String circle;

    public SickChildItem(int id,int facility_id,String sp_client,String sp_designataion,
                         String serial_no, String form_date, String start_time, String child_description,
                         String age, String feed, String vomit, String stutter, String cough,
                         String diahorea,String fever, String measure_fever, String stethoscope,
                         String breathing_test, String eye_test, String infected_mouth,String neck,
                         String ear, String hand, String dehydration, String weight, String clinic_test,
                         String belly_button, String height, String end_time,String result, String village, String district,
                         String union,String sub_district, String ct_client,String fields,String comments,int status)
    {   this.id =id;
//        this.facility_id =facility_id;
        this.sp_client = sp_client;
        this.name = sp_client;
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
        this.subdistrict = sub_district;
        this.ct_client = ct_client;
        this.fields= fields;
        this.comments=comments;
        this.status=status;


    }

    public SickChildItem() {
        form_date = AppUtils.getDate();
        start_time = AppUtils.getTime();
        end_time = AppUtils.getTime();
        status = 7;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacility_id() {
        return facility_id;
    }

//    public void setFacility_id(int facility_id) {
//        this.facility_id = facility_id;
//    }

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
        return subdistrict;
    }

    public void setSub_district(String sub_district) {
        this.subdistrict = sub_district;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static SickChildItem getObject(String json){
        SickChildItem item = new SickChildItem();
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
            item.facility_id = AppUtils.itos(AppUtils.getInt(data,"facility_id"));
            item.sp_client = AppUtils.getString(data,"sp_client");
            item.so_designation =  AppUtils.getString(data,"sp_designation");
            item.serial_no = AppUtils.itos(AppUtils.getInt(data,"seral_no"));
            item.form_date = AppUtils.getString(data,"form_date");
            item.start_time = AppUtils.getString(data,"start_time");
            item.child_description = AppUtils.getString(data,"child_description");
            item.age = AppUtils.getString(data,"age");
            item.feed = AppUtils.btos(AppUtils.getBoolean(data,"feed"));
            item.vomit = AppUtils.btos(AppUtils.getBoolean(data,"vomit"));
            item.stutter = AppUtils.btos(AppUtils.getBoolean(data,"stutter"));
            item.cough = AppUtils.btos(AppUtils.getBoolean(data,"cough"));
            item.diahorea = AppUtils.btos(AppUtils.getBoolean(data,"diaria"));
            item.fever = AppUtils.btos(AppUtils.getBoolean(data,"fever"));
            item.measure_fever = AppUtils.btos(AppUtils.getBoolean(data,"measure_fever"));
            item.stethoscope = AppUtils.btos(AppUtils.getBoolean(data,"stethoscope"));
            item.breathing_test = AppUtils.btos(AppUtils.getBoolean(data,"breathing_test"));
            item.eye_test = AppUtils.btos(AppUtils.getBoolean(data,"eye_test"));
            item.infected_mouth = AppUtils.btos(AppUtils.getBoolean(data,"infected_mouth"));
            item.neck = AppUtils.btos(AppUtils.getBoolean(data,"neck"));
            item.ear = AppUtils.btos(AppUtils.getBoolean(data,"ear"));
            item.hand = AppUtils.btos(AppUtils.getBoolean(data,"hand"));
            item.dehydration = AppUtils.btos(AppUtils.getBoolean(data,"dehydration"));
            item.weight = AppUtils.btos(AppUtils.getBoolean(data,"weight"));
            item.clinic_test = AppUtils.btos(AppUtils.getBoolean(data,"clinic_test"));
            item.belly_button = AppUtils.btos(AppUtils.getBoolean(data,"belly_button"));
            item.height = AppUtils.btos(AppUtils.getBoolean(data,"height"));
            item.bmi = AppUtils.btos(AppUtils.getBoolean(data,"bmi"));
            item.result = AppUtils.getString(data,"result");
            item.end_time = AppUtils.getString(data,"end_time");
            item.village = AppUtils.getString(data,"village");
            item.district = AppUtils.getString(data,"district");
            item.union = AppUtils.getString(data,"union");
            item.subdistrict = AppUtils.getString(data,"sub_district");
            item.facility = AppUtils.getString(data,"facility");

        }catch (Exception e){
            e.printStackTrace();
        }
        return item;
    }

    public static SickChildItem getUserObject(String json){
        SickChildItem item = new SickChildItem();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject data = object.getJSONObject("data");

            item.id = object.getInt("form_id");
            item.status = object.getInt("status");

            item.form_type = object.getString("form_type");
            item.facility_id = AppUtils.itos(AppUtils.getInt(data,"facility_id"));
            item.sp_client = AppUtils.getString(data,"sp_client");
            item.so_designation =  AppUtils.getString(data,"sp_designation");
            item.serial_no = AppUtils.itos(AppUtils.getInt(data,"seral_no"));
            item.form_date = AppUtils.getString(data,"form_date");
            item.start_time = AppUtils.getString(data,"start_time");
            item.child_description = AppUtils.getString(data,"child_description");
            item.age = AppUtils.getString(data,"age");
            item.feed = AppUtils.btos(AppUtils.getBoolean(data,"feed"));
            item.vomit = AppUtils.btos(AppUtils.getBoolean(data,"vomit"));
            item.stutter = AppUtils.btos(AppUtils.getBoolean(data,"stutter"));
            item.cough = AppUtils.btos(AppUtils.getBoolean(data,"cough"));
            item.diahorea = AppUtils.btos(AppUtils.getBoolean(data,"diaria"));
            item.fever = AppUtils.btos(AppUtils.getBoolean(data,"fever"));
            item.measure_fever = AppUtils.btos(AppUtils.getBoolean(data,"measure_fever"));
            item.stethoscope = AppUtils.btos(AppUtils.getBoolean(data,"stethoscope"));
            item.breathing_test = AppUtils.btos(AppUtils.getBoolean(data,"breathing_test"));
            item.eye_test = AppUtils.btos(AppUtils.getBoolean(data,"eye_test"));
            item.infected_mouth = AppUtils.btos(AppUtils.getBoolean(data,"infected_mouth"));
            item.neck = AppUtils.btos(AppUtils.getBoolean(data,"neck"));
            item.ear = AppUtils.btos(AppUtils.getBoolean(data,"ear"));
            item.hand = AppUtils.btos(AppUtils.getBoolean(data,"hand"));
            item.dehydration = AppUtils.btos(AppUtils.getBoolean(data,"dehydration"));
            item.weight = AppUtils.btos(AppUtils.getBoolean(data,"weight"));
            item.clinic_test = AppUtils.btos(AppUtils.getBoolean(data,"clinic_test"));
            item.belly_button = AppUtils.btos(AppUtils.getBoolean(data,"belly_button"));
            item.height = AppUtils.btos(AppUtils.getBoolean(data,"height"));
            item.bmi = AppUtils.btos(AppUtils.getBoolean(data,"bmi"));
            item.result = AppUtils.getString(data,"result");
            item.end_time = AppUtils.getString(data,"end_time");
            item.village = AppUtils.getString(data,"village");
            item.district = AppUtils.getString(data,"district");
            item.union = AppUtils.getString(data,"union");
            item.subdistrict = AppUtils.getString(data,"sub_district");
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
