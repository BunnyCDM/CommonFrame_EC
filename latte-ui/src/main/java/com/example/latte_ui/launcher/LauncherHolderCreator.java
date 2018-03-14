package com.example.latte_ui.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Created by mac on 2017/10/12.
 */

public class LauncherHolderCreator implements CBViewHolderCreator<LauncherHolder>{


    @Override
    public LauncherHolder createHolder() {
        return new LauncherHolder();
    }
}
