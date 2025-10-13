package com.atguigu.spzx.common.log.service;

import com.atguigu.spzx.model.entity.system.SysOperLog;

/**
 * ClassName: AsyncOperLogService
 * Package: com.atguigu.spzx.common.log.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/13 23:02
 * @Version 1.0
 */


public interface AsyncOperLogService {
    public abstract void saveSysOperLog(SysOperLog sysOperLog) ;


}
