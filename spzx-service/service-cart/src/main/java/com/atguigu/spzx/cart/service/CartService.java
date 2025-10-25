package com.atguigu.spzx.cart.service;

import com.atguigu.spzx.model.entity.h5.CartInfo;

import java.util.List;

/**
 * ClassName: CartService
 * Package: com.atguigu.spzx.cart.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/21 23:29
 * @Version 1.0
 */


public interface CartService {
//    增加购物车
    void addToCart(Long skuId, Integer skuNum);

//    查询购物车
    List<CartInfo> getCartList();
//删除购物车
    void deleteCart(Long skuId);
//    更新购物车商品选中状态
void CheckCart(Long skuId, Integer isChecked);
//    更新购物车商品全部选中状态
    void allCheckCart(Long skuId, Integer isChecked);
//    清空购物车
    void clearCart();
}
