package com.example.greeknews;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by Lenovo on 2019/4/17.
 */

public class BaseApp extends Application {
    private static BaseApp app;

    //默认不是夜间模式
    public static int mMode = AppCompatDelegate.MODE_NIGHT_NO;

    public static BaseApp getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }
}
