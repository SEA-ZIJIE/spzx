package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.SysRoleService;
import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import com.atguigu.spzx.model.vo.common.Result;

import org.springframework.web.bind.annotation.*;


/**
 * ClassName: SysRoleController
 * Package: com.atguigu.spzx.manager.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/20 16:37
 * @Version 1.0
 */


@RestController
@RequestMapping(value = "/admin/system/sysRole")
public class SysRoleController {



    @Resource
    private SysRoleService sysRoleService;


    //角色列表方法
    // current：当前页  limit：每页显示记录数  SysRoleDto 条件角色的名称
    @PostMapping("/findByPage/{current}/{limit}")
    public Result findByPage(@PathVariable("current")Integer current,
                             @PathVariable("limit")Integer limit,
                             @RequestBody SysRoleDto sysRoleDto ){
        //pageHelper插件实现分页
        PageInfo<SysRole> pageInfo = sysRoleService.findByPage(sysRoleDto,current,limit);
        return com.atguigu.spzx.model.vo.common.Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }
}
