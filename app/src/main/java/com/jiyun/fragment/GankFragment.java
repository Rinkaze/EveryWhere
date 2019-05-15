package com.jiyun.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.jiyun.adapter.VpGankAdapter;
import com.jiyun.base.BaseFragment;
import com.jiyun.day03.R;
import com.jiyun.presenter.GankPresenter;
import com.jiyun.view.GankView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class GankFragment extends BaseFragment<GankView, GankPresenter> implements GankView {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    public static String[] types = {"Android","IOS","前端","福利"};
    private ArrayList<Fragment> fragments;
    private VpGankAdapter adapter;

    @Override
    protected GankPresenter initPresenter() {
        return new GankPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.gank_layout;
    }

    @Override
    protected void initView() {
        tab.setupWithViewPager(vp);
        fragments = new ArrayList<>();
        for (String type : types) {
            if (!type.equals("福利")){
                TechFragment fragment = new TechFragment();
                Bundle bundle = new Bundle();
                bundle.putString("type",type);
                fragment.setArguments(bundle);
                fragments.add(fragment);
            }else {
                fragments.add(new GrilFragment());
            }
        }
        adapter = new VpGankAdapter(getChildFragmentManager(), fragments);
        vp.setAdapter(adapter);
    }
}
