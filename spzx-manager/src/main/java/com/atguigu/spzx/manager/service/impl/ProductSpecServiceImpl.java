package com.atguigu.spzx.manager.service.impl;/**
 * ClassName: ProductSpecServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/30 15:18
 * @Version 1.0
 */

import com.atguigu.spzx.manager.mapper.ProductSpecMapper;
import com.atguigu.spzx.manager.service.ProductSpecService;
import com.atguigu.spzx.model.entity.product.ProductSpec;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;

import java.util.List;

import static net.sf.jsqlparser.parser.feature.Feature.limit;


public class ProductSpecServiceImpl implements ProductSpecService {


    @Resource
    private ProductSpecMapper productSpecMapper;
    //列表
    @Override
    public PageInfo<ProductSpec> findByPage (Integer page,Integer limit ) {
        PageHelper.startPage(page,limit);
        List<ProductSpec> list =  productSpecMapper.findByPage();
        return new PageInfo<>(list);
    }
    //添加
    @Override
    public void save(ProductSpec productSpec){
        productSpecMapper.save(productSpec);

    }
    //修改
    @Override
    public void updateById(ProductSpec productSpec) {
    productSpecMapper.update(productSpec);
    }
    //删除
    @Override
    public void deleteById(Long id) {
    productSpecMapper.delete(id);
    }
}
