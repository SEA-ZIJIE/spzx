package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.CategoryService;
import com.atguigu.spzx.model.entity.product.Category;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: CategoryController
 * Package: com.atguigu.spzx.manager.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/26 22:23
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/admin/product/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    //导出
    @GetMapping("/ExporData")
    public void exporData(HttpServletResponse response){
        categoryService.exportData(response);
    }

    //分类的列表，每次查询一层的数据
    @GetMapping("/findCategoryList/{id}")
    public Result<Void> findCategoryList(@PathVariable Long id){
        List<Category> list = categoryService.findCategoryList(id);
        return Result.build(list, ResultCodeEnum.SUCCESS);

    }
}
