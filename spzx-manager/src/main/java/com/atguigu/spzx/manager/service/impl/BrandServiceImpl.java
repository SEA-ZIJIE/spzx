package com.atguigu.spzx.manager.service.impl;

import com.atguigu.spzx.manager.mapper.BrandMapper;
import com.atguigu.spzx.manager.service.BrandService;
import com.atguigu.spzx.model.entity.product.Brand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: BrandServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/6 11:10
 * @Version 1.0
 */

@Service
public class BrandServiceImpl implements BrandService {


    //列表查询
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageInfo<Brand> findByPage(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Brand> brandList = brandMapper.findByPage();
        return new PageInfo(brandList);
    }
    //品牌添加

    @Override
    public void save(Brand brand) {
        brandMapper.save(brand) ;

    }
    //修改品牌

    @Override
    public void updateById(Brand brand) {
        brandMapper.updateById(brand) ;


    }
    //删除品牌

    @Override
    public void deleteById(Long id) {
        brandMapper.deleteById(id) ;

    }

    @Override
    public List<Brand> findAll() {
         return brandMapper.findAll();

    }
}
