package com.example.latte.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.latte.app.Latte;

/**
 * Created by mac on 2017/9/17.
 */

public class DimenUtil {

    public static int getScreenWidth() {
        //final Resources resources = Latte.getApplication().getResources();
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        //final Resources resources = Latte.getApplication().getResources();
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
