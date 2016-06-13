package caresurvey.sci.com.caresurvey.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import caresurvey.sci.com.caresurvey.model.DBRow;
import caresurvey.sci.com.caresurvey.model.SatelliteClinicItem;
import caresurvey.sci.com.caresurvey.model.SickChildItem;

/**
 * Created by Mazharul.Islam1 on 4/24/2016.
 */
public class SickChildTable {
    public static final String TABLE_NAME = DatabaseHelper.FORM_SICK_CHILD;
    public static final String KEY_ID = "_id"; // 0 -integer

    public static final String KEY_FACILITY_ID = "_facilityId"; // 0 -integer
    public static final String KEY_SP_CLIENT = "_spClient"; // 1 - text
    public static final String KEY_SP_DESIGNATGION = "_spDesignation"; // 2 - text
    public static final String KEY_SERIAL_NO = "_serialNo"; // 1 - text
    public static final String KEY_FORM_DATE = "_formDate"; // 1 - text
    public static final String KEY_START_TIME = "_startTime"; // 1 - text
    public static final String KEY_CHILD_DESCRIPTION = "_childDescription"; // 1 - text
    public static final String KEY_AGE = "_age"; // 1 - text
    public static final String KEY_FEED = "_feed"; // 1 - text
    public static final String KEY_VOMIT = "_vomit"; // 1 - text
    public static final String KEY_STUTTER = "_stutter"; // 1 - text
    public static final String KEY_COUGH = "_cough"; // 1 - text
    public static final String KEY_DIAHOREA = "_diahorea"; // 1 - text
    public static final String KEY_FEVER = "_fever"; // 1 - text
    public static final String KEY_MEASURE_FEVER = "_measureFever"; // 1 - text
    public static final String KEY_STETHOSCOPE = "_stethoscope"; // 1 - text
    public static final String KEY_BREATHING_TEST = "_breathingTest"; // 1 - text
    public static final String KEY_EYE_TEST = "_eyeTest"; // 1 - text
    public static final String KEY_INFECTED_MOUTH = "_infectedMouth"; // 1 - text
    public static final String KEY_NECK = "_neck"; // 1 - text
    public static final String KEY_EAR = "_ear"; // 1 - text
    public static final String KEY_HAND = "_hand"; // 1 - text
    public static final String KEY_DEHYDRATION = "_dehydration"; // 1 - text
    public static final String KEY_WEIGHT = "_weight"; // 1 - text
    public static final String KEY_CLINIC_TEST = "_cTest"; // 1 - text
    public static final String KEY_BELLEY_BUTTON = "_belleyButton"; // 1 - text
    public static final String KEY_HEIGHT = "_height"; // 1 - text
    public static final String KEY_RESULT = "_result"; // 1 - text
    public static final String KEY_END_TIME = "_endTime"; // 1 - text
    public static final String KEY_VILLAGE = "_village"; // 1 - text
    public static final String KEY_DISTRICT = "_district"; // 1 - text
    public static final String KEY_UNION = "_union"; // 1 - text
    public static final String KEY_SUB_DISTRICT = "_subdistrict"; // 1 - text
    public static final String KEY_CT_CLIENT = "_client"; // 1 - text
    public static final String KEY_COMMENT = "_comment"; // 1 - text
    public static final String KEY_FIELD = "_field"; // 1 - text
    public static final String KEY_STATUS = "_status"; // 1 - text
    private static final String KEY_BMI = "_bmi";
    private static final String KEY_CIRCLE = "_circle";
    private static final String KEY_UPOZILLA = "_upozilla";


    public Context tContext;

    public SickChildTable (Context context) {
        tContext = context;
        createTable();
    }
    public long getRowSize(){
        SQLiteDatabase db = openDB();
        long numRows = DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        closeDB();
        return numRows;
    }


