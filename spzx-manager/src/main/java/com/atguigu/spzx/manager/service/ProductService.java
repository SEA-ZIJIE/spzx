package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.dto.product.ProductDto;
import com.atguigu.spzx.model.entity.product.Product;
import com.github.pagehelper.PageInfo;

/**
 * ClassName: ProductService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/7 16:05
 * @Version 1.0
 */


public interface ProductService {
    //列表查询

    PageInfo<Product> findByPage(Integer page, Integer limit, ProductDto productDto);

}
