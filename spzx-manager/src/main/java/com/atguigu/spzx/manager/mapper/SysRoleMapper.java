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
}
