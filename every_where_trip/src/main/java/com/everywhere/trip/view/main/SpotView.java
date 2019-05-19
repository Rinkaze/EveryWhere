package com.everywhere.trip.view.main;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.SpotBean;

/**
 * @author xts
 *         Created by asus on 2019/4/29.
 */

public interface SpotView extends BaseMvpView {
    void onSuccess(SpotBean.ResultEntity resultEntity);
    void onFail(String msg);
}
