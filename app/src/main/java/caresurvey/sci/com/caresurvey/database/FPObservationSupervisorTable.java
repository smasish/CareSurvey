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
import caresurvey.sci.com.caresurvey.model.FpObservationFormItem;

/**
 * Created by shantanu on 6/12/16.
 */

public class FPObservationSupervisorTable extends SuperTable{
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
    private static final String TABLE_NAME = "fp_table_supervisor";


    private static final String KEY_USER_ID = "_user_id";
    private static final String KEY_COMMENTS="_comments";
    private static final String KEY_FIELDS="_fields";
    private static final String KEY_META="_meta";
    private static final String KEY_SUBMITTED_BY="_submitted_by";
    private static final String KEY_FORM_TYPE = "_form_type";

    public FPObservationSupervisorTable(Context context){
        super(context,TABLE_NAME);
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
            Log.e("fp_supervisor table:","created");
            closeDB();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void generateTable() {
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
        table.put(DBRow.KEY_LAT,"TEXT");
        table.put(DBRow.KEY_LON,"TEXT");

        //supervisor field
        table.put(KEY_USER_ID,"text");
        table.put(KEY_COMMENTS,"text");
        table.put(KEY_FIELDS,"text");
        table.put(KEY_META,"text");
        table.put(KEY_SUBMITTED_BY,"text");
        table.put(KEY_FORM_TYPE,"text");
        setNewTable(TABLE_NAME, table);
    }

    public List<FpObservationFormItem> getList(String cName, String facility) {
        ArrayList<FpObservationFormItem> fpList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " where " + KEY_SUBMITTED_BY + "='" + cName + "' and " + DBRow.KEY_FACILITY + "='" + facility + "'", null);

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

    public long insert(FpObservationFormItem item){
        if(item == null) return 0;
        ContentValues values = new ContentValues();
        values.put(KEY_ID,item.id);
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
            Log.e("fp id:","" + id);
        }
        closeDB();
        return item.id;
    }

    public static List<DBRow> toDbrow(List<FpObservationFormItem> list){
        List<DBRow> result = new ArrayList<>();
        for(FpObservationFormItem item : list){
            result.add(item);
        }
        return result;
    }

    public FpObservationFormItem get(long id) {

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
        return new FpObservationFormItem();
    }
}
