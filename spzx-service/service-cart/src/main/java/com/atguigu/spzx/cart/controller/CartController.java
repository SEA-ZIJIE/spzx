package com.atguigu.spzx.cart.controller;

import com.atguigu.spzx.cart.service.CartService;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //skuId:商品sku的id
//    skuNum:商品的数量
    @Operation(summary = "添加购物车")
    @GetMapping("auth/addToCart/{skuId}/{skuNum}")
    public Result<Void> addToCart(@PathVariable Long skuId ,
                                  @PathVariable Integer skuNum){
        cartService.addToCart(skuId,skuNum);


        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
}
