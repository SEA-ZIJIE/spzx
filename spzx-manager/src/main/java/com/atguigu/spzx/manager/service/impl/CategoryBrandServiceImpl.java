package com.atguigu.spzx.manager.service.impl;

import com.atguigu.spzx.manager.mapper.CategoryBrandMapper;
import com.atguigu.spzx.manager.service.CategoryBrandService;
import com.atguigu.spzx.model.dto.product.CategoryBrandDto;
import com.atguigu.spzx.model.entity.product.CategoryBrand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;

import java.util.List;

/**
 * ClassName: CategoryBrandServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/29 19:34
 * @Version 1.0
 */


public class CategoryBrandServiceImpl implements CategoryBrandService {
    @Resource
    private CategoryBrandMapper categoryBrandMapper;

    //分类品牌的条件分页查询
    @Override
    public PageInfo<CategoryBrand> findByPage(Integer page,
                                              Integer limit,
                                              CategoryBrandDto categoryBrandDto) {
        PageHelper.startPage(page, limit);
        List<CategoryBrand> list =  categoryBrandMapper.findByPage(categoryBrandDto);
        PageInfo<CategoryBrand> pageInfo = new PageInfo<>(list);



        return pageInfo;
    }
}
