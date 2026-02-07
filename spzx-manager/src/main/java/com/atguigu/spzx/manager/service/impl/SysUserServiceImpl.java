package com.atguigu.spzx.manager.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.atguigu.spzx.common.exception.GuiguException;
import com.atguigu.spzx.manager.mapper.SysUserMapper;
import com.atguigu.spzx.manager.service.SysUserService;
import com.atguigu.spzx.model.dto.system.LoginDto;
import com.atguigu.spzx.model.entity.system.SysUser;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.model.vo.system.LoginVo;
import jakarta.annotation.Resource;
import org.ietf.jgss.GSSException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: SysUserServiceImpl
 * Package: com.atguigu.spzx.manager.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/17 15:48
 * @Version 1.0
 */

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public LoginVo login(LoginDto loginDto) {

//        根据用户名查询用户

        SysUser sysUser = sysUserMapper.selectUserInfoByUserName(loginDto.getUserName());
        if (sysUser == null) {
            throw new GuiguException(ResultCodeEnum.LOGIN_ERROR);

            /*throw new RuntimeException("用户名或密码错误");*/

        }
//        验证密码是否正确
        String password = loginDto.getPassword();
        DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(sysUser.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }
//        生成令牌保存到redis中
        String token = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set("user:login" + token, JSON.toJSONString(sysUser), 30, TimeUnit.MINUTES);

//        构建响应结果对象
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);
        loginVo.setRefresh_token("");
        // 校验验证码是否正确
        String captcha = loginDto.getCaptcha();     // 用户输入的验证码
        String codeKey = loginDto.getCodeKey();     // redis中验证码的数据key

        // 从Redis中获取验证码
        String redisCode = redisTemplate.opsForValue().get("user:login:validatecode:" + codeKey);
        if (StrUtil.isEmpty(redisCode) || !StrUtil.equalsIgnoreCase(redisCode, captcha)) {
            throw new GuiguException(ResultCodeEnum.VALIDATECODE_ERROR);
        }

        // 验证通过删除redis中的验证码
        redisTemplate.delete("user:login:validatecode:" + codeKey);

//        返回
        return loginVo;

    }

    @Override
    public SysUser getUserInfo(String token) {
        String userJson = redisTemplate.opsForValue().get("user:login:" + token);
        return JSON.parseObject(userJson , SysUser.class) ;
    }
    //退出功能

    @Override
    public void logout(String token) {
        redisTemplate.delete("user:login:" + token) ;

    }



    /*//用户登录
    @Override
    public LoginVo login(LoginDto loginDto) {
        //1.获取用户名，loginDto获取
        String userName = loginDto.getUserName();

        //2.根据用户查询数据库表sys_user
        SysUser sysUser = sysUserMapper.selectUserInfoByUserName(userName);
        //3.如果根据用户名查不到对应的信息，用户不存在，返回错误信息
        if(sysUser == null){
//            throw new RuntimeException("用户名不存在");
        throw new GuiguException(ResultCodeEnum.LOGIN_ERROR);


        }
        //4.如果根据用户名查询到用户信息，用户存在
        //5.获取输入的密码，比较输入的密码和数据库密码是否一致
        String datebase_password = sysUser.getPassword();
        String input_password = DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes());

        //比较
        if(!input_password.equals(datebase_password)){
//            throw new RuntimeException("密码不正确");
            throw new GuiguException(ResultCodeEnum.LOGIN_ERROR);



        }


        //6.如果密码一致，登陆成功,如果密码不一致登录失败
        //7.登陆成功，生成用户我唯一标识token
        String token = UUID.randomUUID().toString().replaceAll("-","");

        //8.把登录成功用户信息放到redis里面
        JSON.toJSONString(sysUser);
        redisTemplate.opsForValue().set("user:login"+token,JSON.toJSONString(sysUser),7, TimeUnit.DAYS);
        //返回loginvo对象
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);
        return loginVo;
    }*/

}
