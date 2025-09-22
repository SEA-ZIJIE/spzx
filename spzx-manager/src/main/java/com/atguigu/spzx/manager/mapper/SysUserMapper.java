package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: SysUserMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/17 15:52
 * @Version 1.0
 */

@Mapper
public interface SysUserMapper {

    //根据用户名查询数据库表sys_user表
    SysUser selectUserInfoByUserName(String userName);

    //1 用户条件分页查询接口

    List<SysUser> findByPage(SysRoleDto sysUserDto);

    //2 用户的添加
    void save(SysUser sysUser);

    //3 用户的修改

    void update(SysUser sysUser);

    //用户的删除
    void delete(long userId);

}
