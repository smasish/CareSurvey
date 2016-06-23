package caresurvey.sci.com.caresurvey.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import caresurvey.sci.com.caresurvey.model.AddressItem;
import caresurvey.sci.com.caresurvey.utils.AppUtils;

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
    static final String upazillaid = "UPAZILAID";
    static final String upazillanameeng = "UPAZILANAMEENG";
    private static DatabaseAccessUpazila instance;

    private Hashtable<String,List<String> > restricted;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccessUpazila(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
        restricted = new Hashtable<>();
        List<String > list = new ArrayList<>();
        list.add("Nabiganj");
        restricted.put("36",list);
        list = new ArrayList<>();
        list.add("Kanthalia");
        restricted.put("42",list);
        list = new ArrayList<>();
        list.add("Kamalnagar");
        list.add("Ramgati");
        restricted.put("51",list);
        list = new ArrayList<>();
        list.add("Begumganj");
        restricted.put("75",list);
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

    public List<AddressItem> getUpazila(String zilaid) {
        List<AddressItem> list = new ArrayList<>();
        List<String> checkList = restricted.get(zilaid);
        Cursor cursor = database.rawQuery("SELECT * FROM upazila WHERE ZILLAID = ?", new String[]{  zilaid });
        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                AddressItem item = new AddressItem();
                item.id = cursor.getInt(cursor.getColumnIndex(upazilaID));
                item.nameEng = cursor.getString(cursor.getColumnIndex(upazillanameeng));
                item.name = cursor.getString(cursor.getColumnIndex(upazillaName));
                Log.e("upozila",item.nameEng);
                if(checkList != null){
                    for(String checkItem : checkList){
                        if(checkItem.equalsIgnoreCase(item.nameEng)){
                            list.add(item);
                            break;
                        }
                    }
                }
                else{
                    list.add(item);
                }

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