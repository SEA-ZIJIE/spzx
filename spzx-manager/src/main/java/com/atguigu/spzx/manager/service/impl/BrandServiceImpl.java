package com.atguigu.spzx.manager.service.impl;

import com.atguigu.spzx.manager.mapper.BrandMapper;
import com.atguigu.spzx.manager.service.BrandService;
import com.atguigu.spzx.model.entity.product.Brand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: BrandServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/28 13:00
 * @Version 1.0
 */

@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    //列表
    @Override
    public PageInfo<Brand> findByPage(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Brand> list = brandMapper.findByPage();
        PageInfo<Brand> pageIndfo = new PageInfo<>(list);
        return pageIndfo;

    }

    //添加
    @Override
    public void save(Brand brand) {
        brandMapper.save(brand);
    }
}
