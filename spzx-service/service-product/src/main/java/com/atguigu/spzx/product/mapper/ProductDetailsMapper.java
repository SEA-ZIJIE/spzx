package com.atguigu.spzx.product.mapper;/**
 * ClassName: ProductDetailsMapper
 * Package: com.atguigu.spzx.product.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/23 0:31
 * @Version 1.0
 */

import com.atguigu.spzx.model.entity.product.ProductDetails;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductDetailsMapper {
    //        根据producId获取商品的详情信息
    ProductDetails getByProductId(Long productId);

}
