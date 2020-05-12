package com.runcode.accessadvanced.lifetime;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    static Context context ;

    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext() ;

    }

    public static Context getContext() {
        return MyApplication.context;
    }
}
