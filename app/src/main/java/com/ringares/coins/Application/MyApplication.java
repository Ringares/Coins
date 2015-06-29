package com.ringares.coins.Application;

import android.app.Application;
import android.content.Context;

/**
 * Created by ls
 * on 2015/6/29
 * Description
 */
public class MyApplication extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        context = this.getApplicationContext();
        super.onCreate();
    }
}
