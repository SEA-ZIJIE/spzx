package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.ProductSpecService;
import com.atguigu.spzx.model.entity.product.ProductSpec;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: ProductSpecController
 * Package: com.atguigu.spzx.manager.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/30 12:18
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/admin/product/productSpec")
public class ProductSpecController {

    @Resource
    private ProductSpecService productSpecService;
    //列表
    @GetMapping("/{page}/{limit}")
    public Result<Void> List(@PathVariable Integer page,
                       @PathVariable Integer limit){
        PageInfo<ProductSpec> pageInfo =  productSpecService.findByPage(page,limit);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);

    }
    //添加的方法
    @PostMapping("/save")
    public Result<Void> save(@RequestBody ProductSpec productSpec){
        productSpecService.save(productSpec);
        return Result.build(null, ResultCodeEnum.SUCCESS);

    }
    //修改
    @PostMapping("/updateById")
    public Result<Void> updateById(@RequestBody ProductSpec productSpec){
        productSpecService.updateById(productSpec);
        return Result.build(null, ResultCodeEnum.SUCCESS);

    }
    //删除
    @DeleteMapping("/deleteById/{id}")
    public Result<Void> delete(@PathVariable Long id){
        productSpecService.deleteById(id);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

}
