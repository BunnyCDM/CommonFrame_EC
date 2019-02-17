package com.example.latte.delegates.web.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.webkit.URLUtil;
import android.webkit.WebView;

import com.example.latte.delegates.LatteDelegate;
import com.example.latte.delegates.web.WebDelegate;
import com.example.latte.delegates.web.WebDelegateImpl;

/**
 * Created by mac on 2017/9/16.
 * <p>
 * 路由者
 */

public class Router {

    private Router() {
    }

    private static class Holder {
        private static final Router INSTANCE = new Router();
    }

    //线程安全的惰性单列
    public static Router getInstance() {
        return Holder.INSTANCE;
    }

    //处理url的方法
    public final boolean handleWebUrl(WebDelegate delegate, String url) {

        //如果是电话协议
        if (url.contains("tel:")) {
            callPhone(delegate.getContext(), url);
            return true;
        }

        final LatteDelegate topDelegate = delegate.getTopDelegate();
        final WebDelegateImpl webDelegate = WebDelegateImpl.create(url);
        topDelegate.getSupportDelegate().start(webDelegate);

//        final LatteDelegate parentDelegate = delegate.getTopDelegate();
//        final WebDelegateImpl webDelegate = WebDelegateImpl.create(url);
//        if (parentDelegate==null){
//            delegate.getSupportDelegate().start(delegate);
//        }else {
//            parentDelegate.getSupportDelegate().start(webDelegate);
//        }


        return true;
    }

    private void loadWebPage(WebView webView, String url) { //web页面的load
        if (webView != null) {
            webView.loadUrl(url);//webview渲染
        } else {
            throw new NullPointerException("WebView is null!");
        }
    }

    private void loadLocalPage(WebView webView, String url) { //本地页面的load
        loadWebPage(webView, "file:///android_asset/" + url);
    }

    private void loadPage(WebView webView, String url) { //共有方法
        if (URLUtil.isNetworkUrl(url) || URLUtil.isAssetUrl(url)) {
            loadWebPage(webView, url);
        } else {
            loadLocalPage(webView, url);
        }
    }

    public final void loadPage(WebDelegate delegate, String url) {
        loadPage(delegate.getWebView(), url);
    }

    private void callPhone(Context context, String uri) {
        final Intent intent = new Intent(Intent.ACTION_DIAL);//提醒用户要不要打电话
        final Uri data = Uri.parse(uri);
        intent.setData(data);
        ContextCompat.startActivity(context, intent, null);//使用这种方式比较谨慎点
    }

}
