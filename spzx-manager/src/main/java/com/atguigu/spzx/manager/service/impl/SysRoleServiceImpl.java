package com.atguigu.spzx.manager.service.impl;/**
 * ClassName: SysRoleServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/20 16:55
 * @Version 1.0
 */

import com.atguigu.spzx.manager.mapper.SysRoleMapper;
import com.atguigu.spzx.manager.service.SysRoleService;
import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;
    //角色列表的方法

    @Override
    public PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer current, Integer limit) {

        //设置分页的相关参数
        PageHelper.startPage(current,limit);
        //根据条件查询数据库
        List<SysRole> list =  sysRoleMapper.findByPage(sysRoleDto);
        //封装对象
        PageInfo<SysRole> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }
}
