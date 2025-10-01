package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.ProductService;

import com.atguigu.spzx.model.dto.product.ProductDto;
import com.atguigu.spzx.model.entity.product.Product;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ProductController
 * Package: com.atguigu.spzx.manager.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/1 12:45
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/admin/product/product")
public class ProductController {

    @Resource
    private ProductService productService;
    //列表（条件分页查询）
    @GetMapping("/{page}/{limit}")
    public Result list(@PathVariable("page") Integer page,
                       @PathVariable("limit") Integer limit,
                       ProductDto productDto){
        PageInfo<Product> pageInfo =  productService.findByPage(page,limit,productDto);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);

    }
}
