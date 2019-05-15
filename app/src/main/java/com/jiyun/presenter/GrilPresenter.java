package com.jiyun.presenter;

import android.util.Log;

import com.jiyun.base.BasePresenter;
import com.jiyun.bean.GankItemBean;
import com.jiyun.bean.GrilBean;
import com.jiyun.model.GrilModel;
import com.jiyun.net.Callback;
import com.jiyun.net.GankHttpResponse;
import com.jiyun.view.GrilView;

import java.util.List;

/**
 * Created by 灵风 on 2019/4/23.
 */

public class GrilPresenter extends BasePresenter<GrilView> {

    GrilModel model;

    @Override
    public void initModel() {
        model = new GrilModel();
    }

    private static final String TAG = "GrilPresenter";
    public void getGrilData(int page){
        model.getGrilData(page, new Callback<GankHttpResponse<List<GankItemBean>>>() {
            @Override
            public void onSuccess(GankHttpResponse<List<GankItemBean>> data) {
                mMvpView.onSuccess(data);
            }

            @Override
            public void onFail(String msg) {
                Log.e(TAG, "onFail: e="+msg);
            }
        });
    }

}
