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
public class DatabaseAccessUpazila {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;

String title3;
    static final String zillaTable="zilla";
    static final String id="DIVID";
    static final String zillaID="ZILLAID";
    static final String upazilaID="UPAZILAID";
    static final String upazillaName="UPAZILANAME";
    private static DatabaseAccessUpazila instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccessUpazila(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccessUpazila getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccessUpazila(context);
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
    public String GetupazilaID(String Dept)
    {

        Cursor cursor = database.rawQuery("SELECT * FROM upazila WHERE UPAZILANAME = ?", new String[]{Dept});

        if (cursor.moveToFirst()) {
            do {
                title3 = cursor.getString(cursor.getColumnIndex(upazilaID));


            } while (cursor.moveToNext());
        }

        cursor.close();;

        return title3;
    }
    public List<String> getUpaZillaname(String insert) {

        List<String> list = new ArrayList<>();


        Cursor cursor = database.rawQuery("SELECT * FROM upazila WHERE ZILLAID = ?", new String[]{ insert });

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                list.add(cursor.getString(cursor.getColumnIndex(upazillaName)));
            } while (cursor.moveToNext());
        }

        cursor.close();

        return list;
    }
    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */





}