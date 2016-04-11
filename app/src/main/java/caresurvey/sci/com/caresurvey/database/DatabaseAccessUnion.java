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
public class DatabaseAccessUnion {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;

 String title2;
    static final String unionTable="unions";
    static final String upazilaDID="UPAZILAID";
    static final String unionid="UNIONID";
    static final String unioname="UNIONNAME";
    private static DatabaseAccessUnion instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccessUnion(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccessUnion getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccessUnion(context);
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

    public List<String> getunionname(String insert) {
        List<String> list = new ArrayList<>();


        Cursor cursor = database.rawQuery("SELECT * FROM unions WHERE UPAZILAID = ?", new String[]{ insert });

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                list.add(cursor.getString(cursor.getColumnIndex(unioname)));
            } while (cursor.moveToNext());
        }

        cursor.close();

        return list;
    }
  /*  public String GetDeptID(String Dept)
    {

        Cursor c=database.query(deptTable, new String[]{colDeptID + " as _id", colDeptName},
                colDeptName + "=?", new String[]{Dept}, null, null, null);
        //Cursor c=db.rawQuery("SELECT "+colDeptID+" as _id FROM "+deptTable+"
        //WHERE "+colDeptName+"=?", new String []{Dept});
        c.moveToFirst();
        return c.getString(c.getColumnIndex(colDeptID));
    }*/
    public String GetUnionID(String Dept)
    {

        Cursor cursor = database.rawQuery("SELECT * FROM unions WHERE UNIONNAME = ?", new String[]{Dept});

        if (cursor.moveToFirst()) {
            do {
                title2 = cursor.getString(cursor.getColumnIndex(unionid));


            } while (cursor.moveToNext());
        }

        cursor.close();

        return title2;
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