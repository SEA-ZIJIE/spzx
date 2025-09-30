package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.CategoryBrandService;
import com.atguigu.spzx.model.dto.product.CategoryBrandDto;
import com.atguigu.spzx.model.entity.product.CategoryBrand;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: CategoryBrandController
 * Package: com.atguigu.spzx.manager.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/29 9:22
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/admin/product/categoryBrand/")
public class CategoryBrandController {
    @Resource
    private CategoryBrandService categoryBrandService;

    //添加
    @PostMapping("/save")
    public Result<Void> save(@RequestBody CategoryBrand categoryBrand){
        categoryBrandService.save(categoryBrand);
        return Result.build(null, ResultCodeEnum.SUCCESS);

    }
    //分类品牌的条件分页查询
    @GetMapping("/{page}/{limit}")
    public Result<Void> findByPage(@PathVariable Integer page,
                                   @PathVariable Integer limit,
                                   CategoryBrandDto categoryBrandDto) {
        PageInfo<CategoryBrand> pageInfo =
                categoryBrandService.findByPage(page,limit,categoryBrandDto);
            return Result.build(pageInfo, ResultCodeEnum.SUCCESS);

    }




}
