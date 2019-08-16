package com.androidwind.demo.test;

import android.app.Application;

import la.xiong.androidquick.module.network.retrofit.RetrofitManager;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class MyApplication extends Application {

    private static MyApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        //get application
        if (INSTANCE == null) {
            INSTANCE = this;
        }
        //init retrofit url
        RetrofitManager.getInstance().initBaseUrl("http://wthrcdn.etouch.cn/");
    }

    public static synchronized MyApplication getInstance() {
        return INSTANCE;
    }
}
