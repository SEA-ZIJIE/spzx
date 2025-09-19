package com.atguigu.spzx.utils;

import com.atguigu.spzx.model.entity.system.SysUser;

/**
 * ClassName: AuthContextUtil
 * Package: com.atguigu.spzx.utils
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/19 16:47
 * @Version 1.0
 */


public class AuthContextUtil {


    //创建一个threadLocal对象
    private static final ThreadLocal<SysUser> threadLocal = new ThreadLocal<>();
    //创建一个方法添加数据
    public static void set(SysUser sysUser){
        threadLocal.set(sysUser);
    }

    //从threadLocal获取数据

    public static SysUser get(){
        return threadLocal.get();
    }

    //删除数据

    public static void remove(){
        threadLocal.remove();

    }

}
