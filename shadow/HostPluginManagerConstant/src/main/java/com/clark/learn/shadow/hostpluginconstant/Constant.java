/*
 * Tencent is pleased to support the open source community by making Tencent Shadow available.
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *     https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.clark.learn.shadow.hostpluginconstant;

/**
 * 宿主和插件共用的常量配置，可以新增，但不能改动变量的值
 */
final public class Constant {

    //PluginDemo插件的 pluginPartKey
    public static final String PLUGIN_PART_KEY_PLUGIN_DEMO = "PluginDemo";

    //插件压缩包所在路径
    public static final String KEY_PLUGIN_ZIP_PATH = "pluginZipPath";

    //跳转插件Activity所需要用到的参数
    public static final String KEY_PLUGIN_PART_KEY = "SHADOW_PLUGIN_KEY_PLUGIN_PART_KEY"; //插件名
    public static final String KEY_ACTIVITY_CLASSNAME = "SHADOW_PLUGIN_KEY_ACTIVITY_CLASSNAME";   //启动的Activity名称
    public static final String KEY_EXTRAS = "SHADOW_PLUGIN_KEY_EXTRAS";   //Activity需要的参数

    //定义插件要进行的行为
    public static final long FROM_ID_NOOP = 1000;    //什么都不做
    public static final long FROM_ID_CREATE_APPLICATION = 1001;  //启动插件的Application
    public static final long FROM_ID_START_ACTIVITY = 1002;  //跳转插件的Activity
    public static final long FROM_ID_START_SERVICE = 1003;  //启动插件的Service

}
