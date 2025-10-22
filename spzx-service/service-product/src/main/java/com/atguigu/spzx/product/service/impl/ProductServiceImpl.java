package com.atguigu.spzx.product.service.impl;

import com.atguigu.spzx.model.dto.h5.ProductSkuDto;
import com.atguigu.spzx.model.entity.product.Product;
import com.atguigu.spzx.model.entity.product.ProductDetails;
import com.atguigu.spzx.model.entity.product.ProductSku;
import com.atguigu.spzx.model.vo.h5.ProductItemVo;
import com.atguigu.spzx.product.mapper.ProductDetailsMapper;
import com.atguigu.spzx.product.mapper.ProductMapper;
import com.atguigu.spzx.product.mapper.ProductSkuMapper;
import com.atguigu.spzx.product.mapper.product;
import com.atguigu.spzx.product.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ProductServiceImpl
 * Package: com.atguigu.spzx.product.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/15 0:40
 * @Version 1.0
 */

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductSkuMapper productSkuMapper;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductDetailsMapper productDetailsMapper;

    @Override
    public List<ProductSku> selectProductSkuBySale() {
        return productSkuMapper.selectProductSkuBySale();
    }

    @Override
    public PageInfo<ProductSku> findByPage(Integer page, Integer limit,
                                              ProductSkuDto productSkuDto) {
        PageHelper.startPage(page,limit);
        List<ProductSku> list = productSkuMapper.findByPage(productSkuDto);

        return new PageInfo<>(list);
    }

//    商品详细接口

    @Override
    public ProductItemVo item(Long skuId){
//        创建vo对象，封装数据
        ProductItemVo productItemVo = new ProductItemVo();

//        根据skuId获取商品的sku信息

        productSku productsku = productSkuMapper.getById(skuId);
//        根据第二步获取sku，从sku中获取productId,获取商品信息

        Long productId =  productsku.getProductId();
        product product = productMapper.getById(productId);

//        根据producId获取商品的详情信息

         ProductDetails productDetails = productDetailsMapper.getByProductId(productId);
//        封装map集合 ==商品规格对应商品skuId信息

        Map<String,Object> skuSpecValueMap = new HashMap<String, Object>();
//        根据id获取商品所有sku列表

        List<Product> productSkuList =productSkuMapper.findByProductId(productId);

//        把需要数据封装到productItemVo里面


        return null;
    }

    @Override
    public ProductSku getBySkuId(Long skuId) {
        ProductSku productSku = productSkuMapper.getById(skuId);
        return null;
    }
}
