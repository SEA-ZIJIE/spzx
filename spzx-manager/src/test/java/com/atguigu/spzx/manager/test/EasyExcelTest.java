package com.atguigu.spzx.manager.test;

import com.alibaba.excel.EasyExcel;
import com.atguigu.spzx.model.vo.product.CategoryExcelVo;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: EasyExcelTest
 * Package: com.atguigu.spzx.manager.test
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/27 15:44
 * @Version 1.0
 */


public class EasyExcelTest {
    public static void main(String[] args) {
        write();

    }
    //读操作
    public static void read(){
        //定义读取excel文件的位置
        String fileName ="D://01.xlsx";
        //调用方法
        ExcelListener<CategoryExcelVo> excelListener = new ExcelListener();
        EasyExcel.read(fileName, CategoryExcelVo.class,excelListener)
                .sheet().doRead();
        List<CategoryExcelVo> data = excelListener.getData();
        System.out.println(data);

    }

    //写操作
    public static void write(){
        List<CategoryExcelVo> list = new ArrayList<>();
        list.add(new CategoryExcelVo(1L , "数码办公" , "",0L, 1, 1)) ;
        list.add(new CategoryExcelVo(11L , "华为手机" , "",1L, 1, 2)) ;
        EasyExcel.write("D://01.xlsx",CategoryExcelVo.class)
                .sheet("分类数据").doWrite(list);
    }
}
