package com.everywhere.trip.ui.main.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.CityBean;
import com.everywhere.trip.presenter.EmptyPresenter;
import com.everywhere.trip.view.main.EmptyView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;

/**
 * Created by 灵风 on 2019/5/19.
 */

public class CountryFragment extends BaseFragment<EmptyView, EmptyPresenter> implements EmptyView {
    @BindView(R.id.tab)
    VerticalTabLayout mTab;
    @BindView(R.id.fragment_container)
    FrameLayout mFragmentContainer;
    private ArrayList<Fragment> fragments;
    private CityBean.ResultEntity resultEntity;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_country;
    }

    @Override
    protected void initView() {
        fragments = new ArrayList<>();
        resultEntity = (CityBean.ResultEntity) getArguments().getSerializable(Constants.DATA);
        initTab();
        initFragment();
    }

    private void initFragment() {
        for (CityBean.ResultEntity.CountriesEntity countriesEntity : resultEntity.getCountries()) {
            CityFragment cityFragment = new CityFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.DATA,countriesEntity);
            cityFragment.setArguments(bundle);
            fragments.add(cityFragment);
        }
        mTab.setupWithFragment(getChildFragmentManager(),R.id.fragment_container,fragments);
    }

    private void initTab() {
        final List<CityBean.ResultEntity.CountriesEntity> countries = resultEntity.getCountries();
        mTab.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return countries.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                return new QTabView.TabTitle.Builder()
                        .setContent(countries.get(position).getName())
                        .setTextColor(R.color.c_fa6a13,R.color.black)
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return R.drawable.tab_bg_ea_white;
            }
        });
    }
}
