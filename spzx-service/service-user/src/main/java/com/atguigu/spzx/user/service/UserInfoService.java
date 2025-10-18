package com.atguigu.spzx.user.service;

import com.atguigu.spzx.model.dto.h5.UserRegisterDto;

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

}
