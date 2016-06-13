package caresurvey.sci.com.caresurvey.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import caresurvey.sci.com.caresurvey.model.DBRow;
import caresurvey.sci.com.caresurvey.model.FpObservationFormItem;

/**
 * Created by Shantanu on 5/28/2016.
 */
public class FpObservationTable {
    private static final String KEY_ID= "_id";
    private static final String KEY_FACILITY_ID= "_facilityid";
    private static final String KEY_CLIENT_NAME= "_clientname";
    private static final String KEY_SERIAL= "_serialno";
    private static final String KEY_DATE= "_cdate";
    private static final String KEY_START_TIME= "_starttime";
    private static final String KEY_CONCENT= "_concent";
    private static final String KEY_COVER= "_cover";
    private static final String KEY_SOUND_PROVE= "_soundprove";
    private static final String KEY_DISCUSS_FP= "_discussfp";
    private static final String KEY_DISCUSS_FP_PROTOCOL= "_discussfpproto";
    private static final String KEY_W_TO_DO= "_wtd";
    private static final String KEY_QUESTION= "_question";
    private static final String KEY_JOB_AID= "_jobaid";
    private static final String KEY_FOLLOWUP= "_followup";
    private static final String KEY_END_TIME= "_endtime";
    private static final String TABLE_NAME = "fp_table";
    private final Context context;

    public FpObservationTable(Context context){
        this.context = context;
        List<String> tableQuery = getCreateTableQuery();
        SQLiteDatabase db = openDB();
        for(int i=0;i<tableQuery.size();i++)
        {
            db.execSQL(tableQuery.get(i));
        }
        closeDB();
    }

    public static void generateTable() // need to call this class once from application
    {
        //creating table for save cart
        Hashtable<String,String> table = new Hashtable<String,String>();
        table.put(KEY_ID, "integer primary key"); //must need to  add this key
        table.put(KEY_FACILITY_ID,"text");
        table.put(KEY_CLIENT_NAME,"text");
        table.put(KEY_SERIAL,"text");
        table.put(KEY_DATE,"text");
        table.put(KEY_START_TIME,"text");
        table.put(KEY_CONCENT,"text");
        table.put(KEY_COVER,"text");
        table.put(KEY_SOUND_PROVE,"text");
        table.put(KEY_DISCUSS_FP,"text");
        table.put(KEY_DISCUSS_FP_PROTOCOL,"text");
        table.put(KEY_W_TO_DO,"text");
        table.put(KEY_QUESTION,"text");
        table.put(KEY_JOB_AID,"text");
        table.put(KEY_FOLLOWUP,"text");
        table.put(KEY_END_TIME,"text");

        table.put(DBRow.KEY_STATUS,"integer");
        table.put(DBRow.KEY_UNION,"text");
        table.put(DBRow.KEY_VILLAGE,"text");
        table.put(DBRow.KEY_NAME,"text");
        table.put(DBRow.KEY_UPOZILA,"text");
        table.put(DBRow.KEY_COLLECTOR_NAME,"text");
        table.put(DBRow.KEY_DIVISION,"text");
        table.put(DBRow.KEY_TIME_PICK,"text");
        table.put(DBRow.KEY_DATE_PICK,"text");
        table.put(DBRow.KEY_OBSTYPE,"text");
        table.put(DBRow.KEY_FACILITY,"text");
        setNewTable(TABLE_NAME, table);

        //another table

    }

    private static Hashtable<String, Hashtable<String,String>> Tables = new Hashtable<String, Hashtable<String,String>>();
    public static void setNewTable(String tableName, Hashtable<String,String> params){
        Tables.put(tableName, params);
    }
    public static Hashtable<String, Hashtable<String,String>> getDbTable(){
        generateTable();
        return Tables;
    }

    @SuppressWarnings("unchecked")
    private List<String> getCreateTableQuery(){
        List<String> queries = new ArrayList<String>();
        Hashtable<String, Hashtable<String,String>> Tables = getDbTable();
        @SuppressWarnings("rawtypes")
        Set set = Tables.entrySet();
        @SuppressWarnings("rawtypes")
        Iterator it = set.iterator();
//        tableList.clear();
        while (it.hasNext())
        {
            @SuppressWarnings("rawtypes")
            Map.Entry entry = (Map.Entry) it.next();
            String tableName =(String) entry.getKey();
            Hashtable<String,String> columns = (Hashtable<String,String>) entry.getValue();
            String query="create table IF NOT EXISTS " + tableName + " (";
//            tableList.add(tableName);
            @SuppressWarnings("rawtypes")
            Set columnSet = columns.entrySet();
            @SuppressWarnings("rawtypes")
            Iterator columnIt=columnSet.iterator();
            while(columnIt.hasNext()){
                @SuppressWarnings("rawtypes")
                Map.Entry columnEntry = (Map.Entry) columnIt.next();
                String columnName = (String) columnEntry.getKey();
                String columnType = (String) columnEntry.getValue();
                query += " " + columnName + " " + columnType;
                if(columnIt.hasNext())
                    query += ",";
                else
                    query+=" )";
            }
            queries.add(query);
        }
        return queries;
    }

    private SQLiteDatabase openDB() {
        return DatabaseManager.getInstance(context).openDatabase();
    }

