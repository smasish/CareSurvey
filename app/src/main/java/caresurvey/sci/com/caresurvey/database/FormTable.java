package caresurvey.sci.com.caresurvey.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import caresurvey.sci.com.caresurvey.model.ANCFormItem;

/**
 *  Created by mazharul.islam on 3/6/2016.
 *
 * @author arafat
 */
public class FormTable  {
    private static final String TAG = FormTable.class.getSimpleName();

    private static final String TABLE_NAME = DatabaseHelper.FORM;

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
    private static final String KEY_STATUS = "_status"; // 1 - text
    private static final String KEY_GLOBAL_ID = "_globalId"; // 1 - text
    private static final String KEY_NAME = "_names"; // 1 - text
    private static final String KEY_COMMENT = "_comments"; // 1 - text
    private static final String KEY_FIELDS = "_fields"; // 1 - text
    private static final String KEY_INS = "_ins"; // 1 - text
    private static final String KEY_CNAME = "_cname"; // 1 - text
    private static final String KEY_DATE_PICK = "_datepick"; // 1 - text
    private static final String KEY_TIME_PICK = "_timepick"; // 1 - text
    private static final String KEY_DISTRICT = "_district"; // 1 - text
    private static final String KEY_SUB_DISTRICT = "_subdistrict"; // 1 - text
    private static final String KEY_UNION = "_union"; // 1 - text
    private static final String KEY_VILLAGE = "_village"; // 1 - text









    private Context tContext;

    public FormTable (Context context) {
        tContext = context;
        createTable();
    }

    private void createTable() {
        SQLiteDatabase db = openDB();

        String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + "( "
                + KEY_ID + " INTEGER PRIMARY KEY, " // 0 - int
                + KEY_BLOOD + " TEXT, "              // 1 - text
                + KEY_HEMO + " TEXT, "
                + KEY_URINE + " TEXT, "              // 1 - text
                + KEY_PREGFOOD + " TEXT, "
                + KEY_PREGDANGER + " TEXT, "              // 1 - text
                + KEY_FOURCENTER + " TEXT, "
                + KEY_DELIVERY + " TEXT, "              // 1 - text
                + KEY_FEED + " TEXT, "
                + KEY_SIXMONTHS + " TEXT, "              // 1 - text
                + KEY_FAMILY + " TEXT, "
                + KEY_FOLICTAB + " TEXT, "
                + KEY_FOLICIMP + " TEXT, "// 1 - text
                + KEY_STATUS + " TEXT, "
                + KEY_GLOBAL_ID + " TEXT, "
                + KEY_NAME + " TEXT, "
                + KEY_COMMENT + " TEXT,"
                + KEY_FIELDS + " TEXT, "
                + KEY_INS + " TEXT, "
                + KEY_CNAME + " TEXT, "
                + KEY_DISTRICT + " TEXT, "
                + KEY_SUB_DISTRICT + " TEXT, "
                + KEY_UNION + " TEXT, "
                + KEY_VILLAGE + " TEXT "










                // 2 - text
                + " )";
        db.execSQL(CREATE_TABLE_SQL);
        closeDB();
    }

    private SQLiteDatabase openDB() {
        return DatabaseManager.getInstance(tContext).openDatabase();
    }

