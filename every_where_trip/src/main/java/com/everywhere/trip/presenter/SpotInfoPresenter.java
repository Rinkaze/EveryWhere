package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.SpotInfo;
import com.everywhere.trip.model.SpotInfoModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.main.SpotInfoView;

/**
 * Created by 灵风 on 2019/5/19.
 */

public class SpotInfoPresenter extends BasePresenter<SpotInfoView> {

    private SpotInfoModel model;

    @Override
    protected void initModel() {
        model = new SpotInfoModel();
        mModels.add(model);
    }

    public void getSpotInfo(int id){
        model.getSpotInfo(id, new ResultCallBack<SpotInfo>() {
            @Override
            public void onSuccess(SpotInfo bean) {
                mMvpView.onSuccess(bean.getResult().getSpot());
            }

            @Override
            public void onFail(String msg) {
                mMvpView.onFail(msg);
            }
        });
    }
}
