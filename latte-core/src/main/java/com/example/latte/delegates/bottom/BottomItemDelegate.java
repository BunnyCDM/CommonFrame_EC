package com.example.latte.delegates.bottom;

import android.widget.Toast;

import com.example.latte.R;
import com.example.latte.app.Latte;
import com.example.latte.delegates.LatteDelegate;

/**
 * Created by mac on 2017/9/16.
 *
 * 每一个fragment的基类
 */

public abstract class BottomItemDelegate extends LatteDelegate {

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, "双击退出" + Latte.getApplicationContext().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}
