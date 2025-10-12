package com.atguigu.spzx.manager.task;

import cn.hutool.core.date.DateUtil;
import com.atguigu.spzx.manager.mapper.OrderInfoMapper;

import com.atguigu.spzx.manager.mapper.OrderStatisticsMapper;
import com.atguigu.spzx.model.entity.order.OrderStatistics;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * ClassName: OrderStaticsTask
 * Package: com.atguigu.spzx.manager.task
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/11 20:40
 * @Version 1.0
 */


public class OrderStaticsTask {

//测试定时任务
// 每隔五秒，方法执行一次

    @Resource
    private OrderInfoMapper orderInfoMapper;
    @Resource
    private OrderStatisticsMapper orderStatiscsMapper;
//    每天凌晨两点查询前一个的统计数据，把统计之后的数据添加到统计的结果表里

//    @Scheduled(cron = "0 0 2 * * ?")
    @Scheduled(cron = "0/5 * * * * ?")//测试

    public void orderTotalAmountStatics(){
//获取前一天的日期
        String createDate =
                DateUtil.offsetDay(new Date(), -1).toString("yyyy-MM-dd");



//根据前一天的日期进行统计（分组操作）
//统计前一天交易的金额
        OrderStatistics orderStatistics =
                orderInfoMapper.selectStatisticsByDate(createDate);


//统计之后的数据添加到统计表里
        if(orderStatistics == null){
            orderStatiscsMapper.insert(orderStatistics);
        }
    }
}
