package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.CityBean;
import com.everywhere.trip.model.CityModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.main.CityView;

/**
 * Created by 灵风 on 2019/5/19.
 */

public class CityPresenter extends BasePresenter<CityView> {

    private CityModel model;

    @Override
    protected void initModel() {
        model = new CityModel();
        mModels.add(model);
    }

    public void getCities(){
        model.getCities(new ResultCallBack<CityBean.ResultEntity>() {
            @Override
            public void onSuccess(CityBean.ResultEntity bean) {
                mMvpView.onSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.onFail(msg);
            }
        });
    }
}
