package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * ClassName: SysRoleService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/3 21:47
 * @Version 1.0
 */

public interface SysRoleService {
    //删除角色

    void deleteById(Long roleId);
    //查询角色

    PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer pageNum, Integer pageSize);
    //添加角色
    void saveSysRole(SysRole sysRole);
    //修改角色

    void updateSysRole(SysRole sysRole);

}
