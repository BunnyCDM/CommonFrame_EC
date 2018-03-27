package com.example.latte_ui.recycler;

import android.support.annotation.ColorInt;

import com.choices.divider.DividerItemDecoration;

/**
 * Created by mac on 2017/10/12.
 *
 * 用于分割线
 */

public class BaseDecoration extends DividerItemDecoration {

    //值做出限制，@ColorInt，仅出入int值
    private BaseDecoration(@ColorInt int color, int size) {
        setDividerLookup(new DividerLookupImpl(color, size));
    }

    //简单工厂模式
    public static BaseDecoration create(@ColorInt int color, int size) {
        return new BaseDecoration(color, size);
    }
}

