package com.atguigu.spzx.cart.controller;

import com.atguigu.spzx.cart.service.CartService;
import com.atguigu.spzx.model.entity.h5.CartInfo;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: CartController
 * Package: com.atguigu.spzx.cart.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/21 23:02
 * @Version 1.0
 */

@RestController
@RequestMapping("/api/order/cart")
public class CartController {
    @Resource
    private CartService cartService;

    @Operation(summary = "清空购物车")
    @GetMapping("/auth/clearCart")
    public Result<Void> clearCart() {
        cartService.clearCart();
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @Operation(summary = "更新购物车商品全部选中状态")
    @GetMapping("/auth/allCheckCart/{isChecked}")
    public Result allCheckCart(@Parameter(name = "isChecked", description = "是否选中 1:选中 0:取消选中", required = true) @PathVariable(value = "isChecked") Integer isChecked) {
        cartService.allCheckCart(isChecked);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @Operation(summary = "更新购物车商品选中状态")
    @GetMapping("/auth/checkCart/{skuId}/{isChecked}")
    public Result<Void> checkCart(@Parameter(name = "skuId", description = "商品skuId", required = true) @PathVariable(value = "skuId") Long skuId,
                                  @Parameter(name = "isChecked", description = "是否选中 1:选中 0:取消选中", required = true) @PathVariable(value = "isChecked") Integer isChecked) {
        cartService.CheckCart(skuId, isChecked);
        return Result.build(null, ResultCodeEnum.SUCCESS);

    }

    @Operation(summary = "删除购物车商品")
    @DeleteMapping("auth/deleteCart/{skuId}")
    public Result<Void> deleteCart(@PathVariable("skuId") Long skuId) {
        cartService.deleteCart(skuId);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @Operation(summary = "查询购物车")
    @GetMapping("auth/cartList")
    public Result<Void> cartList() {
        List<CartInfo> cartInfoList = cartService.getCartList();
        return Result.build(cartInfoList, ResultCodeEnum.SUCCESS);
    }


    //skuId:商品sku的id
//    skuNum:商品的数量
    @Operation(summary = "添加购物车")
    @GetMapping("auth/addToCart/{skuId}/{skuNum}")
    public Result<Void> addToCart(@PathVariable Long skuId,
                                  @PathVariable Integer skuNum) {
        cartService.addToCart(skuId, skuNum);


        return Result.build(null, ResultCodeEnum.SUCCESS);

    }

    // 远程调用:订单结算的时候，获取购物车中选中的商品列表
    @Operation(summary = "选中的购物车")
    @GetMapping(value = "/auth/getAllCkecked")
    public List<CartInfo> getAllCkecked() {
        List<CartInfo> list =  cartService.getAllChecked();
        return list;

    }
   //远程调用：删除生成订单的购物车商品
    @GetMapping("/auth/deleteChecked")
    public Result<Void> deleteChecked(){

        cartService.deleteChecked();

        return Result.build(null, ResultCodeEnum.SUCCESS);

    }



}
