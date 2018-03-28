package com.example.latte.delegates.web;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by mac on 2017/9/16.
 * <p>
 * 承载web页面的核心
 */

public class WebDelegateImpl extends WebDelegate {


    @Override
    public WebView initWebView(WebView webView) {
        return null;
    }

    @Override
    public WebViewClient initWebViewClient() {
        return null;
    }

    @Override
    public WebChromeClient initWebChromeClient() {
        return null;
    }

    @Override
    public IWebViewInitializer setInitializer() {
        return null;
    }

    @Override
    public Object setLayout() {
        return null;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
