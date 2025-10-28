package com.atguigu.spzx.user.mapper;

import com.atguigu.spzx.model.entity.user.UserAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: UserAddressMapper
 * Package: com.atguigu.spzx.user.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/25 23:43
 * @Version 1.0
 */

@Mapper
public interface UserAddressMapper {
    //    获取用户地址列表
    List<UserAddress> findUserAddressList(Long userId);

    //    根据收货地址的id获取收货地址的信息
    UserAddress getUserAddress(Long id);
}
