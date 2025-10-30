package com.atguigu.spzx.order.mapper;

import com.atguigu.spzx.model.entity.order.OrderItem;

import java.util.List;

/**
 * ClassName: OrderItemMapper
 * Package: com.atguigu.spzx.order.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/27 16:31
 * @Version 1.0
 */


public interface OrderItemMapper {
//       添加数据到order_item表

    void save(OrderItem orderItem);

//           订单id查询订单里面订单
    List<OrderItem> findByOrderId(Long orderId);
}
