package com.everywhere.trip.view.main;

import com.everywhere.trip.base.BaseMvpView;
import com.everywhere.trip.bean.VersionInfo;

/**
 * Created by 灵风 on 2019/5/16.
 */

public interface VersionView extends BaseMvpView {
    void onSuccess(VersionInfo versionInfo);
    void onFail(String msg);
}
