package com.atguigu.spzx.feign.order;/**
 * ClassName: OrderFeignClient
 * Package: com.atguigu.spzx.feign.order
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/11/1 0:44
 * @Version 1.0
 */

import com.atguigu.spzx.model.entity.order.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-order")
public interface OrderFeignClient {
    @GetMapping("/api/order/orderInfo/auth/getOrderInfoByOrderNo/{orderNo}")
    public OrderInfo getOrderInfoByOrderNo(@PathVariable("orderNo") String orderNo);
}
