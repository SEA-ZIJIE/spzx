package com.atguigu.spzx.product.service;/**
 * ClassName: BrandService
 * Package: com.atguigu.spzx.product.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/17 13:07
 * @Version 1.0
 */

import com.atguigu.spzx.model.entity.product.Brand;

import java.util.List;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2025/10/17 13:07</p>
 * <p>作者：王贤 </p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 * 维护单：<br>
 * 修改日期：<br>
 * 修改人：<br>
 * 修改内容：<br>
 */
public interface BrandService {

//    获取全部品牌
    List<Brand> findAll();
}
