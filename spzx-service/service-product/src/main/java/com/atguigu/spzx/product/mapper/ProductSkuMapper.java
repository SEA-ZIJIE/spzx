package com.atguigu.spzx.product.mapper;/**
 * ClassName: ProductSkuMapper
 * Package: com.atguigu.spzx.product.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/15 0:43
 * @Version 1.0
 */

import com.atguigu.spzx.model.entity.product.ProductSku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ProductSkuMapper {

    //根据销量排序，获取前10条记录
    List<ProductSku> selectProductSkuBySale();

}
