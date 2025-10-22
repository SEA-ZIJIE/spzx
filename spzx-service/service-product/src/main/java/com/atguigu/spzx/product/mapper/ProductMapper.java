package com.atguigu.spzx.product.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: ProductMapper
 * Package: com.atguigu.spzx.product.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/23 0:31
 * @Version 1.0
 */

@Mapper
public interface ProductMapper {

//    从sku中获取productId,获取商品信息
    product getById(Long productId);
}
