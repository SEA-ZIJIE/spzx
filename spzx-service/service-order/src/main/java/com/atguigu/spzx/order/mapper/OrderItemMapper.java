package com.atguigu.spzx.order.mapper;

import com.atguigu.spzx.model.entity.order.OrderItem;

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
}
