package com.example.mac.commonframe_ec.generators;

import com.example.annotations.AppRegisterGenerator;
import com.example.latte.wechat.templates.AppRegisterTemplate;

/**
 * Created by mac on 2017/10/8.
 *
 * 把注解写进去
 */


@AppRegisterGenerator(
        packageName = "com.example.mac.commonframe_ec",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
