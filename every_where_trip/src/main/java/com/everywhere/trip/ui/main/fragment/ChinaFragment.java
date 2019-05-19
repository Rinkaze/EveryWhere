package com.everywhere.trip.ui.main.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.baidu.mapapi.model.LatLng;
import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.CityBean;
import com.everywhere.trip.presenter.EmptyPresenter;
import com.everywhere.trip.ui.main.activity.MainActivity;
import com.everywhere.trip.ui.main.adapter.RecChinaAdapter;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.view.main.EmptyView;
import com.everywhere.trip.widget.SideBar;

import butterknife.BindView;

/**
 * Created by 灵风 on 2019/5/17.
 */

public class ChinaFragment extends BaseFragment<EmptyView, EmptyPresenter> implements EmptyView {
    @BindView(R.id.sideBar)
    SideBar mSideBar;
    @BindView(R.id.recView)
    RecyclerView mRecView;
    private RecChinaAdapter adapter;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_china;
    }

    @Override
    protected void initView() {
        CityBean.ResultEntity.ChinaEntity chinaEntity = (CityBean.ResultEntity.ChinaEntity) getArguments().getSerializable(Constants.DATA);
        mRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecChinaAdapter(getContext(), chinaEntity, mSideBar);
        mRecView.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        adapter.setOnCityClickListener(new RecChinaAdapter.OnCityClickListener() {
            @Override
            public void onCityClick(int id, String name, LatLng latLng) {
                SpUtil.setParam("cityID",id);
                SpUtil.setParam("cityName",name);
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("latlng",latLng);
                getActivity().setResult(200,intent);
                getActivity().finish();
            }
        });
    }
}
