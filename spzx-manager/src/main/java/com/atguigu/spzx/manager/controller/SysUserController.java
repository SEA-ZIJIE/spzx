package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.manager.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //2 用户的添加

    //3 用户的修改

    //4 用户的删除


}
