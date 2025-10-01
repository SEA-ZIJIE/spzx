package com.atguigu.spzx.manager.mapper;


import com.atguigu.spzx.model.dto.product.ProductDto;
import com.atguigu.spzx.model.entity.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: ProductMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/1 12:47
 * @Version 1.0
 */

@Mapper
public interface ProductMapper {

    //列表（条件分页查询）
    List<Product> findByPage(ProductDto productDto);
}
