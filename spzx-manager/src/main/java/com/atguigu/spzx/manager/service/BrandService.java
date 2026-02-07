package com.atguigu.spzx.manager.service;/**
 * ClassName: BrandService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/6 11:10
 * @Version 1.0
 */

import com.atguigu.spzx.model.entity.product.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2026/2/6 11:10</p>
 * <p>作者：王贤 </p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 * 维护单：<br>
 * 修改日期：<br>
 * 修改人：<br>
 * 修改内容：<br>
 */
public interface BrandService {
    //列表查询
    PageInfo<Brand> findByPage(Integer page, Integer limit);
    //品牌添加

    void save(Brand brand);
    //修改品牌

    void updateById(Brand brand);
    //删除品牌

    void deleteById(Long id);
    //品牌列表接口

    List<Brand> findAll();


}
