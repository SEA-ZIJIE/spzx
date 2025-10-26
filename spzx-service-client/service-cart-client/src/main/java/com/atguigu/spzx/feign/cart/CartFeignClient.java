package com.atguigu.spzx.feign.cart;

import com.atguigu.spzx.model.entity.h5.CartInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * ClassName: CartFeignClient
 * Package: com.atguigu.spzx.feign.cart
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/26 17:18
 * @Version 1.0
 */

@FeignClient(value = "service-cart")
public interface CartFeignClient {

    @GetMapping(value = "/api/order/cart/auth/getAllCkecked")
    public List<CartInfo> getAllCkecked();
}
