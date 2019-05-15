package com.jiyun.model;

import com.jiyun.base.BaseModel;
import com.jiyun.bean.ZhihuDetailBean;
import com.jiyun.net.Callback;
import com.jiyun.net.ZhihuService;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 灵风 on 2019/4/22.
 */

public class ZhihuDetailModel extends BaseModel{

    public void getZhihuDetailData(String id, final Callback<ZhihuDetailBean> callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ZhihuService.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ZhihuService service = retrofit.create(ZhihuService.class);
        Observable<ZhihuDetailBean> observable = service.getZhihuDetail(id);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ZhihuDetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ZhihuDetailBean zhihuDetailBean) {
                        callback.onSuccess(zhihuDetailBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
