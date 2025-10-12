package com.atguigu.spzx.manager.service.impl;

import com.atguigu.spzx.manager.mapper.ProductUnitMapper;
import com.atguigu.spzx.manager.service.ProductUnitService;
import com.atguigu.spzx.model.entity.base.ProductUnit;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: ProductUnitServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/2 11:56
 * @Version 1.0
 */

@Service
public class ProductUnitServiceImpl implements ProductUnitService {

    @Resource
    private ProductUnitMapper productUnitMapper;
    @Override
    //查询计量单位
    public List<ProductUnit> findAll() {
        return productUnitMapper.findAll();
    }
}
