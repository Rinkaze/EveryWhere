package com.everywhere.trip.ui.main.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.CityBean;
import com.everywhere.trip.presenter.EmptyPresenter;
import com.everywhere.trip.ui.main.activity.MainActivity;
import com.everywhere.trip.ui.main.adapter.LvChinaAdapter;
import com.everywhere.trip.ui.main.adapter.RecHotCityAdapter;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.view.main.EmptyView;
import com.everywhere.trip.widget.MyListView;
import com.everywhere.trip.widget.SideBar;

import butterknife.BindView;

/**
 * Created by 灵风 on 2019/5/17.
 */

public class ChinaFragment extends BaseFragment<EmptyView, EmptyPresenter> implements EmptyView {
    @BindView(R.id.sideBar)
    SideBar mSideBar;
    @BindView(R.id.lv)
    ListView mLocationListview;
    /**
     * 北京
     */
    private TextView mTvCity;
    private RecyclerView mRecHotCity;
    private RecHotCityAdapter recHotCityAdapter;
    private LvChinaAdapter lvChinaAdapter;

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
        View view = View.inflate(getContext(), R.layout.item_location, null);
        mTvCity = (TextView) view.findViewById(R.id.tv_city);
        mTvCity.setText((String) SpUtil.getParam("cityName","北京"));
        mRecHotCity = view.findViewById(R.id.rec_hot_city);
        mRecHotCity.setLayoutManager(new GridLayoutManager(getContext(),3));
        recHotCityAdapter = new RecHotCityAdapter(getContext(), chinaEntity.getTopCities());
        mRecHotCity.setAdapter(recHotCityAdapter);
        lvChinaAdapter = new LvChinaAdapter(chinaEntity.getCities(), getContext());
        lvChinaAdapter.setSideBar(mSideBar);
        lvChinaAdapter.setListView(mLocationListview);
        mLocationListview.addHeaderView(view);
        mLocationListview.setAdapter(lvChinaAdapter);
        lvChinaAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initListener() {
        recHotCityAdapter.setOnItemClickListener(new RecHotCityAdapter.OnItemClickListener() {
            @Override
            public void onClick(int id,String name,LatLng latLng) {
                SpUtil.setParam("cityID", id);
                SpUtil.setParam("cityName", name);
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("latlng", latLng);
                getActivity().setResult(200, intent);
                getActivity().finish();
            }
        });
        lvChinaAdapter.setOnItemClickListener(new LvChinaAdapter.OnItemClickListener() {
            @Override
            public void onClick(int id, String name, LatLng latLng) {
                SpUtil.setParam("cityID", id);
                SpUtil.setParam("cityName", name);
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("latlng", latLng);
                getActivity().setResult(200, intent);
                getActivity().finish();
            }
        });
    }
}
