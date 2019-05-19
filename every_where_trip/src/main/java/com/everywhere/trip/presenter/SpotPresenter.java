package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.SpotBean;
import com.everywhere.trip.model.SpotModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.main.SpotView;

/**
 * Created by 灵风 on 2019/5/17.
 */

public class SpotPresenter extends BasePresenter<SpotView> {

    private SpotModel model;

    @Override
    protected void initModel() {
        model = new SpotModel();
        mModels.add(model);
    }

    public void getSpotData(String tagId,int cityId){
        model.getSpotData(tagId, cityId, new ResultCallBack<SpotBean>() {
            @Override
            public void onSuccess(SpotBean bean) {
                mMvpView.onSuccess(bean.getResult());
            }

            @Override
            public void onFail(String msg) {
                mMvpView.onFail(msg);
            }
        });
    }
}
