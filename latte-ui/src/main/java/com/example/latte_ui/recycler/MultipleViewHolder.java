package com.example.latte_ui.recycler;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by mac on 2017/10/12.
 * <p>
 * 方便以后处理
 */

public class MultipleViewHolder extends BaseViewHolder {

    private MultipleViewHolder(View view) {
        super(view);
    }

    //简单工厂方法包装一下
    public static MultipleViewHolder create(View view) {
        return new MultipleViewHolder(view);
    }

}