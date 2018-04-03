package com.example.latte.util.log;

import com.orhanobut.logger.Logger;

/**
 * Created by mac on 2017/10/8.
 * <p>
 * 日志管理
 */

public class LatteLogger {

    private static final String TAG=LatteLogger.class.getSimpleName();
    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;
    private static final int NOTHING = 6;
    private static final int ASSERT = 7;

    private static int LEVEL = VERBOSE;//控制log等级

    public static void v(String tag, String message) {
        if (LEVEL <= VERBOSE) {
            Logger.t(tag).v(message);
        }
    }

    public static void d(String tag, Object message) {
        if (LEVEL <= DEBUG) {
            Logger.t(tag).d(message);
        }
    }

    public static void d(Object message) {
        if (LEVEL <= DEBUG) {
            Logger.d(TAG,message);
        }
    }

    public static void i(String tag, String message) {
        if (LEVEL <= INFO) {
            Logger.t(tag).i(message);
        }
    }

    public static void json(String tag, String message) {
        if (LEVEL <= WARN) {
            Logger.t(tag).json(message);
        }
    }

    public static void w(String tag, String message) {
        if (LEVEL <= WARN) {
            Logger.t(tag).w(message);
        }
    }

    public static void e(String tag, String message) {
        if (LEVEL <= ERROR) {
            Logger.t(tag).e(message);
        }
    }

    public static void e(String message) {
        if (LEVEL <= ERROR) {
            Logger.e(TAG,message);
        }
    }

}
