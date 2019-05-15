package com.jiyun.view;

import com.jiyun.base.BaseMvpView;
import com.jiyun.bean.GankItemBean;
import com.jiyun.net.GankHttpResponse;

import java.util.List;

/**
 * Created by 灵风 on 2019/4/22.
 */

public interface TechView extends BaseMvpView{
    void onSuccess(GankHttpResponse<List<GankItemBean>> gankItemBean);
}
