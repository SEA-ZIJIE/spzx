package com.atguigu.spzx.manager.config;

import com.atguigu.spzx.manager.interceptor.LoginAuthInterceptor;
import com.atguigu.spzx.manager.properties.UserProperties;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: WebMvcConfiguration
 * Package: com.atguigu.spzx.manager.config
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/18 21:49
 * @Version 1.0
 */

@Component
public class WebMvcConfiguration implements WebMvcConfigurer {


    @Resource
    private LoginAuthInterceptor loginAuthInterceptor;

    @Resource
    private UserProperties userProperties;
    //拦截器的注册
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginAuthInterceptor)
//                .excludePathPatterns("/admin/system/index/login",
//                        "/admin/system/index/generateValidateCode")
                .excludePathPatterns(userProperties.getNoAuthUrls())
                .addPathPatterns("/**");
    }

    //跨域解决方法
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")      // 添加路径规则
                .allowCredentials(true)               // 是否允许在跨域的情况下传递Cookie
                .allowedOriginPatterns("*")           // 允许请求来源的域规则
                .allowedMethods("*")
                .allowedHeaders("*") ;                // 允许所有的请求头
    }
}
