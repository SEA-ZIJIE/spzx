package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.SysUserService;
import com.atguigu.spzx.model.dto.system.AssginRoleDto;
import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysUser;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: SysUserController
 * Package: com.atguigu.spzx.manager.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/21 18:43
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/admin/system/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    //1 用户条件分页查询接口
    @GetMapping(value = "/findByPage/{pageNum}/{pageSize}")
    public Result<Void> findByPage( @PathVariable("pageNum") Integer pageNum,
                                    @PathVariable("pageSize") Integer pageSize,
                                    SysRoleDto sysUserDto){
        PageInfo<SysUser> pageInfo = sysUserService.findByPage(pageNum,pageSize,sysUserDto);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);

    }

    //2 用户的添加
    @PostMapping("/saveSysUser")
    public Result<Void> saveSysUser(@RequestBody SysUser sysUser){
        sysUserService.saveSysUser(sysUser);
        return Result.build(null, ResultCodeEnum.SUCCESS);

    }
    //3 用户的修改
    @PutMapping("/updateSysUser")

    public Result<Void> updateSysUser(@RequestBody SysUser sysUser) {
        sysUserService.updateSysUser(sysUser);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
    //4 用户的删除
    @DeleteMapping("/deleteById/{userId}")
    public Result<Void> deleteById(@PathVariable("userId") long userId){
        sysUserService.deleteById(userId);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
    //用户分配角色
    // 保存分配的数据
    @PostMapping("/doAssign")
    public Result<Void> doAssign(@RequestBody AssginRoleDto assginRoleDto){
        sysUserService.doAssign(assginRoleDto);
        return Result.build(null, ResultCodeEnum.SUCCESS);

    }

}
