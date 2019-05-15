package com.jiyun.net;

import com.jiyun.bean.GankItemBean;

import java.util.List;

/**
 * Created by 灵风 on 2019/4/2.
 */

public interface GankCallback<T> {

    void onSuccess(GankHttpResponse<List<GankItemBean>> listGankHttpResponse);
    void onFail(String msg);


}
