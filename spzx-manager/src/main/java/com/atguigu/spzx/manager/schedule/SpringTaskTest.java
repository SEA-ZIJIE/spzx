package com.atguigu.spzx.manager.schedule;

import com.atguigu.spzx.manager.service.OrderInfoService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * ClassName: SpringTaskTest
 * Package: com.atguigu.spzx.manager.schedule
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/4 21:36
 * @Version 1.0
 */

@Component
public class SpringTaskTest {
    @Resource
    private OrderInfoService service;
    //每隔一天统计订单金额
    @Scheduled(cron = "0 0 2 * * ?")
    public void task(){
         service.countOrderAll();
    }


}
