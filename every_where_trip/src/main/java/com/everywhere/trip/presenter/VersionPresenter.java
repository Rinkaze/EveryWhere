package com.everywhere.trip.presenter;

import com.everywhere.trip.base.BasePresenter;
import com.everywhere.trip.bean.VersionInfo;
import com.everywhere.trip.model.VersionModel;
import com.everywhere.trip.net.ResultCallBack;
import com.everywhere.trip.view.main.EmptyView;
import com.everywhere.trip.view.main.VersionView;

/**
 * @author xts
 *         Created by asus on 2019/5/4.
 */

public class VersionPresenter extends BasePresenter<VersionView> {

    private VersionModel model;

    @Override
    protected void initModel() {
        model = new VersionModel();
        mModels.add(model);
    }

    public void checkVersion(){
        model.checkVersion(new ResultCallBack<VersionInfo>() {
            @Override
            public void onSuccess(VersionInfo bean) {
                mMvpView.onSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.onFail(msg);
            }
        });
    }
}
