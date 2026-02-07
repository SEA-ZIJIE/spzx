package com.atguigu.spzx.manager.service.impl;/**
 * ClassName: CategoryBrandServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/6 20:26
 * @Version 1.0
 */

import com.atguigu.spzx.manager.mapper.CategoryBrandMapper;
import com.atguigu.spzx.manager.service.CategoryBrandService;
import com.atguigu.spzx.model.dto.product.CategoryBrandDto;
import com.atguigu.spzx.model.entity.product.CategoryBrand;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2026/2/6 20:26</p>
 * <p>作者：王贤 </p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 * 维护单：<br>
 * 修改日期：<br>
 * 修改人：<br>
 * 修改内容：<br>
 */
@Service
public class CategoryBrandServiceImpl implements CategoryBrandService {

@Autowired
private CategoryBrandMapper categoryBrandMapper;
    //分类品牌列表接口
    @Override
    public PageInfo<CategoryBrand> findByPage(Integer page, Integer limit, CategoryBrandDto CategoryBrandDto) {
    List<CategoryBrand> categoryBrandList =categoryBrandMapper.findByPage(CategoryBrandDto) ;
        return new PageInfo<>(categoryBrandList);
    }


    //添加功能
    @Override
    public void save(CategoryBrand categoryBrand) {

        categoryBrandMapper.save(categoryBrand);

    }
    //修改功能
    @Override
    public void updateById(CategoryBrand categoryBrand) {
        categoryBrandMapper.updateById(categoryBrand) ;

    }
    //删除功能

    @Override
    public void deleteById(Integer id) {
        categoryBrandMapper.deleteById(id) ;


    }


}

