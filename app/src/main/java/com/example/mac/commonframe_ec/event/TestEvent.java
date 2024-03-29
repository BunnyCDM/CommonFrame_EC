package com.example.mac.commonframe_ec.event;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.latte.delegates.web.event.Event;

/**
 * Created by mac on 2017/10/8.
 *
 * 测试js使用
 */

public class TestEvent extends Event {
    @Override
        public String execute(String params) {
        Toast.makeText(getContext(), getAction(), Toast.LENGTH_LONG).show();
        if (getAction().equals("test")) {
            final WebView webView = getWebView();
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.evaluateJavascript("nativeCall();", new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            Toast.makeText(getContext(), value, Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });
        }
        return null;
    }
}
