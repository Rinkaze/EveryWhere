package com.everywhere.trip.ui.main.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.everywhere.trip.R;
import com.everywhere.trip.base.BaseFragment;
import com.everywhere.trip.presenter.LoginOrBindPresenter;
import com.everywhere.trip.ui.main.activity.MainActivity;
import com.everywhere.trip.ui.main.activity.WebViewActivity;
import com.everywhere.trip.util.ToastUtil;
import com.everywhere.trip.view.main.LoginOrBindView;
import com.umeng.socialize.bean.SHARE_MEDIA;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author xts
 *         Created by asus on 2019/5/4.
 */

public class LoginOrBindFragment extends BaseFragment<LoginOrBindView, LoginOrBindPresenter> implements LoginOrBindView{

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_hello)
    TextView mTvHello;
    @BindView(R.id.tv_login)
    TextView mTvLogin;
    @BindView(R.id.tv_coutry_code)
    TextView mTvCoutryCode;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.btn_send_verify)
    Button mBtnSendVerify;
    @BindView(R.id.ll_container)
    LinearLayout mLlContainer;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.ll_or)
    LinearLayout mLlOr;
    @BindView(R.id.iv_wechat)
    ImageView mIvWechat;
    @BindView(R.id.iv_qq)
    ImageView mIvQq;
    @BindView(R.id.iv_sina)
    ImageView mIvSina;
    @BindView(R.id.tv_protocol)
    TextView mTvProtocol;

    @Override
    protected LoginOrBindPresenter initPresenter() {
        return new LoginOrBindPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login_bind;
    }

    @OnClick({R.id.iv_back, R.id.btn_send_verify, R.id.iv_wechat, R.id.iv_qq, R.id.iv_sina})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.btn_send_verify:
                addVerifyFragment();
                break;
            case R.id.iv_wechat:
                mPresenter.oauthLogin(SHARE_MEDIA.WEIXIN);
                break;
            case R.id.iv_qq:
                mPresenter.oauthLogin(SHARE_MEDIA.QQ);
                break;
            case R.id.iv_sina:
                mPresenter.oauthLogin(SHARE_MEDIA.SINA);
                break;
        }
    }

    private void addVerifyFragment() {
        if (TextUtils.isEmpty(getPhone())){
            return;
        }
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        //添加到回退栈
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.fl_container,new VerifyFragment()).commit();
    }

    @Override
    protected void initListener() {
        //文本发生改变监听
        mEtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                switchBtnState(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    /**
     * 根据输入框中是否有内容,切换发送验证码的背景
     * @param s
     */
    private void switchBtnState(CharSequence s) {
        if (TextUtils.isEmpty(s)){
            mBtnSendVerify.setBackgroundResource(R.drawable.bg_btn_ea_r15);
        }else {
            mBtnSendVerify.setBackgroundResource(R.drawable.bg_btn_fa6a13_r15);
        }
    }

    @Override
    public String getPhone() {
        return mEtPhone.getText().toString().trim();
    }

    @Override
    public Activity getAct() {
        return getActivity();
    }

    @Override
    public void go2MainActivity() {
        MainActivity.startAct(getContext());
    }

    @Override
    protected void initView() {

        //SpannableString ss = new SpannableString(getResources().getString(R.string.agree_protocol));
        //通过设置不同的span达到不同的显示效果
      /*  what：对SpannableString进行润色的各种Span；
        start：需要润色文字段开始的下标,包含；
        end：需要润色文字段结束的下标,结束应用指定Span的位置，不包含；
        flags：Spannable.SPAN_EXCLUSIVE_EXCLUSIVE：前后都不包括（
        在标志位【start，end）前后添加文字，新添加的文字不会有任何设置的属性）
Spannable.SPAN_EXCLUSIVE_INCLUSIVE ：前面不包括，后面包括。
（在标志位【start，end）前添加文字，新添加的文字不会有任何设置的属性，后边的添加的文字会带有设置的what属性）
Spannable.SPAN_INCLUSIVE_EXCLUSIVE ：前面包括，后面不包括。
（在标志位【start，end）后添加文字，新添加的文字不会有任何设置的属性，前边边的添加的文字会带有设置的what属性）
Spannable.SPAN_INCLUSIVE_INCLUSIVE ：前后都包括。前后都不包括
（在标志位【start，end）前后添加文字，新添加的文字会有设置的属性）
*/

       /* ss.setSpan(what,0,16, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


        mTvProtocol.setText(ss);*/

        //17个字,0-16
     /*   SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getResources().getString(R.string.agree_protocol));
        //SPAN_INCLUSIVE_EXCLUSIVE 1-16,插入的位置1-15 可以渲染,16就不会被渲染
        //SPAN_INCLUSIVE_INCLUSIVE 1-16,插入的位置1-16 都可以渲染
        //SPAN_EXCLUSIVE_INCLUSIVE 1-16,插入的位置2-16 都可以渲染
        spannableStringBuilder.setSpan(what,1,16, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableStringBuilder.insert(2,"12");
        mTvProtocol.setText(spannableStringBuilder);*/

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getResources().getString(R.string.agree_protocol));
        //点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                //跳转页面,webview展示协议
                //webView有很多坑,所以我们不直接用webView
                WebViewActivity.startAct(getActivity());
            }
        };
        spannableStringBuilder.setSpan(clickableSpan,13,17, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        //下划线
        UnderlineSpan underlineSpan = new UnderlineSpan();
        spannableStringBuilder.setSpan(underlineSpan,13,17, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        //前景色
        ForegroundColorSpan what = new ForegroundColorSpan(
                getResources().getColor(R.color.c_fa6a13));
        spannableStringBuilder.setSpan(what,13,17, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        //需要设置这个ClickableSpan才会有效果
        mTvProtocol.setMovementMethod(LinkMovementMethod.getInstance());
        mTvProtocol.setText(spannableStringBuilder);
    }
}
