package com.atguigu.spzx.manager.service;/**
 * ClassName: CategoryBrandService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/6 20:26
 * @Version 1.0
 */

import com.atguigu.spzx.model.dto.product.CategoryBrandDto;
import com.atguigu.spzx.model.entity.product.CategoryBrand;
import com.github.pagehelper.PageInfo;

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
public interface CategoryBrandService {

    //分类品牌列表接口
    PageInfo<CategoryBrand> findByPage(Integer page, Integer limit, CategoryBrandDto categoryBrandDto);
    //添加功能
    void save(CategoryBrand categoryBrand);
    //修改功能
    void updateById(CategoryBrand categoryBrand);

    //删除功能

    void deleteById(Integer id);
}
