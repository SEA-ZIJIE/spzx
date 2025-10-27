package com.atguigu.spzx.order.mapper;

import com.atguigu.spzx.model.entity.order.OrderLog;

/**
 * ClassName: OrderLogMapper
 * Package: com.atguigu.spzx.order.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/27 16:31
 * @Version 1.0
 */


public interface OrderLogMapper {
    //              添加数据到order_Log表

    void save(OrderLog orderLog);
}
