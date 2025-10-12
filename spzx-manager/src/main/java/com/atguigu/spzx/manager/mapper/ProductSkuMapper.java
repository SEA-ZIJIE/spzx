package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.product.ProductSku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: ProductSkuMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/2 15:44
 * @Version 1.0
 */

@Mapper
public interface ProductSkuMapper {
// 添加
    void save(ProductSku productSku);
//  根据商品id查询商品sku信息列表 product_sku
    List<ProductSku> findProductSkuByProductId(Long id);

    //      修改product_sku
    void updateById(ProductSku productSku);
//        根据id删除product_sku

    void deleteProductId(Long id);

}
