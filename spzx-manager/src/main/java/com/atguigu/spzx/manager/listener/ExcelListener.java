package com.atguigu.spzx.manager.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.atguigu.spzx.manager.mapper.CategoryMapper;
import com.atguigu.spzx.model.vo.product.CategoryExcelVo;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * ClassName: ExceptionListener
 * Package: com.atguigu.spzx.manager.listener
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/27 21:17
 * @Version 1.0
 */

//监听器
public class ExcelListener implements ReadListener<T> {

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;
    /**
     * 缓存的数据
     */
    private List<T> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    //构造传递mapper，操作数据库
    private CategoryMapper categoryMapper;
    public ExcelListener(CategoryMapper categoryMapper){
        this.categoryMapper = categoryMapper;


    }
    //从第二行开始读取，把每行读取内容封装到对象中
    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        //把每行数据对象t放到list集合里面
        cachedDataList.add(t);
        if (cachedDataList.size() >= BATCH_COUNT) {

            //调用方法一次性批量添加数据库中
            saveData();
            //清理list集合
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    //保存数据
        saveData();
    }
    //保存的方法
    private void saveData() {
        categoryMapper.batchInsert((List<CategoryExcelVo>)cachedDataList);

    }

}
