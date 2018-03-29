package com.example.latte.delegates.web.client;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.latte.app.ConfigKeys;
import com.example.latte.app.Latte;
import com.example.latte.delegates.IPageLoadListener;
import com.example.latte.delegates.web.WebDelegate;
import com.example.latte.delegates.web.route.Router;
import com.example.latte.ui.loader.LatteLoader;
import com.example.latte.util.log.LatteLogger;
import com.example.latte.util.storage.LattePreference;

/**
 * Created by mac on 2017/9/16.
 */

public class WebViewClientImpl extends WebViewClient {

    private final WebDelegate DELEGATE;
    private IPageLoadListener mIPageLoadListener = null;
    private static final Handler HANDLER = Latte.getHandler();//延迟

    public void setPageLoadListener(IPageLoadListener listener) {
        this.mIPageLoadListener = listener;
    }

    public WebViewClientImpl(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {//最好用这个，因为一般机型还没达到要求
        LatteLogger.d("shouldOverrideUrlLoading", url);
        return Router.getInstance().handleWebUrl(DELEGATE, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadStart();
        }
        LatteLoader.showLoading(view.getContext());
    }

    //获取浏览器cookie
    private void syncCookie() {
        final CookieManager manager = CookieManager.getInstance();
        /*
          注意，这里的Cookie和API请求的Cookie是不一样的，这个在网页不可见
         */
        final String webHost = Latte.getConfiguration(ConfigKeys.WEB_HOST);
        if (webHost != null) {
            if (manager.hasCookies()) {
                final String cookieStr = manager.getCookie(webHost);
                if (cookieStr != null && !cookieStr.equals("")) {
                    LattePreference.addCustomAppProfile("cookie", cookieStr);
                }
            }
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        syncCookie();
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadEnd();
        }
        HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                LatteLoader.stopLoading();
            }
        }, 1000);
    }

}
