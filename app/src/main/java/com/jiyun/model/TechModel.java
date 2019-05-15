package com.jiyun.model;

import com.jiyun.base.BaseModel;
import com.jiyun.bean.GankItemBean;
import com.jiyun.net.Callback;
import com.jiyun.net.GankCallback;
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
 * Created by 灵风 on 2019/4/22.
 */

public class TechModel extends BaseModel{
    public void getTechList(String tech, int page, final GankCallback<GankItemBean> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GankService.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GankService service = retrofit.create(GankService.class);
        Observable<GankHttpResponse<List<GankItemBean>>> observable = service.getTechList(tech, page);
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
