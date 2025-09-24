package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.entity.system.SysMenu;

import java.util.List;

/**
 * ClassName: SysMenuService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/24 15:30
 * @Version 1.0
 */


public interface SysMenuService {
    //菜单列表
    List<SysMenu> findNodes();

}
