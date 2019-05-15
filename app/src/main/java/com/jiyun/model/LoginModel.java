package com.jiyun.model;

import com.jiyun.base.BaseModel;
import com.jiyun.bean.LoginBean;
import com.jiyun.net.ApiService;
import com.jiyun.base.BaseObserver;
import com.jiyun.net.Callback;
import com.jiyun.util.HttpUtils;
import com.jiyun.util.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 灵风 on 2019/4/2.
 */

public class LoginModel extends BaseModel {


    public void login(String uName, String psw, final Callback callback) {
        ApiService apiService = HttpUtils.getInstance().getApiserver(ApiService.baseUrl, ApiService.class);
        Observable<LoginBean> observable = apiService.login(uName, psw);
        observable.compose(RxUtils.<LoginBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callback.onSuccess(loginBean);
                    }
                });
    }
}
