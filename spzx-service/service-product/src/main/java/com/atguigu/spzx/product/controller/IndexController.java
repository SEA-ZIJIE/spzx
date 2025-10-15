package com.atguigu.spzx.product.controller;

import com.atguigu.spzx.model.entity.product.Category;
import com.atguigu.spzx.model.entity.product.ProductSku;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.model.vo.h5.IndexVo;
import com.atguigu.spzx.product.service.CategoryService;
import com.atguigu.spzx.product.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: IndexController
 * Package: com.atguigu.spzx.product.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/14 23:32
 * @Version 1.0
 */

@Tag(name = "首页接口管理")
@RestController
@RequestMapping(value = "/api/product/index")
public class IndexController {
    @Resource
    private ProductService  productService;
    @Resource
    private CategoryService categoryService;

    @GetMapping
    public Result<Void> index(){
        //所有的一级分类
        List<Category> categoryList = categoryService.selectOneCategory();


        //根据销量排序，获取前十条记录
        List<ProductSku> productSkuList = productService.selectProductSkuBySale();

        //封装数据到vo数据对象中去
        IndexVo indexVo = new IndexVo();
        indexVo.setCategoryList(categoryList);
        indexVo.setProductSkuList(productSkuList);
        return Result.build(indexVo, ResultCodeEnum.SUCCESS);
    }
}
