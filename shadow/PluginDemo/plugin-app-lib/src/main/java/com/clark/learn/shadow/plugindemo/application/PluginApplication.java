package com.clark.learn.shadow.plugindemo.application;

import android.app.Application;

public class PluginApplication extends Application {

    private static PluginApplication mInstance;

    public static PluginApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

}
