package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.ProductService;

import com.atguigu.spzx.model.dto.product.ProductDto;
import com.atguigu.spzx.model.entity.product.Product;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: ProductController
 * Package: com.atguigu.spzx.manager.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/1 12:45
 * @Version 1.0
 */
@Tag(name = "商品管理")
@RestController
@RequestMapping(value = "/admin/product/product")
public class ProductController {

    @Resource
    private ProductService productService;

//    上下架


//    审核

//     删除
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@Parameter(name = "id", description = "商品id", required = true) @PathVariable Long id) {
        productService.deleteById(id);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }
//    保存修改数据
    @PutMapping("/updateById")
    public Result update(@RequestBody Product product){

        productService.update(product);
        return Result.build(null, ResultCodeEnum.SUCCESS);


    }

//    根据商品id查询商品的信息
    @GetMapping("/getById/{id}")
    public Result<Void> getById(@PathVariable Long id) {
        Product product =  productService.getById(id);
        return Result.build(product, ResultCodeEnum.SUCCESS);

    }

    //添加商品信息
    @PostMapping("/save")
    public Result<Void> save(@RequestBody Product product){
        productService.save(product);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
    //列表（条件分页查询）
    @GetMapping("/{page}/{limit}")
    public Result list(@PathVariable("page") Integer page,
                       @PathVariable("limit") Integer limit,
                       @RequestBody ProductDto productDto){
        PageInfo<Product> pageInfo =  productService.findByPage(page,limit,productDto);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);

    }
}
