package com.clark.learn.shadow.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.clark.learn.shadow.R;
import com.clark.learn.shadow.application.HostApplication;
import com.clark.learn.shadow.hostpluginbridge.IPluginUiLayerProvider;
import com.clark.learn.shadow.hostpluginconstant.Constant;

public class HostAddPluginViewActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_add_plugin_view);

        final FrameLayout flContainer = findViewById(R.id.fl_container);

        findViewById(R.id.btn_add_plugin_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getPluginView();
                if (view != null) {
                    //让View居中
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.gravity = Gravity.CENTER;
                    view.setLayoutParams(layoutParams);
                    flContainer.removeAllViews();
                    flContainer.addView(view);
                }
            }
        });
    }

    public View getPluginView() {
        Log.i("HostAddPluginViewActivity", "ShadowKapaiPluginUtil.getKapaiShareBottomView() -> start");

        ClassLoader classLoader = HostApplication.mPluginClassloaderMap.get(Constant.PLUGIN_PART_KEY_PLUGIN_DEMO);
        if (classLoader != null) {
            try {
                Class<?> aClass = classLoader.loadClass("com.clark.learn.shadow.plugindemo.bridgeimpl.PluginUiLayerProvider");
                if (IPluginUiLayerProvider.class.isAssignableFrom(aClass)) {
                    Log.i("HostAddPluginViewActivity", "ShadowKapaiPluginUtil.getKapaiShareBottomView() -> success");
                    IPluginUiLayerProvider iPluginUiLayerProvider = (IPluginUiLayerProvider) aClass.getConstructor().newInstance();
                    return iPluginUiLayerProvider.getPluginView();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.i("HostAddPluginViewActivity", "ShadowKapaiPluginUtil.getKapaiShareBottomView() -> fail,e=" + e.getLocalizedMessage());
            }
        }
        return null;
    }
}
