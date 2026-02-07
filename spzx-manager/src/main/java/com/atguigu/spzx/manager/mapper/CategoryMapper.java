package com.atguigu.spzx.manager.mapper;/**
 * ClassName: CategoryMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/5 22:44
 * @Version 1.0
 */

import com.atguigu.spzx.model.entity.product.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2026/2/5 22:44</p>
 * <p>作者：王贤 </p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 * 维护单：<br>
 * 修改日期：<br>
 * 修改人：<br>
 * 修改内容：<br>
 */
@Mapper
public interface CategoryMapper {


    List<Category> selectByParentId(Long parentId);
    // 查询该分类下子分类的数量

    int countByParentId(Long id);

    List<Category> selectAll();


    void batchInsert(List cachedDataList);

}
