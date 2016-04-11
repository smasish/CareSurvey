package caresurvey.sci.com.caresurvey.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by israt.jahan on 4/11/2016.
 */
public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;

    public static final String TABLE_UPOZILLA = "upazilla";
    static final String deptTable="division";
    static final String zillaTable="zilla";
    static final String zillaDID="DIVID";
    static final String zillaID="ZILLAID";
    static final String zillaNamebn="ZILLANAME";
    static final String colDeptID="_id";
    static final String colDeptName="division";
    public static final String KEY_ZILLADIV_ID ="DIVID";
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<String> getDivisions() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " +deptTable, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getZillaname(String insert) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT "+ zillaID + " as _id FROM " +zillaTable+ " WHERE "+ zillaDID + " = " +insert, null);

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                list.add(cursor.getString(cursor.getColumnIndex("_id")));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }
    public String GetDeptID(String Dept)
    {

        Cursor c=database.query(deptTable, new String[]{colDeptID + " as _id", colDeptName},
                colDeptName + "=?", new String[]{Dept}, null, null, null);
        //Cursor c=db.rawQuery("SELECT "+colDeptID+" as _id FROM "+deptTable+"
        //WHERE "+colDeptName+"=?", new String []{Dept});
        c.moveToFirst();
        return c.getString(c.getColumnIndex(colDeptID));
    }
   /* public int getDivisionid( String div) {
        int list = 0;
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_DIVISION + " WHERE "+ KEY_DIVISION + " = " +div ,null);
        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
               list=cursor.getInt(0);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }*/
  /*  public List<String> getZillaNames(int divid) {
        String divid2=String.valueOf(divid);
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " +TABLE_ZILLA + " WHERE "+KEY_ZILLADIV_ID+"="+ divid2, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(3));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }*/
}