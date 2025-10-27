package com.atguigu.spzx.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * ClassName: GatewayApplication
 * Package: com.atguigu.spzx.product
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/14 16:32
 * @Version 1.0
 */


@SpringBootApplication
@EnableCaching
    public class GatewayApplication {

        public static void main(String[] args) {
            SpringApplication.run(GatewayApplication.class, args);
        }

    }
