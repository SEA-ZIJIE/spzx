package com.atguigu.spzx.user.service.impl;

import com.atguigu.spzx.user.service.SmsService;
import com.atguigu.spzx.utils.HttpUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import org.apache.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
        String code = redisTemplate.opsForValue().get(phone);
        if (StringUtils.hasText(code)) {
            return;
        }
//        生成验证码
        code = RandomStringUtils.randomNumeric(4);
//        把生成的验证码放到redis，设置过期时间
        redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
//        发送短信验证码
        sendMessage(phone,code);
    }
//发送短信验证码的方法
    private void sendMessage(String phone, String code) {
        String host = "https://send.market.alicloudapi.com";
        String path = "/sms/send";
        String method = "POST";
        String appcode = "73d8ccaf147d4343a682f35d0da6150c ";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("content", "code:" +code);
        bodys.put("templateid", "lxym_20111_sdgsfhwqgvyh");
        bodys.put("mobile", "phone");


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