    public void createTable() {
        SQLiteDatabase db = openDB();

        String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + "( "
                + KEY_ID + " INTEGER PRIMARY KEY, " // 0 - int
                + KEY_FACILITY_ID + " INTEGER, "
                + KEY_SP_CLIENT + " TEXT, "              // 1 - text
                + KEY_SP_DESIGNATGION + " TEXT, "
                + KEY_SERIAL_NO + " TEXT, "              // 1 - text
                + KEY_FORM_DATE + " TEXT, "
                + KEY_START_TIME + " TEXT, "              // 1 - text
                + KEY_CHILD_DESCRIPTION + " TEXT, "
                + KEY_AGE + " TEXT, "              // 1 - text
                + KEY_FEED + " TEXT, "
                + KEY_VOMIT + " TEXT, "              // 1 - text
                + KEY_STUTTER + " TEXT, "
                + KEY_COUGH + " TEXT, "
                + KEY_DIAHOREA + " TEXT, "// 1 - text
                + KEY_FEVER + " TEXT, "
                + KEY_MEASURE_FEVER + " TEXT, "
                + KEY_STETHOSCOPE + " TEXT, "
                + KEY_BREATHING_TEST + " TEXT,"
                + KEY_EYE_TEST + " TEXT, "
                + KEY_INFECTED_MOUTH + " TEXT, "
                + KEY_NECK + " TEXT, "
                + KEY_EAR + " TEXT, "
                + KEY_HAND + " TEXT, "
                + KEY_DEHYDRATION + " TEXT, "
                + KEY_WEIGHT + " TEXT, "
                + KEY_CLINIC_TEST + " TEXT, "
                + KEY_BELLEY_BUTTON + " TEXT, "
                + KEY_HEIGHT + " TEXT, "
                + KEY_CIRCLE + " TEXT, "
                + KEY_BMI + " TEXT, "
                + KEY_RESULT + " TEXT, "
                + KEY_END_TIME + " TEXT, "
                + KEY_VILLAGE + " TEXT, "
                + KEY_UPOZILLA + " TEXT, "
                + KEY_DISTRICT + " TEXT, "
                + KEY_UNION + " TEXT, "
                + KEY_SUB_DISTRICT + " TEXT, "
                + KEY_CT_CLIENT + " TEXT, "
                + KEY_COMMENT + " TEXT, "
                + DBRow.KEY_NAME + " TEXT, "
                + DBRow.KEY_DIVISION + " TEXT, "
                + DBRow.KEY_TIME_PICK + " TEXT, "
                + DBRow.KEY_DATE_PICK + " TEXT, "
                + DBRow.KEY_OBSTYPE + " TEXT, "
                + DBRow.KEY_FACILITY + " TEXT, "
                + KEY_FIELD + " TEXT, "

                + KEY_STATUS + " integer "
                // 2 - text
                + " )";
        db.execSQL(CREATE_TABLE_SQL);
        closeDB();
    }

    public SQLiteDatabase openDB() {
        return DatabaseManager.getInstance(tContext).openDatabase();
    }

    public void closeDB() {
        DatabaseManager.getInstance(tContext).closeDatabase();
    }

