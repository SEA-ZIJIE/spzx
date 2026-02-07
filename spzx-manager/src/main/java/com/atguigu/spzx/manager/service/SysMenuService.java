package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.entity.system.SysMenu;
import com.atguigu.spzx.model.vo.system.SysMenuVo;

import java.util.List;

/**
 * ClassName: SysMenuService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/4 15:40
 * @Version 1.0
 */


public interface SysMenuService {
    //查询菜单
    List<SysMenu> findNodes();

    //添加菜单

    void save(SysMenu sysMenu);
    //修改菜单

    void updateById(SysMenu sysMenu);
    //删除表单

    void removeById(Long id);
    //动态菜单

    List<SysMenuVo> findUserMenuList();

}