    private void closeDB() {
        DatabaseManager.getInstance(context).closeDatabase();
    }

    public long getRowSize(){
        SQLiteDatabase db = openDB();
        long numRows = DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        closeDB();
        return numRows;
    }

    public long insert(FpObservationFormItem item){
        if(item == null) return 0;
        ContentValues values = new ContentValues();
        values.put(KEY_FACILITY_ID,item.facility_id);
        values.put(KEY_CLIENT_NAME,item.client_name);
        values.put(KEY_SERIAL,item.serial_no);
        values.put(KEY_DATE,item.date);
        values.put(KEY_START_TIME,item.start_time);
        values.put(KEY_CONCENT,item.concent);
        values.put(KEY_COVER,item.cover);
        values.put(KEY_SOUND_PROVE,item.sound_prove);
        values.put(KEY_DISCUSS_FP,item.discuss_fp);
        values.put(KEY_DISCUSS_FP_PROTOCOL,item.discuss_fp_protocol);
        values.put(KEY_W_TO_DO,item.what_to_do);
        values.put(KEY_QUESTION,item.questions);
        values.put(KEY_JOB_AID,item.job_aid);
        values.put(KEY_FOLLOWUP,item.followup);
        values.put(KEY_END_TIME,item.end_time);

        values.put(DBRow.KEY_STATUS,item.status);
        values.put(DBRow.KEY_UNION,item.union);
        values.put(DBRow.KEY_VILLAGE,item.village);
        values.put(DBRow.KEY_UPOZILA,item.upozila);
        values.put(DBRow.KEY_NAME,item.name);
        values.put(DBRow.KEY_COLLECTOR_NAME,item.collector_name);
        values.put(DBRow.KEY_DIVISION,item.division);
        values.put(DBRow.KEY_TIME_PICK,item.timepick);
        values.put(DBRow.KEY_DATE_PICK,item.datepick);
        values.put(DBRow.KEY_OBSTYPE,item.obs_type);
        values.put(DBRow.KEY_FACILITY,item.facility);

        SQLiteDatabase db = openDB();
        if(item.id > 0){
            db.update(TABLE_NAME,values,KEY_ID + "=" + item.id,null);
        }
        else {
            item.id = db.insert(TABLE_NAME, null, values);
        }
        closeDB();
        return item.id;
    }

    public ArrayList<FpObservationFormItem> getAll() {
        ArrayList<FpObservationFormItem> fpList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

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

    private FpObservationFormItem cursorToSubCatList(Cursor cursor) {
        FpObservationFormItem item = new FpObservationFormItem();
        item.id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
        item.facility_id = cursor.getString(cursor.getColumnIndex(KEY_FACILITY_ID));
        item.client_name = cursor.getString(cursor.getColumnIndex(KEY_CLIENT_NAME));
        item.serial_no = cursor.getString(cursor.getColumnIndex(KEY_SERIAL));
        item.date = cursor.getString(cursor.getColumnIndex(KEY_DATE));
        item.start_time = cursor.getString(cursor.getColumnIndex(KEY_START_TIME));
        item.concent = cursor.getString(cursor.getColumnIndex(KEY_CONCENT));
        item.cover = cursor.getString(cursor.getColumnIndex(KEY_COVER));
        item.sound_prove = cursor.getString(cursor.getColumnIndex(KEY_SOUND_PROVE));
        item.discuss_fp = cursor.getString(cursor.getColumnIndex(KEY_DISCUSS_FP));
        item.discuss_fp_protocol = cursor.getString(cursor.getColumnIndex(KEY_DISCUSS_FP_PROTOCOL));
        item.what_to_do = cursor.getString(cursor.getColumnIndex(KEY_W_TO_DO));
        item.questions = cursor.getString(cursor.getColumnIndex(KEY_QUESTION));
        item.job_aid = cursor.getString(cursor.getColumnIndex(KEY_JOB_AID));
        item.followup = cursor.getString(cursor.getColumnIndex(KEY_FOLLOWUP));
        item.end_time = cursor.getString(cursor.getColumnIndex(KEY_END_TIME));

        item.status = cursor.getInt(cursor.getColumnIndex(DBRow.KEY_STATUS));
        item.union = cursor.getString(cursor.getColumnIndex(DBRow.KEY_UNION));
        item.village = cursor.getString(cursor.getColumnIndex(DBRow.KEY_VILLAGE));
        item.upozila = cursor.getString(cursor.getColumnIndex(DBRow.KEY_UPOZILA));
        item.name = cursor.getString(cursor.getColumnIndex(DBRow.KEY_NAME));
        item.collector_name = cursor.getString(cursor.getColumnIndex(DBRow.KEY_COLLECTOR_NAME));
        item.division = cursor.getString(cursor.getColumnIndex(DBRow.KEY_DIVISION));
        item.timepick = cursor.getString(cursor.getColumnIndex(DBRow.KEY_TIME_PICK));
        item.datepick = cursor.getString(cursor.getColumnIndex(DBRow.KEY_DATE_PICK));
        return item;
    }

    public FpObservationFormItem get(long id) {
        FpObservationFormItem item = new FpObservationFormItem();
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " where _id=" + id, null);

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                item = cursorToSubCatList(cursor);
                break;
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return item;
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
