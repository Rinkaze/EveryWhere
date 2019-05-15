package com.jiyun.base;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.jiyun.dao.DaoMaster;
import com.jiyun.dao.DaoSession;
import com.jiyun.util.SpUtil;
import com.jiyun.util.UIModeUtil;
import com.tencent.smtt.sdk.QbSdk;


/**
 * Created by asus on 2019/3/5.
 */

public class BaseApp extends Application {
    private static BaseApp sBaseApp;
    //默认不是夜间模式
    public static int mMode = AppCompatDelegate.MODE_NIGHT_NO;
    private static DaoSession daoSession;
    public static int mWidthPixels;
    public static int mHeightPixels;

    public static DaoSession getDaoSession() {
        return daoSession;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp = this;
        initDb();
        //初始化tbs x5 webview
        QbSdk.allowThirdPartyAppDownload(true);
        QbSdk.initX5Environment(getApplicationContext(), QbSdk.WebviewInitType.FIRSTUSE_AND_PRELOAD, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
            }

            @Override
            public void onViewInitFinished(boolean b) {
            }
        });
        getScreenWH();
        setDayNightMode();
    }

    private void setDayNightMode() {
        //设置以前用户的模式选项
        mMode = (int) SpUtil.getParam(Constants.MODE, AppCompatDelegate.MODE_NIGHT_NO);
        UIModeUtil.setAppMode(mMode);
    }

    private void getScreenWH() {
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display defaultDisplay = manager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        defaultDisplay.getMetrics(metrics);
        mWidthPixels = metrics.widthPixels;
        mHeightPixels = metrics.heightPixels;
    }

    private void initDb() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "dailyNews.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public static BaseApp getInstance() {
        return sBaseApp;
    }

}
