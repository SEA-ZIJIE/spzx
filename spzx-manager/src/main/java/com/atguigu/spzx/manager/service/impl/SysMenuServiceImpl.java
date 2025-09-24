package com.atguigu.spzx.manager.service.impl;/**
 * ClassName: SysMenuServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/24 15:30
 * @Version 1.0
 */

import com.atguigu.spzx.manager.mapper.SysMenuMapper;
import com.atguigu.spzx.manager.service.SysMenuService;
import com.atguigu.spzx.manager.utils.MenuHelper;
import com.atguigu.spzx.model.entity.system.SysMenu;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {


@Resource
private SysMenuMapper  sysMenuMapper;
    //菜单列表

    @Override
    public List<SysMenu> findNodes() {
        //查询所有菜单，返回 list集合
        List<SysMenu> sysMenuList =  sysMenuMapper.findAll();
        if(CollectionUtils.isEmpty(sysMenuList)) {
            return null;
        }

        // 调用工具类的方法，返回list集合封装要求数据格式
            List<SysMenu> treeList = MenuHelper.buildTree(sysMenuList);


        return treeList;
    }
}
