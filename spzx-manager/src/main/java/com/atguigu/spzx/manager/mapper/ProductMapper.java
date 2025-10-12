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

    //保存商品基本信息 product表
    void save(Product product);
//        根据id查询商品的基本信息product
    Product findProductById(Long id);

    //      修改product
    void updataById(Product product);

    //        根据商品id删除product
    void deleteById(Long id);





}
