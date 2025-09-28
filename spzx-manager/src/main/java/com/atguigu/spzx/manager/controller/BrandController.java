package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.BrandService;
import com.atguigu.spzx.model.entity.product.Brand;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: BrandController
 * Package: com.atguigu.spzx.manager.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/28 12:47
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/admin/product/brand")
public class BrandController {
    @Resource
    private BrandService brandService;
    //列表
    @GetMapping("/{page}/{limit}")
    public Result<Void> list (@PathVariable Integer page
    , @PathVariable Integer limit) {
        PageInfo<Brand> pageInfo =  brandService.findByPage(page,limit);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }
    //添加
    @PostMapping("/save")
    public Result<Void> save (@RequestBody Brand brand){
        brandService.save(brand);
        return Result.build(null, ResultCodeEnum.SUCCESS);

    }
}
