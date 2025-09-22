package com.atguigu.spzx.manager.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.atguigu.spzx.common.exception.GuiguException;
import com.atguigu.spzx.manager.mapper.SysUserMapper;
import com.atguigu.spzx.manager.service.SysUserService;
import com.atguigu.spzx.model.dto.system.LoginDto;
import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysUser;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.model.vo.system.LoginVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
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

    //用户登录
    @Override
    public LoginVo login(LoginDto loginDto) {

        //1.获取输入验证码和存储的redis的key名称，通过loginDto可以获得
        String captcha = loginDto.getCaptcha();
        String key = loginDto.getCodeKey();
        //2.根据获取到的redis里的key，查询redis里面存储的验证码
        String redisCode = redisTemplate.opsForValue().get("user:validate" + key);

        //3.比较输入的验证码和redis存储的验证码是否一致

        if (StringUtils.isEmpty(redisCode) || !StrUtil.equalsIgnoreCase(redisCode,captcha)) {

            throw new GuiguException(ResultCodeEnum.VALIDATECODE_ERROR);

        }
        //4.如果不一致，提示用户，校验失败

        //5，如果一致，删除redis里面的验证码
        redisTemplate.delete("user:validate" + key);


        //1.获取用户名，loginDto获取
        String userName = loginDto.getUserName();

        //2.根据用户查询数据库表sys_user
        SysUser sysUser = sysUserMapper.selectUserInfoByUserName(userName);
        //3.如果根据用户名查不到对应的信息，用户不存在，返回错误信息

        if (sysUser == null) {
            throw new GuiguException(ResultCodeEnum.LOGIN_ERROR);

        }
        //4.如果根据用户名查询到用户信息，用户存在
        //5.获取输入的密码，比较输入的密码和数据库密码是否一致
        String datebase_password = sysUser.getPassword();
        String input_password = DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes());

        //比较
        if (!input_password.equals(datebase_password)) {

            throw new GuiguException(ResultCodeEnum.LOGIN_ERROR);
        }

        //6.如果密码一致，登陆成功,如果密码不一致登录失败
        //7.登陆成功，生成用户我唯一标识token

        String token = UUID.randomUUID().toString().replaceAll("-", "");

        //8.把登录成功用户信息放到redis里面

        JSON.toJSONString(sysUser);
        redisTemplate.opsForValue().set("user:login" + token,
                JSON.toJSONString(sysUser),
                7, TimeUnit.DAYS);
        //返回loginvo对象

        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);
        return loginVo;

    }

    @Override
    public SysUser getUserInfo(String token) {

        String userjson = redisTemplate.opsForValue().get("user:login" + token);
        SysUser sysUser = JSON.parseObject(userjson, SysUser.class);
        return sysUser;
    }

    //用户退出
    @Override
    public void logout(String token) {
        redisTemplate.delete("user:login" + token);
    }
    //1 用户条件分页查询接口
    @Override
    public PageInfo<SysUser> findByPage(Integer pageNum,
                                        Integer pageSize,
                                        SysRoleDto sysUserDto) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysUser> list = sysUserMapper.findByPage(sysUserDto);
        PageInfo<SysUser> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    //2 用户的添加
    @Override
    public void saveSysUser(SysUser sysUser) {
        //判断用户名不能重复
        String userName = sysUser.getUserName();
        SysUser dbSysUser = sysUserMapper.selectUserInfoByUserName(userName);
        if (dbSysUser != null) {
            throw new GuiguException(ResultCodeEnum.USER_NAME_IS_EXISTS);
        }
        // 输入密码进行加密
        String md5_password = DigestUtils.md5DigestAsHex(sysUser.getPassword().getBytes());
        sysUser.setPassword(md5_password);

        //设置status值
        sysUser.setStatus(1);
        sysUserMapper.save(sysUser);
    }
    //3 用户的修改

    @Override
    public void updateSysUser(SysUser sysUser) {
        sysUserMapper.update(sysUser);
    }

    @Override
    public void deleteById(long userId) {
        sysUserMapper.delete(userId);



    }
}
