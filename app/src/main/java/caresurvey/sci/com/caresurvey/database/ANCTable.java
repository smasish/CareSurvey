package caresurvey.sci.com.caresurvey.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Hashtable;

import caresurvey.sci.com.caresurvey.model.DBRow;
import caresurvey.sci.com.caresurvey.model.ANCFormItem;


/**
 *  Created by mazharul.islam on 3/6/2016.
 *
 * @author arafat
 */
public class ANCTable extends SuperTable{
    private static final String TAG = FormTable.class.getSimpleName();

    private static final String TABLE_NAME = DatabaseHelper.FORM_USER;

    private static final String KEY_ID = "_id"; // 0 -integer
    private static final String KEY_BLOOD = "_bloodpressure"; // 1 - text
    private static final String KEY_HEMO = "_hemoglobintest"; // 2 - text
    private static final String KEY_URINE = "_urinetest"; // 1 - text
    private static final String KEY_PREGFOOD = "_pregnancyfood"; // 2 - text
    private static final String KEY_PREGDANGER = "_pregnancydanger"; // 1 - text
    private static final String KEY_FOURCENTER = "_fourparts"; // 2 - text
    private static final String KEY_DELIVERY = "_delivery"; // 1 - text
    private static final String KEY_FEED = "_feedbaby"; // 2 - text
    private static final String KEY_SIXMONTHS = "_sixmonths"; // 1 - text
    private static final String KEY_FAMILY = "_familyplanning"; // 2 - text
    private static final String KEY_FOLICTAB = "_folictablet"; // 1 - text
    private static final String KEY_FOLICIMP = "_folictabletimportance"; // 1 - text
    private static final String KEY_FOLICSIDEEFFECT = "_folicsideeffect";
    private static final String KEY_GLOBAL_ID = "_globalId"; // 1 - text
    private static final String KEY_NAME = "_names"; // 1 - text
    private static final String KEY_COMMENT = "_comments"; // 1 - text
    private static final String KEY_FIELDS = "_fields"; // 1 - text
    private static final String KEY_INS = "_ins"; // 1 - text
    private static final String KEY_DATE_PICK= "_datepick";
    private static final String KEY_TIME_PICK= "_timepick";
    private static final String KEY_COLLECTOR_NAME= "_collectorname";
    private static final String KEY_DIVISION = "_division";
    private static final String KEY_UPOZILA= "_upozila";
    private static final String KEY_UNION= "_union";
    private static final String KEY_VILLAGE= "_village";
    private static final String KEY_OBSTYPE= "_obstype";
    private static final String KEY_DATE = "_date";
    private static final String KEY_START_TIME = "_start_time";
    private static final String KEY_END_TIME = "_end_time";
    private static final String KEY_WEIGHT = "_weight";
    private static final String KEY_DISTRIC = "_district";
    private static final String KEY_SERVICE = "_service";

    public ANCTable(Context context) {
        super(context,TABLE_NAME);
    }


    public long insertItem(ANCFormItem formItem) {
        return insertItem(formItem.getPatientid(),formItem.getBloodpressure(),formItem.getHemoglobintest(),
                formItem.getUrinetest(),formItem.getPregnancyfood(),formItem.getPregnancydanger(),formItem.getFourparts(),
                formItem.getDelivery(),formItem.getFeedbaby(),formItem.getSixmonths(),formItem.getFamilyplanning(),formItem.getFolictablet(),
                formItem.getFolictabletimportance(),formItem.getStatus(),formItem.getGlobal_id(),formItem.getName(),formItem.getComments(),formItem.getFields(),formItem.getInS(),formItem.getDatepick(),formItem.getTimepick(),formItem.getCollector_name(),formItem.getDivision(),formItem.getUpozila(),formItem.getUnion(),formItem.getVillage(),formItem.getObs_type());
    }

