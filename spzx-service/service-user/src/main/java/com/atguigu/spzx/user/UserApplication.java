package com.atguigu.spzx.user;

import com.atguigu.spzx.common.anno.EnableUserLoginAuthInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: UserApplication
 * Package: com.atguigu.spzx.user.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/18 11:49
 * @Version 1.0
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu.spzx"})
@EnableUserLoginAuthInterceptor
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}