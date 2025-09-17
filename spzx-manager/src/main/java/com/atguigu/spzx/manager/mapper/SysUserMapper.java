package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;

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

}
