package com.atguigu.spzx.user.service;

import com.atguigu.spzx.model.dto.h5.UserLoginDto;
import com.atguigu.spzx.model.dto.h5.UserRegisterDto;
import com.atguigu.spzx.model.vo.h5.UserInfoVo;

/**
 * ClassName: UserInfoService
 * Package: com.atguigu.spzx.user.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/18 18:54
 * @Version 1.0
 */


public interface UserInfoService {

//    注册
    void register(UserRegisterDto userRegisterDto);

//    登录
    String login(UserLoginDto userLoginDto);
//    获取当前登录用户信息
    UserInfoVo getCurrentUserInfo(String token);
}
