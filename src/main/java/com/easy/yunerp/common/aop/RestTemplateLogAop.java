package com.easy.yunerp.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RestTemplateLogAop {
    @Pointcut("execution(public * org.springframework.web.client.RestTemplate.get*(..))")
    private void getMethod() {
    }

    @Pointcut("execution(public * org.springframework.web.client.RestTemplate.post*(..))")
    private void postMethod() {
    }

    @Around("getMethod()||postMethod()")
    public Object aroundLog(ProceedingJoinPoint joinPoint) {
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        String[] paramNames = codeSignature.getParameterNames();
        Object url = null;
        Object request = null;
        for (int i = 0; i < paramNames.length; i++) {
            if (paramNames[i].equals("url")) {
                url = joinPoint.getArgs()[i];
            } else if (paramNames[i].equals("request")) {
                request = joinPoint.getArgs()[i];
            }
        }

        //log.info(" ###### 接口调用url: {} ; 参数 : {} ", StrUtil.toString(url), StrUtil.toString(request));
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.info(" ###### 接口调用出现异常 : {}", throwable.getMessage());
        } finally {
            if (result != null) {
                log.info(" ###### 接口调用返回值 : {}", result.toString());
            } else {
                log.info(" ###### 接口调用返回空值");
            }
        }
        return result;
    }
}
