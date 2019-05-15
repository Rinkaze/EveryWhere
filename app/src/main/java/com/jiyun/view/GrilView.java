package com.jiyun.view;

import com.jiyun.base.BaseMvpView;
import com.jiyun.bean.GankItemBean;
import com.jiyun.bean.GrilBean;
import com.jiyun.net.GankHttpResponse;

import java.util.List;

/**
 * Created by 灵风 on 2019/4/23.
 */

public interface GrilView extends BaseMvpView{
    void onSuccess(GankHttpResponse<List<GankItemBean>> listGankHttpResponse);
}
