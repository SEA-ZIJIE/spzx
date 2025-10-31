package com.atguigu.spzx.pay.mapper;

import com.atguigu.spzx.model.entity.pay.PaymentInfo;

/**
 * ClassName: PaymentInfoMapper
 * Package: com.atguigu.spzx.pay.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/31 8:36
 * @Version 1.0
 */


public interface PaymentInfoMapper {

//    添加
    void save(PaymentInfo paymentInfo);


    //        根据订单编号查询支付记录
    PaymentInfo getByOrderNo(String orderNo);
}
