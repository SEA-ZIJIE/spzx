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
public interface OrderStaticMapper {


    void insert(OrderStatistics orderStatistics);

}
