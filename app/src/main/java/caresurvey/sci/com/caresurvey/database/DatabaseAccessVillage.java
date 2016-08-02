package caresurvey.sci.com.caresurvey.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import caresurvey.sci.com.caresurvey.model.AddressItem;

/**
 * Created by israt.jahan on 4/11/2016.
 */
public class DatabaseAccessVillage {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;

 String title2;
    static final String villageTable="village";
    static final String villageaid="VILLAGEID";
    static final String unionid="UNIONID";
    static final String villagename="VILLAGENAME";
    static final String villagenameeng = "VILLAGENAMEENG";
    private static DatabaseAccessVillage instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccessVillage(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccessVillage getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccessVillage(context);
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

    public List<String> getvilname(String insert) {
        List<String> list = new ArrayList<>();


        Cursor cursor = database.rawQuery("SELECT * FROM village WHERE UNIONID = ?", new String[]{ insert });

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                list.add(cursor.getString(cursor.getColumnIndex(villagename)));
            } while (cursor.moveToNext());
        }

        cursor.close();

        return list;
    }

    public List<AddressItem> getVillage(String districtid,String upazilaid, String unionid){
        List<AddressItem> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM village WHERE ZILLAID = ? and UPAZILAID = ? and UNIONID = ?", new String[]{ districtid,upazilaid,unionid });
        if (cursor.moveToFirst()) {
            do {
                AddressItem item = new AddressItem();
                item.id = cursor.getInt(cursor.getColumnIndex(villageaid));
                item.name = cursor.getString(cursor.getColumnIndex(villagename));
                item.nameEng = cursor.getString(cursor.getColumnIndex(villagenameeng));
                list.add(item);
            } while (cursor.moveToNext());
        }

        cursor.close();
        AddressItem item = new AddressItem();
        item.id = 999;
        item.name = "অন্যান্য";
        item.nameEng = "annanyo";
        list.add(item);
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
    public String GetvillageID(String Dept)
    {

        Cursor cursor = database.rawQuery("SELECT * FROM village WHERE VILLAGENAME = ?", new String[]{Dept});

        if (cursor.moveToFirst()) {
            do {
                title2 = cursor.getString(cursor.getColumnIndex(villageaid));


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