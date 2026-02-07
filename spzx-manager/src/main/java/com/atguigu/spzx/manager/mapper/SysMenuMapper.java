package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.system.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: SysMenuMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/4 19:45
 * @Version 1.0
 */

@Mapper
public interface SysMenuMapper {
    //查询菜单

    List<SysMenu> selectAll();
    //添加菜单

    void insert(SysMenu sysMenu);
    //修改菜单

    void updateById(SysMenu sysMenu);

    //删除表单

    int countByParentId(Long id);

    void deleteById(Long id);
//动态菜单

    List<SysMenu> selectListByUserId(Long userId);

    SysMenu selectById(Long parentId);
}
