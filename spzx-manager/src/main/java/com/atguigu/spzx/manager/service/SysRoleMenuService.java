package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.dto.system.AssginMenuDto;
import com.atguigu.spzx.model.dto.system.AssginRoleDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * ClassName: SysRoleMenuService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/25 10:06
 * @Version 1.0
 */

public interface SysRoleMenuService {


    //查询所有菜单和查询角色分配过的菜单id列表
    Map<String, Object> findSysRoleMenuByRoleId(Long roleId);


    //分配菜单
    void doAssign(AssginMenuDto assginnMenuDto);
}
