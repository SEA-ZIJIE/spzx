package com.atguigu.spzx.manager.controller;

import com.atguigu.spzx.model.dto.system.LoginDto;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.model.vo.system.LoginVo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.atguigu.spzx.manager.service.SysUserService;
/**
 * ClassName: IndexController
 * Package: com.atguigu.spzx.manager.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/17 11:46
 * @Version 1.0
 */


@Tag(name = "用户接口")
@RestController
@RequestMapping(value = "/admin/system/index")
public class IndexController {

    @Resource
    private SysUserService sysUserService;

    //用户登录
    @PostMapping("login")
    public Result<Void> login(@RequestBody LoginDto loginDto){
        LoginVo loginVo =  sysUserService.login(loginDto);
        return Result.build(loginVo, ResultCodeEnum.SYSTEM_ERROR.SUCCESS);
    }






}