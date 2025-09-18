package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.vo.system.ValidateCodeVo;

/**
 * ClassName: ValidateCodeService
 * Package: com.atguigu.spzx.manager.service
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/18 22:29
 * @Version 1.0
 */


public interface ValidateCodeService {

    //生成图片验证码
    ValidateCodeVo genernateValidateCode();

}
