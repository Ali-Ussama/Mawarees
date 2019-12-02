package com.company.mawarees.Model.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.company.mawarees.App;

import java.util.ArrayList;

public class Helper extends SQLiteOpenHelper {

    private static final String DB_NAME = "MAWAREETH.db";
    private static final int DB_VERSION_1 = 1;
    private static final int DB_VERSION_2 = 2;
    private static final int DB_VERSION_3 = 3;
    private static final int DB_VERSION_4 = 4;
    private static final String TAG = "DBHelper";

    private Context mContext;

    /**
     * DATABASE VERSION Changed from V3 to V4
     * By Ali Ussama on 10/9/2019
     */
    public Helper(Context context) {
        super(context, DB_NAME, null, DB_VERSION_1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // execute Sql commands for tables.
        ArrayList<String> listSqlStatements = DBConfig.TablesSqlStatements.getAllSqlCreationStatements();
        for (String sqlStatement : listSqlStatements) {
            db.execSQL(sqlStatement);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        if (oldVersion == 1) {//TODO upgrade
            Log.i(TAG, "database version is changed to 4");
            upgradeVersionToV1(db);
        } else {
            onCreate(db);
        }
    }

    private void upgradeVersionToV1(SQLiteDatabase db) {
        try {
            ArrayList<String> bccTablesNamesList = getAllDBTablesNames(mContext);
            if (bccTablesNamesList != null) {
                if (!bccTablesNamesList.isEmpty()) {
                    for (String tableName : bccTablesNamesList) {
                        db.execSQL(DBConfig.TablesSqlStatements.deleteTable(tableName));
                    }
                    onCreate(db);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> getAllDBTablesNames(Context context) {
        ArrayList<String> listTablesNames = null;
        try {
            String sqlStatement = "SELECT NAME FROM sqlite_master" + " WHERE type='table'";
            Cursor cursor = ((App) context.getApplicationContext()).dbConnect().rawQuery(sqlStatement, null);
            listTablesNames = new ArrayList<>();
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    listTablesNames.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
            cursor.close();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            ((App) context.getApplicationContext()).dbDisconnect();
        }
        if (listTablesNames != null) {
            if (!listTablesNames.isEmpty()) {
                listTablesNames.remove(0); // remove metadata table.
            }
        }
        return listTablesNames;
    }
}
