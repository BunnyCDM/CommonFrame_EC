package com.example.mac.commonframe_ec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.example.latte.activities.ProxyActivity;
import com.example.latte.app.Latte;
import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.main.EcBottomDelegate;
import com.example.latte.ec.sign.SignInDelegate;
import com.example.latte.ec.sign.SignUpDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

//        setContentView(R.layout.activity_main);

//        Latte.getConfigurator().withActivity(this);

    }

    @Override
    public LatteDelegate setRootDelegate() {
//        return new SignInDelegate();
        return new EcBottomDelegate();
    }


}
