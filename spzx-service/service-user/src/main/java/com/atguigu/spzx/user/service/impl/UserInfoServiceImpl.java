package com.atguigu.spzx.user.service.impl;/**
 * ClassName: UserInfoServiceImpl
 * Package: com.atguigu.spzx.user.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/18 18:54
 * @Version 1.0
 */

import com.atguigu.spzx.model.dto.h5.UserRegisterDto;
import com.atguigu.spzx.user.service.UserInfoService;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl implements UserInfoService {
//    注册
    @Override
    public void register(UserRegisterDto userRegisterDto) {
//        userRegisterDto中获取数据

//        验证码校验
//        从redis中获取验证码
//        获取输入的验证码,进行比对
//        校验用户名不能重复
//        封装添加数据,调用方法添加数据库
//        从redis删除发送的验证码

    }
}
