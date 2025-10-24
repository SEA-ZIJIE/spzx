package com.atguigu.spzx.feign.product;

import com.atguigu.spzx.model.entity.product.ProductSku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: ProductFeignClient
 * Package: com.atguigu.spzx.feign.product
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/24 0:41
 * @Version 1.0
 */

@FeignClient(value = "service - porduct")
public interface ProductFeignClient {

    @GetMapping("/api/product/getBySkuId/{skuId}")
    public ProductSku getBySkuId(@PathVariable("skuId") Long skuId);

}
