package com.everywhere.trip.ui.main.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseActivity;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.MainDataInfo;
import com.everywhere.trip.presenter.ReviewsPresenter;
import com.everywhere.trip.ui.main.adapter.RecMainInfoAdapter;
import com.everywhere.trip.ui.main.adapter.RecReviewsAdapter;
import com.everywhere.trip.view.main.ReviewsView;
import com.jaeger.library.StatusBarUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 灵风 on 2019/5/13.
 */

public class ReviewsActivity extends BaseActivity<ReviewsView, ReviewsPresenter> implements ReviewsView {
    @BindView(R.id.recView)
    RecyclerView mRecView;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;
    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.ll_parent)
    LinearLayout llParent;
    private RecReviewsAdapter adapter;
    private int page = 1;
    private ArrayList<MainDataInfo.ResultEntity.ReviewsEntity> list;
    private PopupWindow popupWindow;

    @Override
    public void onSuccess(MainDataInfo.ResultEntity resultEntity) {
        list.addAll(resultEntity.getReviews());
        adapter.setList(list);
        mSrl.finishLoadMore();
        mSrl.finishRefresh();
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected ReviewsPresenter initPresenter() {
        return new ReviewsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reviews;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setLightMode(this);
        list = new ArrayList<>();
        mRecView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecReviewsAdapter(this);
        mRecView.setAdapter(adapter);
        mToolBar.setNavigationIcon(R.mipmap.back_white);
        mToolBar.setTitle("");
    }

    @Override
    protected void initData() {
        mPresenter.getMainData(getIntent().getIntExtra(Constants.DATA, 0), page);
    }

    @Override
    protected void initListener() {
        mSrl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                initData();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (page == 1) {
                    list.clear();
                }
                initData();
            }
        });
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        adapter.setOnImageClickListener(new RecReviewsAdapter.OnImageClickListener() {
            @Override
            public void onClick(List<String> imgUrl, int position) {
                popup(imgUrl,position);
            }
        });
    }

    private void popup(final List<String> imgUrl, int position) {
        View view = View.inflate(this, R.layout.layout_zoomimg, null);
        ViewPager mVp = view.findViewById(R.id.vp);
        mVp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imgUrl.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                PhotoView photoView = new PhotoView(ReviewsActivity.this);
                Glide.with(ReviewsActivity.this).load(imgUrl.get(position)).into(photoView);
                photoView.enable();
                photoView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (popupWindow != null){
                            popupWindow.dismiss();
                        }
                    }
                });
                container.addView(photoView);
                return photoView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });
        mVp.setCurrentItem(position);
        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(llParent, Gravity.CENTER,0,0);
    }
}
