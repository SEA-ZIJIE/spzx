package com.atguigu.spzx.common.exception;

import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import lombok.Data;

/**
 * ClassName: GuiguException
 * Package: com.atguigu.spzx.common.exception
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/18 19:43
 * @Version 1.0
 */

@Data
public class GuiguException extends RuntimeException {

    private Integer code;
    private String message;

    private ResultCodeEnum resultCodeEnum;


    public GuiguException(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }
 }
