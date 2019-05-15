package com.jiyun.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.base.BaseFragment;
import com.jiyun.base.Constants;
import com.jiyun.day03.MainActivity;
import com.jiyun.day03.R;
import com.jiyun.presenter.EmptyPresenter;
import com.jiyun.util.SpUtil;
import com.jiyun.util.UIModeUtil;
import com.jiyun.view.EmptyView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class SettingsFragment extends BaseFragment<EmptyView, EmptyPresenter> implements EmptyView {
    @BindView(R.id.cb_setting_cache)
    AppCompatCheckBox cbSettingCache;
    @BindView(R.id.cb_setting_image)
    AppCompatCheckBox cbSettingImage;
    @BindView(R.id.cb_setting_night)
    AppCompatCheckBox cbSettingNight;
    @BindView(R.id.ll_setting_feedback)
    LinearLayout llSettingFeedback;
    @BindView(R.id.tv_setting_clear)
    TextView tvSettingClear;
    @BindView(R.id.ll_setting_clear)
    LinearLayout llSettingClear;
    @BindView(R.id.tv_setting_update)
    TextView tvSettingUpdate;
    @BindView(R.id.ll_setting_update)
    LinearLayout llSettingUpdate;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.settings_layout;
    }

    @Override
    protected void initView() {
        //if (sp里面的模式是否为夜间){
        int mode = (int) SpUtil.getParam(Constants.MODE, AppCompatDelegate.MODE_NIGHT_NO);
        if (mode == AppCompatDelegate.MODE_NIGHT_YES){
            cbSettingNight.setChecked(true);
        }else {
            cbSettingNight.setChecked(false);
        }
    }

    @Override
    protected void initListener() {
        cbSettingNight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //切换模式,
                //切换夜间模式的时候,Activiyt会重新创建,新建的switchCompat默认是false,会
                //调用这个回调,去掉非人为的回调
                if (buttonView.isPressed()){
                    UIModeUtil.changeModeUI((MainActivity)getActivity());
                    //保存设置碎片的位置,再次进来之后直接显示设置Fragmnet
                    SpUtil.setParam(Constants.NIGHT_CURRENT_FRAG_POS,MainActivity.TYPE_SETTING);
                }
            }
        });
    }

}
