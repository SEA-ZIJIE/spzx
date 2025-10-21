package com.atguigu.spzx.cart.service.impl;

import com.atguigu.spzx.cart.service.CartService;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: CartServiceImpl
 * Package: com.atguigu.spzx.cart.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/21 23:29
 * @Version 1.0
 */

@Service
public class CartServiceImpl implements CartService {

//添加购物车
    @Override
    public void addToCart(Long skuId, Integer skuNum) {
//        必须登录状态，获取用户id（作为hash类的key值）
//        从ThreadLocal获取用户信息






    }
}
