package com.atguigu.spzx.common.interceptor;

import com.alibaba.fastjson2.JSON;
import com.atguigu.spzx.model.entity.user.UserInfo;
import com.atguigu.spzx.utils.AuthContextUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ClassName: UserLoginAuthInterceptor
 * Package: com.atguigu.spzx.common.interceptor
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/21 10:38
 * @Version 1.0
 */


public class UserLoginAuthInterceptor implements HandlerInterceptor {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String token = request.getHeader("token");
        String userJson = redisTemplate.opsForValue().get("user:spzx:" + token);
//        放到threadlocal
        AuthContextUtil.setUserInfo(JSON.parseObject(userJson, UserInfo.class));


        return true;
    }
}
