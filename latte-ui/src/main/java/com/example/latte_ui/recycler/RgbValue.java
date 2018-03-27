package com.example.latte_ui.recycler;

import com.google.auto.value.AutoValue;

/**
 * Created by mac on 2017/10/12.
 * <p>
 * 用于存储红、绿、蓝颜色值的
 *
 * 定义成抽象类，是因为我想使用google的AutoValue
 */

@AutoValue
public abstract class RgbValue {
    public abstract int red();

    public abstract int green();

    public abstract int blue();

    public static RgbValue create(int red, int green, int blue) {
        return new AutoValue_RgbValue(red, green, blue);
    }
}
