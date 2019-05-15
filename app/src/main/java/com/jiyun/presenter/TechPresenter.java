package com.jiyun.presenter;

import android.util.Log;

import com.jiyun.base.BasePresenter;
import com.jiyun.bean.GankItemBean;
import com.jiyun.model.TechModel;
import com.jiyun.net.Callback;
import com.jiyun.net.GankCallback;
import com.jiyun.net.GankHttpResponse;
import com.jiyun.view.TechView;

import java.util.List;

/**
 * Created by 灵风 on 2019/4/22.
 */

public class TechPresenter extends BasePresenter<TechView>{

    TechModel model;

    @Override
    public void initModel() {
        model = new TechModel();
    }

    private static final String TAG = "TechPresenter";
    public void getTechList(String tech,int page){
        model.getTechList(tech, page, new GankCallback<GankItemBean>() {

            @Override
            public void onSuccess(GankHttpResponse<List<GankItemBean>> listGankHttpResponse) {
                mMvpView.onSuccess(listGankHttpResponse);
            }

            @Override
            public void onFail(String msg) {
                Log.e(TAG, "onFail: e="+msg );
            }
        });
    }
}
