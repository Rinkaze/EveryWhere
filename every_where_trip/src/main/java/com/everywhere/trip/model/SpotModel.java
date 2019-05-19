package com.everywhere.trip.model;

import android.util.Log;

import com.everywhere.trip.base.BaseModel;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.SpotBean;
import com.everywhere.trip.net.BaseObserver;
import com.everywhere.trip.net.EveryWhereService;
import com.everywhere.trip.net.HttpUtils;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.net.RxUtils;
import com.everywhere.trip.util.SpUtil;

import io.reactivex.disposables.Disposable;

/**
 * Created by 灵风 on 2019/5/17.
 */

public class SpotModel extends BaseModel {
    private static final String TAG = "SpotModel";

    public void getSpotData(String tagId, int cityId, final ResultCallBack<SpotBean> callBack){
        HttpUtils.getInstance().getApiserver(EveryWhereService.BASE_URL,EveryWhereService.class)
                .getSpotData((String) SpUtil.getParam(Constants.TOKEN,""),tagId, cityId)
                .compose(RxUtils.<SpotBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<SpotBean>() {
                    @Override
                    public void error(String msg) {
                        Log.e(TAG, "error: "+msg );
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(SpotBean spotBean) {
                        if (spotBean != null){
                            if (spotBean.getCode() == EveryWhereService.SUCCESS_CODE){
                                callBack.onSuccess(spotBean);
                            }else {
                                callBack.onFail(spotBean.getError());
                            }
                        }
                    }
                });
    }
}
