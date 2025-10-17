package com.atguigu.spzx.product.service.impl;/**
 * ClassName: BrandServiceImpl
 * Package: com.atguigu.spzx.product.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/17 13:07
 * @Version 1.0
 */

import com.atguigu.spzx.model.entity.product.Brand;
import com.atguigu.spzx.product.mapper.BrandMapper;
import com.atguigu.spzx.product.service.BrandService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;


    //    获取全部品牌
    @Override
    public List<Brand> findAll() {
        return brandMapper.findAll();
    }
}
