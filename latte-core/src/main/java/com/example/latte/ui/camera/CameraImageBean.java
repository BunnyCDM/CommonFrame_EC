package com.example.latte.ui.camera;

import android.net.Uri;

/**
 * Created by mac on 2017/9/16.
 * <p>
 * 存储一些中间值
 */

public final class CameraImageBean {
    private Uri mPath = null;

    private static final CameraImageBean INSTANCE = new CameraImageBean();

    public static CameraImageBean getInstance(){
        return INSTANCE;
    }

    public Uri getPath() {
        return mPath;
    }

    public void setPath(Uri mPath) {
        this.mPath = mPath;
    }
}
