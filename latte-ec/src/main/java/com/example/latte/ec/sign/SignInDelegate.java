package com.example.latte.ec.sign;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.latte.app.Latte;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.R;
import com.example.latte.ec.R2;
import com.example.latte.net.RestClient;
import com.example.latte.net.callback.ISuccess;
import com.example.latte.util.log.LatteLogger;
import com.example.latte.wechat.LatteWeChat;
import com.example.latte.wechat.callbacks.IWeChatSignInCallback;
import com.joanzapata.iconify.widget.IconTextView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mac on 2017/10/8.
 */

public class SignInDelegate extends LatteDelegate {


    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword;
    @BindView(R2.id.btn_sign_in)
    AppCompatButton btnSignIn;
    @BindView(R2.id.tv_link_sign_up)
    AppCompatTextView tvLinkSignUp;
    @BindView(R2.id.icon_sign_in_wechat)
    IconTextView iconSignInWechat;

    private ISignListener mISignListener=null;


    @OnClick({R2.id.btn_sign_in, R2.id.tv_link_sign_up, R2.id.icon_sign_in_wechat})
    public void onClick(View view) {
        switch (view.getId()) {
            case R2.id.btn_sign_in:
                if(checkForm()){
                    RestClient.builder()
                            .url("")
                            .params("email",mEmail.getText().toString().trim())
                            .params("password",mPassword.getText().toString().trim())
                            .success(new ISuccess() {
                                @Override
                                public void onSuccess(String response) {
                                    LatteLogger.json("USER_PROFILE",response);
                                    SignHandler.onSignIn(response,mISignListener);
                                }
                            })
                            .build()
                            .post();
                }
                break;
            case R2.id.tv_link_sign_up:
                getSupportDelegate().start(new SignUpDelegate());
                break;
            case R2.id.icon_sign_in_wechat:
                // TODO: 2017/10/13  微信登录，待续...
                LatteWeChat
                        .getInstance()
                        .onSignSuccess(new IWeChatSignInCallback() {
                            @Override
                            public void onSignInSuccess(String userInfo) {
                                Toast.makeText(getContext(), userInfo, Toast.LENGTH_LONG).show();
                            }
                        })
                        .signIn();
                break;
            default:
                break;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener){
            mISignListener= (ISignListener) activity;
        }
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    private boolean checkForm(){
        final String email=mEmail.getText().toString().trim();
        final String password=mPassword.getText().toString().trim();

        boolean isPass=true;

        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("错误的邮箱格式");
            isPass=false;
        }else {
            mEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 6){
            mPassword.setError("请填写至少6位数密码");
            isPass=false;
        }else {
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
