package com.atguigu.spzx.user.service;

import com.atguigu.spzx.model.entity.user.UserAddress;

import java.util.List;

/**
 * ClassName: UserAddressService
 * Package: com.atguigu.spzx.user.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/25 23:42
 * @Version 1.0
 */


public interface UserAddressService {
//    获取用户地址列表
    List<UserAddress> findUserAddressList();

    //    根据收货地址的id获取收货地址的信息
    UserAddress getUserAddress(Long id);
}
