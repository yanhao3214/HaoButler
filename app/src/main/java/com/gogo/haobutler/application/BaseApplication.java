package com.gogo.haobutler.application;

import android.app.Application;

import com.gogo.haobutler.utils.Consts;
import com.tencent.bugly.crashreport.CrashReport;

import cn.bmob.v3.Bmob;

/**
 * @author: 闫昊
 * @date: 2018/4/12
 * @function: 项目初始化、参数配置
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), Consts.BUGLY_APP_ID, false);
        Bmob.initialize(this,Consts.BMOB_APP_ID);
    }
}
