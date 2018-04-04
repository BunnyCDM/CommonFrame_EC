package com.example.latte.ui.camera;

import android.net.Uri;

import com.example.latte.delegates.PermissionCheckerDelegate;
import com.example.latte.util.file.FileUtil;

/**
 * Created by mac on 2017/9/16.
 * <p>
 * 照片调用类
 */

public class LatteCamera {

    public static Uri createCropFile() {
        return Uri.parse
                (FileUtil.createFile("crop_image",
                        FileUtil.getFileNameByTime("IMG", "jpg")).getPath());
    }

    public static void start(PermissionCheckerDelegate delegate) {
        new CameraHandler(delegate).beginCameraDialog();
    }

}
