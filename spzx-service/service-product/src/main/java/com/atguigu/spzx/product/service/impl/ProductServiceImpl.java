package com.atguigu.spzx.product.service.impl;

import com.atguigu.spzx.model.dto.h5.ProductSkuDto;
import com.atguigu.spzx.model.entity.product.ProductSku;
import com.atguigu.spzx.product.mapper.ProductSkuMapper;
import com.atguigu.spzx.product.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public PageInfo<ProductSkuDto> findByPage(Integer page, Integer limit,
                                              ProductSkuDto productSkuDto) {
        PageHelper.startPage(page, limit);
        List<ProductSku> list = productSkuMapper.findByPage(ProductSkuDto);

        return new PageInfo<>(list);
    }
}
