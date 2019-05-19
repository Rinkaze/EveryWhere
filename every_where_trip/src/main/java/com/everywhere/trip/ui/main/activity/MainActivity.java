package com.everywhere.trip.ui.main.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.presenter.EmptyPresenter;
import com.everywhere.trip.ui.main.fragment.BanmiFragment;
import com.everywhere.trip.ui.main.fragment.MainFragment;
import com.everywhere.trip.ui.main.fragment.MapFragment;
import com.everywhere.trip.ui.main.fragment.MyFragment;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.view.main.EmptyView;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity<EmptyView, EmptyPresenter> implements EmptyView {

	/**
	*
	*	Created by Rinkaze for 2019/05/15
	*
	*/

    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    @BindView(R.id.tab)
    TabLayout tab;
    private ArrayList<Fragment> fragments;
    private FragmentManager manager;
    final int TYPE_MAIN = 0;
    final int TYPE_MAP = 1;
    final int TYPE_BANMI = 2;
    final int TYPE_MY = 3;
    private int lastPosition = 0;
    private TextView tvMain;
    private TextView tvBanmi;
    private TextView tvMy;
    private TextView tvMap;
    private MapFragment mapFragment;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(this);
        tab.addTab(tab.newTab().setCustomView(R.layout.item_tab_main));
        tab.addTab(tab.newTab().setCustomView(R.layout.item_tab_map));
        tab.addTab(tab.newTab().setCustomView(R.layout.item_tab_banmi));
        tab.addTab(tab.newTab().setCustomView(R.layout.item_tab_my));
        tvMain = (TextView) tab.getTabAt(0).getCustomView().findViewById(R.id.tv_main);
        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DATA, (String) SpUtil.getParam(Constants.TOKEN, ""));
        mainFragment.setArguments(bundle);
        fragments.add(mainFragment);
        mapFragment = new MapFragment();
        fragments.add(mapFragment);
        fragments.add(new BanmiFragment());
        fragments.add(new MyFragment());
        manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        tran.add(R.id.fragment_container, fragments.get(0));
        tran.commit();
    }

    @Override
    protected void initListener() {
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() != 1){
                    tvCity.setVisibility(View.GONE);
                }
                switch (tab.getPosition()) {
                    case 0:
                        tvMain.setTextColor(getResources().getColor(R.color.c_fa6a13));
                        if (tvBanmi != null) {
                            tvBanmi.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        if (tvMy != null) {
                            tvMy.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        if (tvMap != null){
                            tvMap.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        switchFragment(TYPE_MAIN);
                        break;
                    case 1:
                        tvCity.setVisibility(View.VISIBLE);
                        if (tvMap == null) {
                            tvMap = (TextView) tab.getCustomView().findViewById(R.id.tv_map);
                        }
                        if (tvMain != null) {
                            tvMain.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        if (tvMy != null) {
                            tvMy.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        if (tvBanmi != null){
                            tvBanmi.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        tvMap.setTextColor(getResources().getColor(R.color.c_fa6a13));
                        switchFragment(TYPE_MAP);
                        break;
                    case 2:
                        if (tvBanmi == null) {
                            tvBanmi = (TextView) tab.getCustomView().findViewById(R.id.tv_banmi);
                        }
                        if (tvMain != null) {
                            tvMain.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        if (tvMy != null) {
                            tvMy.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        if (tvMap != null){
                            tvMap.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        tvBanmi.setTextColor(getResources().getColor(R.color.c_fa6a13));
                        switchFragment(TYPE_BANMI);
                        break;
                    case 3:
                        if (tvMy == null) {
                            tvMy = (TextView) tab.getCustomView().findViewById(R.id.tv_my);
                        }
                        if (tvMain != null) {
                            tvMain.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        if (tvBanmi != null){
                            tvBanmi.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        if (tvMap != null){
                            tvMap.setTextColor(getResources().getColor(R.color.c_cecece));
                        }
                        tvMy.setTextColor(getResources().getColor(R.color.c_fa6a13));
                        switchFragment(TYPE_MY);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tvCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,CityActivity.class),1);
            }
        });
    }

    private static final String TAG = "MainActivity";

    private void switchFragment(int type) {
        FragmentTransaction tran = manager.beginTransaction();
        Fragment fragment = fragments.get(type);
        if (!fragment.isAdded()) {
            tran.add(R.id.fragment_container, fragment);
        }
        tran.hide(fragments.get(lastPosition));
        tran.show(fragment);
        tran.commit();
        lastPosition = type;
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvCity.setText((String) SpUtil.getParam("cityName","北京"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 200){
            if (mapFragment != null){
                mapFragment.updateMap((LatLng) data.getParcelableExtra("latlng"));
            }
        }
    }
}
