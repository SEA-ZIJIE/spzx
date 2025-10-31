package com.atguigu.spzx.pay.service;

import com.atguigu.spzx.model.entity.pay.PaymentInfo;

/**
 * ClassName: PaymentInfoService
 * Package: com.atguigu.spzx.pay.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/31 8:37
 * @Version 1.0
 */


public interface PaymentInfoService {

//    保存支付记录
PaymentInfo savePaymentInfo(String orderNo);



}
