package com.everywhere.trip.ui.main.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.CityBean;
import com.everywhere.trip.presenter.EmptyPresenter;
import com.everywhere.trip.ui.main.activity.MainActivity;
import com.everywhere.trip.ui.main.adapter.RecCityAdapter;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.view.main.EmptyView;

import butterknife.BindView;

/**
 * Created by 灵风 on 2019/5/19.
 */

public class CityFragment extends BaseFragment<EmptyView, EmptyPresenter> implements EmptyView {
    @BindView(R.id.tv_lately)
    TextView mTvLately;
    @BindView(R.id.tv_city)
    TextView mTvCity;
    @BindView(R.id.rl_city)
    RelativeLayout mRlCity;
    @BindView(R.id.tv_hot_city)
    TextView mTvHotCity;
    @BindView(R.id.rec_hot_city)
    RecyclerView mRecHotCity;
    private RecCityAdapter recCityAdapter;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_city;
    }

    @Override
    protected void initView() {
        CityBean.ResultEntity.CountriesEntity countriesEntity = (CityBean.ResultEntity.CountriesEntity) getArguments().getSerializable(Constants.DATA);
        mRecHotCity.setLayoutManager(new GridLayoutManager(getContext(),2));
        recCityAdapter = new RecCityAdapter(getContext(), countriesEntity.getCities());
        mRecHotCity.setAdapter(recCityAdapter);
        mTvCity.setText((String) SpUtil.getParam("cityName","北京"));
    }

    @Override
    protected void initListener() {
        recCityAdapter.setOnItemClickListener(new RecCityAdapter.OnItemClickListener() {
            @Override
            public void onClick(int id, String name, LatLng latLng) {
                SpUtil.setParam("cityID",id);
                SpUtil.setParam("cityName",name);
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("latlng",latLng);
                getActivity().setResult(200,intent);
                getActivity().finish();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mTvCity.setText((String) SpUtil.getParam("cityName","北京"));
    }
}
