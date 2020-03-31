package com.easy.yunerp.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 日志
 */
@Slf4j
@Aspect
@Component
public class SubscribeAop {

    @Pointcut("execution(public * com.easy.yunerp.web..*Controller.*(..))")
    private void method() {
    }

    @Before("method()")
    public void beforeLog(JoinPoint joinPoint) {
        StringBuilder msg = new StringBuilder();
        msg.append("Start Method: ==> ").append(joinPoint.getTarget().getClass().getName()).append(".");
        msg.append(joinPoint.getSignature().getName()).append("()");
        msg.append(" | Params: ==> ").append(getParams(joinPoint));
        log.info(msg.toString());
    }

    @After("method()")
    public void afterLog(JoinPoint joinPoint) {
        StringBuilder msg = new StringBuilder();
        msg.append("Finish Method: ==> ").append(joinPoint.getTarget().getClass().getName()).append(".");
        msg.append(joinPoint.getSignature().getName()).append("()");
        log.info(msg.toString());
    }

    private String getParams(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] names = methodSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        if (names == null || names.length == 0 || args == null || args.length == 0) {
            return " params is empty.";
        }
        int namesLength = names.length;
        List<String> list = new ArrayList();
        for (int i = 0; i < namesLength; i++) {
            list.add("'" + names[i] + "':'" + args[i] + "'");
        }
        StringBuilder params = new StringBuilder();
        //params.append("[").append(StringUtils.join(list, ",")).append("]");
        return params.toString();
    }
}
