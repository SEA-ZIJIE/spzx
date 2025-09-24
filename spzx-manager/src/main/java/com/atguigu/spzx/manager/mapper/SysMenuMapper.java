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



}
