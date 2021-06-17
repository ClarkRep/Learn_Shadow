package com.clark.learn.shadow.plugindemo;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.clark.learn.shadow.hostpluginbridge.HostUiLayerProvider;

public class PluginAddHostViewActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin_add_host_view);

        final FrameLayout flContainer = findViewById(R.id.fl_container);

        findViewById(R.id.btn_add_host_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = HostUiLayerProvider.getInstance().buildHostUiLayer();
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
}
