package com.jiyun.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.adapter.RecDailyNewsAdapter;
import com.jiyun.adapter.RecLikeAdapter;
import com.jiyun.base.BaseApp;
import com.jiyun.base.BaseFragment;
import com.jiyun.bean.DailyNewsBean;
import com.jiyun.bean.StoriesEntity;
import com.jiyun.day03.R;
import com.jiyun.day03.ZhihuDetailActivity;
import com.jiyun.presenter.EmptyPresenter;
import com.jiyun.view.EmptyView;
import com.jiyun.widget.SimpleItemTouchCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 灵风 on 2019/4/3.
 */

public class LikeFragment extends BaseFragment<EmptyView, EmptyPresenter> implements EmptyView {
    @BindView(R.id.recView)
    RecyclerView recView;
    private RecLikeAdapter adapter;
    private List<StoriesEntity> list = new ArrayList<>();

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.like_layout;
    }

    private static final String TAG = "LikeFragment";

    public void refreshData(){
        list = BaseApp.getDaoSession().loadAll(StoriesEntity.class);
        adapter.setStories((ArrayList<StoriesEntity>) list);
    }

    @Override
    public void onResume() {
        super.onResume();
            refreshData();
    }

    @Override
    protected void initView() {
        recView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = BaseApp.getDaoSession().loadAll(StoriesEntity.class);
        adapter = new RecLikeAdapter(getContext(), (ArrayList<StoriesEntity>) list);
        recView.setAdapter(adapter);
        //拖拽移动和左滑删除
        SimpleItemTouchCallback simpleItemTouchCallBack = new SimpleItemTouchCallback(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(simpleItemTouchCallBack);
        helper.attachToRecyclerView(recView);

        adapter.setOnItemClickListener(new RecLikeAdapter.OnItemClickListener() {
            @Override
            public void onClick(String url, StoriesEntity storiesEntity) {
                Intent intent = new Intent(getContext(), ZhihuDetailActivity.class);
                intent.putExtra("id",url);
                startActivity(intent);
            }
        });
    }

}
