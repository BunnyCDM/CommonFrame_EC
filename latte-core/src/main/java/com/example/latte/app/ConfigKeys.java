package com.example.latte.app;

/**
 * Created by mac on 2017/9/11.
 * <p>
 * 关于枚举类型，在整个应用程序中唯一的单列，并且只初始化一次
 * 也就是进行多线程可以使用其，保证安全、惰性单列初始化（线程安全的懒汉模式）
 */

public enum ConfigKeys {
    API_HOST,//网络域名
    APPLICATION_CONTEXT,//全局上下文
    CONFIG_READY,//初始化是否完成
    ICON,//字体
    LOADER_DELAYED,
    INTERCEPTOR,//模拟请求
    WE_CHAT_APP_ID,
    WE_CHAT_APP_SECRET,
    ACTIVITY,
    HANDLER,
    JAVASCRIPT_INTERFACE,
    WEB_HOST
}
