package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.entity.product.Category;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * ClassName: CategoryService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/26 22:26
 * @Version 1.0
 */


public interface CategoryService {

    //分类的列表，每次查询一层的数据
    List<Category> findCategoryList(Long id);

    //导出
    void exportData(HttpServletResponse response);
}
