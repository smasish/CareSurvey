package caresurvey.sci.com.caresurvey.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import caresurvey.sci.com.caresurvey.model.DBRow;
import caresurvey.sci.com.caresurvey.model.FpObservationFormItem;
import caresurvey.sci.com.caresurvey.model.SickChildItem;
import caresurvey.sci.com.caresurvey.utils.AppUtils;

/**
 * Created by shantanu on 6/13/16.
 */

public class SickChildSupervisorTable2 extends SuperTable{
    public static final String TABLE_NAME = "csc_supervisor";
    private static final String KEY_ID = "_id";
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

    private static final String KEY_USER_ID = "_user_id";
    private static final String KEY_COMMENTS="_comments";
    private static final String KEY_FIELDS="_fields";
    private static final String KEY_META="_meta";
    private static final String KEY_SUBMITTED_BY="_submitted_by";
    private static final String KEY_FORM_TYPE = "_form_type";

    public SickChildSupervisorTable2(Context context) {
        super(context, TABLE_NAME);
    }

    @Override
    protected void createTable() {
        try {
            List<String> tableQuery = getCreateTableQuery();
            SQLiteDatabase db = openDB();
            for(int i=0;i<tableQuery.size();i++)
            {
                db.execSQL(tableQuery.get(i));
            }
            Log.e("fp_supervisor table:","created");
            closeDB();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void generateTable() {
        //creating table for save cart
        Hashtable<String,String> table = new Hashtable<String,String>();
        table.put(KEY_ID, "integer primary key"); //must need to  add this key
        table.put(KEY_FACILITY_ID , " INTEGER ");
        table.put(KEY_SP_CLIENT , " TEXT");              // 1 - text
        table.put(KEY_SP_DESIGNATGION , " TEXT");
        table.put(KEY_SERIAL_NO , " TEXT");              // 1 - text
        table.put(KEY_FORM_DATE , " TEXT");
        table.put(KEY_START_TIME , " TEXT");              // 1 - text
        table.put(KEY_CHILD_DESCRIPTION , " TEXT");
        table.put(KEY_AGE , " TEXT");              // 1 - text
        table.put(KEY_FEED , " TEXT");
        table.put(KEY_VOMIT , " TEXT");              // 1 - text
        table.put(KEY_STUTTER , " TEXT");
        table.put(KEY_COUGH , " TEXT");
        table.put(KEY_DIAHOREA , " TEXT");// 1 - text
        table.put(KEY_FEVER , " TEXT");
        table.put(KEY_MEASURE_FEVER , " TEXT");
        table.put(KEY_STETHOSCOPE , " TEXT");
        table.put(KEY_BREATHING_TEST , " TEXT");
        table.put(KEY_EYE_TEST , " TEXT");
        table.put(KEY_INFECTED_MOUTH , " TEXT");
        table.put(KEY_NECK , " TEXT");
        table.put(KEY_EAR , " TEXT");
        table.put(KEY_HAND , " TEXT");
        table.put(KEY_DEHYDRATION , " TEXT");
        table.put(KEY_WEIGHT , " TEXT");
        table.put(KEY_CLINIC_TEST , " TEXT");
        table.put(KEY_BELLEY_BUTTON , " TEXT");
        table.put(KEY_HEIGHT , " TEXT");
        table.put(KEY_CIRCLE , " TEXT");
        table.put(KEY_BMI , " TEXT");
        table.put(KEY_RESULT , " TEXT");
        table.put(KEY_END_TIME , " TEXT");
        table.put(KEY_VILLAGE , " TEXT");
        table.put(KEY_UPOZILLA , " TEXT");
        table.put(KEY_DISTRICT , " TEXT");
        table.put(KEY_UNION , " TEXT");
        table.put(KEY_SUB_DISTRICT , " TEXT");
        table.put(KEY_CT_CLIENT , " TEXT");
        table.put(KEY_COMMENT , " TEXT");
        table.put(DBRow.KEY_NAME , " TEXT");
        table.put(DBRow.KEY_DIVISION , " TEXT");
        table.put(DBRow.KEY_TIME_PICK , " TEXT");
        table.put(DBRow.KEY_DATE_PICK , " TEXT");
        table.put(DBRow.KEY_OBSTYPE , " TEXT");
        table.put(DBRow.KEY_FACILITY , " TEXT");
        table.put(KEY_FIELD , " TEXT");
        table.put(KEY_STATUS , " integer ");

        //supervisor field
        table.put(KEY_USER_ID,"text");
        table.put(KEY_COMMENTS,"text");
        table.put(KEY_FIELDS,"text");
        table.put(KEY_META,"text");
        table.put(KEY_SUBMITTED_BY,"text");
        table.put(KEY_FORM_TYPE,"text");
        setNewTable(TABLE_NAME, table);
    }

    public List<SickChildItem> getList(String cName, String facility) {
        ArrayList<SickChildItem> fpList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " where " + KEY_SUBMITTED_BY + "='" + cName + "'", null);

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                fpList.add(cursorToSubCatList(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return fpList;
    }

    private SickChildItem cursorToSubCatList(Cursor cursor) {
        SickChildItem item = new SickChildItem();
        item.id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
        item.facility_id = AppUtils.itos(cursor.getInt(cursor.getColumnIndex(KEY_FACILITY_ID)));
        item.name = item.sp_client = cursor.getString(cursor.getColumnIndex(KEY_SP_CLIENT));
        item.so_designation =cursor.getString(cursor.getColumnIndex(KEY_SP_DESIGNATGION));
        item.serial_no = cursor.getString(cursor.getColumnIndex(KEY_SERIAL_NO));
        item.form_date = cursor.getString(cursor.getColumnIndex(KEY_FORM_DATE));
        item.start_time = cursor.getString(cursor.getColumnIndex(KEY_START_TIME));
        item.child_description = cursor.getString(cursor.getColumnIndex(KEY_CHILD_DESCRIPTION));
        item.age = cursor.getString(cursor.getColumnIndex(KEY_AGE));
        item.feed= cursor.getString(cursor.getColumnIndex(KEY_FEED));
        item.vomit= cursor.getString(cursor.getColumnIndex(KEY_VOMIT));
        item.stutter= cursor.getString(cursor.getColumnIndex(KEY_STUTTER));
        item.cough =cursor.getString(cursor.getColumnIndex(KEY_COUGH));
        item.diahorea = cursor.getString(cursor.getColumnIndex(KEY_DIAHOREA));
        item.fever = cursor.getString(cursor.getColumnIndex(KEY_FEVER));
        item.measure_fever= cursor.getString(cursor.getColumnIndex(KEY_MEASURE_FEVER));
        item.stethoscope= cursor.getString(cursor.getColumnIndex(KEY_STETHOSCOPE));
        item.breathing_test = cursor.getString(cursor.getColumnIndex(KEY_BREATHING_TEST));
        item.eye_test= cursor.getString(cursor.getColumnIndex(KEY_EYE_TEST));
        item.infected_mouth=cursor.getString(cursor.getColumnIndex(KEY_INFECTED_MOUTH));
        item.neck=cursor.getString(cursor.getColumnIndex(KEY_NECK));
        item.ear= cursor.getString(cursor.getColumnIndex(KEY_EAR));
        item.hand= cursor.getString(cursor.getColumnIndex(KEY_HAND));
        item.dehydration= cursor.getString(cursor.getColumnIndex(KEY_DEHYDRATION));
        item.weight = cursor.getString(cursor.getColumnIndex(KEY_WEIGHT));
        item.clinic_test = cursor.getString(cursor.getColumnIndex(KEY_CLINIC_TEST));
        item.belly_button=cursor.getString(cursor.getColumnIndex(KEY_BELLEY_BUTTON));
        item.height= cursor.getString(cursor.getColumnIndex(KEY_HEIGHT));
        item.result=cursor.getString(cursor.getColumnIndex(KEY_RESULT));
        item.end_time=cursor.getString(cursor.getColumnIndex(KEY_END_TIME));
        item.village= cursor.getString(cursor.getColumnIndex(KEY_VILLAGE));
        item.district=cursor.getString(cursor.getColumnIndex(KEY_DISTRICT));
        item.union= cursor.getString(cursor.getColumnIndex(KEY_UNION));
        item.subdistrict = cursor.getString(cursor.getColumnIndex(KEY_SUB_DISTRICT));
        item.ct_client = cursor.getString(cursor.getColumnIndex(KEY_CT_CLIENT));
        item.status = cursor.getInt(cursor.getColumnIndex(KEY_STATUS));


        item.comments = cursor.getString(cursor.getColumnIndex(KEY_COMMENTS));
        item.fields = cursor.getString(cursor.getColumnIndex(KEY_FIELDS));
        item.user_id = cursor.getString(cursor.getColumnIndex(KEY_USER_ID));
        item.meta = cursor.getString(cursor.getColumnIndex(KEY_META));
        item.submittedBy = cursor.getString(cursor.getColumnIndex(KEY_SUBMITTED_BY));
        item.form_type = cursor.getString(cursor.getColumnIndex(KEY_FORM_TYPE));
        return item;
    }

    public long insert(SickChildItem item) {
        ContentValues values= new ContentValues();
        values.put(KEY_ID,item.id);
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

        values.put(KEY_USER_ID,item.user_id);
        values.put(KEY_COMMENTS,item.comments);
        values.put(KEY_FIELDS,item.fields);
        values.put(KEY_META,item.meta);
        values.put(KEY_SUBMITTED_BY,item.submittedBy);
        values.put(KEY_FORM_TYPE,item.form_type);


        SQLiteDatabase db = openDB();
        boolean hasItem = hasItem(item.id);
        if(hasItem){
            db.update(TABLE_NAME,values,KEY_ID + "=" + item.id,null);
        }
        else {
            long id = db.insert(TABLE_NAME, null, values);
            Log.e("sch id:","" + id);
        }
        closeDB();
        return item.id;
    }

    public static List<DBRow> toDbrow(List<SickChildItem> list){
        List<DBRow> result = new ArrayList<>();
        for(SickChildItem item : list){
            result.add(item);
        }
        return result;
    }

    public SickChildItem get(long id) {

        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " where _id=" + id, null);

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                return cursorToSubCatList(cursor);
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return new SickChildItem();
    }
}
