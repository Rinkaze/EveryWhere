package com.everywhere.trip.ui.main.fragment;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.bean.SpotBean;
import com.everywhere.trip.presenter.SpotPresenter;
import com.everywhere.trip.ui.main.activity.SpotInfoActivity;
import com.everywhere.trip.util.GlideUtil;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.view.main.SpotView;
import com.koushikdutta.ion.Ion;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;

/**
 * Created by 灵风 on 2019/5/17.
 */

public class MapFragment extends BaseFragment<SpotView, SpotPresenter> implements SpotView, View.OnClickListener {
    @BindView(R.id.bmapView)
    MapView mMapView;
    @BindView(R.id.iv_location)
    ImageView ivLocation;
    @BindView(R.id.tab)
    TabLayout tab;
    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient;
    private LatLng latLng;
    private List<OverlayOptions> options;
    private SpotBean.ResultEntity resultEntity;

    @Override
    protected SpotPresenter initPresenter() {
        return new SpotPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_map;
    }

    @Override
    protected void initView() {
        ivLocation.setOnClickListener(this);
        tab.addTab(tab.newTab().setText("全部"));
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMyLocationEnabled(true);
        //定位初始化
        mLocationClient = new LocationClient(getContext());

        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);

        //设置locationClientOption
        mLocationClient.setLocOption(option);

        //注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);
        //开启地图定位图层
        mLocationClient.start();

        //创建OverlayOptions的集合
        options = new ArrayList<>();
    }

    @Override
    protected void initData() {
        mPresenter.getSpotData("", (int) SpUtil.getParam("cityID",10));
    }

    @Override
    protected void initListener() {
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (resultEntity != null){
                    if (tab.getPosition() == 0){
                        options.clear();
                        mBaiduMap.clear();
                        initData();
                    }else {
                        options.clear();
                        mBaiduMap.clear();
                        int id = resultEntity.getAllTags().get(tab.getPosition() - 1).getId();
                        mPresenter.getSpotData(id+"", (int) SpUtil.getParam("cityID",10));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            //marker被点击时回调的方法
            //若响应点击事件，返回true，否则返回false
            //默认返回false
            @Override
            public boolean onMarkerClick(Marker marker) {
                LatLng position = marker.getPosition();
                for (SpotBean.ResultEntity.DisplaySpotsEntity displaySpotsEntity : resultEntity.getDisplaySpots()) {
                    if (position.latitude == displaySpotsEntity.getLatitude() && position.longitude == displaySpotsEntity.getLongitude()){
                        int id = displaySpotsEntity.getId();
                        Intent intent = new Intent(getContext(), SpotInfoActivity.class);
                        intent.putExtra("spotId",id);
                        startActivity(intent);
                        break;
                    }
                }
                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
    }

    @Override
    public void onSuccess(SpotBean.ResultEntity resultEntity) {
        this.resultEntity = resultEntity;
        if (tab.getTabAt(1) == null){
            for (SpotBean.ResultEntity.AllTagsEntity allTagsEntity : resultEntity.getAllTags()) {
                tab.addTab(tab.newTab().setText(allTagsEntity.getName()));
            }
        }
        for (SpotBean.ResultEntity.DisplaySpotsEntity spotsEntity : resultEntity.getDisplaySpots()) {
            LatLng point = new LatLng(spotsEntity.getLatitude(), spotsEntity.getLongitude());
            OverlayOptions option = null;
            try {
                option = new MarkerOptions()
                        .title(spotsEntity.getTitle())
                        .position(point)
                        .icon(BitmapDescriptorFactory.fromBitmap(Ion.with(getContext()).load(spotsEntity.getDefaultMapIcon()).asBitmap().get()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            options.add(option);
        }
        /*for (SpotBean.ResultEntity.OtherSpotsEntity spotsEntity : resultEntity.getOtherSpots()) {
            LatLng point = new LatLng(spotsEntity.getLatitude(), spotsEntity.getLongitude());
            OverlayOptions option = null;
            try {
                option = new MarkerOptions()
                        .position(point)
                        .icon(BitmapDescriptorFactory.fromBitmap(Ion.with(getContext()).load(spotsEntity.getDefaultMapIcon()).asBitmap().get()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            options.add(option);
        }*/
        mBaiduMap.addOverlays(options);
    }

    @Override
    public void onFail(String msg) {

    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mMapView == null){
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
            latLng = new LatLng(location.getLatitude(), location.getLongitude());
        }
    }

    @Override
    public void onResume() {
        mMapView.onResume();
        super.onResume();
    }

    @Override
    public void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        options.clear();
        mLocationClient.stop();
        mBaiduMap.clear();
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroyView();
    }

    public void updateMap(LatLng latLng){
        mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(latLng));
        initData();
    }
}