    private void closeDB() {
        DatabaseManager.getInstance(tContext).closeDatabase();
    }
    public long insertItem(ANCFormItem formItem) {
//        return insertItem(formItem.getPatientid(),formItem.getBloodpressure(),formItem.getHemoglobintest(),
//                formItem.getUrinetest(),formItem.getPregnancyfood(),formItem.getPregnancydanger(),formItem.getFourparts(),
//                formItem.getDelivery(),formItem.getFeedbaby(),formItem.getSixmonths(),formItem.getFamilyplanning(),formItem.getFolictablet(),
//                formItem.getFolictabletimportance(),formItem.getStatus(),formItem.getGlobal_id(),formItem.getName(),formItem.getComments(),formItem.getFields(),formItem.getInS(),formItem.getC_name(),formItem.getDistrict(),formItem.getSubdistrict(),formItem.getUnion(),formItem.getVillage());
        return 0;
    }
    public long insertItem(int patientid, String bloodpressure, String hemoglobintest,
                           String urinetest, String pregnancyfood, String pregnancydanger,
                           String fourparts, String delivery, String feedbaby,
                           String sixmonths, String familyplanning, String folictablet,
                           String folictabletimportance, int status, String globalId, String name,String comments, String fields, String inS,String c_name,String district, String subdistrict, String union, String village) {
        if (isFieldExist(patientid)) {
            return updateItem(patientid,bloodpressure, hemoglobintest,
                    urinetest, pregnancyfood, pregnancydanger,
                    fourparts, delivery,feedbaby,
                    sixmonths, familyplanning,folictablet,
                    folictabletimportance,status,globalId,name,comments,fields,inS,c_name,district,subdistrict,union,village);
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
        values.put(KEY_STATUS, status);
        values.put(KEY_GLOBAL_ID, globalId);
        values.put(KEY_NAME, name);
        values.put(KEY_COMMENT, comments);
        values.put(KEY_FIELDS, fields);
        values.put(KEY_INS, inS);
        values.put(KEY_CNAME, c_name);
        values.put(KEY_DISTRICT,district);
        values.put(KEY_SUB_DISTRICT,subdistrict);
        values.put(KEY_UNION,union);
        values.put(KEY_VILLAGE,village);





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

    public ArrayList<ANCFormItem> getListfromuser(String name, String  facility) {
        ArrayList<ANCFormItem> subCatList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE _district = '"+facility+"'" + " AND  _cname = '"+name+"'", null);
        Log.d("...>>>>>>", "valuecountDatabase " );
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






    public long updateItem(int patientid, String bloodpressure, String hemoglobintest,
                           String urinetest, String pregnancyfood, String pregnancydanger,
                           String fourparts, String delivery, String feedbaby,
                           String sixmonths, String familyplanning, String folictablet,
                           String folictabletimportance,int status, String globalId, String name, String comments, String fields,String inS,String cname,String district, String subdistrict, String union, String village) {


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
        values.put(KEY_STATUS, status);
        values.put(KEY_GLOBAL_ID, globalId);
        values.put(KEY_NAME, name);
        values.put(KEY_COMMENT, comments);
        values.put(KEY_FIELDS,fields);
        values.put(KEY_INS,inS);
        values.put(KEY_INS,cname);
        values.put(KEY_DISTRICT,district);
        values.put(KEY_SUB_DISTRICT,subdistrict);
        values.put(KEY_UNION,union);
        values.put(KEY_VILLAGE,village);

        SQLiteDatabase db = openDB();
        long ret = db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{patientid + ""});
        closeDB();
        return ret;
    }

    public long updateItemq(int patientid, String bloodpressure, String hemoglobintest,
                            String urinetest, String pregnancyfood, String pregnancydanger,
                            String fourparts, String delivery, String feedbaby,
                            String sixmonths, String familyplanning, String folictablet, String folimp_status, String inS) {


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
        values.put(KEY_INS, inS);



        SQLiteDatabase db = openDB();
        long ret = db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{patientid + ""});
        closeDB();
        return ret;
    }






    public long updatefieldforuser(String globalId, int status, String comments,
                                   String fields) {


        ContentValues values = new ContentValues();
        values.put(KEY_GLOBAL_ID, globalId);
        values.put(KEY_STATUS, status);
        values.put(KEY_COMMENT, comments);
        values.put(KEY_FIELDS, fields);



        SQLiteDatabase db = openDB();
        long ret = db.update(TABLE_NAME, values, KEY_GLOBAL_ID + " = ?",
                new String[]{globalId + ""});
        closeDB();
        return ret;
    }



    public long updateglobalId(String globalId, int patientId) {
        ContentValues values = new ContentValues();
        values.put(KEY_STATUS, globalId);
        values.put(KEY_ID, patientId);
        SQLiteDatabase db = openDB();
        Log.d(".....>>>>>>>>>>", "...");
        Log.d(".....>>>>>>>>>>", "..." + patientId);
        long ret = db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{patientId + ""});
        closeDB();
        return ret;
    }
    private long Updatedata(int patientid, String bloodpressure, String hemoglobintest,
                            String urinetest, String pregnancyfood, String pregnancydanger,
                            String fourparts, String delivery, String feedbaby,
                            String sixmonths, String familyplanning, String folictablet,
                            String folictabletimportance) {


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

        SQLiteDatabase db = openDB();
        long ret = db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{patientid + ""});
        closeDB();
        return ret;
    }


    public ANCFormItem cursorToSubCatList(Cursor cursor) {
        int _id = cursor.getInt(0);
        String _bloodpressure = cursor.getString(1);
        String _hemoglobintest = cursor.getString(2);
        String _urinetest = cursor.getString(3);
        String _pregnancyfood =cursor.getString(4);
        String _pregnancydanger = cursor.getString(5);
        String _fourparts = cursor.getString(6);
        String _delivery = cursor.getString(7);
        String _feedbaby = cursor.getString(8);
        String _sixmonths = cursor.getString(9);
        String _familyplanning =cursor.getString(10);
        String _folictablet = cursor.getString(11);
        String _folictabletimportance = cursor.getString(12);
        int _status = cursor.getInt(13);
        String _globalId = cursor.getString(14);
        String _name = cursor.getString(15);
        String _comments = cursor.getString(16);
        String _fields= cursor.getString(17);
        String _ins= cursor.getString(18);
        String _cname= cursor.getString(19);
        String _district= cursor.getString(20);
        String _subdistrict= cursor.getString(21);
        String _union= cursor.getString(22);
        String _village= cursor.getString(23);



        return new ANCFormItem();
//        return new ANCFormItem(_id, _bloodpressure,_hemoglobintest,_urinetest,_pregnancyfood,_pregnancydanger,_fourparts,
//                _delivery,_feedbaby,_sixmonths,_familyplanning,_folictablet,_folictabletimportance,_status,_globalId,_name,_comments,_fields,_ins,_cname,_district,_subdistrict,_union,_village);
    }

    public void dropTable() {
        SQLiteDatabase db = openDB();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        createTable();
        //Lg.d(TAG, "Table dropped and recreated.");
        closeDB();
    }

    public long getLastId(){
        SQLiteDatabase db = openDB();
        long lastId = 0;
        String query = "SELECT _id from " +  TABLE_NAME +" order by _id DESC limit 1";
        Cursor c = db.rawQuery(query,null);
        if (c != null && c.moveToFirst()) {
            lastId = c.getLong(0); //The 0 is the column index, we only have 1 column, so the index is 0
        }
        closeDB();
        return lastId;
    }

}