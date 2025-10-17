package com.atguigu.spzx.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.spzx.model.entity.product.Category;
import com.atguigu.spzx.product.mapper.CategoryMapper;
import com.atguigu.spzx.product.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * ClassName: CategoryServiceImpl
 * Package: com.atguigu.spzx.product.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/15 0:39
 * @Version 1.0
 */

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public List<Category> selectOneCategory() {
//        查询redis，是否有一级分类
        String categoryOneJson =  redisTemplate.opsForValue().get("category:one");
//        如果包含所有的一节分类，直接返回
        if(!StringUtils.hasText(categoryOneJson)){
            List<Category> existCategoryList = JSON.parseArray(categoryOneJson, Category.class);
            return  existCategoryList;
        }
//        如果redis没有一级分类，查询数据库，把数据库内容返回，并且放到redis中

        List<Category> categoryList = categoryMapper.selectOneCategory();
        redisTemplate.opsForValue().set("category:one",JSON.toJSONString(categoryList),7, TimeUnit.DAYS);
        return categoryMapper.selectOneCategory();
    }

    @Cacheable(value = "category",key="'all'")
    @Override
    public List<Category> findCategoryTree() {
//        查询所有分类返回list集合
    List<Category> allCategoryList = categoryMapper.findAll();

//        遍历所有分类list集合，通过条件得到所有的一级分类

        List<Category> oneCategoryList =
                allCategoryList.stream().filter(item -> item.getParentId().longValue() == 0)
                        .collect(Collectors.toList());
//    遍历所有一级分类list集合，条件判断 id=praentid，得到二级分类
        oneCategoryList.forEach(oneCategory -> {
            List<Category> twoCategoryList =
                    allCategoryList.stream()
                            .filter(item -> item.getParentId() == oneCategory.getId())
                            .collect(Collectors.toList());
//     二级分类封装到一级分类里面
    oneCategory.setChildren(twoCategoryList);
//            遍历二级分类，得到下面三级分类
            twoCategoryList.forEach(twoCategory ->{
                List<Category> threeCategoryList =
                allCategoryList.stream()
                        .filter(item -> item.getParentId() == twoCategory.getId())
                        .collect(Collectors.toList());

//     三级分类封装到二级分类里面
                twoCategory.setChildren(threeCategoryList);

            });


        });

        return oneCategoryList;

    }
}
