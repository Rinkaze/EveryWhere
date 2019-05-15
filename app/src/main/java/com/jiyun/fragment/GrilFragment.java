package com.jiyun.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jiyun.adapter.RecGrilAdapter;
import com.jiyun.base.BaseFragment;
import com.jiyun.bean.GankItemBean;
import com.jiyun.day03.R;
import com.jiyun.net.GankHttpResponse;
import com.jiyun.presenter.GankPresenter;
import com.jiyun.presenter.GrilPresenter;
import com.jiyun.view.GrilView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 灵风 on 2019/4/23.
 */

public class GrilFragment extends BaseFragment<GrilView, GrilPresenter> implements GrilView {

    @BindView(R.id.recView)
    RecyclerView recView;
    @BindView(R.id.sml)
    SmartRefreshLayout sml;
    private int page = 1;
    private RecGrilAdapter adapter;

    @Override
    public void onSuccess(GankHttpResponse<List<GankItemBean>> listGankHttpResponse) {
        if (page == 1){
            adapter.list.clear();
        }
        List<GankItemBean> list = listGankHttpResponse.getResults();
        adapter.setList(list);
        sml.finishRefresh();
        sml.finishLoadMore();
    }

    @Override
    protected GrilPresenter initPresenter() {
        return new GrilPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gril;
    }

    @Override
    protected void initView() {
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL);
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        recView.setLayoutManager(manager);
        adapter = new RecGrilAdapter(getContext());
        recView.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        mPresenter.getGrilData(page);
    }

    @Override
    protected void initListener() {
        sml.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresenter.getGrilData(page);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                mPresenter.getGrilData(page);
            }
        });
    }
}
