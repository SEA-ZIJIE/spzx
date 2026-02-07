package com.atguigu.spzx.manager.mapper;/**
 * ClassName: CategoryBrandMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/6 21:09
 * @Version 1.0
 */

import com.atguigu.spzx.model.dto.product.CategoryBrandDto;
import com.atguigu.spzx.model.entity.product.CategoryBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2026/2/6 21:09</p>
 * <p>作者：王贤 </p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 * 维护单：<br>
 * 修改日期：<br>
 * 修改人：<br>
 * 修改内容：<br>
 */
@Mapper
public interface CategoryBrandMapper {

    //分类品牌列表接口

     List<CategoryBrand> findByPage(CategoryBrandDto categoryBrandDto);
    //添加功能

    void save(CategoryBrand categoryBrand);
    //修改功能

    void updateById(CategoryBrand categoryBrand);
    //删除功能

    void deleteById(Integer id);

}
