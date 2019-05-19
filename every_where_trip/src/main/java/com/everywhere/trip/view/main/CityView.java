package com.everywhere.trip.view.main;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.CityBean;

/**
 * Created by 灵风 on 2019/5/19.
 */

public interface CityView extends BaseMvpView{
    void onSuccess(CityBean.ResultEntity resultEntity);
    void onFail(String msg);
}
