package com.example.latte.util.callback;

import android.support.annotation.Nullable;

/**
 * Created by mac on 2017/10/8.
 */

public interface IGlobalCallback<T> {
    void executeCallback(@Nullable T args);
}
