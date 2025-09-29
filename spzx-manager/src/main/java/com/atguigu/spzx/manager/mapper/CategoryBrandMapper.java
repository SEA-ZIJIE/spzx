package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.dto.product.CategoryBrandDto;
import com.atguigu.spzx.model.entity.product.CategoryBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: CategoryBrandMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/29 19:35
 * @Version 1.0
 */
@Mapper
public interface CategoryBrandMapper {
    //分类品牌的条件分页查询
   List<CategoryBrand> findByPage(CategoryBrandDto categoryBrandDto) {

    }
}
