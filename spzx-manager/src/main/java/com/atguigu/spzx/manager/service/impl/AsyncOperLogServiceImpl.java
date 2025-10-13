package com.atguigu.spzx.manager.service.impl;/**
 * ClassName: AsyncOperLogServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/13 23:04
 * @Version 1.0
 */

import com.atguigu.spzx.common.log.service.AsyncOperLogService;
import com.atguigu.spzx.manager.mapper.SysOperLogMapper;
import com.atguigu.spzx.model.entity.system.SysOperLog;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AsyncOperLogServiceImpl implements AsyncOperLogService {

    @Resource
    private SysOperLogMapper sysOperLogMapper;
//    保存日记数据
    @Override
    public void saveSysOperLog(SysOperLog sysOperLog) {
        sysOperLogMapper.insert(sysOperLog);
    }
}
