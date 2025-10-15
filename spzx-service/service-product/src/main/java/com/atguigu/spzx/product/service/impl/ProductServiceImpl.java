package com.atguigu.spzx.product.service.impl;

import com.atguigu.spzx.model.entity.product.ProductSku;
import com.atguigu.spzx.product.mapper.ProductSkuMapper;
import com.atguigu.spzx.product.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: ProductServiceImpl
 * Package: com.atguigu.spzx.product.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/15 0:40
 * @Version 1.0
 */

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductSkuMapper productSkuMapper;

    @Override
    public List<ProductSku> selectProductSkuBySale() {



        return productSkuMapper.selectProductSkuBySale();
    }
}
