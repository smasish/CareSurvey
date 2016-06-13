package caresurvey.sci.com.caresurvey.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
    abstract protected void createTable();
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


}
