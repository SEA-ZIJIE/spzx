package com.atguigu.spzx.user.service;/**
 * ClassName: SmsService
 * Package: com.atguigu.spzx.user.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/17 22:37
 * @Version 1.0
 */


public interface SmsService {

    void sendValidateCode(String phone);
}
