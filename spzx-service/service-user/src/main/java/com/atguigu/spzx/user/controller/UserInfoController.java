package com.atguigu.spzx.user.controller;

import com.atguigu.spzx.model.dto.h5.UserRegisterDto;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.user.service.UserInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserInfoController
 * Package: com.atguigu.spzx.user.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/18 18:54
 * @Version 1.0
 */

@RestController
@RequestMapping("api/user/userInfo")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;
    @PostMapping("register")
    public Result<Void> register(@RequestBody UserRegisterDto userRegisterDto){
        userInfoService.register(userRegisterDto);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
}