    public long insertItem(SickChildItem item) {
//        return insertItem(sickChildItem.getId(),sickChildItem.getFacility_id(),sickChildItem.getSp_client(),sickChildItem.getSo_designation(),
//                sickChildItem.getSerial_no(),sickChildItem.getForm_date(),
//                sickChildItem.getStart_time(),sickChildItem.getChild_description(),
//                sickChildItem.getAge(),sickChildItem.getFeed(),sickChildItem.getVomit(),
//                sickChildItem.getStutter(),sickChildItem.getCough(),sickChildItem.getDiahorea(),
//                sickChildItem.getFever(),sickChildItem.getMeasure_fever(),
//                sickChildItem.getStethoscope(),sickChildItem.getBreathing_test(),
//                sickChildItem.getEye_test(),sickChildItem.getInfected_mouth(),sickChildItem.getNeck(),
//                sickChildItem.getEar(),sickChildItem.getHand(),sickChildItem.getDehydration(),
//                sickChildItem.getWeight(),sickChildItem.getClinic_test(),
//                sickChildItem.getBelly_button(),sickChildItem.getHeight(),sickChildItem.getResult(),
//                sickChildItem.getEnd_time(),sickChildItem.getVillage(),
//                sickChildItem.getDistrict(),sickChildItem.getUnion(),sickChildItem.getSub_district(),sickChildItem.getCt_client(),
//                sickChildItem.getFields(),sickChildItem.getComments(),sickChildItem.getStatus());
        ContentValues values= new ContentValues();
//        values.put(KEY_ID,id);
        values.put(KEY_FACILITY_ID,item.facility_id);
        values.put(KEY_SP_CLIENT,item.sp_client);
        values.put(KEY_SP_DESIGNATGION,item.so_designation);
        values.put(KEY_SERIAL_NO,item.serial_no);
        values.put(KEY_FORM_DATE,item.form_date);
        values.put(KEY_START_TIME,item.start_time);
        values.put(KEY_CHILD_DESCRIPTION,item.child_description);
        values.put(KEY_AGE,item.age);
        values.put(KEY_FEED,item.feed);
        values.put(KEY_VOMIT,item.vomit);
        values.put(KEY_STUTTER,item.stutter);
        values.put(KEY_COUGH,item.cough);
        values.put(KEY_DIAHOREA,item.diahorea);
        values.put(KEY_FEVER,item.fever);
        values.put(KEY_MEASURE_FEVER,item.measure_fever);
        values.put(KEY_STETHOSCOPE,item.stethoscope);
        values.put(KEY_BREATHING_TEST,item.breathing_test);
        values.put(KEY_EYE_TEST,item.eye_test);
        values.put(KEY_INFECTED_MOUTH,item.infected_mouth);
        values.put(KEY_NECK,item.neck);
        values.put(KEY_EAR,item.ear);
        values.put(KEY_HAND,item.hand);
        values.put(KEY_DEHYDRATION,item.dehydration);
        values.put(KEY_WEIGHT,item.weight);
        values.put(KEY_CLINIC_TEST,item.clinic_test);
        values.put(KEY_BELLEY_BUTTON,item.belly_button);
        values.put(KEY_HEIGHT,item.height);
        values.put(KEY_BMI,item.bmi);
        values.put(KEY_CIRCLE,item.circle);
        values.put(KEY_RESULT,item.result);
        values.put(KEY_END_TIME,item.end_time);
        values.put(KEY_VILLAGE,item.village);
        values.put(KEY_DISTRICT,item.district);
        values.put(KEY_UNION,item.union);
        values.put(KEY_SUB_DISTRICT,item.subdistrict);
        values.put(KEY_CT_CLIENT,item.ct_client);
        values.put(KEY_STATUS,item.status);
        values.put(KEY_UNION,item.union);
        values.put(KEY_VILLAGE,item.village);
        values.put(KEY_UPOZILLA,item.upozila);
        values.put(DBRow.KEY_NAME,item.name);
        values.put(DBRow.KEY_DIVISION,item.division);
        values.put(DBRow.KEY_TIME_PICK,item.timepick);
        values.put(DBRow.KEY_DATE_PICK,item.datepick);
        values.put(DBRow.KEY_OBSTYPE,item.obs_type);
        values.put(DBRow.KEY_FACILITY,item.facility);
        SQLiteDatabase db = openDB();
        if(item.id > 0){ //update
            db.update(TABLE_NAME,values,KEY_ID + "=" + item.id,null);
        }
        else{
            item.id = db.insert(TABLE_NAME, null, values);
        }
        closeDB();
        return item.id;
    }

