package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * ClassName: SysRoleService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/20 16:55
 * @Version 1.0
 */


public interface SysRoleService {


    //角色列表方法
    PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer current, Integer limit);

    //角色添加方法
    void saveSysRole(SysRole sysRole);

    //角色修改的方法
    void updateSysRole(SysRole sysRole);

    //角色删除的方法
    void deleteById(Long roleId);

    //查询所有角色
    Map<String, Object> findAll();


}
