package com.atguigu.spzx.manager.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.atguigu.spzx.manager.mapper.OrderInfoMapper;
import com.atguigu.spzx.manager.service.OrderInfoService;
import com.atguigu.spzx.model.dto.order.OrderStatisticsDto;
import com.atguigu.spzx.model.entity.order.OrderInfo;
import com.atguigu.spzx.model.vo.order.OrderStatisticsVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ClassName: OrderInfoServiceImplTest
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/5 11:09
 * @Version 1.0
 */

@RunWith(MockitoJUnitRunner.class)
public class OrderInfoServiceImplTest {

    @InjectMocks
    private OrderInfoServiceImpl orderInfoService;

    @Mock
    private OrderInfoMapper orderInfoMapper;

    @Test
    public void countAmountTest(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ArrayList<OrderInfo> orderInfos = new ArrayList<>();
        // 随机生成10条 OrderInfo 数据
        for (int i = 1; i <= 10; i++) {
            OrderInfo orderInfo = new OrderInfo();
            // 设置随机取消时间
            Date randomDate = getRandomDate("2025-10-01", "2025-10-10");
            orderInfo.setCreateTime(randomDate);

            // 设置随机金额（100 到 1000 之间）
            BigDecimal randomAmount = BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(100, 1001));
            orderInfo.setTotalAmount(randomAmount);

            // 添加到列表
            orderInfos.add(orderInfo);

            // 打印生成的数据
            System.out.println("Order " + i + ": cancelTime=" + dateFormat.format(randomDate)
                    + ", totalAmount=" + randomAmount);
        }

        Mockito.when(orderInfoMapper.selectOrderInfoBy(Mockito.any(),Mockito.any())).thenReturn(orderInfos);
        OrderStatisticsVo orderStatisticsVo = orderInfoService.countAmount(new OrderStatisticsDto());

        System.out.println(JSONUtil.toJsonStr(orderStatisticsVo));
    }

    // 随机生成日期
    private static Date getRandomDate(String startDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(startDate);
            Date end = format.parse(endDate);
            long randomTime = ThreadLocalRandom.current().nextLong(start.getTime(), end.getTime());
            return new Date(randomTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void  testDate(){
        DateTime yesterday = DateUtil.yesterday();
        DateTime dateTime = DateUtil.beginOfDay(yesterday);
        System.out.println(dateTime);
        DateTime dateTime1 = DateUtil.endOfDay(yesterday);
        System.out.println(dateTime1);
        System.out.println(yesterday);
    }

}
