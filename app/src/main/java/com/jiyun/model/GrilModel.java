package com.jiyun.model;

import com.google.gson.Gson;
import com.jiyun.base.BaseModel;
import com.jiyun.bean.GankItemBean;
import com.jiyun.bean.GrilBean;
import com.jiyun.net.Callback;
import com.jiyun.net.GankHttpResponse;
import com.jiyun.net.GankService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 灵风 on 2019/4/23.
 */

public class GrilModel extends BaseModel{
    public void getGrilData(int page, final Callback<GankHttpResponse<List<GankItemBean>>> callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GankService.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<GankHttpResponse<List<GankItemBean>>> observable = retrofit.create(GankService.class).getGirlList(page);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GankHttpResponse<List<GankItemBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(GankHttpResponse<List<GankItemBean>> listGankHttpResponse) {
                        callback.onSuccess(listGankHttpResponse);
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
