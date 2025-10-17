package com.atguigu.spzx.product.mapper;

import com.atguigu.spzx.model.entity.product.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: BrandMapper
 * Package: com.atguigu.spzx.product.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/17 13:08
 * @Version 1.0
 */

@Mapper
public interface BrandMapper {
    //    获取全部品牌
    List<Brand> findAll();

}
