package com.atguigu.spzx.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: ProductApplication
 * Package: com.atguigu.spzx.product
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/8 11:46
 * @Version 1.0
 */
@MapperScan("com.atguigu.spzx.product.mapper")
@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}