package com.example.latte.app;

import android.content.Context;
import android.os.Handler;

import java.util.HashMap;

/**
 * Created by mac on 2017/9/11.
 * <p>
 * 因为对外工具类所以都是静态static
 */

public final class Latte {

    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getLatteConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }

    public static Handler getHandler() {
        return getConfiguration(ConfigKeys.HANDLER);
    }

    public static void test() {
    }

//        public static Context getApplication() {
//        return (Context) getConfigurations().get(ConfigKeys.APPLICATION_CONTEXT);
//    }

//    public static HashMap<Object, Object> getConfigurations() {
//        return Configurator.getInstance().getLatteConfigs();
//    }
}
