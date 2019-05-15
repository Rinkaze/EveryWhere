package com.jiyun.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jiyun.adapter.RecTechAdapter;
import com.jiyun.base.BaseFragment;
import com.jiyun.bean.GankItemBean;
import com.jiyun.day03.R;
import com.jiyun.net.GankHttpResponse;
import com.jiyun.presenter.TechPresenter;
import com.jiyun.util.SystemUtil;
import com.jiyun.view.TechView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by 灵风 on 2019/4/22.
 */

public class TechFragment extends BaseFragment<TechView, TechPresenter> implements TechView {

    @BindView(R.id.recView)
    RecyclerView rvTechContent;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;
    @BindView(R.id.iv_tech_blur)
    ImageView ivBlur;
    @BindView(R.id.iv_tech_origin)
    ImageView ivOrigin;
    @BindView(R.id.tv_tech_copyright)
    TextView tvCopyright;
    @BindView(R.id.tech_appbar)
    AppBarLayout appbar;

    private int page = 1;
    List<GankItemBean> mList;
    RecTechAdapter mAdapter;
    private String string;

    @Override
    public void onSuccess(GankHttpResponse<List<GankItemBean>> gankItemBean) {
        if (page == 1) {
            mList.clear();
        }
        mList.addAll(gankItemBean.getResults());
        mAdapter.notifyDataSetChanged();
        mSrl.finishLoadMore();
        mSrl.finishRefresh();
    }

    @Override
    protected TechPresenter initPresenter() {
        return new TechPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tech;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        string = bundle.getString("type");
        mPresenter.getTechList(string, page);
        mList = new ArrayList<>();
        mAdapter = new RecTechAdapter(getContext(), mList, string);
        rvTechContent.setLayoutManager(new LinearLayoutManager(getContext()));
        rvTechContent.setAdapter(mAdapter);
        BlurTransformation blurTransformation = new BlurTransformation(getContext());
        RequestOptions options = RequestOptions.bitmapTransform(blurTransformation)
                .centerCrop();
        Glide.with(getContext()).load(R.mipmap.p3).into(ivOrigin);
        Glide.with(getContext())
                .load(R.mipmap.p3)
                .apply(options)
                .into(ivBlur);
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                float rate = (float) (SystemUtil.dp2px(getContext(), 256) + verticalOffset * 2)
                        / SystemUtil.dp2px(getContext(), 256);
                if (rate >= 0)
                    ivOrigin.setAlpha(rate);
            }
        });
    }

    @Override
    protected void initListener() {
        mSrl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresenter.getTechList(string, page);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                mPresenter.getTechList(string, page);
            }
        });
    }
}
