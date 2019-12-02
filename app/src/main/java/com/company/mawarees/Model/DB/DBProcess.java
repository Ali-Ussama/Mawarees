package com.company.mawarees.Model.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.company.mawarees.App;

import java.util.ArrayList;

import com.company.mawarees.Model.Callback.DatabaseListener;
import com.company.mawarees.Model.DB.DBConfig.ProofsTable;
import com.company.mawarees.Model.Models.ProofModel;

public class DBProcess {

    private final String TAG = "DBProcess";
    private App mAppContext;
    private Context mContext;

    public DBProcess(Context c) {
        this.mContext = c;
        mAppContext = (App) c.getApplicationContext();
    }

    public boolean deleteTable(String tableName) {
        return ((getTableCount(tableName) <= 0)) ||
                (mAppContext.dbConnect().delete(tableName, null, null) > 0);/* No. of deleted rows*/
    }


    public int getTableCount(String tableName) {

        String countLbl = "COUNT";
        String sqlStm = "SELECT COUNT(*)  AS " + countLbl + " FROM " + tableName;
        try {
            Cursor cursor = mAppContext.dbConnect().rawQuery(sqlStm, null);
            int tableCount = 0;
            if (cursor != null) {
                cursor.moveToFirst();
                tableCount = cursor.getInt(cursor.getColumnIndex(countLbl));
                cursor.close();
            }
            return tableCount;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mAppContext.dbDisconnect();
        }
        return 0;

    }

    public void insert(ArrayList<ProofModel> data) {

        try {
            deleteTable(ProofsTable.TABLE_NAME);

            for (ProofModel mData : data) {
                ContentValues cv = new ContentValues();

                cv.put(ProofsTable.COLUMN_NAME_ID, mData.getId());
                cv.put(ProofsTable.COLUMN_NAME_RELATION, mData.getRelation());
                cv.put(ProofsTable.COLUMN_NAME_RELIGION, mData.getReligion());
                cv.put(ProofsTable.COLUMN_NAME_KEY, mData.getKey());
                cv.put(ProofsTable.COLUMN_NAME_VALUE, mData.getValue());

                mAppContext.dbConnect().insert(ProofsTable.TABLE_NAME, null, cv);
                mAppContext.dbDisconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
            mAppContext.dbDisconnect();
        }
    }

    public void readProofs(DatabaseListener listener) {
        ArrayList<ProofModel> result = new ArrayList<>();

        try {
            String sqlQuery = "SELECT * FROM " + ProofsTable.TABLE_NAME;

            Cursor cursor = mAppContext.dbConnect().rawQuery(sqlQuery, null);

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();

                    do {
                        Log.i(TAG, "readProofs(): cursor count = " + cursor.getCount());

                        ProofModel proof = new ProofModel();
                        proof.setId(cursor.getString(cursor.getColumnIndex(ProofsTable.COLUMN_NAME_ID)));
                        proof.setRelation(cursor.getString(cursor.getColumnIndex(ProofsTable.COLUMN_NAME_RELATION)));
                        proof.setReligion(cursor.getString(cursor.getColumnIndex(ProofsTable.COLUMN_NAME_RELIGION)));
                        proof.setKey(cursor.getString(cursor.getColumnIndex(ProofsTable.COLUMN_NAME_KEY)));
                        proof.setValue(cursor.getString(cursor.getColumnIndex(ProofsTable.COLUMN_NAME_VALUE)));

                        result.add(proof);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mAppContext.dbDisconnect();
        }

        if (listener != null) {
            listener.onReadProofs(result);
        }
    }


}
