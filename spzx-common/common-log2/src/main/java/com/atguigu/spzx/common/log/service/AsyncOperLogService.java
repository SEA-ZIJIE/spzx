package com.atguigu.spzx.common.log.service;

import com.atguigu.spzx.model.entity.system.SysOperLog;

/**
 * ClassName: AsyncOperLogService
 * Package: com.atguigu.spzx.common.log.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2026/2/7 19:55
 * @Version 1.0
 */


public interface AsyncOperLogService {			// 保存日志数据
    public abstract void saveSysOperLog(SysOperLog sysOperLog) ;
}

