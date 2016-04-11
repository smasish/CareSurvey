package caresurvey.sci.com.caresurvey.database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by israt.jahan on 4/10/2016.
 */

   public class DatabaseOpenHelper extends SQLiteAssetHelper {

private static final String DATABASE_NAME="caresurveyv2.db";
private static final int DATABASE_VERSION=1;

public DatabaseOpenHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }
        }

