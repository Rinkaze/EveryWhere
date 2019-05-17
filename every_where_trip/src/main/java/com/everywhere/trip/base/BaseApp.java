package com.everywhere.trip.base;

import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.everywhere.trip.R;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

import org.xutils.x;

import luo.library.base.base.BaseAndroid;
import luo.library.base.base.BaseConfig;

/**
 * Created by asus on 2019/3/5.
 */

public class BaseApp extends Application {
    private static BaseApp sBaseApp;
    public static int mWidthPixels;
    public static int mHeightPixels;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp = this;
        getScreenWH();
        initUmeng();
        initUpdate();
    }

    private void initUpdate() {
        x.Ext.init(this);
        x.Ext.setDebug(true);

        BaseAndroid.init(new BaseConfig()
                .setAppColor(R.color.c_fa6a13)//app主调颜色，用于标题栏等背景颜色
                .setAppLogo(R.mipmap.ic_launcher)//app图标
                .setFailPicture(R.mipmap.zhanweitu_home_kapian)//加载加载失败和加载中显示的图
                .setCode(0)//网络请求成功返回的code数字，默认为1
                .setHttpCode("code")//网络请求返回的code字段名称，默认为code
                .setHttpMessage("msg")//网络请求返回的message字段名称，默认为message
                .setHttpResult("resp"));//网络请求返回的result字段名称，默认为result
    }

    private void initUmeng() {
        UMConfigure.init(this,"5ccea4873fc1958892000940"
                ,"umeng", UMConfigure.DEVICE_TYPE_PHONE,"");
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setSinaWeibo("3172199632", "48b951a0d3bc61eae1d124496bc1ff00","http://sns.whalecloud.com");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }

    //计算屏幕宽高
    private void getScreenWH() {
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display defaultDisplay = manager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        defaultDisplay.getMetrics(metrics);
        mWidthPixels = metrics.widthPixels;
        mHeightPixels = metrics.heightPixels;
    }

    public static BaseApp getInstance(){
        return sBaseApp;
    }

    public static Resources getRes() {
        return sBaseApp.getResources();
    }
}
