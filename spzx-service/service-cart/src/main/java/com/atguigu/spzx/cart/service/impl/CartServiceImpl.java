package com.atguigu.spzx.cart.service.impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.spzx.cart.service.CartService;
import com.atguigu.spzx.feign.product.ProductFeignClient;
import com.atguigu.spzx.model.entity.h5.CartInfo;
import com.atguigu.spzx.model.entity.product.ProductSku;
import com.atguigu.spzx.utils.AuthContextUtil;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


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
//删除购物车
    @Override
    public void deleteCart(Long skuId) {

        Long userId = AuthContextUtil.getUserInfo().getId();
        String cartKey = this.getCartKey(userId);
        redisTemplate.opsForHash().delete(cartKey,String.valueOf(skuId));
    }
    //    更新购物车商品选中状态
    @Override
    public void CheckCart(Long skuId, Integer isChecked) {
        //        构建查询的redis里面key值，根据当前userId

        Long userId = AuthContextUtil.getUserInfo().getId();
        String cartKey = this.getCartKey(userId);

//        判断key是否包含filed

        Boolean hasKey = redisTemplate.opsForHash().hasKey(cartKey, String.valueOf(skuId));

        if(hasKey){

//        根据key+field吧value获取出来

            String cartInfoString =
                    redisTemplate.opsForHash().get(cartKey, String.valueOf(skuId)).toString();

//        更新value里面选中状态

            CartInfo cartInfo = JSON.parseObject(cartInfoString, CartInfo.class);
            cartInfo.setIsChecked(isChecked);

//        放回到redis的hash类型里面
            redisTemplate.opsForHash().put(cartKey,
                    String.valueOf(skuId),
                    JSON.toJSONString(cartInfo));

        }
    }
    //        更新购物车商品全部选中状态
    @Override
    public void allCheckCart(Long skuId, Integer isChecked) {

//            构建查询的redis里面key值，根据当前userId

        Long userId = AuthContextUtil.getUserInfo().getId();
        String cartKey = this.getCartKey(userId);

//        根据key获取购物车中的所有的value值

        List<Object> objectList = redisTemplate.opsForHash().values(cartKey);

//        判断不为空
        if(CollectionUtils.isEmpty(objectList)){
            List<CartInfo> cartInfoList = objectList.stream().map(object -> JSON.parseObject(object.toString(), CartInfo.class))
                    .collect(Collectors.toList());


//        把每个商品的isChecked进行更新
        cartInfoList.forEach(cartInfo -> {

            cartInfo.setIsChecked(isChecked);
            redisTemplate.opsForHash().put(cartKey,String.valueOf(cartInfo.getSkuId()),
                    JSON.toJSONString(cartInfo));

        });


        }

    }

    @Override
    public void clearCart() {
        //        构建要查询的redis里面的key值，根据当前登录的用户id
        Long userId = AuthContextUtil.getUserInfo().getId();
        String cartKey = this.getCartKey(userId);
//        根据key删除redis里面的数据

        redisTemplate.delete(cartKey);


    }

}

