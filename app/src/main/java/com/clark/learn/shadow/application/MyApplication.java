package com.clark.learn.shadow.application;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.util.Log;

import com.clark.learn.shadow.hostpluginbridge.HostUiLayerProvider;
import com.clark.learn.shadow.hostpluginloaderbridge.LoadPluginCallback;
import com.clark.learn.shadow.shadowmodule.Shadow;

public class MyApplication extends Application {

    private static MyApplication mInstance;

    public static MyApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        initShadow();
    }

    /**
     * 初始化Shadow的相关配置
     */
    private void initShadow() {
        Shadow.init(this);

        //加载插件完成之后的回调，这个回调所在的进程，是指定的插件所运行的进程。
        LoadPluginCallback.setCallback(new LoadPluginCallback.Callback() {
            @Override
            public void beforeLoadPlugin(String partKey) {
                Log.d("Plugin2ProcessPPS", "beforeLoadPlugin(" + partKey + ")");
            }

            @Override
            public void afterLoadPlugin(String partKey, ApplicationInfo applicationInfo, ClassLoader pluginClassLoader, Resources pluginResources) {
                Log.d("Plugin2ProcessPPS", "afterLoadPlugin(" + partKey + "," + applicationInfo.className + "{metaData=" + applicationInfo.metaData + "}" + "," + pluginClassLoader + ")");
            }
        });

        //初始化给插件提供View的Provider。
        HostUiLayerProvider.init(this);
    }


}
