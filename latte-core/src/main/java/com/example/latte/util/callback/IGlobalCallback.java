package com.example.latte.util.callback;

import android.support.annotation.Nullable;

/**
 * Created by mac on 2017/10/8.
 *
 * 高级泛型接口，比较安全，对程序健壮性较好
 */

public interface IGlobalCallback<T> {

    void executeCallback(@Nullable T args);

}
