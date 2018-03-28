package com.example.latte.delegates.web;

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.example.latte.delegates.web.event.Event;
import com.example.latte.delegates.web.event.EventManager;

/**
 * Created by mac on 2017/9/16.
 *
 * 和原生进行交互的
 */

public final class LatteWebInterface {

    private final WebDelegate DELEGATE;

    private LatteWebInterface(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    static LatteWebInterface create(WebDelegate delegate) {
        return new LatteWebInterface(delegate);
    }

    @SuppressWarnings("unused")
    @JavascriptInterface
    public String event(String params) {//js默认返回的地方
        final String action = JSON.parseObject(params).getString("action");
//        final Event event = EventManager.getInstance().createEvent(action);
//        LatteLogger.d("WEB_EVENT",params);
//        if (event != null) {
//            event.setAction(action);
//            event.setDelegate(DELEGATE);
//            event.setContext(DELEGATE.getContext());
//            event.setUrl(DELEGATE.getUrl());
//            return event.execute(params);
//        }
        return null;
    }

}
