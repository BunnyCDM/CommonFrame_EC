package com.example.latte.delegates;

/**
 * Created by mac on 2017/9/16.
 * <p>
 * 用来监听web界面加载事件的
 */

public interface IPageLoadListener {

    void onLoadStart();

    void onLoadEnd();

}
