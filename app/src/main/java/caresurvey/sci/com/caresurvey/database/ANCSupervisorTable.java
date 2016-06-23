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
import caresurvey.sci.com.caresurvey.model.ANCFormItem;

/**
 * Created by shantanu on 6/14/16.
 */

public class ANCSupervisorTable extends SuperTable{
    private static final String TABLE_NAME = DatabaseHelper.FORM_ANC_SUPERVISOR;
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
    private static final String KEY_STATUS = "_status"; // 1 - text
    private static final String KEY_GLOBAL_ID = "_globalId"; // 1 - text
    private static final String KEY_NAME = "_names"; // 1 - text
    private static final String KEY_COMMENT = "_comments"; // 1 - text
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

    private static final String KEY_USER_ID = "_user_id";
    private static final String KEY_COMMENTS="_comments";
    private static final String KEY_FIELDS="_fields";
    private static final String KEY_META="_meta";
    private static final String KEY_SUBMITTED_BY="_submitted_by";
    private static final String KEY_FORM_TYPE = "_form_type";

    public ANCSupervisorTable(Context context) {
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
            Log.e("anc_supervisor table:","created");
            closeDB();
        }
        catch (Exception e){
            e.printStackTrace();
        }
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
        table.put(KEY_STATUS ," TEXT");
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
        table.put(KEY_FOLICSIDEEFFECT," TEXT ");
        table.put(DBRow.KEY_FACILITY,"TEXT");
        table.put(DBRow.KEY_LAT,"TEXT");
        table.put(DBRow.KEY_LON,"TEXT");

        table.put(DBRow.KEY_STATUS,"integer");
        //supervisor field
        table.put(KEY_USER_ID,"text");
        table.put(KEY_COMMENTS,"text");
        table.put(KEY_FIELDS,"text");
        table.put(KEY_META,"text");
        table.put(KEY_SUBMITTED_BY,"text");
        table.put(KEY_FORM_TYPE,"text");
        setNewTable(TABLE_NAME, table);
    }

    public List<ANCFormItem> getList(String cName, String facility) {
        ArrayList<ANCFormItem> fpList = new ArrayList<>();
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

    private ANCFormItem cursorToSubCatList(Cursor cursor) {
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

        item.comments = cursor.getString(cursor.getColumnIndex(KEY_COMMENTS));
        item.fields = cursor.getString(cursor.getColumnIndex(KEY_FIELDS));
        item.user_id = cursor.getString(cursor.getColumnIndex(KEY_USER_ID));
        item.meta = cursor.getString(cursor.getColumnIndex(KEY_META));
        item.submittedBy = cursor.getString(cursor.getColumnIndex(KEY_SUBMITTED_BY));
        item.form_type = cursor.getString(cursor.getColumnIndex(KEY_FORM_TYPE));

        return item;
    }

    public long insert(ANCFormItem item) {
        ContentValues values = new ContentValues();
        values.put(KEY_ID,item.id);
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
        values.put(KEY_STATUS, item.status);
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
        values.put(DBRow.KEY_FACILITY,item.facility);
        values.put(DBRow.KEY_LAT,item.lat);
        values.put(DBRow.KEY_LON,item.lon);

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
            Log.e("anc id:","" + id);
        }
        closeDB();
        return item.id;
    }

    public static List<DBRow> toDbrow(List<ANCFormItem> list){
        List<DBRow> result = new ArrayList<>();
        for(ANCFormItem item : list){
            result.add(item);
        }
        return result;
    }

    public ANCFormItem get(long id) {

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
        return new ANCFormItem();
    }
}
