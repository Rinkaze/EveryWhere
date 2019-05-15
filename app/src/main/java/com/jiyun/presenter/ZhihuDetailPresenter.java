package com.jiyun.presenter;

import android.util.Log;

import com.jiyun.base.BasePresenter;
import com.jiyun.bean.GankItemBean;
import com.jiyun.bean.ZhihuDetailBean;
import com.jiyun.model.ZhihuDetailModel;
import com.jiyun.net.Callback;
import com.jiyun.net.GankHttpResponse;
import com.jiyun.view.ZhihuDetailView;

import java.util.List;

/**
 * Created by 灵风 on 2019/4/22.
 */

public class ZhihuDetailPresenter extends BasePresenter<ZhihuDetailView>{

    ZhihuDetailModel model;

    @Override
    public void initModel() {
        model = new ZhihuDetailModel();
    }

    private static final String TAG = "ZhihuDetailPresenter";
    public void getZhihuDetailData(String id){
        model.getZhihuDetailData(id, new Callback<ZhihuDetailBean>() {
            @Override
            public void onSuccess(ZhihuDetailBean data) {
                mMvpView.onSuccess(data);
            }

            @Override
            public void onFail(String msg) {
                Log.e(TAG, "onFail: e="+msg );
            }
        });
    }
}
