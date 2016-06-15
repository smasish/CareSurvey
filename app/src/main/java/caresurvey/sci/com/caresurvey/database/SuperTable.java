package caresurvey.sci.com.caresurvey.database;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by shantanu on 6/12/16.
 */

public abstract class SuperTable {
    protected Context context;
    protected String TABLE_NAME = "";
    public SuperTable(Context context,String TABLE_NAME){
        this.context = context;
        this.TABLE_NAME = TABLE_NAME;
        createTable();
    }

    protected  Hashtable<String, Hashtable<String,String>> Tables = new Hashtable<String, Hashtable<String,String>>();
    protected  void setNewTable(String tableName, Hashtable<String,String> params){
        Tables.put(tableName, params);
    }
    protected  Hashtable<String, Hashtable<String,String>> getDbTable(){
        generateTable();
        return Tables;
    }
    protected void createTable(){
        try {
            List<String> tableQuery = getCreateTableQuery();
            SQLiteDatabase db = openDB();
            for(int i=0;i<tableQuery.size();i++)
            {
                db.execSQL(tableQuery.get(i));
            }
            Log.e("table:", TABLE_NAME + " created");
            closeDB();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    abstract protected  void generateTable();

    @SuppressWarnings("unchecked")
    protected List<String> getCreateTableQuery(){
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

    protected SQLiteDatabase openDB() {
        return DatabaseManager.getInstance(context).openDatabase();
    }

    protected void closeDB() {
        DatabaseManager.getInstance(context).closeDatabase();
    }
    protected boolean hasItem(long id) {
        String query = "Select _id from " + TABLE_NAME + " where " + "_id=" + id;
        SQLiteDatabase db = openDB();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor != null && cursor.getCount() > 0){
            return true;
        }
        return false;
    }

    public long getRowSize(){
        SQLiteDatabase db = openDB();
        long numRows = DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        closeDB();
        return numRows;
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
