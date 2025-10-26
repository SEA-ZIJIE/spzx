package com.atguigu.spzx.user.controller;

import com.atguigu.spzx.model.entity.user.UserAddress;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.user.service.UserAddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: UserAddressController
 * Package: com.atguigu.spzx.user.controller
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/25 23:41
 * @Version 1.0
 */


@Tag(name = "用户地址接口")
@RestController
@RequestMapping(value="/api/user/userAddress")
@SuppressWarnings({"unchecked", "rawtypes"})
public class UserAddressController {

    @Resource
    private UserAddressService userAddressService;
    @Operation(summary = "获取用户地址列表")
    @GetMapping("auth/findUserAddressList")
    public Result<Void> findUserAddressList() {
        List<UserAddress> list = userAddressService.findUserAddressList();
        return Result.build(list , ResultCodeEnum.SUCCESS) ;

    }
}
