package com.clark.learn.shadow.hostpluginloaderbridge;

import android.content.pm.ApplicationInfo;
import android.content.res.Resources;

/**
 * 加载插件成功的回调
 */
public class LoadPluginCallback {

    private static Callback sCallback;

    public static void setCallback(Callback callback) {
        sCallback = callback;
    }

    public static Callback getCallback() {
        return sCallback;
    }

    public interface Callback {

        void beforeLoadPlugin(String partKey);

        void afterLoadPlugin(String partKey, ApplicationInfo applicationInfo, ClassLoader pluginClassLoader, Resources pluginResources);
    }
}
