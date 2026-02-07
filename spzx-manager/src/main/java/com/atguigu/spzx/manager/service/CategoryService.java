package com.atguigu.spzx.manager.service;/**
 * ClassName: CategoryService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/5 21:48
 * @Version 1.0
 */

import com.atguigu.spzx.model.entity.product.Category;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2026/2/5 21:48</p>
 * <p>作者：王贤 </p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 * 维护单：<br>
 * 修改日期：<br>
 * 修改人：<br>
 * 修改内容：<br>
 */
public interface CategoryService {
//    根据parentId获取下级节点
    List<Category> findByParentId(Long parentId);
    //数据导出导入
    void exportData(HttpServletResponse response);
    //数据导出导入

    void importData(MultipartFile file);
}
