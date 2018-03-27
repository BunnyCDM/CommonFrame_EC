package com.example.latte.delegates;

import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * Created by mac on 2017/9/16.
 * <p>
 * 中间层，权限判断，基于android6.0以后动态判定
 */


public abstract class PermissionCheckerDelegate extends BaseDelegate {

    public void startCameraWithCheck() {

    }

    public void startScanWithCheck(BaseDelegate delegate) {

    }

    private void showRationaleDialog() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                default:
                    break;
            }
        }
    }
}
