package com.everywhere.trip.ui.main.fragment;

import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.bean.VersionInfo;
import com.everywhere.trip.presenter.VersionPresenter;
import com.everywhere.trip.ui.main.activity.MainActivity;
import com.everywhere.trip.ui.my.activity.FollowActivity;
import com.everywhere.trip.ui.my.activity.InformationActivity;
import com.everywhere.trip.ui.my.activity.LikeActivity;
import com.everywhere.trip.util.GlideUtil;
import com.everywhere.trip.util.InstallUtil;
import com.everywhere.trip.util.SpUtil;
import com.everywhere.trip.util.UpdateManager;
import com.everywhere.trip.view.main.VersionView;

import java.io.File;

import butterknife.BindView;

public class MyFragment extends BaseFragment<VersionView, VersionPresenter> implements VersionView {

    @BindView(R.id.iv_header_left)
    ImageView ivHeaderLeft;
    @BindView(R.id.tv_name_left)
    TextView tvNameLeft;
    @BindView(R.id.tv_info_left)
    TextView tvInfoLeft;
    @BindView(R.id.tv_edit_left)
    TextView tvEditLeft;
    @BindView(R.id.iv_edit_left)
    ImageView ivEditLeft;
    @BindView(R.id.rl_title_left)
    RelativeLayout rlTitleLeft;
    @BindView(R.id.tv_money_left)
    TextView tvMoneyLeft;
    @BindView(R.id.tv_bonus_left)
    TextView tvBonusLeft;
    @BindView(R.id.rl_moneybag_left)
    RelativeLayout rlMoneybagLeft;
    @BindView(R.id.iv_kaquan_left)
    ImageView ivKaquanLeft;
    @BindView(R.id.rl_kaquan_left)
    RelativeLayout rlKaquanLeft;
    @BindView(R.id.iv_trip_left)
    ImageView ivTripLeft;
    @BindView(R.id.rl_trip_left)
    RelativeLayout rlTripLeft;
    @BindView(R.id.iv_like_left)
    ImageView ivLikeLeft;
    @BindView(R.id.rl_like_left)
    RelativeLayout rlLikeLeft;
    @BindView(R.id.iv_follow_left)
    ImageView ivFollowLeft;
    @BindView(R.id.rl_follow_left)
    RelativeLayout rlFollowLeft;
    @BindView(R.id.tv_service_left)
    TextView tvServiceLeft;
    @BindView(R.id.tv_idea_left)
    TextView tvIdeaLeft;
    @BindView(R.id.tv_version_left)
    TextView tvVersionLeft;
    @BindView(R.id.rl_left)
    RelativeLayout rlLeft;

    private String mPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/downloads/";
    private String downloadUrl = "http://cdn.banmi.com/banmiapp/apk/banmi_330.apk";
    private String fileName = "";
    private VersionInfo.ResultEntity.InfoEntity info;

    @Override
    protected VersionPresenter initPresenter() {
        return new VersionPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    public void onSuccess(VersionInfo versionInfo) {
        UpdateManager instance = UpdateManager.getInstance();
        info = versionInfo.getResult().getInfo();
        if (instance.updateApp(instance.getVersionName(getContext()), info.getVersion())){
            int type = 0;
            if(luo.library.base.utils.UpdateManager.getInstance().isWifi(getContext())) {
                type = 1;
            }

            if(false) {
                type = 2;
            }

            String downLoadPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/downloads/";
            File dir = new File(downLoadPath);
            if(!dir.exists()) {
                dir.mkdir();
            }

            fileName = info.getDownload_url().substring(info.getDownload_url().lastIndexOf("/") + 1, info.getDownload_url().length());
            if(fileName == null && TextUtils.isEmpty(fileName) && !fileName.contains(".apk")) {
                fileName = getActivity().getPackageName() + ".apk";
            }

            File file = new File(downLoadPath + fileName);
            UpdateManager.getInstance().setType(type).setUrl(info.getDownload_url()).setUpdateMessage("更新了UI\n添加图片缩放功能").setFileName(fileName).setIsDownload(file.exists());
            if(type == 1 && !file.exists()) {
                UpdateManager.getInstance().downloadFile(getContext());
            } else {
                UpdateManager.getInstance().showDialog(getContext());
            }
        }
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initView() {
        String photo = (String) SpUtil.getParam(Constants.PHOTO, "");
        GlideUtil.loadUrlCircleImage(R.mipmap.zhanweitu_touxiang, R.mipmap.zhanweitu_touxiang, photo, ivHeaderLeft, getContext());
        tvNameLeft.setText((String) SpUtil.getParam(Constants.USERNAME, "user"));
        tvInfoLeft.setText((String) SpUtil.getParam(Constants.DESC, "暂无"));
    }

    @Override
    protected void initListener() {
        rlTitleLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), InformationActivity.class));
            }
        });

        rlFollowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FollowActivity.class));
            }
        });

        rlLikeLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LikeActivity.class));
            }
        });

        tvVersionLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.checkVersion();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        String name = (String) SpUtil.getParam(Constants.USERNAME, "no");
        String signature = (String) SpUtil.getParam(Constants.DESC, "未设置");
        String photo = (String) SpUtil.getParam(Constants.PHOTO, "");
        tvNameLeft.setText(name);
        tvInfoLeft.setText(signature);
        GlideUtil.loadUrlCircleImage(R.mipmap.zhanweitu_touxiang, R.mipmap.zhanweitu_touxiang, photo, ivHeaderLeft, getContext());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == InstallUtil.UNKNOWN_CODE) {
            InstallUtil.installApk(getContext(),mPath+fileName);//再次执行安装流程，包含权限判等
        }
    }
}
