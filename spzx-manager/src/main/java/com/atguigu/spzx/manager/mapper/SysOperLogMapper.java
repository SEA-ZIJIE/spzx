package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.system.SysOperLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: SysOperLogMapper
 * Package: com.atguigu.spzx.manager.mapper
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/13 23:22
 * @Version 1.0
 */

@Mapper
public interface SysOperLogMapper {
    //    保存日记数据
    void insert(SysOperLog sysOperLog);

}
