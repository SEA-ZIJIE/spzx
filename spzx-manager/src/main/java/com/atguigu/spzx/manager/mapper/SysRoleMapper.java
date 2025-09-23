package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: SysRoleMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/20 16:56
 * @Version 1.0
 */

@Mapper
public interface SysRoleMapper {

    //角色列表的方法
    List<SysRole> findByPage(SysRoleDto sysRoleDto);

    //角色添加的方法
    void save(SysRole sysRole);

    //角色修改的方法
    void update(SysRole sysRole);

    //角色删除的方法
    void delete(Long roleId);

    //查询所有角色
    List<SysRole> findAll();

}
