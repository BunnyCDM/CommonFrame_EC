package com.example.latte_ui.dimen;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by mac on 2017/10/12.
 */

public class ScreenUtils {

    public static int getScreenWidth(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }
}
