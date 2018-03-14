package com.example.latte.ec.sign;

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

public class SignUpDelegate extends LatteDelegate {


    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText mName;
    @BindView(R2.id.edit_sign_up_email)
    TextInputEditText mEmail;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText mPhone;
    @BindView(R2.id.edit_sign_up_password)
    TextInputEditText mPassword;
    @BindView(R2.id.edit_sign_up_re_password)
    TextInputEditText mRePassword;
    @BindView(R2.id.btn_sign_up)
    AppCompatButton mSignUp;
    @BindView(R2.id.tv_link_sign_in)
    AppCompatTextView mLinkSignIn;

    private ISignListener mISignListener = null;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener = (ISignListener) activity;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @OnClick({R2.id.btn_sign_up, R2.id.tv_link_sign_in})
    public void onClick(View view) {
        switch (view.getId()) {
            case R2.id.btn_sign_up:
                if (checkForm()) {
                    RestClient.builder()
                            .url("")
                            .params("name", mName.getText().toString().trim())
                            .params("email", mEmail.getText().toString().trim())
                            .params("phone", mPhone.getText().toString().trim())
                            .params("password", mPassword.getText().toString().trim())
                            .success(new ISuccess() {
                                @Override
                                public void onSuccess(String response) {
                                    LatteLogger.json("USER_PROFILE", response);
                                    SignHandler.onSignUp(response,mISignListener);

                                }
                            })
                            .build()
                            .post();

                }
                break;
            case R2.id.tv_link_sign_in:
                getSupportDelegate().start(new SignInDelegate());
                break;
            default:
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    private boolean checkForm() {
        final String name = mName.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        final String phone = mPhone.getText().toString().trim();
        final String password = mPassword.getText().toString().trim();
        final String rePassword = mRePassword.getText().toString().trim();

        boolean isPass = true;

        if (name.isEmpty()) {
            mName.setError("请输入姓名");
            isPass = false;
        } else {
            mName.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (phone.isEmpty() || phone.length() < 6) {
            mPhone.setError("手机号码错误");
            isPass = false;
        } else {
            mPhone.setError(null);
        }

        if (password.isEmpty() || mPassword.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        if (rePassword.isEmpty() || rePassword.length() < 6 || !rePassword.equals(password)) {
            mRePassword.setError("密码验证错误");
            isPass = false;
        } else {
            mRePassword.setError(null);
        }

        return isPass;

    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

}
