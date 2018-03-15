package com.example.mac.commonframe_ec;

import android.app.Application;

import com.example.latte.app.Latte;
import com.example.latte.ec.database.DatabaseManager;
import com.example.latte.ec.icon.FontEcModule;
import com.example.latte.net.interceptors.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by mac on 2017/9/16.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Latte.init(this)
                .withApiHost("http://127.0.0.1/")//回环（本机地址）
                .configure();

//        Latte.init(this)
//                .withIcon(new FontAwesomeModule())
//                .withIcon(new FontEcModule())//自定义字体
//                .withLoaderDelayed(1000)
//                .withApiHost("http://127.0.0.1/")
//                .withInterceptor(new DebugInterceptor("index",R.raw.test))
//                .withWeChatAppId("")
//                .withWeChatAppSecret("")
//                .configure();
//
//        DatabaseManager.getInstance().init(this);

    }
}
