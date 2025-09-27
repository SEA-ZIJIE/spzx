package com.atguigu.spzx.manager.test;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ExcelListener
 * Package: com.atguigu.spzx.manager.test
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/27 15:47
 * @Version 1.0
 */


public class ExcelListener<T> extends AnalysisEventListener<T> {

    private List<T> data = new ArrayList<T>();
    //读取excle内容，从第二行开始读取，把每行读取内容封装到t对象里面
    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        data.add(t);
    }
    public List<T> getData(){
        return data;
    }
    //
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
