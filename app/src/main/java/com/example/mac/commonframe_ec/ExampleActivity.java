package com.example.mac.commonframe_ec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.example.latte.activities.ProxyActivity;
import com.example.latte.app.Latte;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.main.EcBottomDelegate;
import com.example.latte.ec.sign.ISignListener;
import com.example.latte.ec.sign.SignInDelegate;
import com.example.latte_ui.launcher.ILauncherListener;
import com.example.latte_ui.launcher.OnLauncherFinishTag;

public class ExampleActivity extends ProxyActivity implements ISignListener, ILauncherListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Latte.getConfigurator().withActivity(this);
    }

    @Override
    public LatteDelegate setRootDelegate() {
        //return new ExampleDelegate();
        //return new LauncherDelegate();
        //return new SignUpDelegate();
        //return new SignInDelegate();
        return new EcBottomDelegate();
    }


    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                Toast.makeText(this, "启动结束，用户登录了", Toast.LENGTH_LONG).show();
                //getSupportDelegate().startWithPop(new EcBottomDelegate());
                getSupportDelegate().start(new EcBottomDelegate());
                break;

            case NOT_SIGNED:
                Toast.makeText(this, "启动结束，用户没登录", Toast.LENGTH_LONG).show();
                //getSupportDelegate().startWithPop(new SignInDelegate());
                getSupportDelegate().start(new SignInDelegate());
                break;

            default:
                break;
        }

    }
}
