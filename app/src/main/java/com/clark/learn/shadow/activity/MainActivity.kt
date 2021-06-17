package com.clark.learn.shadow.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.clark.learn.shadow.R
import com.clark.learn.shadow.application.HostApplication
import com.clark.learn.shadow.hostpluginconstant.Constant
import com.clark.learn.shadow.shadowmodule.PluginHelper
import com.clark.learn.shadow.shadowmodule.PluginManagerHandler
import com.clark.learn.shadow.shadowmodule.Shadow
import com.tencent.shadow.dynamic.host.EnterCallback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //创建PluginManager的本地路径
        PluginManagerHandler.getPluginManager(PluginHelper.getInstance().pluginManagerFile)

        //启动插件的MainActivity
        findViewById<View>(R.id.btn_start_plugin_main_activity).setOnClickListener(View.OnClickListener {
            goPluginMainActivity()
        })

        //启动插件添加宿主View的Activity
        findViewById<View>(R.id.btn_start_plugin_add_host_view_activity).setOnClickListener(View.OnClickListener {
            goPluginAddHostViewActivity()
        })

        //启动宿主添加插件View的Activity
        findViewById<View>(R.id.btn_start_host_add_plugin_view_activity).setOnClickListener(View.OnClickListener {
            val intent = Intent(it.context, HostAddPluginViewActivity::class.java)
            startActivity(intent)
        })
    }

    /**
     * 跳转插件的 MainActivity
     */
    fun goPluginMainActivity() {
        PluginHelper.getInstance().singlePool.execute(Runnable {
            val bundle = Bundle()
            bundle.putString(
                Constant.KEY_PLUGIN_ZIP_PATH,
                PluginHelper.getInstance().pluginZipFile.absolutePath
            )
            bundle.putString(Constant.KEY_PLUGIN_PART_KEY, Constant.PLUGIN_PART_KEY_PLUGIN_DEMO)
            bundle.putString(
                Constant.KEY_ACTIVITY_CLASSNAME,
                "com.clark.learn.shadow.plugindemo.MainActivity"
            )

            PluginManagerHandler.loadPluginManager(PluginHelper.getInstance().pluginManagerFile)
            PluginManagerHandler.getPluginManager(PluginHelper.getInstance().pluginManagerFile)
                .enter(
                    HostApplication.getInstance(),
                    Constant.FROM_ID_START_ACTIVITY,
                    bundle,
                    object : EnterCallback {
                        override fun onEnterComplete() {
                        }

                        override fun onShowLoadingView(view: View?) {
                        }

                        override fun onCloseLoadingView() {
                        }
                    })
        })
    }

    /**
     * 跳转插件的添加宿主View的Activity
     */
    fun goPluginAddHostViewActivity() {
        PluginHelper.getInstance().singlePool.execute(Runnable {
            val bundle = Bundle()
            bundle.putString(
                Constant.KEY_PLUGIN_ZIP_PATH,
                PluginHelper.getInstance().pluginZipFile.absolutePath
            )
            bundle.putString(Constant.KEY_PLUGIN_PART_KEY, Constant.PLUGIN_PART_KEY_PLUGIN_DEMO)
            bundle.putString(
                Constant.KEY_ACTIVITY_CLASSNAME,
                "com.clark.learn.shadow.plugindemo.PluginAddHostViewActivity"
            )

            PluginManagerHandler.loadPluginManager(PluginHelper.getInstance().pluginManagerFile)
            PluginManagerHandler.getPluginManager(PluginHelper.getInstance().pluginManagerFile)
                .enter(
                    HostApplication.getInstance(),
                    Constant.FROM_ID_START_ACTIVITY,
                    bundle,
                    object : EnterCallback {
                        override fun onEnterComplete() {
                        }

                        override fun onShowLoadingView(view: View?) {
                        }

                        override fun onCloseLoadingView() {
                        }
                    })
        })
    }


}