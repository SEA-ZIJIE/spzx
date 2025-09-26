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
 * @Create 2025/9/24 15:30
 * @Version 1.0
 */


public interface SysMenuService {
    //菜单列表
    List<SysMenu> findNodes();
    //菜单添加
    void save(SysMenu sysMenu);
    //菜单修改
    void update(SysMenu sysMenu);
    //菜单的删除
    void removeById(Long id);
    //查询用户可以操作的菜单
    List<SysMenuVo> findMenuByUserId();
}
