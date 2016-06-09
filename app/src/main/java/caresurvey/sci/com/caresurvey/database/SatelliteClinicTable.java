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
import caresurvey.sci.com.caresurvey.model.SatelliteClinicItem;

/**
 * Created by shantanu on 5/26/16.
 */
public class SatelliteClinicTable {
    public static final String ID = "_id";
    public static final String TABLE_NAME = "satellite_clinic";
    private final Context context;
    private long rowSize;
    private ArrayList<SatelliteClinicItem> all;

    public static void generateTable() // need to call this class once from application
    {
        //creating table for save cart
        Hashtable<String,String> table = new Hashtable<String,String>();
        table.put(ID, "integer primary key"); //must need to  add this key
        for(int i=101;i<108;i++){
            String str = "csi" + Integer.toString(i);
            table.put(str, "text");
        }
        for(int i=201;i<230;i++){
            String str = "csi" + Integer.toString(i);
            table.put(str, "text");
        }
        table.put("csi230_1", "text");
        table.put("csi230_2", "text");
        for(int i=231;i<235;i++){
            String str = "csi" + Integer.toString(i);
            table.put(str, "text");
        }
        table.put("date","text");
        table.put("stime","text");
        table.put("etime","text");
        table.put("cname","text");
        table.put("dsignation","text");
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
        table.put(DBRow.KEY_FACI_ID,"integer");
        setNewTable(TABLE_NAME, table);

        //another table

    }

    public SatelliteClinicTable(Context context){
        this.context = context;
        List<String> tableQuery = getCreateTableQuery();
        SQLiteDatabase db = openDB();
        for(int i=0;i<tableQuery.size();i++)
        {
            db.execSQL(tableQuery.get(i));
        }
        closeDB();
    }

    private static Hashtable<String, Hashtable<String,String>> Tables = new Hashtable<String, Hashtable<String,String>>();
    public static void setNewTable(String tableName, Hashtable<String,String> params){
        Tables.put(tableName, params);
    }
    public static Hashtable<String, Hashtable<String,String>> getDbTable(){
        generateTable();
        return Tables;
    }

    public long insert(SatelliteClinicItem item){
        if(item == null) return 0;
        ContentValues values = new ContentValues();
        values.put("csi101",item.csi101);
        values.put("csi102",item.csi102);
        values.put("csi103",item.csi103);
        values.put("csi104",item.csi104);
        values.put("csi105",item.csi105);
        values.put("csi106",item.csi106);
        values.put("csi107",item.csi107);
        values.put("csi201",item.csi201);
        values.put("csi202",item.csi202);
        values.put("csi203",item.csi203);
        values.put("csi204",item.csi204);
        values.put("csi205",item.csi205);
        values.put("csi206",item.csi206);
        values.put("csi207",item.csi207);
        values.put("csi208",item.csi208);
        values.put("csi209",item.csi209);
        values.put("csi210",item.csi210);
        values.put("csi211",item.csi211);
        values.put("csi212",item.csi212);
        values.put("csi213",item.csi213);
        values.put("csi214",item.csi214);
        values.put("csi215",item.csi215);
        values.put("csi216",item.csi216);
        values.put("csi217",item.csi217);
        values.put("csi218",item.csi218);
        values.put("csi219",item.csi219);
        values.put("csi220",item.csi220);
        values.put("csi221",item.csi221);
        values.put("csi222",item.csi222);
        values.put("csi223",item.csi223);
        values.put("csi224",item.csi224);
        values.put("csi225",item.csi225);
        values.put("csi226",item.csi226);
        values.put("csi227",item.csi227);
        values.put("csi228",item.csi228);
        values.put("csi229",item.csi229);
        values.put("csi230_1",item.csi230_1);
        values.put("csi230_2",item.csi230_2);
        values.put("csi231",item.csi231);
        values.put("csi232",item.csi232);
        values.put("csi233",item.csi233);
        values.put("csi234",item.csi234);
        values.put("date",item.date);
        values.put("stime",item.startTime);
        values.put("etime",item.endTime);
        values.put("cname",item.clientName);
        values.put("dsignation",item.designation);

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
        values.put(DBRow.KEY_FACI_ID,item.facilityID);

        SQLiteDatabase db = openDB();
        return db.insert(TABLE_NAME,null,values);
    }

    /*
	 * Create table from class
	 */
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

