package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.dto.system.LoginDto;
import com.atguigu.spzx.model.vo.system.LoginVo;

/**
 * ClassName: SysUserService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/17 15:45
 * @Version 1.0
 */


public interface SysUserService {

    //用户登录
    LoginVo login(LoginDto loginDto);
}
