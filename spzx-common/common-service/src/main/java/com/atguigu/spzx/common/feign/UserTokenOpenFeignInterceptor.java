package com.atguigu.spzx.common.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.Servlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * ClassName: UserTokenOpenFeignInterceptor
 * Package: com.atguigu.spzx.common.feign
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/27 9:21
 * @Version 1.0
 */

//创建拦截器的类
public class UserTokenOpenFeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = requestAttributes.getRequest();
        String token = request.getHeader("token");

        requestTemplate.header("token",token);

    }
}
