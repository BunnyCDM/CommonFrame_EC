package com.example.latte.delegates.web;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by mac on 2017/9/16.
 * <p>
 * 需要初始化web的接口
 */

public interface IWebViewInitializer {

    WebView initWebView(WebView webView);

    WebViewClient initWebViewClient();//针对浏览器本身

    WebChromeClient initWebChromeClient();//针对页面本身

}
