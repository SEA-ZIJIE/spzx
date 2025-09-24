package com.atguigu.spzx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: SysRoleUserMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/23 16:02
 * @Version 1.0
 */

@Mapper
public interface SysRoleUserMapper {

    //根据用户id删除用户之前分配过的角色数据
    void deleteByUserId(Long userId);

    // 2重新分配新的数据
    void doAssign(Long userId, Long roleId);

    //根据userId查询用户分配过角色id列表
    List<Long> selectRoleIdsByUserId(Long userId);

}
