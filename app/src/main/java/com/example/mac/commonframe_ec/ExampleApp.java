package com.example.mac.commonframe_ec;

import android.app.Application;
import android.support.annotation.Nullable;

import com.example.latte.app.Latte;
import com.example.latte.ec.database.DatabaseManager;
import com.example.latte.ec.icon.FontEcModule;
import com.example.latte.net.interceptors.DebugInterceptor;
import com.example.latte.net.rx.AddCookieInterceptor;
import com.example.latte.util.callback.CallbackManager;
import com.example.latte.util.callback.CallbackType;
import com.example.latte.util.callback.IGlobalCallback;
import com.example.mac.commonframe_ec.event.ShareEvent;
import com.example.mac.commonframe_ec.event.TestEvent;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by mac on 2017/9/16.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        Latte.init(this)
//                .withApiHost("http://127.0.0.1/")//回环（本机地址）
//                .configure();

        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())//自定义字体
                .withLoaderDelayed(1000)
                .withApiHost("http://192.168.31.80.8080/RestServer/api/")//回环（本机地址）：http://127.0.0.1/
                .withInterceptor(new DebugInterceptor("test", R.raw.test))//index
                .withWeChatAppId("")
                .withWeChatAppSecret("")
                .withJavascriptInterface("latte")
                .withWebEvent("test", new TestEvent())
                .withWebEvent("share", new ShareEvent())
                //添加Cookie同步拦截器
                .withWebHost("https://www.baidu.com/")
                .withInterceptor(new AddCookieInterceptor())
                .configure();

        DatabaseManager.getInstance().init(this);


        //开启极光推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        CallbackManager.getInstance()
                .addCallback(CallbackType.TAG_OPEN_PUSH, new IGlobalCallback() {
                    @Override
                    public void executeCallback(@Nullable Object args) {
                        if (JPushInterface.isPushStopped(Latte.getApplicationContext())) {
                            //开启极光推送
                            JPushInterface.setDebugMode(true);
                            JPushInterface.init(Latte.getApplicationContext());
                        }
                    }
                })
                .addCallback(CallbackType.TAG_STOP_PUSH, new IGlobalCallback() {
                    @Override
                    public void executeCallback(@Nullable Object args) {
                        if (!JPushInterface.isPushStopped(Latte.getApplicationContext())) {
                            JPushInterface.stopPush(Latte.getApplicationContext());
                        }
                    }
                });


    }
}
