package com.example.mac.commonframe_ec.generators;

import com.example.annotations.PayEntryGenerator;
import com.example.latte.wechat.templates.WXPayEntryTemplate;

/**
 * Created by mac on 2017/10/8.
 * <p>
 * 把注解写进去
 */

@PayEntryGenerator(
        packageName = "com.example.mac.commonframe_ec",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
