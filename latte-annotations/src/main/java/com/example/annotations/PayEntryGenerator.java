package com.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mac on 2017/10/8.
 */

@Target(ElementType.TYPE)//仅使用在类上
@Retention(RetentionPolicy.SOURCE)//在源码处理
public @interface PayEntryGenerator {
    String packageName();

    Class<?> payEntryTemplate();
}
