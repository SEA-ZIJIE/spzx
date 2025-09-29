package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.dto.product.CategoryBrandDto;
import com.atguigu.spzx.model.entity.product.CategoryBrand;
import com.github.pagehelper.PageInfo;

/**
 * ClassName: CategoryBrandService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/29 19:34
 * @Version 1.0
 */


public interface CategoryBrandService {
    //分类品牌的条件分页查询
    PageInfo<CategoryBrand> findByPage(Integer page, Integer limit, CategoryBrandDto categoryBrandDto);

}
