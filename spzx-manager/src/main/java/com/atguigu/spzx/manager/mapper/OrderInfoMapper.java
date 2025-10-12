package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.order.OrderInfo;
import com.atguigu.spzx.model.entity.order.OrderStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: OrderInfoMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/5 10:43
 * @Version 1.0
 */

@Mapper
public interface OrderInfoMapper{

    List<OrderInfo> selectOrderInfoBy(@Param("createTimeBegin") String createTimeBegin,@Param("createTimeEnd") String createTimeEnd);

    //统计前一天交易的金额
    OrderStatistics selectStatisticsByDate(String createDate);
}
