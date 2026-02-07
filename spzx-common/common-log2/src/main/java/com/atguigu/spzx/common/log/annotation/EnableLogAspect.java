package com.atguigu.spzx.common.log.annotation;/**
 * ClassName: EnableLogAspect
 * Package: com.atguigu.spzx.common.log.annotation
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/7 19:47
 * @Version 1.0
 */

import com.atguigu.spzx.common.log.aspect.LogAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(value = LogAspect.class)            // 通过Import注解导入日志切面类到Spring容器中
public @interface EnableLogAspect {

}