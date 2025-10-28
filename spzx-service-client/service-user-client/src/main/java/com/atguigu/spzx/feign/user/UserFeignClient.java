package com.atguigu.spzx.feign.user;

import com.atguigu.spzx.model.entity.user.UserAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: UserFeignClient
 * Package: com.atguigu.spzx.feign.user
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/28 15:10
 * @Version 1.0
 */

@FeignClient("service-user")
public interface UserFeignClient {
    @GetMapping("/api/user/userAddress/getUserAddress/{id}")
    public UserAddress getUserAddress(@PathVariable Long id);



}
