package com.clark.learn.shadow.shadowmodule;

import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.PluginManager;

import java.io.File;

public class PluginManagerHandler {

    private static PluginManager mPluginManager;

    public static void loadPluginManager(File apk) {
        if (mPluginManager == null) {
            mPluginManager = getPluginManager(apk);
        }
    }

    public static PluginManager getPluginManager(File apk) {
        final FixedPathPmUpdater fixedPathPmUpdater = new FixedPathPmUpdater(apk);
        File tempPm = fixedPathPmUpdater.getLatest();
        if (tempPm != null) {
            return new DynamicPluginManager(fixedPathPmUpdater);
        }
        return null;
    }
}
