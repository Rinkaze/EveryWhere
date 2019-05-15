package com.jiyun.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jiyun.fragment.GankFragment;

import java.util.ArrayList;

/**
 * Created by 灵风 on 2019/4/22.
 */

public class VpGankAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> fragments;

    public VpGankAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

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
        return GankFragment.types[position];
    }
}
