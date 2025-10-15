package com.atguigu.spzx.product.service;

import com.atguigu.spzx.model.entity.product.ProductSku;

import java.util.List;

/**
 * ClassName: ProductService
 * Package: com.atguigu.spzx.product.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/15 0:40
 * @Version 1.0
 */


public interface ProductService {


    //根据销量排序，获取前10条记录
    List<ProductSku> selectProductSkuBySale();

}
