package com.example.latte_ui.banner;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Created by mac on 2017/10/12.
 */

public class HolderCreator implements CBViewHolderCreator<ImageHolder> {

    @Override
    public ImageHolder createHolder() {
        return new ImageHolder();
    }

}