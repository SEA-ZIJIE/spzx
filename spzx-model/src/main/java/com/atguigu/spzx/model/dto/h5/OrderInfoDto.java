package com.atguigu.spzx.model.dto.h5;

import com.atguigu.spzx.model.entity.order.OrderItem;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
//类 not object  实例化 new  全部都有构造方法 默认的空构造方法 一但手动定义一个构造方法， 把默认的构造方法删了
public class OrderInfoDto {

    //送货地址id
    private Long userAddressId;

    //运费
    private BigDecimal feightFee;

    //备注
    private String remark;

    //订单明细
    private List<OrderItem> orderItemList;


}