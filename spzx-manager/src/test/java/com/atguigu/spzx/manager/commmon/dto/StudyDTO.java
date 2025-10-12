package com.atguigu.spzx.manager.commmon.dto;

import lombok.Data;

import java.util.Date;

/**
 * ClassName: StudyDTO
 * Package: com.atguigu.spzx.manager.commmon.dto
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/5 10:06
 * @Version 1.0
 */
// POJO 对象 用来存数据的
@Data
public class StudyDTO {

    private String name;
    private Integer age;
    private Float price;
    private Date createTime;
    private Double salary;
    private Boolean delFlag;


}
