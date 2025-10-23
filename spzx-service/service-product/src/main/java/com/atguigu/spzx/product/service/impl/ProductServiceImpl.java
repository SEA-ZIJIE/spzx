package com.atguigu.spzx.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.spzx.model.dto.h5.ProductSkuDto;
import com.atguigu.spzx.model.entity.product.Product;
import com.atguigu.spzx.model.entity.product.ProductDetails;
import com.atguigu.spzx.model.entity.product.ProductSku;
import com.atguigu.spzx.model.vo.h5.ProductItemVo;
import com.atguigu.spzx.product.mapper.ProductDetailsMapper;
import com.atguigu.spzx.product.mapper.ProductMapper;
import com.atguigu.spzx.product.mapper.ProductSkuMapper;
import com.atguigu.spzx.product.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

//        根据skuId获取商品的sku信

        ProductSku productsku = productSkuMapper.getById(skuId);
//        根据第二步获取sku，从sku中获取productId,获取商品信息

        Long productId =  productsku.getProductId();
        Product product = productMapper.getById(productId);

//        根据producId获取商品的详情信息

         ProductDetails productDetails = productDetailsMapper.getByProductId(productId);
//        封装map集合 ==商品规格对应商品skuId信息

        Map<String,Object> skuSpecValueMap = new HashMap<>();
//        根据id获取商品所有sku列表

        List<ProductSku> productSkuList =productSkuMapper.findByProductId(productId);
        productSkuList.forEach(item ->{
            skuSpecValueMap.put(item.getSkuSpec(),item.getId());
        });
//        把需要数据封装到productItemVo里面

        productItemVo.setProduct(product);
        productItemVo.setProductSku(productsku);
        productItemVo.setSkuSpecValueMap(skuSpecValueMap);
//封装详情图片list集合
        String imageUrls = productDetails.getImageUrls();
        String[] split = imageUrls.split(",");
        List<String> list = Arrays.asList(split);

        productItemVo.setDetailsImageUrlList(Arrays.asList(productDetails.getImageUrls().split(",")));
//封装轮播图
        productItemVo.setSliderUrlList(Arrays.asList(product.getSliderUrls().split(",")));

//        @Schema(description = "商品规格信息")
//        private JSONArray specValueList;

        productItemVo.setSpecValueList(JSON.parseArray(product.getSpecValue()));
        return productItemVo;
    }

    @Override
    public ProductSku getBySkuId(Long skuId) {
        ProductSku productSku = productSkuMapper.getById(skuId);
        return null;
    }
}
