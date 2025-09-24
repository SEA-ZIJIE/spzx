package com.atguigu.spzx.manager.utils;

import com.atguigu.spzx.model.entity.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MenuHelper
 * Package: com.atguigu.spzx.manager.utils
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/24 16:46
 * @Version 1.0
 */

//封装树形菜单的数据
public class MenuHelper {

    //递归实现封装的过程

    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList){
//创建一个list集合，用于封装最终的数据
        List<SysMenu> trees = new ArrayList<>();
        //遍历所有菜单的集合
        for (SysMenu sysMenu : sysMenuList) {
            //找到递归操作的入口
            //parent_id=0
            if(sysMenu.getParentId().longValue() == 0){
                //根据第一层，找下层数据
                //找方法实现找下层
                // 方法传递两个参数第一个参数是当前第一层菜单，第二个参数是所有菜单集合

                trees.add(findChildren(sysMenu,sysMenuList));
            }

        }
        // 完成封装过程

        return trees;

    }
    //递归查找下层是数据
    private static SysMenu findChildren(SysMenu sysMenu, List<SysMenu> sysMenuList) {
        //SysMenu有属性private list<SysMenu>;封装下一层数据
        sysMenu.setChildren(new ArrayList<>());
        for (SysMenu it : sysMenuList) {
            //判断id和parentid是否相同
            if (sysMenu.getId().longValue() == it.getParentId().longValue()) {
                //it为下层数据，进行封装
                sysMenu.getChildren().add(findChildren(it, sysMenuList));
            }
        }
        return sysMenu;
    }
}
