package com.everywhere.trip.model;

import android.util.Log;

import com.everywhere.trip.base.BaseModel;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.SpotInfo;
import com.everywhere.trip.net.BaseObserver;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.net.HttpUtils;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.net.RxUtils;
import com.everywhere.trip.util.SpUtil;

import io.reactivex.disposables.Disposable;

/**
 * Created by 灵风 on 2019/5/19.
 */

public class SpotInfoModel extends BaseModel {
    private static final String TAG = "SpotInfoModel";

    public void getSpotInfo(int id, final ResultCallBack<SpotInfo> callBack) {
        HttpUtils.getInstance().getApiserver(EveryWhereService.BASE_URL, EveryWhereService.class)
                .getSpotInfo((String) SpUtil.getParam(Constants.TOKEN, ""), id)
                .compose(RxUtils.<SpotInfo>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<SpotInfo>() {
                    @Override
                    public void error(String msg) {
                        Log.e(TAG, "error: e=" + msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(SpotInfo spotInfo) {
                        if (spotInfo != null){
                            if (spotInfo.getCode() == EveryWhereService.SUCCESS_CODE){
                                callBack.onSuccess(spotInfo);
                            }else {
                                callBack.onFail(spotInfo.getError());
                            }
                        }
                    }
                });
    }
}
