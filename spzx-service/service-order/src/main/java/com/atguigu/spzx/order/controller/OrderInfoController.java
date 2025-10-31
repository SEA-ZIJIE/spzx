package com.atguigu.spzx.order.controller;

import com.atguigu.spzx.model.dto.h5.OrderInfoDto;
import com.atguigu.spzx.model.entity.order.OrderInfo;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.model.vo.h5.TradeVo;
import com.atguigu.spzx.order.service.OrderInfoService;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: OrderInfoController
 * Package: com.atguigu.spzx.order.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/26 17:09
 * @Version 1.0
 */


@Tag(name = "订单管理")
@RestController
@RequestMapping(value="/api/order/orderInfo")
public class OrderInfoController {

    @Resource
    private OrderInfoService orderInfoService;

//    生成订单
    @Operation(summary = "提交订单")
    @PostMapping("auth/submitOrder")
    public Result submitOrder(@RequestBody OrderInfoDto orderInfoDto){
        Long orderId = orderInfoService.submitOrder(orderInfoDto);
        return Result.build(orderId, ResultCodeEnum.SUCCESS);
    }


//    结算接口
    @Operation(summary = "确认下单")
    @GetMapping("auth/trade")
    public Result<TradeVo> trade(){
        TradeVo tradeVo  = orderInfoService.getTrade();
        return Result.build(tradeVo, ResultCodeEnum.SUCCESS);
    }

    @Operation(summary = "获取订单信息")
    @GetMapping("auth/{orderId}")
    public Result<Void> getOrderInfo(@PathVariable Long orderId){
        OrderInfo orderInfo =orderInfoService.getOrderInfo(orderId);
        return Result.build(orderInfo, ResultCodeEnum.SUCCESS);
    }

    @Operation(summary = "立即购买")
    @GetMapping("/auth/buy/{skuId}")
    public Result<Void> buy(@PathVariable Long skuId){
        TradeVo tradeVo = orderInfoService.buy(skuId);
        return Result.build(tradeVo, ResultCodeEnum.SUCCESS);
    }

    @Operation(summary = "获取订单分页列表")
    @GetMapping("auth/{page}/{limit}")
    public Result<PageInfo<OrderInfo>> list(@PathVariable Integer page,
                                            @PathVariable Integer limit,
                                            @RequestParam(required = false, defaultValue = "") Integer orderStatus){
        PageInfo<OrderInfo> pageInfo = orderInfoService.findOrderByPage(page,limit,orderStatus);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }
//远程调用:根据订单编号获取订单的信息
@Operation(summary = "获取订单信息")
@GetMapping("auth/getOrderInfoByOrderNo/{orderNo}")
public OrderInfo getOrderInfoByOrderNo(@Parameter(name = "orderId",
        description = "订单id",
         required = true) @PathVariable String orderNo) {
        OrderInfo orderInfo= orderInfoService.getOrderInfoByOrderNo(orderNo);
        return orderInfo;
         }


}