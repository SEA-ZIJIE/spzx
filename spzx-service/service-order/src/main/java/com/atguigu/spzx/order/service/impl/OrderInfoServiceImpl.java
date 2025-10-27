package com.atguigu.spzx.order.service.impl;

import com.atguigu.spzx.common.exception.GuiguException;
import com.atguigu.spzx.feign.cart.CartFeignClient;
import com.atguigu.spzx.feign.product.ProductFeignClient;
import com.atguigu.spzx.model.dto.h5.OrderInfoDto;
import com.atguigu.spzx.model.entity.h5.CartInfo;
import com.atguigu.spzx.model.entity.order.OrderInfo;
import com.atguigu.spzx.model.entity.order.OrderItem;
import com.atguigu.spzx.model.entity.order.OrderLog;
import com.atguigu.spzx.model.entity.product.ProductSku;
import com.atguigu.spzx.model.entity.user.UserAddress;
import com.atguigu.spzx.model.entity.user.UserInfo;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.model.vo.h5.TradeVo;
import com.atguigu.spzx.order.mapper.OrderInfoMapper;
import com.atguigu.spzx.order.mapper.OrderItemMapper;
import com.atguigu.spzx.order.mapper.OrderLogMapper;
import com.atguigu.spzx.order.service.OrderInfoService;
import com.atguigu.spzx.utils.AuthContextUtil;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: OrderInfoServiceImpl
 * Package: com.atguigu.spzx.order.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/26 17:10
 * @Version 1.0
 */

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Resource
    private CartFeignClient cartFeignClient;

    @Resource
    private ProductFeignClient productFeignClient;

    @Resource
    private OrderInfoMapper  orderInfoMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Resource
    private OrderLogMapper  orderLogMapper;
    //    结算接口
    @Override
    public TradeVo getTrade() {

//        远程调用获取购物车中选中的商品列表
        List<CartInfo> cartInfoList = cartFeignClient.getAllCkecked();
        List<OrderItem> orderItemList = new ArrayList<>();
        for (CartInfo cartInfo : cartInfoList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setSkuId(cartInfo.getSkuId());
            orderItem.setSkuName(cartInfo.getSkuName());
            orderItem.setSkuNum(cartInfo.getSkuNum());
            orderItem.setSkuPrice(cartInfo.getCartPrice());
            orderItem.setThumbImg(cartInfo.getImgUrl());
            orderItemList.add(orderItem);
        }

//        获取订单的总金额
        BigDecimal totalAmount = new BigDecimal(0);
        for (OrderItem orderItem : orderItemList) {
            totalAmount = totalAmount.add(orderItem.getSkuPrice().multiply(new BigDecimal(orderItem.getSkuNum())));
        }
        TradeVo tradeVo = new TradeVo();
        tradeVo.setOrderItemList(orderItemList);
        tradeVo.setTotalAmount(totalAmount);
        return tradeVo;
    }
//    生成订单
    @Override
    public Long submitOrder(OrderInfoDto orderInfoDto) {

//        orderInfoDto获取所有订单项list
        List<OrderItem> orderItemList = orderInfoDto.getOrderItemList();
//        判断list<orderItem>为空，抛出异常
        if (CollectionUtils.isEmpty(orderItemList)) {
            throw new GuiguException(ResultCodeEnum.DATA_ERROR);
        }
//        检验库存是否充足
//        遍历list<OrderItem>集合，得到每一个orderItem
            for(OrderItem orderItem : orderItemList){
//                根据skuId获取sku信息    远程调用获取商品sku信息，（包含库存量）
                ProductSku productSku = productFeignClient.getBySkuId(orderItem.getSkuId());
                if(productSku == null){
                    throw new GuiguException(ResultCodeEnum.DATA_ERROR);
                }
//        校验每个orderItem库存量是否充足
                if (orderItem.getSkuNum().intValue() > productSku.getStockNum().intValue()){
                    throw new GuiguException(ResultCodeEnum.STOCK_LESS);
                }

            }


//        添加数据到order—info表
//        封装数据到OrderInfo对象
//        远程调用：获取用户收货地址信息
            OrderInfo orderInfo = new OrderInfo();
            UserInfo userInfo = AuthContextUtil.getUserInfo();
            //订单编号
            orderInfo.setOrderNo(String.valueOf(System.currentTimeMillis()));
            //用户id
            orderInfo.setUserId(userInfo.getId());
            //用户昵称
            orderInfo.setNickName(userInfo.getNickName());

//            封装收货信息
            Long userAddressId = orderInfoDto.getUserAddressId();
//          ToDo:远程调用：获取收货地址Id,获取用户收货地址信息
            UserAddress userAddress = null;
            orderInfo.setReceiverName(userAddress.getName());
            orderInfo.setReceiverPhone(userAddress.getPhone());
            orderInfo.setReceiverTagName(userAddress.getTagName());
            orderInfo.setReceiverProvince(userAddress.getProvinceCode());
            orderInfo.setReceiverCity(userAddress.getCityCode());
            orderInfo.setReceiverDistrict(userAddress.getDistrictCode());
            orderInfo.setReceiverAddress(userAddress.getFullAddress());
            //订单金额
            BigDecimal totalAmount = new BigDecimal(0);
            for (OrderItem orderItem : orderItemList) {
                totalAmount = totalAmount.add(orderItem.getSkuPrice().multiply(new BigDecimal(orderItem.getSkuNum())));
            }
            orderInfo.setTotalAmount(totalAmount);
            orderInfo.setCouponAmount(new BigDecimal(0));
            orderInfo.setOriginalTotalAmount(totalAmount);
            orderInfo.setFeightFee(orderInfoDto.getFeightFee());
            orderInfo.setPayType(2);
            orderInfo.setOrderStatus(0);
            orderInfoMapper.save(orderInfo);

//            5 添加数据到order_item表
//            添加List<OrderItem>里面数据，把集合每个orderItem添加表
              for (OrderItem orderItem : orderItemList) {
//                  设置对应的订单id
                  orderItem.setOrderId(orderInfo.getId());
                  orderItemMapper.save(orderItem);

              }
//             6 添加数据到order_Log表

            OrderLog orderLog = new OrderLog();
            orderLog.setOrderId(orderInfo.getId());
            orderLog.setProcessStatus(0);
            orderLog.setNote("提交订单");
            orderLogMapper.save(orderLog);

//           TODO 7 把生成订单商品，从购物车删除

//           8 返回订单id
            return orderInfo.getId();
        }

    }

