package com.example.latte.delegates;

/**
 * Created by mac on 2017/9/16.
 * <p>
 * 今后正式使用的delegate
 */

public abstract class LatteDelegate extends PermissionCheckerDelegate {

    @SuppressWarnings("unchecked")
    public <T extends LatteDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }

}
