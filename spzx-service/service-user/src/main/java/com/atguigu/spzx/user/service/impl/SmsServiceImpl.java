package com.atguigu.spzx.user.service.impl;

import com.atguigu.spzx.user.service.SmsService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * ClassName: SmsServiceImpl
 * Package: com.atguigu.spzx.user.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/17 22:37
 * @Version 1.0
 */

@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Override
    public void sendValidateCode(String phone) {
//        生成验证码
        String code = RandomStringUtils.randomNumeric(4);
//        把生成的验证码放到redis，设置过期时间

//        发送短信验证

    }
}