    public long insertItem(long patientid, String bloodpressure, String hemoglobintest,
                           String urinetest, String pregnancyfood, String pregnancydanger,
                           String fourparts, String delivery, String feedbaby,
                           String sixmonths, String familyplanning, String folictablet,
                           String folictabletimportance, int status, String globalId, String name,String comments, String fields, String inS, String datepick,String timepick,String collector_name, String division, String upozila, String union, String village, String obstype) {
        if (isFieldExist(patientid)) {
            return updateItem(patientid,bloodpressure, hemoglobintest,
                    urinetest, pregnancyfood, pregnancydanger,
                    fourparts, delivery,feedbaby,
                    sixmonths, familyplanning,folictablet, folictabletimportance,status,globalId,name,comments,fields,inS,datepick,timepick,collector_name,division,upozila,union,village,obstype);
        }
        ContentValues values = new ContentValues();
        values.put(KEY_ID, patientid);
        values.put(KEY_BLOOD, bloodpressure);
        values.put(KEY_HEMO, hemoglobintest);
        values.put(KEY_URINE, urinetest);
        values.put(KEY_PREGFOOD, pregnancyfood);
        values.put(KEY_PREGDANGER, pregnancydanger);
        values.put(KEY_FOURCENTER, fourparts);
        values.put(KEY_DELIVERY, delivery);
        values.put(KEY_FEED, feedbaby);
        values.put(KEY_SIXMONTHS, sixmonths);
        values.put(KEY_FAMILY, familyplanning);
        values.put(KEY_FOLICTAB, folictablet);
        values.put(KEY_FOLICIMP, folictabletimportance);
//        values.put(DBKEY_STATUS, status);
        values.put(KEY_GLOBAL_ID, globalId);
        values.put(KEY_NAME, name);
        values.put(KEY_COMMENT, comments);
        values.put(KEY_FIELDS, fields);
        values.put(KEY_INS, inS);
        values.put(KEY_DATE_PICK,datepick);
        values.put(KEY_TIME_PICK, timepick);
        values.put(KEY_COLLECTOR_NAME, collector_name);
        values.put(KEY_DIVISION, division);
        values.put(KEY_UPOZILA, upozila);
        values.put(KEY_UNION, union);
        values.put(KEY_VILLAGE, village);
        values.put(KEY_OBSTYPE, obstype);

        SQLiteDatabase db = openDB();
        long ret= db.insert(TABLE_NAME, null, values);
        closeDB();
        return ret;
    }


