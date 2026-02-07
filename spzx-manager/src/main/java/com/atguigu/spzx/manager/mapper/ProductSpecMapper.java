package com.atguigu.spzx.manager.mapper;/**
 * ClassName: ProductSpecMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/7 13:26
 * @Version 1.0
 */

import com.atguigu.spzx.model.entity.product.ProductSpec;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2026/2/7 13:26</p>
 * <p>作者：王贤 </p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 * 维护单：<br>
 * 修改日期：<br>
 * 修改人：<br>
 * 修改内容：<br>
 */
@Mapper
public interface ProductSpecMapper {
    //列表查询
    List<ProductSpec> findByPage();
    //添加

    void save(ProductSpec productSpec);
    //修改

    void updateById(ProductSpec productSpec);
    //删除

    void deleteById(Long id);

}
