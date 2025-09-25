package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.SysMenuService;
import com.atguigu.spzx.model.entity.system.SysMenu;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: SysMenuController
 * Package: com.atguigu.spzx.manager.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/24 15:28
 * @Version 1.0
 */

@RestController
@RequestMapping(value="/admin/system/sysMenu")
public class SysMenuController {
@Resource
private SysMenuService sysMenuService;

    //菜单的删除
    @DeleteMapping("removeById/{Id}")
    public Result removeById(@PathVariable("id") Long id){
        sysMenuService.removeById(id);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }

    //菜单修改
    @PutMapping("/update")
    public Result update(@RequestBody SysMenu sysMenu){
    sysMenuService.update(sysMenu);
    return Result.build(null,ResultCodeEnum.SUCCESS);
    }
    //菜单添加
    @PostMapping("/save")
    public Result save(@RequestBody SysMenu sysMenu){
    sysMenuService.save(sysMenu);
    return Result.build(null,ResultCodeEnum.SUCCESS);
    }
    //菜单列表
    @GetMapping("/findNodes")
    public Result findNodes(){
    List<SysMenu> list = sysMenuService.findNodes();
    return Result.build(list, ResultCodeEnum.SUCCESS);


}


}
