package com.atguigu.spzx.product.service.impl;

import com.atguigu.spzx.model.entity.product.Category;
import com.atguigu.spzx.product.mapper.CategoryMapper;
import com.atguigu.spzx.product.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: CategoryServiceImpl
 * Package: com.atguigu.spzx.product.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/15 0:39
 * @Version 1.0
 */

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> selectOneCategory() {
        return categoryMapper.selectOneCategory();
    }
}
