package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.entity.product.Brand;
import com.github.pagehelper.PageInfo;

/**
 * ClassName: BrandService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/28 12:59
 * @Version 1.0
 */


public interface BrandService {

    //列表
    PageInfo<Brand> findByPage(Integer page, Integer limit);

    //添加
    void save(Brand brand);
}
