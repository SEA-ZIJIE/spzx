package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.base.ProductUnit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: ProductUnitMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/2 12:42
 * @Version 1.0
 */

@Mapper
public interface ProductUnitMapper {
    //查询计量单位
    List<ProductUnit> findAll();

}
