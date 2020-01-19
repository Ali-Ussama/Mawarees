package com.company.mawarees;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.company.mawarees.Model.DB.Helper;

import java.util.Locale;

public class App extends Application {
    private final String TAG = App.class.getName();
    private SQLiteDatabase mDataBase = null;

    @Override
    public void onCreate() {
        super.onCreate();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        try {
            MultiDex.install(this);
        }catch (Exception e){
            e.printStackTrace();
        }
        //MultiDex.install(base);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //Log.v(TAG, "Configuration changed," + newConfig.toString());

    }




    public SQLiteDatabase dbConnect() {
        try {
            if (mDataBase == null) {
                Helper helper = new Helper(getApplicationContext());
                mDataBase = helper.getWritableDatabase();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDataBase;
    }

    public void dbDisconnect() {
        try {
            if (mDataBase != null) mDataBase.close();
            mDataBase = null;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
