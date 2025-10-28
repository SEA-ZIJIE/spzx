package com.atguigu.spzx.user.service.impl;/**
 * ClassName: UserAddressServiceImpl
 * Package: com.atguigu.spzx.user.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/25 23:44
 * @Version 1.0
 */

import com.atguigu.spzx.model.entity.user.UserAddress;
import com.atguigu.spzx.user.mapper.UserAddressMapper;
import com.atguigu.spzx.user.service.UserAddressService;
import com.atguigu.spzx.utils.AuthContextUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Resource
    private UserAddressMapper userAddressMapper;

    //    获取用户地址列表
    @Override
    public List<UserAddress> findUserAddressList() {

        Long userId = AuthContextUtil.getUserInfo().getId();


        return userAddressMapper.findUserAddressList(userId);
    }

    //    根据收货地址的id获取收货地址的信息
    @Override
    public UserAddress getUserAddress(Long id) {

        return userAddressMapper.getUserAddress(id);
    }
}
