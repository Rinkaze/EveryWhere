package com.jiyun.day03;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.base.BaseActivity;
import com.jiyun.base.BaseApp;
import com.jiyun.bean.StoriesEntity;
import com.jiyun.bean.ZhihuDetailBean;
import com.jiyun.dao.DaoSession;
import com.jiyun.dao.StoriesEntityDao;
import com.jiyun.fragment.DailyNewsFragment;
import com.jiyun.presenter.ZhihuDetailPresenter;
import com.jiyun.util.HtmlUtil;
import com.jiyun.view.ZhihuDetailView;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhihuDetailActivity extends BaseActivity<ZhihuDetailView, ZhihuDetailPresenter> implements ZhihuDetailView {


    @BindView(R.id.detail_bar_image)
    ImageView detailBarImage;
    @BindView(R.id.detail_bar_copyright)
    TextView detailBarCopyright;
    @BindView(R.id.view_toolbar)
    Toolbar viewToolbar;
    @BindView(R.id.clp_toolbar)
    CollapsingToolbarLayout clpToolbar;
    @BindView(R.id.view_main)
    WebView wvDetailContent;
    @BindView(R.id.nsv_scroller)
    NestedScrollView nsvScroller;
    @BindView(R.id.tv_detail_bottom_like)
    TextView tvDetailBottomLike;
    @BindView(R.id.tv_detail_bottom_comment)
    TextView tvDetailBottomComment;
    @BindView(R.id.tv_detail_bottom_share)
    TextView tvDetailBottomShare;
    @BindView(R.id.ll_detail_bottom)
    FrameLayout llDetailBottom;
    @BindView(R.id.fab_like)
    FloatingActionButton fabLike;

    private boolean isBottomShow = true;
    private String imgUrl;
    private String shareUrl;

    @Override
    protected ZhihuDetailPresenter initPresenter() {
        return new ZhihuDetailPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhihu_detail;
    }

    @Override
    public void onSuccess(ZhihuDetailBean zhihuDetailBean) {
        imgUrl = zhihuDetailBean.getImage();
        shareUrl = zhihuDetailBean.getShare_url();
        Glide.with(this)
                .load(zhihuDetailBean.getImage())
                .into(detailBarImage);


        clpToolbar.setTitle(zhihuDetailBean.getTitle());
        detailBarCopyright.setText(zhihuDetailBean.getImage_source());
        String htmlData = HtmlUtil.createHtmlData(zhihuDetailBean.getBody(), zhihuDetailBean.getCss(), zhihuDetailBean.getJs());
        wvDetailContent.loadData(htmlData, HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);
    }

    @Override
    protected void initView() {
        viewToolbar.setTitle("");
        setSupportActionBar(viewToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        mPresenter.getZhihuDetailData(id);
        WebSettings settings = wvDetailContent.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        wvDetailContent.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        nsvScroller.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY - oldScrollY > 0 && isBottomShow) {  //下移隐藏
                    isBottomShow = false;
                    llDetailBottom.animate().translationY(llDetailBottom.getHeight());
                } else if (scrollY - oldScrollY < 0 && !isBottomShow) {    //上移出现
                    isBottomShow = true;
                    llDetailBottom.animate().translationY(0);
                }
            }
        });

    }

    @Override
    protected void initListener() {
        fabLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaoSession daoSession = BaseApp.getDaoSession();
                if (DailyNewsFragment.storiesEntity != null){
                    StoriesEntity unique = daoSession.queryBuilder(StoriesEntity.class)
                            .where(StoriesEntityDao.Properties.Id.eq(DailyNewsFragment.storiesEntity.getId()))
                            .unique();
                    if (unique == null){
                        daoSession.insert(DailyNewsFragment.storiesEntity);
                        Toast.makeText(ZhihuDetailActivity.this, "已添加到收藏", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
