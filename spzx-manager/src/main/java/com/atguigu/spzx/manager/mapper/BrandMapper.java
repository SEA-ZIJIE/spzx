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
 * @Create 2025/9/28 12:48
 * @Version 1.0
 */

@Mapper
public interface BrandMapper {

    //列表
    List<Brand> findByPage();

    //添加
    void save(Brand brand);

    //查询所有品牌
    List<Brand> findAll();

}
