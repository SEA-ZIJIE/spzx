package com.atguigu.spzx.order.mapper;

import com.atguigu.spzx.model.entity.order.OrderInfo;

/**
 * ClassName: OrderInfoMapper
 * Package: com.atguigu.spzx.order.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/27 16:31
 * @Version 1.0
 */


public interface OrderInfoMapper {
//    添加数据到order_info表里面
    void save(OrderInfo orderInfo);
}
