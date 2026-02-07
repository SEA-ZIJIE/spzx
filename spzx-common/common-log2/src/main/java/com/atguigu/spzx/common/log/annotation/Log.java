package com.atguigu.spzx.common.log.annotation;

import org.apache.poi.ss.usermodel.DataValidationConstraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Log
 * Package: com.atguigu.spzx.common.log.annotation
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/7 19:40
 * @Version 1.0
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {		// 自定义操作日志记录注解

    public String title() ;								// 模块名称
    public DataValidationConstraint.OperatorType operatorType() default DataValidationConstraint.OperatorType.MANAGE;	// 操作人类别
    public int businessType() ;     // 业务类型（0其它 1新增 2修改 3删除）
    public boolean isSaveRequestData() default true;   // 是否保存请求的参数
    public boolean isSaveResponseData() default true;  // 是否保存响应的参数

}