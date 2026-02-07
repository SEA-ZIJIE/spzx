package com.atguigu.spzx.manager;

import com.atguigu.spzx.common.log.annotation.EnableLogAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * ClassName: MangerApplication
 * Package: com.atguigu.spzx.manager
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/17 11:44
 * @Version 1.0
 */
@EnableLogAspect
@EnableAsync
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu.spzx"})
public class MangerApplication {//创建启动类

    public static void main(String[] args) {
        SpringApplication.run(MangerApplication.class, args);
    }
}
