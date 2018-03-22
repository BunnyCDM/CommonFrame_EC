package com.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mac on 2017/10/8.
 * <p>
 * 用来传入包名以及微信模版代码，也就是绕过微信限制，在编译期间处理的
 */

@Target(ElementType.TYPE)//仅使用到类上
@Retention(RetentionPolicy.SOURCE)//在源码处理

public @interface EntryGenerator {

    String packageName();

    Class<?> entryTemplate();

}
