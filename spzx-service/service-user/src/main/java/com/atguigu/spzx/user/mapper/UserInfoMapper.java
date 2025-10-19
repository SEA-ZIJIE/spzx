package com.atguigu.spzx.user.mapper;

import com.atguigu.spzx.model.entity.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: UserInfoMapper
 * Package: com.atguigu.spzx.user.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/19 14:19
 * @Version 1.0
 */

@Mapper
public interface UserInfoMapper {
//    校验用户不能重复
    UserInfo selectByUsername(String username);

//    注册
    void save(UserInfo userInfo);

}
