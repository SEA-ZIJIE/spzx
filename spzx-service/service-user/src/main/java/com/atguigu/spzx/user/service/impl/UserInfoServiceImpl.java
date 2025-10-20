package com.atguigu.spzx.user.service.impl;/**
 * ClassName: UserInfoServiceImpl
 * Package: com.atguigu.spzx.user.service.impl
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/18 18:54
 * @Version 1.0
 */

import com.alibaba.fastjson2.JSON;
import com.atguigu.spzx.common.exception.GuiguException;
import com.atguigu.spzx.model.dto.h5.UserLoginDto;
import com.atguigu.spzx.model.dto.h5.UserRegisterDto;
import com.atguigu.spzx.model.entity.user.UserInfo;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.model.vo.h5.UserInfoVo;
import com.atguigu.spzx.user.mapper.UserInfoMapper;
import com.atguigu.spzx.user.service.UserInfoService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private RedisTemplate<String,String> redisTemplate;
//    注册
    @Override
    public void register(UserRegisterDto userRegisterDto) {
//        userRegisterDto中获取数据
        String username = userRegisterDto.getUsername();
        String password = userRegisterDto.getPassword();
        String nickName = userRegisterDto.getNickName();
        String code = userRegisterDto.getCode();


//        验证码校验
//        从redis中获取验证码
        String redisCode = redisTemplate.opsForValue().get(username);
//        获取输入的验证码,进行比对
        if(!redisCode.equals(code)){
            throw new GuiguException(ResultCodeEnum.VALIDATECODE_ERROR);
        }
//        校验用户名不能重复
        UserInfo userInfo = userInfoMapper.selectByUsername(username);
        if(userInfo!=null){
            throw new GuiguException(ResultCodeEnum.USER_NAME_IS_EXISTS);
        }
//        封装添加数据,调用方法添加数据库
        userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setNickName(nickName);
        userInfo.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        userInfo.setPhone(username);
        userInfo.setStatus(1);
        userInfo.setSex(0);
        userInfo.setAvatar("http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132");
        userInfoMapper.save(userInfo);

//        从redis删除发送的验证码
        redisTemplate.delete(username);

    }
//          登录
    @Override
    public String login(UserLoginDto userLoginDto) {
//        dto获取用户名和密码
        String username = userLoginDto.getUsername();
        String password = userLoginDto.getPassword();

//        根据用户名查询数据库
        UserInfo userInfo = userInfoMapper.selectByUsername(username);
        if(userInfo==null){
            throw new GuiguException(ResultCodeEnum.LOGIN_ERROR);
        }
//        比较密码是否一致
        String database_password = userInfo.getPassword();
        String md5_password = DigestUtils.md5DigestAsHex(password.getBytes());
        if(!md5_password.equals(database_password)){
            throw new GuiguException(ResultCodeEnum.LOGIN_ERROR);
        }
//        校验用户是否被禁用
        if(userInfo.getStatus()==0){
            throw new GuiguException(ResultCodeEnum.ACCOUNT_STOP);
        }
//        生成token
        String token = UUID.randomUUID().toString().replace("_", "");

//        把用户信息放到redis里面

        redisTemplate.opsForValue().set("user:spzx:"+token,
                JSON.toJSONString(userInfo),
                30, TimeUnit.DAYS);
//        返回token
        return token;
     }
//    获取当前登录用户信息
    @Override
    public UserInfoVo getCurrentUserInfo(String token) {
//        从redis里面获取用户信息
        String userJson = redisTemplate.opsForValue().get("user:spzx:" + token);
        if(!StringUtils.hasText(userJson)){
            throw new GuiguException(ResultCodeEnum.LOGIN_AUTH);
        }
        UserInfo userInfo = JSON.parseObject(userJson, UserInfo.class);
        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(userInfo,userInfoVo);
        return userInfoVo; 
    }

}