    public ArrayList<ANCFormItem> getAllInfo() {
        ArrayList<ANCFormItem> subCatList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME , null);

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                subCatList.add(cursorToSubCatList(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return subCatList;
    }
    public boolean isFieldExist(long id) {
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

    public ArrayList<ANCFormItem> getAll() {
        ArrayList<ANCFormItem> FieldList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                FieldList.add(cursorToSubCatList(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return FieldList;
    }



    public ArrayList<ANCFormItem> getSpecificItem(int cat_id) {
        ArrayList<ANCFormItem> subCatList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE "+ KEY_ID+"="+cat_id, null);



        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                subCatList.add(cursorToSubCatList(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return subCatList;
    }



    public ArrayList<ANCFormItem> dateconcate(int patient_id) {
        ArrayList<ANCFormItem> subCatList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE "+ KEY_ID+"="+patient_id, null);



        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                subCatList.add(cursorToSubCatList(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return subCatList;
    }

    public ArrayList<ANCFormItem> getAllItem(int cat_id) {
        ArrayList<ANCFormItem> subCatList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME , null);



        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                subCatList.add(cursorToSubCatList(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return subCatList;
    }






    public long updateItem(long patientid, String bloodpressure, String hemoglobintest,
                           String urinetest, String pregnancyfood, String pregnancydanger,
                           String fourparts, String delivery, String feedbaby,
                           String sixmonths, String familyplanning, String folictablet,
                           String folictabletimportance,int status, String globalId, String name, String comments, String fields, String inS, String datepick, String timepick, String collector_name, String division, String upozila, String union, String village, String obstype) {


        ContentValues values = new ContentValues();
        values.put(KEY_ID, patientid);
        values.put(KEY_BLOOD, bloodpressure);
        values.put(KEY_HEMO, hemoglobintest);
        values.put(KEY_URINE, urinetest);
        values.put(KEY_PREGFOOD, pregnancyfood);
        values.put(KEY_PREGDANGER, pregnancydanger);
        values.put(KEY_FOURCENTER, fourparts);
        values.put(KEY_DELIVERY, delivery);
        values.put(KEY_FEED, feedbaby);
        values.put(KEY_SIXMONTHS, sixmonths);
        values.put(KEY_FAMILY, familyplanning);
        values.put(KEY_FOLICTAB, folictablet);
        values.put(KEY_FOLICIMP, folictabletimportance);
//        values.put(KEY_STATUS, status);
        values.put(KEY_GLOBAL_ID, globalId);
        values.put(KEY_NAME, name);
        values.put(KEY_COMMENT, comments);
        values.put(KEY_FIELDS,fields);
        values.put(KEY_INS,inS);
        values.put(KEY_DATE_PICK,datepick);
        values.put(KEY_TIME_PICK,timepick);
        values.put(KEY_COLLECTOR_NAME,collector_name);
        values.put(KEY_DIVISION,division);
        values.put(KEY_UPOZILA,upozila);
        values.put(KEY_UNION,union);
        values.put(KEY_VILLAGE,village);
        values.put(KEY_OBSTYPE,obstype);

        SQLiteDatabase db = openDB();
        long ret = db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{patientid + ""});
        closeDB();
        return ret;
    }

    public long updateItemq(int patientid, String bloodpressure, String hemoglobintest,
                            String urinetest, String pregnancyfood, String pregnancydanger,
                            String fourparts, String delivery, String feedbaby,
                            String sixmonths, String familyplanning, String folictablet, String folimp_status,int status,String name, String datepicker, String timepicker, String collcetor_name, String facility, String subDiv, String union, String vaillage) {


        ContentValues values = new ContentValues();
        values.put(KEY_ID, patientid);
        values.put(KEY_BLOOD, bloodpressure);
        values.put(KEY_HEMO, hemoglobintest);
        values.put(KEY_URINE, urinetest);
        values.put(KEY_PREGFOOD, pregnancyfood);
        values.put(KEY_PREGDANGER, pregnancydanger);
        values.put(KEY_FOURCENTER, fourparts);
        values.put(KEY_DELIVERY, delivery);
        values.put(KEY_FEED, feedbaby);
        values.put(KEY_SIXMONTHS, sixmonths);
        values.put(KEY_FAMILY, familyplanning);
        values.put(KEY_FOLICTAB, folictablet);
        values.put(KEY_FOLICIMP, folimp_status);

//        values.put(KEY_STATUS, status);
        values.put(KEY_NAME, name);
        values.put(KEY_DATE_PICK, datepicker);
        values.put(KEY_TIME_PICK, timepicker);
        values.put(KEY_COLLECTOR_NAME, collcetor_name);
        values.put(KEY_DIVISION,facility);
        values.put(KEY_UPOZILA,subDiv);
        values.put(KEY_UNION,union);
        values.put(KEY_VILLAGE,vaillage);




        SQLiteDatabase db = openDB();
        long ret = db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{patientid + ""});
        closeDB();
        return ret;
    }



    public long updatefor(int patientid, String bloodpressure, String hemoglobintest,
                          String urinetest, String pregnancyfood, String pregnancydanger,
                          String fourparts, String delivery, String feedbaby,
                          String sixmonths, String familyplanning, String folictablet, String folimp_status,int status, String date) {


        ContentValues values = new ContentValues();
        values.put(KEY_ID, patientid);
        values.put(KEY_BLOOD, bloodpressure);
        values.put(KEY_HEMO, hemoglobintest);
        values.put(KEY_URINE, urinetest);
        values.put(KEY_PREGFOOD, pregnancyfood);
        values.put(KEY_PREGDANGER, pregnancydanger);
        values.put(KEY_FOURCENTER, fourparts);
        values.put(KEY_DELIVERY, delivery);
        values.put(KEY_FEED, feedbaby);
        values.put(KEY_SIXMONTHS, sixmonths);
        values.put(KEY_FAMILY, familyplanning);
        values.put(KEY_FOLICTAB, folictablet);
        values.put(KEY_FOLICIMP, folimp_status);

//        values.put(KEY_STATUS, status);
        values.put(KEY_DATE_PICK,date);






        SQLiteDatabase db = openDB();
        long ret = db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{patientid + ""});
        closeDB();
        return ret;
    }


    public long updateSupervisor(String globalId, int patientId) {
        ContentValues values = new ContentValues();
        values.put(KEY_GLOBAL_ID, globalId);
        values.put(KEY_ID, patientId);
        SQLiteDatabase db = openDB();
        Log.d(".....>>>>>>>>>>", "...");
        Log.d(".....>>>>>>>>>>", "..." + patientId);
        long ret = db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{patientId + ""});
        closeDB();
        return ret;
    }




    public long updatefieldforuser(int patientId, int status, String comments,
                                   String fields) {


        ContentValues values = new ContentValues();
        values.put(KEY_ID, patientId);
//        values.put(KEY_STATUS, status);
        values.put(KEY_COMMENT, comments);
        values.put(KEY_FIELDS, fields);



        SQLiteDatabase db = openDB();
        long ret = db.update(TABLE_NAME, values, KEY_GLOBAL_ID + " = ?",
                new String[]{patientId + ""});
        Log.d("......false", ">>>>>>>" + patientId);

        closeDB();
        return ret;
    }



    public long updateglobalId(int globalId, int patientId, String comments,String fields,String name) {
        ContentValues values = new ContentValues();
        values.put(KEY_ID, globalId);
//        values.put(KEY_STATUS, patientId);
        values.put(KEY_COMMENT, comments);
        values.put(KEY_FIELDS, fields);
        values.put(KEY_NAME, name);
        SQLiteDatabase db = openDB();

        Log.d(".....>>>>>>>>>>", "Status-insert " +globalId);
        long ret = db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{globalId + ""});
        closeDB();
        return ret;
    }





    public long updateglobalI(int globalId, int patientId) {
        ContentValues values = new ContentValues();
        values.put(KEY_ID, globalId);
//        values.put(KEY_STATUS, patientId);

        SQLiteDatabase db = openDB();

        Log.d(".....>>>>>>>>>>", "Status " +patientId);
        long ret = db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{globalId + ""});
        closeDB();
        return ret;
    }




    public long updateIns(String ins, int patientId) {
        ContentValues values = new ContentValues();
        values.put(KEY_INS, ins);
        values.put(KEY_ID, patientId);
        SQLiteDatabase db = openDB();
        Log.d(".....>>>>>>>>>>","...");
        Log.d(".....>>>>>>>>>>","..."+patientId);
        long ret = db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{patientId + ""});
        closeDB();
        return ret;
    }



    private long Updatedata(int patientid, String bloodpressure, String hemoglobintest,
                            String urinetest, String pregnancyfood, String pregnancydanger,
                            String fourparts, String delivery, String feedbaby,
                            String sixmonths, String familyplanning, String folictablet,
                            String folictabletimportance,String obstype) {


        ContentValues values = new ContentValues();
        values.put(KEY_ID, patientid);
        values.put(KEY_BLOOD, bloodpressure);
        values.put(KEY_HEMO, hemoglobintest);
        values.put(KEY_URINE, urinetest);
        values.put(KEY_PREGFOOD, pregnancyfood);
        values.put(KEY_PREGDANGER, pregnancydanger);
        values.put(KEY_FOURCENTER, fourparts);
        values.put(KEY_DELIVERY, delivery);
        values.put(KEY_FEED, feedbaby);
        values.put(KEY_SIXMONTHS, sixmonths);
        values.put(KEY_FAMILY, familyplanning);
        values.put(KEY_FOLICTAB, folictablet);
        values.put(KEY_FOLICIMP, folictabletimportance);
        values.put(KEY_OBSTYPE, obstype);

        SQLiteDatabase db = openDB();
        long ret = db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{patientid + ""});
        closeDB();
        return ret;
    }


    public ANCFormItem cursorToSubCatList(Cursor cursor) {
        return cursorlist(cursor);
    }

    public void dropTable() {
        SQLiteDatabase db = openDB();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        createTable();
        //Lg.d(TAG, "Table dropped and recreated.");
        closeDB();
    }

    @Override
    protected void generateTable() {
        Hashtable<String,String> table = new Hashtable<String,String>();
        table.put(KEY_ID, " integer primary key"); //must need to  add this key
        table.put(KEY_DATE ," TEXT");
        table.put(KEY_START_TIME ," TEXT");
        table.put(KEY_END_TIME ," TEXT");
        table.put(KEY_SERVICE ," TEXT");
        table.put(KEY_BLOOD ," TEXT");
        table.put(KEY_WEIGHT ," TEXT");// 1 - text
        table.put(KEY_HEMO ," TEXT");
        table.put(KEY_URINE ," TEXT");              // 1 - text
        table.put(KEY_PREGFOOD ," TEXT");
        table.put(KEY_PREGDANGER ," TEXT");              // 1 - text
        table.put(KEY_FOURCENTER ," TEXT");
        table.put(KEY_DELIVERY ," TEXT");              // 1 - text
        table.put(KEY_FEED ," TEXT");
        table.put(KEY_SIXMONTHS ," TEXT");              // 1 - text
        table.put(KEY_FAMILY ," TEXT");
        table.put(KEY_FOLICTAB ," TEXT");
        table.put(KEY_FOLICIMP ," TEXT");// 1 - text
        table.put(KEY_FOLICSIDEEFFECT," TEXT ");
        table.put(KEY_GLOBAL_ID ," TEXT");
        table.put(KEY_NAME ," TEXT");
        table.put(KEY_INS ," TEXT");
        table.put(KEY_DATE_PICK ," TEXT");
        table.put(KEY_TIME_PICK ," TEXT");
        table.put(KEY_COLLECTOR_NAME ," TEXT");
        table.put(KEY_DIVISION ," TEXT");
        table.put(KEY_UPOZILA ," TEXT");
        table.put(KEY_UNION ," TEXT");
        table.put(KEY_VILLAGE ," TEXT");
        table.put(KEY_OBSTYPE ," TEXT");
        table.put(KEY_DISTRIC ," TEXT ");
        table.put(DBRow.KEY_STATUS,"integer");

        table.put(DBRow.KEY_COMMENTS,"text");
        table.put(DBRow.KEY_FIELDS,"text");
        table.put(DBRow.KEY_CHECKED_BY,"text");
        table.put(DBRow.KEY_SUBMITTED_BY,"text");
        table.put(DBRow.KEY_FACILITY,"text");
        table.put(DBRow.KEY_LAT,"text");
        table.put(DBRow.KEY_LON,"text");
        setNewTable(TABLE_NAME, table);
    }


    public long insert(ANCFormItem item) {
        ContentValues values = new ContentValues();
        values.put(KEY_DATE,item.date);
        values.put(KEY_START_TIME,item.start_time);
        values.put(KEY_SERVICE,item.serviceDescription);
        values.put(KEY_BLOOD, item.bloodpressure);
        values.put(KEY_WEIGHT, item.weight);
        values.put(KEY_HEMO, item.hemoglobintest);
        values.put(KEY_URINE, item.urinetest);
        values.put(KEY_PREGFOOD, item.pregnancyfood);
        values.put(KEY_PREGDANGER, item.pregnancydanger);
        values.put(KEY_FOURCENTER, item.fourparts);
        values.put(KEY_DELIVERY, item.delivery);
        values.put(KEY_FEED, item.feedbaby);
        values.put(KEY_SIXMONTHS, item.sixmonths);
        values.put(KEY_FAMILY, item.familyplanning);
        values.put(KEY_FOLICTAB, item.folictablet);
        values.put(KEY_FOLICIMP, item.folictabletimportance);
        values.put(KEY_FOLICSIDEEFFECT,item.folicsideeffect);
        values.put(KEY_NAME, item.name);
        values.put(KEY_DATE_PICK,item.datepick);
        values.put(KEY_TIME_PICK, item.timepick);
        values.put(KEY_COLLECTOR_NAME, item.collector_name);
        values.put(KEY_DIVISION, item.division);
        values.put(KEY_UPOZILA, item.upozila);
        values.put(KEY_UNION, item.union);
        values.put(KEY_VILLAGE, item.village);
        values.put(KEY_OBSTYPE, item.obs_type);
        values.put(KEY_DISTRIC, item.district);
        values.put(DBRow.KEY_STATUS,item.status);

        values.put(DBRow.KEY_LAT,item.lat);
        values.put(DBRow.KEY_LON,item.lon);
        values.put(DBRow.KEY_FACILITY,item.facility);

        values.put(DBRow.KEY_COMMENTS,item.comments);
        values.put(DBRow.KEY_FIELDS,item.fields);
        values.put(DBRow.KEY_CHECKED_BY,item.checkedBy);
        values.put(DBRow.KEY_SUBMITTED_BY,item.submittedBy);
        SQLiteDatabase db = openDB();
        if(item.id > 0){
            values.put(KEY_ID,item.id);
            boolean hasItem = hasItem(item.id);
            if(hasItem) {
                int status = db.update(TABLE_NAME, values, KEY_ID + "=" + item.id, null);
                Log.e("update state: ",""+status);
            }
            else{
                long status = db.insert(TABLE_NAME, null, values);
                Log.e("update state: ",""+status);
            }
        }
        else {
            item.id = db.insert(TABLE_NAME, null, values);
        }
        closeDB();
        return item.id;
    }

    public ANCFormItem get(long id) {
        ANCFormItem item = new ANCFormItem();
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

    private ANCFormItem cursorlist(Cursor cursor) {
        ANCFormItem item = new ANCFormItem();
        item.id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
        item.date = cursor.getString(cursor.getColumnIndex(KEY_DATE));
        item.start_time = cursor.getString(cursor.getColumnIndex(KEY_START_TIME));
        item.serviceDescription = cursor.getString(cursor.getColumnIndex(KEY_SERVICE));
        item.bloodpressure = cursor.getString(cursor.getColumnIndex(KEY_BLOOD));
        item.weight = cursor.getString(cursor.getColumnIndex(KEY_WEIGHT));
        item.hemoglobintest = cursor.getString(cursor.getColumnIndex(KEY_HEMO));
        item.urinetest = cursor.getString(cursor.getColumnIndex(KEY_URINE));
        item.pregnancyfood = cursor.getString(cursor.getColumnIndex(KEY_PREGFOOD));
        item.pregnancydanger = cursor.getString(cursor.getColumnIndex(KEY_PREGDANGER));
        item.fourparts = cursor.getString(cursor.getColumnIndex(KEY_FOURCENTER));
        item.delivery = cursor.getString(cursor.getColumnIndex(KEY_DELIVERY));
        item.feedbaby = cursor.getString(cursor.getColumnIndex(KEY_FEED));
        item.sixmonths = cursor.getString(cursor.getColumnIndex(KEY_SIXMONTHS));
        item.familyplanning = cursor.getString(cursor.getColumnIndex(KEY_FAMILY));
        item.folictablet = cursor.getString(cursor.getColumnIndex(KEY_FOLICTAB));
        item.folictabletimportance = cursor.getString(cursor.getColumnIndex(KEY_FOLICIMP));
        item.folicsideeffect = cursor.getString(cursor.getColumnIndex(KEY_FOLICSIDEEFFECT));
        item.name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
        item.datepick = cursor.getString(cursor.getColumnIndex(KEY_DATE_PICK));
        item.timepick = cursor.getString(cursor.getColumnIndex(KEY_TIME_PICK));
        item.collector_name = cursor.getString(cursor.getColumnIndex(KEY_COLLECTOR_NAME));
        item.division = cursor.getString(cursor.getColumnIndex(KEY_DIVISION));
        item.upozila = cursor.getString(cursor.getColumnIndex(KEY_UPOZILA));
        item.union = cursor.getString(cursor.getColumnIndex(KEY_UNION));
        item.village = cursor.getString(cursor.getColumnIndex(KEY_VILLAGE));
        item.district = cursor.getString(cursor.getColumnIndex(KEY_DISTRIC));
        item.status = cursor.getInt(cursor.getColumnIndex(DBRow.KEY_STATUS));
        item.facility = cursor.getString(cursor.getColumnIndex(DBRow.KEY_FACILITY));
        item.lat = cursor.getString(cursor.getColumnIndex(DBRow.KEY_LAT));
        item.lon = cursor.getString(cursor.getColumnIndex(DBRow.KEY_LON));
        item.comments = cursor.getString(cursor.getColumnIndex(DBRow.KEY_COMMENTS));
        item.fields = cursor.getString(cursor.getColumnIndex(DBRow.KEY_FIELDS));
        item.checkedBy = cursor.getString(cursor.getColumnIndex(DBRow.KEY_CHECKED_BY));
        item.submittedBy = cursor.getString(cursor.getColumnIndex(DBRow.KEY_SUBMITTED_BY));
        return item;
    }
}