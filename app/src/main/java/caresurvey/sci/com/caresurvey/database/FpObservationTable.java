package caresurvey.sci.com.caresurvey.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import caresurvey.sci.com.caresurvey.activity.DisplayUserFormActivity;
import caresurvey.sci.com.caresurvey.model.FpObservationFormItem;

/**
 * Created by Shahin on 5/18/2016.
 */
public class FpObservationTable {
    public FpObservationTable(DisplayUserFormActivity displayUserFormActivity) {

    }

    public ArrayList<FpObservationFormItem> getAllInfo() {
        ArrayList<FpObservationFormItem> subCatList = new ArrayList<>();
        //System.out.println(cat_id+"  "+sub_cat_id);
//        SQLiteDatabase db = openDB();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME , null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                //System.out.println("abc="+cursor.getString(4));
//                subCatList.add(cursorlist(cursor));
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        closeDB();

        FpObservationFormItem  dd = new FpObservationFormItem();
        dd.setId(0);
        dd.setSp_client("cbdsk");
        dd.setStatus("3");

        FpObservationFormItem  dd1 = new FpObservationFormItem();
        dd1.setId(1);
        dd1.setSp_client("cbdsk");
        dd1.setStatus("3");

        subCatList.add(dd);
        return subCatList;
    }

}
