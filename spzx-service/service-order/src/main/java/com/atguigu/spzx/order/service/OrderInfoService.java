package com.atguigu.spzx.order.service;

import com.atguigu.spzx.model.dto.h5.OrderInfoDto;
import com.atguigu.spzx.model.vo.h5.TradeVo;

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
}
