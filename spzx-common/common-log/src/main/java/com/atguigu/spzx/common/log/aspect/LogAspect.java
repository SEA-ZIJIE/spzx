package com.atguigu.spzx.common.log.aspect;

import com.atguigu.spzx.common.log.annotation.Log;
import com.atguigu.spzx.common.log.service.AsyncOperLogService;
import com.atguigu.spzx.common.log.utils.LogUtil;
import com.atguigu.spzx.model.entity.system.SysOperLog;
import jakarta.annotation.Resource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * ClassName: LogAspect
 * Package: com.atguigu.spzx.common.log.aspect
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/13 16:03
 * @Version 1.0
 */

@Aspect
@Component
public class LogAspect {

    @Resource
    private AsyncOperLogService asyncOperLogService ;

    @Around(value = "@annotation(sysLog)")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint, Log sysLog) {

//        String title = sysLog.title();
//        int businessType = sysLog.businessType();
//        System.out.println("title:"+title+" ::+businessType: " + businessType);
//        业务方法调用之前，封装数据

        SysOperLog sysOperLog = new SysOperLog();
        LogUtil.beforeHandleLog(sysLog,joinPoint,sysOperLog);
//        业务方法
        Object proceed = null;
        try {
             proceed = joinPoint.proceed();
//            System.out.println("在业务方法之后执行。。。");
//            调用方法之后封装数据
            LogUtil.afterHandlLog(sysLog,proceed,sysOperLog,0,null);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        return proceed;
    }

}
