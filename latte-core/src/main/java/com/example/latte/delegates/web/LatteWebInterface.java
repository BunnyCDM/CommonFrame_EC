package com.example.latte.delegates.web;

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.example.latte.delegates.web.event.Event;
import com.example.latte.delegates.web.event.EventManager;
import com.example.latte.util.log.LatteLogger;

/**
 * Created by mac on 2017/9/16.
 * <p>
 * 和原生进行交互的
 */

public final class LatteWebInterface {

    private final WebDelegate DELEGATE;

    private LatteWebInterface(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    //使用简单工厂方法
    static LatteWebInterface create(WebDelegate delegate) {
        return new LatteWebInterface(delegate);
    }

    @SuppressWarnings("unused")
    @JavascriptInterface //该注解必须添加
    public String event(String params) {//js默认返回的地方
        final String action = JSON.parseObject(params).getString("action");
        final Event event = EventManager.getInstance().createEvent(action);
        LatteLogger.d("WEB_EVENT", params);
        if (event != null) {
            event.setAction(action);
            event.setDelegate(DELEGATE);
            event.setContext(DELEGATE.getContext());
            event.setUrl(DELEGATE.getUrl());
            return event.execute(params);
        }
        return null;
    }

}
