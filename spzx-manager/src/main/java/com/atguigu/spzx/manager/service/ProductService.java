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
 * @Create 2025/10/1 12:46
 * @Version 1.0
 */


public interface ProductService {

    //列表（条件分页查询）
    PageInfo<Product> findByPage(Integer page, Integer limit, ProductDto productDto);
    //添加商品信息
    void save(Product product);
//    根据商品id查询商品的信息
    Product getById(Long id);
//    保存修改数据
    void update(Product product);
    //     删除
    void deleteById(Long id);
}
