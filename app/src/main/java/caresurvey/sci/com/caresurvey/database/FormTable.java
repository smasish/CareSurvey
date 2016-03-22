package caresurvey.sci.com.caresurvey.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import caresurvey.sci.com.caresurvey.model.FormItem;

/**
 *  Created by israt.jahan on 3/6/2016.
 *
 * @author israt
 */
public class FormTable {
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
                + KEY_FOLICTAB + " TEXT, "              // 1 - text
                + KEY_FOLICIMP + " TEXT "

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
    public long insertItem(FormItem formItem) {
        return insertItem(formItem.getPatientid(),formItem.getBloodpressure(),formItem.getHemoglobintest(),
                formItem.getUrinetest(),formItem.getPregnancyfood(),formItem.getPregnancydanger(),formItem.getFourparts(),
                formItem.getDelivery(),formItem.getFeedbaby(),formItem.getSixmonths(),formItem.getFamilyplanning(),formItem.getFolictablet(),
                formItem.getFolictabletimportance());
    }
    public long insertItem(int patientid, String bloodpressure, String hemoglobintest,
                           String urinetest, String pregnancyfood, String pregnancydanger,
                           String fourparts, String delivery, String feedbaby,
                           String sixmonths, String familyplanning, String folictablet,
                           String folictabletimportance) {
        if (isFieldExist(patientid)) {
            return updateItem(patientid,bloodpressure, hemoglobintest,
                    urinetest, pregnancyfood, pregnancydanger,
                    fourparts, delivery,feedbaby,
                    sixmonths, familyplanning,folictablet,
                    folictabletimportance);
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



        SQLiteDatabase db = openDB();
        long ret= db.insert(TABLE_NAME, null, values);
        closeDB();
        return ret;
    }
    public ArrayList<FormItem> getAllInfo() {
        ArrayList<FormItem> subCatList = new ArrayList<>();
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

    private long updateItem(int patientid, String bloodpressure, String hemoglobintest,
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


    public FormItem cursorToSubCatList(Cursor cursor) {
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



        return new FormItem(_id,_bloodpressure,_hemoglobintest,_urinetest,_pregnancyfood,_pregnancydanger,_fourparts,
                _delivery,_feedbaby,_sixmonths,_familyplanning,_folictablet,_folictabletimportance);
    }

    public void dropTable() {
        SQLiteDatabase db = openDB();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        createTable();
        //Lg.d(TAG, "Table dropped and recreated.");
        closeDB();
    }
}
