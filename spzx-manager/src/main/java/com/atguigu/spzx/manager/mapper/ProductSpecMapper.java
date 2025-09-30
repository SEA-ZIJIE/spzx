package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.product.ProductSpec;

import java.util.List;

/**
 * ClassName: ProductSpecMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/30 17:04
 * @Version 1.0
 */


public interface ProductSpecMapper {

    //列表
    List<ProductSpec> findByPage();
    //添加
    void save(ProductSpec productSpec);
    //修改
    void update(ProductSpec productSpec);
    //删除
    void delete(Long id);
}