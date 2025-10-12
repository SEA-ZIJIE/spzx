package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.OrderInfoService;
import com.atguigu.spzx.model.dto.order.OrderStatisticsDto;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.model.vo.order.OrderStatisticsVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OrderInfoController
 * Package: com.atguigu.spzx.manager.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/4 19:06
 * @Version 1.0
 */

@Slf4j
@Tag(name = "订单信息管理")
@RestController
@RequestMapping("/admin/product/orderinfo")
public class OrderInfoController {

    @Setter(onMethod_ = @Autowired)
    private OrderInfoService orderInfoService;

    @GetMapping("/getOrderStatisticsData")
    public Result<OrderStatisticsVo> getOrderStatisticsData(@RequestBody OrderStatisticsDto orderStatisticsDto) {
        OrderStatisticsVo orderStatisticsVo =
                orderInfoService.getOrderStatisticsData(orderStatisticsDto);


        return Result.build(orderStatisticsVo, ResultCodeEnum.SUCCESS);
    }


}
