package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.dto.system.AssginRoleDto;
import com.atguigu.spzx.model.dto.system.LoginDto;
import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysUser;
import com.atguigu.spzx.model.vo.system.LoginVo;
import com.github.pagehelper.PageInfo;

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

    //获取当前登录用户信息
    SysUser getUserInfo(String token);

    //用户退出
    void logout(String token);

    //1 用户条件分页查询接口
    PageInfo<SysUser> findByPage(Integer pageNum, Integer pageSize, SysRoleDto sysUserDto);

    //2 用户的添加
    void saveSysUser(SysUser sysUser);

    //3 用户的修改

    void updateSysUser(SysUser sysUser);

      //4 用户的删除
    void deleteById(long userId);

    //用户分配角色
    void doAssign(AssginRoleDto assginRoleDto);

}
