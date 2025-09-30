package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.entity.product.ProductSpec;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * ClassName: ProductSpecService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/30 15:17
 * @Version 1.0
 */

public interface ProductSpecService {


    //添加的方法
    void save(ProductSpec productSpec);

    //修改
    void updateById(ProductSpec productSpec);

    //删除
    void deleteById(Long id);
    //列表
    PageInfo<ProductSpec> findByPage(Integer page, Integer limit);
}
