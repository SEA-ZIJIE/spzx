package com.atguigu.spzx.common.config;

import com.atguigu.spzx.common.interceptor.UserLoginAuthInterceptor;
import jakarta.annotation.Resource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: UserWebMvcConfiguration
 * Package: com.atguigu.spzx.common.config
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/21 12:18
 * @Version 1.0
 */


public class UserWebMvcConfiguration implements WebMvcConfigurer {

    @Resource
    private UserLoginAuthInterceptor userLoginAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(userLoginAuthInterceptor)
                .addPathPatterns("/api/**");

    }

    }
