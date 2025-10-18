package com.atguigu.spzx.user.controller;

import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.user.service.SmsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: SmsController
 * Package: com.atguigu.spzx.user.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/17 22:33
 * @Version 1.0
 */

@RestController
@RequestMapping("/api/user/sms")
public class SmsController {
@Resource
    private SmsService smsService;
    @GetMapping(value = "/sendCode/{phone}")
    public Result<Void> sendCode(@PathVariable String phone) {
        smsService.sendValidateCode(phone);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

}
