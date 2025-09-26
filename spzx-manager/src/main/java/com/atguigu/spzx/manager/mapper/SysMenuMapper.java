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
 * @Create 2025/9/24 15:31
 * @Version 1.0
 */

@Mapper
public interface SysMenuMapper {


    //查询所有菜单，返回 list集合
    List<SysMenu> findAll();

    //菜单添加
    void save(SysMenu sysMenu);

    //菜单修改
    void update(SysMenu sysMenu);

    //根据当前菜单id，查询是否包含子菜单
    int selectCountById(Long id);

    //count等于0，直接删除
    void delete(Long id);


    //查询用户可以操作的菜单
    List<SysMenu> findMenuByUserId(Long userId);

    //新添加子菜单，把父菜单isHalf改为半开状态1
    SysMenu selectParentMenu(Long parentId);
}
