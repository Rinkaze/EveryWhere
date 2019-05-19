package com.everywhere.trip.model;

import android.util.Log;

import com.everywhere.trip.base.BaseModel;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.VersionInfo;
import com.everywhere.trip.net.BaseObserver;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.net.HttpUtils;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.net.RxUtils;
import com.everywhere.trip.util.SpUtil;

import io.reactivex.disposables.Disposable;

/**
 * Created by 灵风 on 2019/5/16.
 */

public class VersionModel extends BaseModel {
    private static final String TAG = "VersionModel";

    public void checkVersion(final ResultCallBack<VersionInfo> callBack) {
        HttpUtils.getInstance().getApiserver(EveryWhereService.BASE_URL, EveryWhereService.class)
                .checkVersion((String) SpUtil.getParam(Constants.TOKEN, ""))
                .compose(RxUtils.<VersionInfo>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<VersionInfo>() {
                    @Override
                    public void error(String msg) {
                        Log.e(TAG, "error: "+msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(VersionInfo versionInfo) {
                        if (versionInfo != null){
                            if (versionInfo.getCode() == EveryWhereService.SUCCESS_CODE){
                                callBack.onSuccess(versionInfo);
                            }else {
                                callBack.onFail(versionInfo.getDesc());
                            }
                        }
                    }
                });
    }
}
