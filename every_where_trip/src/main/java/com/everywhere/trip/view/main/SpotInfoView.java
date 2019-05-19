package com.everywhere.trip.view.main;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.SpotBean;
import com.everywhere.trip.bean.SpotInfo;

/**
 * @author xts
 *         Created by asus on 2019/4/29.
 */

public interface SpotInfoView extends BaseMvpView {
    void onSuccess(SpotInfo.ResultEntity.SpotEntity spotEntity);
    void onFail(String msg);
}
