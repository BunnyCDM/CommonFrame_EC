package com.example.latte.delegates.bottom;

import java.util.LinkedHashMap;

/**
 * Created by mac on 2017/9/16.
 * <p>
 * 构造器，创造者把BottomItemDelegate和BottomTabBean连个类结合起来
 */

public final class ItemBuilder {

    //有序序列
    private final LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();

    static ItemBuilder builder() {
        return new ItemBuilder();
    }//简单工厂模式

    public final ItemBuilder addItem(BottomTabBean bean, BottomItemDelegate delegate) {
        ITEMS.put(bean, delegate);
        return this;
    }

    public final ItemBuilder addItems(LinkedHashMap<BottomTabBean, BottomItemDelegate> items) {
        ITEMS.putAll(items);
        return this;//链式调用
    }

    public final LinkedHashMap<BottomTabBean, BottomItemDelegate> build() {
        return ITEMS;
    }

}
