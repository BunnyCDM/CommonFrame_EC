package com.example.latte.ec.sign;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.R;
import com.example.latte.ec.R2;
import com.example.latte.net.RestClient;
import com.example.latte.net.callback.ISuccess;
import com.example.latte.util.log.LatteLogger;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mac on 2017/10/8.
 */

public class SignInDelegate extends LatteDelegate {

    private static final String TAG = SignInDelegate.class.getSimpleName();
    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;


    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_sign_in)
    public void onClickSignIn() {
        Log.d(TAG, "onClickSignIn: ");
        if (checkForm()) {
            Log.d(TAG, "onClick: 登录验证成功");
            Toast.makeText(getContext(), "登录验证成功", Toast.LENGTH_SHORT).show();
            RestClient.builder()
                    //.url("http://192.168.56.1:8080/RestDataServer/api/user_profile.php")
                    .url("http://mock.fulingjie.com/mock/data/user_profile.json")
                    .params("email", mEmail.getText().toString().trim())
                    .params("password", mPassword.getText().toString().trim())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            LatteLogger.json("USER_PROFILE", response);
                            SignHandler.onSignIn(response, mISignListener);
                        }
                    })
                    .build()
                    .post();
        }
    }

    @OnClick(R2.id.tv_link_sign_up)
    public void onClickLink() {
        Log.d(TAG, "onClickSignIn: ");
        getSupportDelegate().start(new SignUpDelegate());
    }

    @OnClick(R2.id.icon_sign_in_wechat)
    public void onClickWeChat() {
        Log.d(TAG, "onClickWeChat: ");
        Toast.makeText(getContext(), "微信登录暂时还未实现（因需注册后的appid及appkey）", Toast.LENGTH_SHORT).show();
//        LatteWeChat
//                .getInstance()
//                .onSignSuccess(new IWeChatSignInCallback() {
//                    @Override
//                    public void onSignInSuccess(String userInfo) {
//                        Toast.makeText(getContext(), userInfo, Toast.LENGTH_LONG).show();
//                    }
//                })
//                .signIn();
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    private boolean checkForm() {
        final String email = mEmail.getText().toString().trim();
        final String password = mPassword.getText().toString().trim();

        boolean isPass = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

}
