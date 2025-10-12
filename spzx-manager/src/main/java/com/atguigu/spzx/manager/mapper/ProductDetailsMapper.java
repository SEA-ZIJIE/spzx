package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.product.ProductDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: ProductDetailsMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/2 15:46
 * @Version 1.0
 */

@Mapper
public interface ProductDetailsMapper {
//    添加
    void save(ProductDetails productDetails);
//        根据商品id删除商品详情数据produc_details
    ProductDetails findProductDetailsById(Long id);

    //      修改 product_details
    void updateById(ProductDetails productDetails);
//        根据id删除product_details

    void deleteByproductId(Long id);
}
