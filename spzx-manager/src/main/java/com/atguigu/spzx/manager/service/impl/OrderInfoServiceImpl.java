package com.atguigu.spzx.manager.service.impl;/**
 * ClassName: OrderInfoServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/4 21:50
 * @Version 1.0
 */

import cn.hutool.core.date.DateUtil;
import com.atguigu.spzx.manager.mapper.OrderInfoMapper;
import com.atguigu.spzx.manager.mapper.OrderStatisticsMapper;
import com.atguigu.spzx.manager.service.OrderInfoService;
import com.atguigu.spzx.model.dto.order.OrderStatisticsDto;
import com.atguigu.spzx.model.entity.order.OrderStatistics;
import com.atguigu.spzx.model.vo.order.OrderStatisticsVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderInfoServiceImpl implements OrderInfoService {

    private final OrderInfoMapper orderInfoMapper;

    private final OrderStatisticsMapper orderStatisticsMapper;
//    @Override
//    public void countOrderAll() {
//        // 查询本日的数据
//        DateTime startTime = DateUtil.beginOfDay(DateUtil.yesterday());
//        DateTime endTime = DateUtil.endOfDay(DateUtil.yesterday());
//        List<OrderInfo> orderInfos = orderInfoMapper.selectOrderInfoBy(startTime.toString(), endTime.toString());
//        // 计算本日的总金额
//
//        BigDecimal totalAmount = new BigDecimal("0");
//        for (int i = 0; i < orderInfos.size(); i++) {
//
//            totalAmount.add(orderInfos.get(i).getTotalAmount());
//        }
//
//        // 保存到数据库
//        OrderStatistics orderStatistics = new OrderStatistics();
//        orderStatistics.setOrderDate(DateUtil.yesterday());
//        orderStatistics.setCreateTime(new Date());
//        orderStatistics.setTotalAmount(totalAmount);
//        orderStatistics.setTotalNum(orderInfos.size());
//
//        orderStaticMapper.insert(orderStatistics);
//
//    }
//
//    @Override
//    public OrderStatisticsVo countAmount(OrderStatisticsDto orderStatisticsDto) {
//        List<OrderInfo> orderInfos = orderInfoMapper.selectOrderInfoBy(orderStatisticsDto.getCreateTimeBegin(),
//                orderStatisticsDto.getCreateTimeEnd());
//        log.info("orderInfos:{}", JSONUtil.toJsonStr(orderInfos));
//
//        Map<String, List<OrderInfo>> group = new TreeMap<>(String::compareTo);
//
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        for (OrderInfo orderInfo : orderInfos) {
//            Date createTime = orderInfo.getCreateTime();
//            String date = dateFormat.format(createTime);
//            List<OrderInfo> orderInfoList = group.computeIfAbsent(date, k -> new ArrayList<>());
//            orderInfoList.add(orderInfo);
//        }
//        OrderStatisticsVo result = new OrderStatisticsVo();
//        ArrayList<String> dateList = new ArrayList<>();
//
//
//        result.setDateList(dateList);
//        ArrayList<BigDecimal> amountList = new ArrayList<>();
//        result.setAmountList(amountList);
//        for (Map.Entry<String, List<OrderInfo>> item : group.entrySet()) {
//            dateList.add(item.getKey());
//            List<OrderInfo> value = item.getValue();
//            BigDecimal sum = new BigDecimal("0");
//
//            for (OrderInfo orderInfo : value) {
//                sum = sum.add(orderInfo.getTotalAmount());
//            }
//            amountList.add(sum);
//        }
//
//        return result;
//    }

    @Override
    public OrderStatisticsVo getOrderStatisticsData(OrderStatisticsDto orderStatisticsDto) {


//        根据dto条件查询统计结果的数据，返回list集合，
            List<OrderStatistics> orderStatisticsList =
                    orderStatisticsMapper.selectList(orderStatisticsDto);

//        遍历list集合得到所有的日期，把所有的日期封装到list集合中

        List<String> dataList = orderStatisticsList.stream()
                .map(orderStatistics ->
                        DateUtil.format(orderStatistics.getOrderDate(), "yyy-MM-dd"))
                .collect(Collectors.toList());

//       遍历list集合得到所有的日期，得到所有日期对应的总金额，把总金额封装到list集合中
        List<BigDecimal> decimalList = orderStatisticsList.stream()
                .map(OrderStatistics::getTotalAmount)
                .collect(Collectors.toList());

//        把两个list集合封装到OrderStatisticsVo，返回OrderStatisticsVo
        OrderStatisticsVo orderStatisticsVo = new OrderStatisticsVo();
        orderStatisticsVo.setDateList(dataList);
        orderStatisticsVo.setAmountList(decimalList);
        return orderStatisticsVo;
    }
}
