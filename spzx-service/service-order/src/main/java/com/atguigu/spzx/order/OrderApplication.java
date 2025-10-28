package com.atguigu.spzx.order;

import com.atguigu.spzx.common.anno.EnableUserLoginAuthInterceptor;
import com.atguigu.spzx.common.anno.EnableUserTokenFeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: OrderApplication
 * Package: com.atguigu.spzx.order
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/26 17:08
 * @Version 1.0
 */


@SpringBootApplication
@EnableFeignClients(basePackages = {"com.atguigu.spzx"})
@EnableUserTokenFeignInterceptor
@EnableUserLoginAuthInterceptor
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class , args) ;
    }

}