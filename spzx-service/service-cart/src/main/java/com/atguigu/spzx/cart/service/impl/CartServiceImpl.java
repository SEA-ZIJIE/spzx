package com.atguigu.spzx.cart.service.impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.spzx.cart.service.CartService;
import com.atguigu.spzx.feign.product.ProductFeignClient;
import com.atguigu.spzx.model.entity.h5.CartInfo;
import com.atguigu.spzx.model.entity.product.ProductSku;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.utils.AuthContextUtil;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private RedisTemplate<String,String> redisTemplate;
    @Resource
    private ProductFeignClient productFeignClient;

    private String getCartKey(Long userId) {
        return "user:cart:" + userId;
    }
//添加购物车
    @Override
    public void addToCart(Long skuId, Integer skuNum) {
//必须登录状态，获取用户id（作为hash类的key值）
//从ThreadLocal获取用户信息

        Long userId = AuthContextUtil.getUserInfo().getId();

//        构建hash类型key名称
        String cartKey = this.getCartKey(userId);

//购物车放到redis里面
//从redis里面获取购物号车数据，根据用户id+skuId获取
        Object cartInfoObj =
                redisTemplate.opsForHash().get(cartKey, String.valueOf(skuId));

//如果购物车存在添加商品，把商品数量相加
        CartInfo cartInfo = null;
        if(cartInfoObj!=null){
//            cartInfo --> CartInfo
            cartInfo = JSON.parseObject(cartInfoObj.toString(),CartInfo.class);
//            数量相加
            cartInfo.setSkuNum(cartInfo.getSkuNum()+skuNum);
//            购物车商品选中状态
            cartInfo.setIsChecked(1);
            cartInfo.setUpdateTime(new Date());
        }else {
//如果购物车没有添加商品，直接把商品添加到购物车中（redis）
//远程调用实现，通过nacos+openfeign实现，根据skuid获取商品sku信息
        cartInfo = new CartInfo();

        //TODO 远程调用的实现：根据skuId获取商品sku信息
            ProductSku productSku = productFeignClient.getBySkuId(skuId);
//            设置相关的数据到cartInfo里面
            cartInfo.setCartPrice(productSku.getSalePrice());
            cartInfo.setSkuNum(skuNum);
            cartInfo.setSkuId(skuId);
            cartInfo.setUserId(userId);
            cartInfo.setImgUrl(productSku.getThumbImg());
            cartInfo.setSkuName(productSku.getSkuName());
            cartInfo.setIsChecked(1);
            cartInfo.setCreateTime(new Date());
            cartInfo.setUpdateTime(new Date());

        }
redisTemplate.opsForHash().put(cartKey, String.valueOf(skuId),JSON.toJSONString(cartInfo));


    }
//    查询购物车
    @Override
    public List<CartInfo> getCartList() {
//        构建要查询的redis里面的key值，根据当前登录的用户id
        Long userId = AuthContextUtil.getUserInfo().getId();
        String cartKey = this.getCartKey(userId);

//        根据key从redis里面hash类型获取所有value值

        List<Object> valueList = redisTemplate.opsForHash().values(cartKey);

        if(!CollectionUtils.isEmpty(valueList)){
            List<CartInfo> cartInfoList = valueList.stream().map(cartInfoObj ->
                            JSON.parseObject(cartInfoObj.toString(), CartInfo.class))
                    .sorted((o1, o2) -> o2.getCreateTime().compareTo(o1.getCreateTime()))
                    .collect(Collectors.toList());
            return cartInfoList;

        }

        return new ArrayList<>();
    }
}