    private SatelliteClinicItem cursorToSubCatList(Cursor cursor) {
        SatelliteClinicItem item = new SatelliteClinicItem();
        if(cursor == null) return null;
        item.id = cursor.getInt(cursor.getColumnIndex("_id"));
        item.csi101 = cursor.getString(cursor.getColumnIndex("csi101"));
        item.csi102 = cursor.getString(cursor.getColumnIndex("csi102"));
        item.csi103 = cursor.getString(cursor.getColumnIndex("csi103"));
        item.csi104 = cursor.getString(cursor.getColumnIndex("csi104"));
        item.csi105 = cursor.getString(cursor.getColumnIndex("csi105"));
        item.csi106 = cursor.getString(cursor.getColumnIndex("csi106"));
        item.csi107 = cursor.getString(cursor.getColumnIndex("csi107"));
        item.csi201 = cursor.getString(cursor.getColumnIndex("csi201"));
        item.csi202 = cursor.getString(cursor.getColumnIndex("csi202"));
        item.csi203 = cursor.getString(cursor.getColumnIndex("csi203"));
        item.csi204 = cursor.getString(cursor.getColumnIndex("csi204"));
        item.csi205 = cursor.getString(cursor.getColumnIndex("csi205"));
        item.csi206 = cursor.getString(cursor.getColumnIndex("csi206"));
        item.csi207 = cursor.getString(cursor.getColumnIndex("csi207"));
        item.csi208 = cursor.getString(cursor.getColumnIndex("csi208"));
        item.csi209 = cursor.getString(cursor.getColumnIndex("csi209"));
        item.csi210 = cursor.getString(cursor.getColumnIndex("csi210"));
        item.csi211 = cursor.getString(cursor.getColumnIndex("csi211"));
        item.csi212 = cursor.getString(cursor.getColumnIndex("csi212"));
        item.csi213 = cursor.getString(cursor.getColumnIndex("csi213"));
        item.csi214 = cursor.getString(cursor.getColumnIndex("csi214"));
        item.csi215 = cursor.getString(cursor.getColumnIndex("csi215"));
        item.csi216 = cursor.getString(cursor.getColumnIndex("csi216"));
        item.csi217 = cursor.getString(cursor.getColumnIndex("csi217"));
        item.csi218 = cursor.getString(cursor.getColumnIndex("csi218"));
        item.csi219 = cursor.getString(cursor.getColumnIndex("csi219"));
        item.csi220 = cursor.getString(cursor.getColumnIndex("csi220"));
        item.csi221 = cursor.getString(cursor.getColumnIndex("csi221"));
        item.csi222 = cursor.getString(cursor.getColumnIndex("csi222"));
        item.csi223 = cursor.getString(cursor.getColumnIndex("csi223"));
        item.csi224 = cursor.getString(cursor.getColumnIndex("csi224"));
        item.csi225 = cursor.getString(cursor.getColumnIndex("csi225"));
        item.csi226 = cursor.getString(cursor.getColumnIndex("csi226"));
        item.csi227 = cursor.getString(cursor.getColumnIndex("csi227"));
        item.csi228 = cursor.getString(cursor.getColumnIndex("csi228"));
        item.csi229 = cursor.getString(cursor.getColumnIndex("csi229"));
        item.csi230_1 = cursor.getString(cursor.getColumnIndex("csi230_1"));
        item.csi230_2 = cursor.getString(cursor.getColumnIndex("csi230_2"));
        item.csi231 = cursor.getString(cursor.getColumnIndex("csi231"));
        item.csi232 = cursor.getString(cursor.getColumnIndex("csi232"));
        item.csi233 = cursor.getString(cursor.getColumnIndex("csi233"));
        item.csi234 = cursor.getString(cursor.getColumnIndex("csi234"));
        item.date = cursor.getString(cursor.getColumnIndex("date"));
        item.startTime = cursor.getString(cursor.getColumnIndex("stime"));
        item.endTime = cursor.getString(cursor.getColumnIndex("etime"));
        item.clientName = cursor.getString(cursor.getColumnIndex("cname"));
        item.designation = cursor.getString(cursor.getColumnIndex("dsignation"));
        item.status = cursor.getInt(cursor.getColumnIndex(DBRow.KEY_STATUS));
        item.union = cursor.getString(cursor.getColumnIndex(DBRow.KEY_UNION));
        item.village = cursor.getString(cursor.getColumnIndex(DBRow.KEY_VILLAGE));
        item.upozila = cursor.getString(cursor.getColumnIndex(DBRow.KEY_UPOZILA));
        item.name = cursor.getString(cursor.getColumnIndex(DBRow.KEY_NAME));
        item.collector_name = cursor.getString(cursor.getColumnIndex(DBRow.KEY_COLLECTOR_NAME));
        item.division = cursor.getString(cursor.getColumnIndex(DBRow.KEY_DIVISION));
        item.timepick = cursor.getString(cursor.getColumnIndex(DBRow.KEY_TIME_PICK));
        item.datepick = cursor.getString(cursor.getColumnIndex(DBRow.KEY_DATE_PICK));
        item.facilityID = cursor.getInt(cursor.getColumnIndex(DBRow.KEY_FACI_ID));

        return item;
    }

    public ArrayList<SatelliteClinicItem> getAll() {
        ArrayList<SatelliteClinicItem> scList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                //System.out.println("abc="+cursor.getString(4));
                scList.add(cursorToSubCatList(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return scList;
    }

    public SatelliteClinicItem get(int id) {
        SatelliteClinicItem item = new SatelliteClinicItem();
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
