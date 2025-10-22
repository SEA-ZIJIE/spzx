package com.atguigu.spzx.product.controller;

import com.atguigu.spzx.model.dto.h5.ProductSkuDto;
import com.atguigu.spzx.model.entity.product.ProductSku;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.product.service.ProductService;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ProductController
 * Package: com.atguigu.spzx.product.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/17 13:52
 * @Version 1.0
 */

@Tag(name = "商品列表管理")
@RestController
@RequestMapping(value="/api/product")
@SuppressWarnings({"unchecked", "rawtypes"})
public class ProductController {

    @Resource
    private ProductService productService;

    @Operation(summary = "分页查询")
    @GetMapping(value ="/{page}/{limit}")
    public Result<Void> list(@PathVariable Integer page,
                             @PathVariable Integer limit,
                             ProductSkuDto productSkuDto) {
        PageInfo<ProductSkuDto> pageInfo = productService.findByPage(page, limit, productSkuDto);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }
//        远程调用：根据skuId返回sku信息
        @GetMapping("/getBySkuId/{skuId}")
        public ProductSku  getBySkuId(@PathVariable Long skuId){

        ProductSku productSku =  productService.getBySkuId(skuId);
        return productSku;


    }
}
