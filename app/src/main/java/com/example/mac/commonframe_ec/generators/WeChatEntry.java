package com.example.mac.commonframe_ec.generators;

import com.example.annotations.EntryGenerator;
import com.example.latte.wechat.templates.WXEntryTemplate;

/**
 * Created by mac on 2017/10/8.
 * <p>
 * 把注解写进去
 */

@EntryGenerator(
        packageName = "com.example.mac.commonframe_ec",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
