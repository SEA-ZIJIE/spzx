package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.product.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: BrandMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/6 11:28
 * @Version 1.0
 */

@Mapper
public interface BrandMapper {

    //列表查询

    List<Brand> findByPage();
    //品牌添加

    void save(Brand brand);
    //修改品牌

    void updateById(Brand brand);
    //删除品牌

    void deleteById(Long id);

    //品牌列表接口

    List<Brand> findAll();
}
