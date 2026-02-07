package com.atguigu.spzx.manager.service;/**
 * ClassName: ProductSpecService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/7 13:21
 * @Version 1.0
 */

import com.atguigu.spzx.model.entity.product.ProductSpec;
import com.github.pagehelper.PageInfo;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2026/2/7 13:21</p>
 * <p>作者：王贤 </p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 * 维护单：<br>
 * 修改日期：<br>
 * 修改人：<br>
 * 修改内容：<br>
 */
public interface ProductSpecService {
    //列表查询
    PageInfo<ProductSpec> findByPage(Integer page, Integer limit);
    //添加

    void save(ProductSpec productSpec);
    //修改

    void updateById(ProductSpec productSpec);
    //删除
    void deleteById(Long id);




}
