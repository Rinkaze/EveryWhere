package com.jiyun.view;

import com.jiyun.base.BaseMvpView;
import com.jiyun.bean.ZhihuDetailBean;

/**
 * Created by 灵风 on 2019/4/22.
 */

public interface ZhihuDetailView extends BaseMvpView{
    void onSuccess(ZhihuDetailBean zhihuDetailBean);
}
