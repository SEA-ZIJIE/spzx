package com.atguigu.spzx.order.service;

import com.atguigu.spzx.model.dto.h5.OrderInfoDto;
import com.atguigu.spzx.model.entity.order.OrderInfo;
import com.atguigu.spzx.model.vo.h5.TradeVo;
import com.github.pagehelper.PageInfo;

/**
 * ClassName: OrderInfoService
 * Package: com.atguigu.spzx.order.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/26 17:10
 * @Version 1.0
 */


public interface OrderInfoService {

//    结算接口
    TradeVo getTrade();
//    生成订单
    Long submitOrder(OrderInfoDto orderInfoDto);
//    获取订单信息
    OrderInfo getOrderInfo(Long orderId);
//    立即购买
    TradeVo buy(Long skuId);
//    获取订单分页列表
    PageInfo<OrderInfo> findOrderByPage(Integer page, Integer limit, Integer orderStatus);

    //远程调用:根据订单编号获取订单的信息
    OrderInfo getOrderInfoByOrderNo(String orderNo);
}
