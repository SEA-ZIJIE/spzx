package com.atguigu.spzx.product.controller;

import com.atguigu.spzx.model.entity.product.Category;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.product.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: CategoryController
 * Package: com.atguigu.spzx.product.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/16 9:00
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/api/product/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

//    查询所有的分类，数信方式封装
    @GetMapping("/findCategoryTree")
    public Result findCategoryTree() {
        List<Category> list = categoryService.findCategoryTree();
        return  Result.build(list, ResultCodeEnum.SUCCESS);


    }

}
