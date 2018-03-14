package com.example.latte.wechat.templates;

import com.example.latte.wechat.BaseWXEntryActivity;
import com.example.latte.wechat.LatteWeChat;

/**
 * Created by mac on 2017/10/20.
 *
 * 模版类
 */

public class WXEntryTemplate extends BaseWXEntryActivity {


    @Override
    protected void onResume() {
        super.onResume();
        finish();

        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);

    }
}
