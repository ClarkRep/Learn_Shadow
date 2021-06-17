package com.clark.learn.shadow.plugindemo.bridgeimpl;

import android.view.LayoutInflater;
import android.view.View;

import com.clark.learn.shadow.hostpluginbridge.IPluginUiLayerProvider;
import com.clark.learn.shadow.plugindemo.R;
import com.clark.learn.shadow.plugindemo.application.PluginApplication;

public class PluginUiLayerProvider implements IPluginUiLayerProvider {

    @Override
    public View getPluginView() {
        return LayoutInflater.from(PluginApplication.getInstance())
                .inflate(R.layout.plugin_ui_layer_layout, null, false);
    }

}
