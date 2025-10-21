package com.atguigu.spzx.common.anno;

import com.atguigu.spzx.common.config.UserWebMvcConfiguration;
import com.atguigu.spzx.common.interceptor.UserLoginAuthInterceptor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: EnableUserLoginAuthInterceptor
 * Package: com.atguigu.spzx.common.anno
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/21 12:22
 * @Version 1.0
 */

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Import(value = {UserLoginAuthInterceptor.class, UserWebMvcConfiguration.class})
public @interface EnableUserLoginAuthInterceptor {
}
