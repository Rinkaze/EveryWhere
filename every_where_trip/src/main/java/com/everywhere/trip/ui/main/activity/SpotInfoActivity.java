package com.everywhere.trip.ui.main.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.bean.SpotInfo;
import com.everywhere.trip.presenter.SpotInfoPresenter;
import com.everywhere.trip.ui.main.adapter.RecSpotInfoAdapter;
import com.everywhere.trip.view.main.SpotInfoView;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;

public class SpotInfoActivity extends BaseActivity<SpotInfoView, SpotInfoPresenter> implements SpotInfoView {

    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.recView)
    RecyclerView mRecView;
    private RecSpotInfoAdapter adapter;

    @Override
    public void onSuccess(SpotInfo.ResultEntity.SpotEntity spotEntity) {
        adapter = new RecSpotInfoAdapter(this, spotEntity);
        mRecView.setAdapter(adapter);
        hideLoading();
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        hideLoading();
    }

    @Override
    protected SpotInfoPresenter initPresenter() {
        return new SpotInfoPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_spot_info;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(this);
        mRecView.setLayoutManager(new LinearLayoutManager(this));
        mToolBar.setNavigationIcon(R.mipmap.back_white);
        mToolBar.setTitle("");
    }

    @Override
    protected void initData() {
        mPresenter.getSpotInfo(getIntent().getIntExtra("spotId",695));
        showLoading();
    }

    @Override
    protected void initListener() {
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
