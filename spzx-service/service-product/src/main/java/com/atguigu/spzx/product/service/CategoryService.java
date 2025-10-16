package com.atguigu.spzx.product.service;

import com.atguigu.spzx.model.entity.product.Category;

import java.util.List;

/**
 * ClassName: CategoryService
 * Package: com.atguigu.spzx.product.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/15 0:41
 * @Version 1.0
 */


public interface CategoryService {
//    所有的一级分类
    List<Category> selectOneCategory();
//    查询所有的分类，数信方式封装

    List<Category> findCategoryTree();
}
