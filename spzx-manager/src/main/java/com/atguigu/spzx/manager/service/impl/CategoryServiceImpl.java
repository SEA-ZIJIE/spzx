package com.atguigu.spzx.manager.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.spzx.common.exception.GuiguException;
import com.atguigu.spzx.manager.mapper.CategoryMapper;
import com.atguigu.spzx.manager.service.CategoryService;
import com.atguigu.spzx.model.entity.product.Category;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.model.vo.product.CategoryExcelVo;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: CategoryServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/26 22:24
 * @Version 1.0
 */


public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findCategoryList(Long id) {
        //根据id条件值进行查询
        List<Category> categoryList = categoryMapper.selectCategoryByParentId(id);

        // 遍历返回的list集合，
        // 判断每个分类是否有下一层分类，如果有设置hasChildren = true
        if (CollectionUtils.isEmpty(categoryList)) {
            categoryList.forEach(category -> {
                int count = categoryMapper.selectCountByParentId(category.getId());
                if (count > 0) {//下一层分类
                    category.setHasChildren(true);
                }else
                {
                    category.setHasChildren(false);
                }
            });
        }

        return categoryList;
    }

    //导出
    @Override
    public void exportData(HttpServletResponse response) {
        try{


            //设置响应的头信息和其他信息
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");

            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("分类数据", "UTF-8");
            //设置响应的头信息
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xlsx");
            //调用 mapper方法查询所有分类，返回list集合
            List<Category> categoryList = categoryMapper.findAll();

            List<CategoryExcelVo> categoryExcelVoList =  new ArrayList<>();
            for (Category category : categoryList) {
                CategoryExcelVo categoryExcelVo = new CategoryExcelVo();
                //把category值获取出来，设置到categoryExcelVo里面
//                Long id = category.getId();
//                categoryExcelVo.setId(id);
                BeanUtils.copyProperties(category, categoryExcelVo);
                categoryExcelVoList.add(categoryExcelVo);

            }
            //调用EasyExcel的write方法完成写操作
            EasyExcel.write(response.getOutputStream(), Category.class)
                    .sheet("分类数据").doWrite(categoryExcelVoList);
        }catch (Exception e){
            e.printStackTrace();
            throw  new GuiguException(ResultCodeEnum.DATA_ERROR);
        }


    }
}
