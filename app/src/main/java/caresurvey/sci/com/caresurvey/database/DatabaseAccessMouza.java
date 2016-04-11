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
public class DatabaseAccessMouza {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;

String title4;
    static final String mouzaTable="mouza";
    static final String unionid="UNIONID";
    static final String mouzaid="MOUZAID";
    static final String upazilaID="UPAZILAID";
    static final String mouzaName="MOUZANAME";
    private static DatabaseAccessMouza instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccessMouza(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccessMouza getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccessMouza(context);
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
    public String GetmouzaID(String Dept)
    {

        Cursor cursor = database.rawQuery("SELECT * FROM mouza WHERE MOUZANAME = ?", new String[]{Dept});

        if (cursor.moveToFirst()) {
            do {
                title4 = cursor.getString(cursor.getColumnIndex(mouzaid));


            } while (cursor.moveToNext());
        }

        cursor.close();;

        return title4;
    }
    public List<String> getMouzaname(String insert) {

        List<String> list = new ArrayList<>();


        Cursor cursor = database.rawQuery("SELECT * FROM mouza WHERE UNIONID = ?", new String[]{ insert });

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                list.add(cursor.getString(cursor.getColumnIndex(mouzaName)));
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