    public long insertItem(long id,int facility_id, String sp_client, String so_designation, String serial_no, String form_date, String start_time, String child_description, String age, String feed, String vomit, String stutter, String cough, String diahorea, String fever, String measure_fever,  String stethoscope, String breathing_test, String eye_test, String infected_mouth, String neck, String ear, String hand, String dehydration, String weight, String clinic_test, String belly_button, String height, String result, String end_time, String village, String district, String union, String sub_district,String ct_client,String field,String comment,int status) {
//                if(isFieldExist(id))
//                {
//                    return updateItem(id,facility_id,sp_client, so_designation,  serial_no,  form_date,  start_time,  child_description,  age,feed, vomit,  stutter,  cough,  diahorea,  fever,  measure_fever,   stethoscope,  breathing_test,  eye_test,  infected_mouth,  neck,  ear,  hand,  dehydration,  weight,   clinic_test,  belly_button,  height,  result,  end_time,  village,  district,  union,  sub_district, ct_client,field,comment,status);
//                }
        ContentValues values= new ContentValues();
//        values.put(KEY_ID,id);
        values.put(KEY_FACILITY_ID,facility_id);
        values.put(KEY_SP_CLIENT,sp_client);
        values.put(KEY_SP_DESIGNATGION,so_designation);
        values.put(KEY_SERIAL_NO,serial_no);
        values.put(KEY_FORM_DATE,form_date);
        values.put(KEY_START_TIME,start_time);
        values.put(KEY_CHILD_DESCRIPTION,child_description);
        values.put(KEY_AGE,age);
        values.put(KEY_FEED,feed);
        values.put(KEY_VOMIT,vomit);
        values.put(KEY_STUTTER,stutter);
        values.put(KEY_COUGH,cough);
        values.put(KEY_DIAHOREA,diahorea);
        values.put(KEY_FEVER,fever);
        values.put(KEY_MEASURE_FEVER,measure_fever);
        values.put(KEY_STETHOSCOPE,stethoscope);
        values.put(KEY_BREATHING_TEST,breathing_test);
        values.put(KEY_EYE_TEST,eye_test);
        values.put(KEY_INFECTED_MOUTH,infected_mouth);
        values.put(KEY_NECK,neck);
        values.put(KEY_EAR,ear);
        values.put(KEY_HAND,hand);
        values.put(KEY_DEHYDRATION,dehydration);
        values.put(KEY_WEIGHT,weight);
        values.put(KEY_CLINIC_TEST,clinic_test);
        values.put(KEY_BELLEY_BUTTON,belly_button);
        values.put(KEY_HEIGHT,height);
        values.put(KEY_RESULT,result);
        values.put(KEY_END_TIME,end_time);
        values.put(KEY_VILLAGE,village);
        values.put(KEY_DISTRICT,district);
        values.put(KEY_UNION,union);
        values.put(KEY_SUB_DISTRICT,sub_district);
        values.put(KEY_CT_CLIENT,ct_client);
        values.put(KEY_FIELD,field);
        values.put(KEY_COMMENT,comment);
        values.put(KEY_STATUS,status);

        SQLiteDatabase db = openDB();
        long ret= db.insert(TABLE_NAME, null, values);
        closeDB();
        return ret;



    }

    public long updateItem(int id,int facility_id, String sp_client, String so_designation, String serial_no, String form_date, String start_time, String child_description, String age, String feed, String vomit, String stutter, String cough, String diahorea, String fever, String measure_fever,  String stethoscope, String breathing_test, String eye_test, String infected_mouth, String neck, String ear, String hand, String dehydration, String weight, String clinic_test, String belly_button, String height, String result, String end_time, String village, String district, String union, String sub_district,String ct_client,String field, String comment, int status) {

        ContentValues values= new ContentValues();
//        values.put(KEY_ID,id);
        values.put(KEY_FACILITY_ID,facility_id);
        values.put(KEY_SP_CLIENT,sp_client);
        values.put(KEY_SP_DESIGNATGION,so_designation);
        values.put(KEY_SERIAL_NO,serial_no);
        values.put(KEY_FORM_DATE,form_date);
        values.put(KEY_START_TIME,start_time);
        values.put(KEY_CHILD_DESCRIPTION,child_description);
        values.put(KEY_AGE,age);
        values.put(KEY_FEED,feed);
        values.put(KEY_VOMIT,vomit);
        values.put(KEY_STUTTER,stutter);
        values.put(KEY_COUGH,cough);
        values.put(KEY_DIAHOREA,diahorea);
        values.put(KEY_FEVER,fever);
        values.put(KEY_MEASURE_FEVER,measure_fever);
        values.put(KEY_STETHOSCOPE,stethoscope);
        values.put(KEY_BREATHING_TEST,breathing_test);
        values.put(KEY_EYE_TEST,eye_test);
        values.put(KEY_INFECTED_MOUTH,infected_mouth);
        values.put(KEY_NECK,neck);
        values.put(KEY_EAR,ear);
        values.put(KEY_HAND,hand);
        values.put(KEY_DEHYDRATION,dehydration);
        values.put(KEY_WEIGHT,weight);
        values.put(KEY_CLINIC_TEST,clinic_test);
        values.put(KEY_BELLEY_BUTTON,belly_button);
        values.put(KEY_HEIGHT,height);
        values.put(KEY_RESULT,result);
        values.put(KEY_END_TIME,end_time);
        values.put(KEY_VILLAGE,village);
        values.put(KEY_DISTRICT,district);
        values.put(KEY_UNION,union);
        values.put(KEY_SUB_DISTRICT,sub_district);
        values.put(KEY_CT_CLIENT,ct_client);
        values.put(KEY_FIELD,field);
        values.put(KEY_COMMENT,comment);
        values.put(KEY_STATUS,status);


        SQLiteDatabase db = openDB();
        long ret= db.update(TABLE_NAME, values, "_id=" + id, null);
        closeDB();
        return ret;

    }


