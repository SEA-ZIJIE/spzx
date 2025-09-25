package com.atguigu.spzx.manager.service.impl;

import com.atguigu.spzx.manager.mapper.SysRoleMenuMapper;
import com.atguigu.spzx.manager.service.SysMenuService;
import com.atguigu.spzx.manager.service.SysRoleMenuService;
import com.atguigu.spzx.model.dto.system.AssginMenuDto;
import com.atguigu.spzx.model.dto.system.AssginRoleDto;
import com.atguigu.spzx.model.entity.system.SysMenu;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: SysRoleMenuServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/25 8:41
 * @Version 1.0
 */

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Resource
    private SysMenuService sysRoleService;

    //查询所有菜单和查询角色分配过的菜单id列表
    @Override
    public Map<String, Object> findSysRoleMenuByRoleId(Long roleId) {
        //查询所有菜单
        List<SysMenu> sysMenuList = sysRoleService.findNodes();

        //查询角色分配过的菜单id列表
        List<Long> roleMenuIds  =  sysRoleMenuMapper.findSysRoleMenuByRoleId(roleId);
        Map<String,Object> map = new HashMap<>();
        map.put("sysMenuList",sysMenuList);
        map.put("roleMenuIds",roleMenuIds);

        return map;
    }


        //分配菜单


    @Override
    public void doAssign(AssginMenuDto assginMenuDto) {

        //删除角色分配过的菜单数据
        sysRoleMenuMapper.deleteByRoleId(assginMenuDto.getRoleId());

        //保存分配的数据
        List<Map<String,Number>> menuInfo = assginMenuDto.getMenuIdList();
        if(menuInfo!=null && menuInfo.size() > 0){ //角色分配了菜单
            sysRoleMenuMapper.doAssign(assginMenuDto);
        }
    }
}
