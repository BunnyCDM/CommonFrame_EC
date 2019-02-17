package com.example.latte.delegates.web.chromeclient;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by mac on 2017/9/16.
 * <p>
 * 有关webview内部一些控制
 */

public class WebChromeClientImpl extends WebChromeClient {

    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {//拦截Alert，暂不做任何处理
        return super.onJsAlert(view, url, message, result);
    }
}
