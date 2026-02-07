package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.CategoryBrandService;
import com.atguigu.spzx.manager.service.CategoryService;
import com.atguigu.spzx.model.dto.product.CategoryBrandDto;
import com.atguigu.spzx.model.entity.product.CategoryBrand;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: CategoryBrandController
 * Package: com.atguigu.spzx.manager.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/6 16:06
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/admin/product/categoryBrand")

public class CategoryBrandController {

    @Autowired
    private CategoryBrandService categoryBrandService;

    //分类品牌列表接口
    @GetMapping("/{page}/{limit}")

    public Result<PageInfo<CategoryBrand>> findByPage(@PathVariable Integer page, @PathVariable Integer limit,
                                                      CategoryBrandDto CategoryBrandDto) {
        PageInfo<CategoryBrand> pageInfo =  categoryBrandService.findByPage(page,limit,CategoryBrandDto);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);


    }


    //添加功能
    @PostMapping("/save")
    public Result<Void> save(@RequestBody CategoryBrand categoryBrand ) {

        categoryBrandService.save(categoryBrand);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    //修改功能
    @PutMapping("/updateById")
    public  Result<Void> updateById(@RequestBody CategoryBrand categoryBrand) {
        categoryBrandService.updateById(categoryBrand);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
    //删除功能
    @DeleteMapping("/deleteById/{id}")
    public Result<Void> deleteById(@PathVariable Integer id) {
        categoryBrandService.deleteById(id);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

}
