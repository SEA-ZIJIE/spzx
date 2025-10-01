package com.atguigu.spzx.manager.service.impl;

import com.atguigu.spzx.manager.mapper.ProductMapper;
import com.atguigu.spzx.manager.service.ProductService;
import com.atguigu.spzx.model.dto.product.ProductDto;
import com.atguigu.spzx.model.entity.product.Product;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: ProductServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/1 12:46
 * @Version 1.0
 */

@Service
public class ProductServiceImpl implements ProductService {

@Resource
private ProductMapper productMapper;
    //列表（条件分页查询）
    @Override
    public PageInfo<Product> findByPage(Integer page,
                                        Integer limit,
                                        ProductDto productDto) {
        PageHelper.startPage(page, limit);
        List<Product> list = productMapper.findByPage(productDto);
        return new PageInfo<>(list);

    }
}