    public ArrayList<SickChildItem> getAllInfo() {
        ArrayList<SickChildItem> subCatList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME , null);

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                subCatList.add(cursorlist(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return subCatList;
    }

    public boolean isFieldExist(int id) {
        //Lg.d(TAG, "isFieldExist : inside, id=" + id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                if (Integer.parseInt(cursor.getString(0)) ==id) {
                    cursor.close();
                    closeDB();
                    return true;
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return false;
    }


    public ArrayList<SickChildItem> getSpecificItem(int cat_id) {
        ArrayList<SickChildItem> subCatList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE "+ KEY_ID+"="+cat_id, null);



        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                subCatList.add(cursorlist(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return subCatList;
    }

    public SickChildItem get(long id) {
        SickChildItem item = new SickChildItem();
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " where _id=" + id, null);

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                item = cursorlist(cursor);
                break;
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return item;

    }


    public SickChildItem cursorlist(Cursor cursor)
    {   int id = cursor.getInt(0);
        int facility_id = cursor.getInt(1);
        String sp_client = cursor.getString(2);
        String so_designation =cursor.getString(3);
        String serial_no = cursor.getString(4);
        String form_date = cursor.getString(5);
        String start_time = cursor.getString(6);
        String child_description = cursor.getString(7);
        String age = cursor.getString(8);
        String feed= cursor.getString(9);
        String vomit= cursor.getString(10);
        String stutter= cursor.getString(11);
        String cough =cursor.getString(12);
        String diahorea = cursor.getString(13);
        String fever = cursor.getString(14);
        String measure_fever= cursor.getString(15);
        String stethoscope= cursor.getString(16);
        String breathing_test = cursor.getString(17);
        String eye_test= cursor.getString(18);
        String infected_mouth=cursor.getString(19);
        String neck=cursor.getString(20);
        String ear= cursor.getString(21);
        String hand= cursor.getString(22);
        String dehydration= cursor.getString(23);
        String weight = cursor.getString(24);

        String clinic_test = cursor.getString(25);
        String belly_button=cursor.getString(26);
        String height= cursor.getString(27);
        String result=cursor.getString(28);
        String end_time=cursor.getString(29);
        String village= cursor.getString(30);
        String district=cursor.getString(31);
        String union= cursor.getString(32);
        String sub_district = cursor.getString(33);
        String ct_client = cursor.getString(34);
        String field = cursor.getString(35);
        String comment = cursor.getString(36);
        int status = cursor.getInt(37);


        return new SickChildItem (id,facility_id,sp_client, so_designation,  serial_no,  form_date,  start_time,  child_description,  age,feed, vomit,  stutter,  cough,  diahorea,  fever,  measure_fever,   stethoscope,  breathing_test,  eye_test,  infected_mouth,  neck,  ear,  hand,  dehydration,  weight,   clinic_test,  belly_button,  height,  result,  end_time,  village,  district,  union,  sub_district,ct_client,field, comment,status);
    }



}
