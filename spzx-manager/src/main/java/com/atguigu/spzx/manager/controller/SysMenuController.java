package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.SysMenuService;
import com.atguigu.spzx.model.entity.system.SysMenu;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
//菜单列表
@GetMapping("/findNodes")
public Result findNodes(){
    List<SysMenu> list = sysMenuService.findNodes();
    return Result.build(list, ResultCodeEnum.SUCCESS);


}


}
