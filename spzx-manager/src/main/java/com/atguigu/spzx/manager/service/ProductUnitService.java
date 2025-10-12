package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.entity.base.ProductUnit;

import java.util.List;

/**
 * ClassName: ProductUnitService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/2 11:55
 * @Version 1.0
 */


public interface ProductUnitService {
    //查询计量单位
    List<ProductUnit> findAll();

}
