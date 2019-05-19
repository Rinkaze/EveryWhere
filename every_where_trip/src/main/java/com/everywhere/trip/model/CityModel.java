package com.everywhere.trip.model;

import android.util.Log;

import com.everywhere.trip.base.BaseModel;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.CityBean;
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

public class CityModel extends BaseModel {
    private static final String TAG = "CityModel";

    public void getCities(final ResultCallBack<CityBean.ResultEntity> callBack){
        HttpUtils.getInstance().getApiserver(EveryWhereService.BASE_URL,EveryWhereService.class)
                .getCities((String) SpUtil.getParam(Constants.DATA,""))
                .compose(RxUtils.<CityBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<CityBean>() {
                    @Override
                    public void error(String msg) {
                        Log.e(TAG, "error: e="+msg );
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(CityBean cityBean) {
                        if (cityBean != null){
                            if (cityBean.getCode()==EveryWhereService.SUCCESS_CODE){
                                callBack.onSuccess(cityBean.getResult());
                            }else {
                                callBack.onFail(cityBean.getError());
                            }
                        }
                    }
                });
    }
}
