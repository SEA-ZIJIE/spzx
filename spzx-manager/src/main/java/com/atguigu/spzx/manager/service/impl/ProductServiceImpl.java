package com.atguigu.spzx.manager.service.impl;

import com.atguigu.spzx.manager.mapper.ProductDetailsMapper;
import com.atguigu.spzx.manager.mapper.ProductMapper;
import com.atguigu.spzx.manager.mapper.ProductSkuMapper;
import com.atguigu.spzx.manager.service.ProductService;
import com.atguigu.spzx.model.dto.product.ProductDto;
import com.atguigu.spzx.model.entity.product.Product;
import com.atguigu.spzx.model.entity.product.ProductDetails;
import com.atguigu.spzx.model.entity.product.ProductSku;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: ProductServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/1 12:46
 * @Version 1.0
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductSkuMapper productSkuMapper;

    @Resource
    private ProductDetailsMapper productDetailsMapper;


    //列表（条件分页查询）
    @Override
    public PageInfo<Product> findByPage(Integer page,
                                        Integer limit,
                                        ProductDto productDto) {
        PageHelper.startPage(page, limit);
        List<Product> list = productMapper.findByPage(productDto);
        return new PageInfo<>(list);

    }

    //添加商品信息
    @Override
    public void save(Product product) {
        //保存商品基本信息 product表
        product.setStatus(0);
        product.setAuditStatus(0);
        productMapper.save(product);

        //获取商品的sku列表集合，保存sku信息，product_sku

        List<ProductSku> productSkuList = product.getProductSkuList();
        for (int i=0;i<productSkuList.size();i++){
            ProductSku productSku = productSkuList.get(i);
//            商品编号
        productSku.setSkuCode(product.getId()+"_"+i);
//            商品ID
            productSku.setProductId(product.getId());
//            skuName
            productSku.setSkuName(product.getName()+productSku.getSkuSpec());
            productSku.setStatus(0);
            productSku.setStatus(0);
            productSkuMapper.save(productSku);


        }

//      保存商品详情数据product_details表
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductId(product.getId());
        productDetails.setImageUrls(product.getDetailsImageUrls());
        productDetailsMapper.save(productDetails);
    }

    //    根据商品id查询商品的信息
    @Override
    public Product getById(Long id) {
//        根据id查询商品的基本信息product
        Product product = productMapper.findProductById(id);
//        根据商品id查询商品sku信息列表 product_sku
        List<ProductSku> productSkuList = productSkuMapper.findProductSkuByProductId(id);
        product.setProductSkuList(productSkuList);
//        根据商品id删除商品详情数据produc_details
        ProductDetails productDetails = productDetailsMapper.findProductDetailsById(id);
        String imageUrls = productDetails.getImageUrls();
        product.setDetailsImageUrls(imageUrls);

        return product;
    }

    //    保存修改数据
    @Override
    public void update(Product product) {
//      修改product
        productMapper.updataById(product);
//      修改product_sku
        List<ProductSku> productSkuList = product.getProductSkuList();
        productSkuList.forEach(productSku -> {
            productSkuMapper.updateById(productSku);
        });
//      修改 product_details

        String detailsImageUrls = product.getDetailsImageUrls();
        ProductDetails productDetails = productDetailsMapper.findProductDetailsById(product.getId());
        productDetails.setImageUrls(detailsImageUrls);
        productDetailsMapper.updateById(productDetails);

    }

    //     删除
    @Override
    public void deleteById(Long id) {
//        根据商品id删除product
        productMapper.deleteById(id);
//        根据id删除product_sku
        productSkuMapper.deleteProductId(id);
//        根据id删除product_details
        productDetailsMapper.deleteByproductId(id);
    }
}
