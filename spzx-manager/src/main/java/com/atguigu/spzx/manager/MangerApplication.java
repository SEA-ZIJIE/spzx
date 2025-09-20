package com.atguigu.spzx.manager;

import com.atguigu.spzx.manager.properties.UserProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: MangerApplication
 * Package: com.atguigu.spzx.manager
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/17 11:44
 * @Version 1.0
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu.spzx"})
@EnableConfigurationProperties(value = {UserProperties.class})
public class MangerApplication {//创建启动类

    public static void main(String[] args) {
        SpringApplication.run(MangerApplication.class, args);
    }
}
