package com.everywhere.trip.ui.main.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.CityBean;
import com.everywhere.trip.presenter.CityPresenter;
import com.everywhere.trip.ui.main.fragment.ChinaFragment;
import com.everywhere.trip.ui.main.fragment.CountryFragment;
import com.everywhere.trip.view.main.CityView;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;

public class CityActivity extends BaseActivity<CityView, CityPresenter> implements CityView {

    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    private String[] titles = {"国内","国际"};
    private ArrayList<Fragment> fragments;

    @Override
    protected CityPresenter initPresenter() {
        return new CityPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_city;
    }

    @Override
    public void onSuccess(CityBean.ResultEntity resultEntity) {
        initFragment(resultEntity);
        initAdatpter();
    }

    private void initAdatpter() {
        mVp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
    }

    private void initFragment(CityBean.ResultEntity resultEntity) {
        ChinaFragment chinaFragment = new ChinaFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.DATA,resultEntity.getChina());
        chinaFragment.setArguments(bundle);
        fragments.add(chinaFragment);
        CountryFragment countryFragment = new CountryFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putSerializable(Constants.DATA,resultEntity);
        countryFragment.setArguments(bundle1);
        fragments.add(countryFragment);
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(this);
        fragments = new ArrayList<>();
        mTab.setupWithViewPager(mVp);
    }

    @Override
    protected void initData() {
        mPresenter.getCities();
    }
}
