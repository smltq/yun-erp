package com.easy.yunerp.common.exception;

import com.easy.yunerp.common.base.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    /**
     * 捕获系统内部异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e) {
        log.error("系统内部异常,异常信息：" + e);
        if (e instanceof UndeclaredThrowableException) {
            return AjaxResult.fail(((UndeclaredThrowableException) e).getUndeclaredThrowable().getMessage());
        }
        return AjaxResult.fail("系统内部异常");
    }

    /**
     * 处理所有运行时异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    AjaxResult handleRuntimeException(RuntimeException e) {
        log.error("RuntimeException==>" + e.getMessage() + "\n" + e.getStackTrace());
        if (e instanceof UndeclaredThrowableException) {
            return AjaxResult.fail(((UndeclaredThrowableException) e).getUndeclaredThrowable().getMessage());
        }
        return AjaxResult.fail(e.getMessage());
    }

    /**
     * 统一处理请求参数的校验(实体类参数)
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public AjaxResult validExceptionHandler(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return AjaxResult.fail(message.toString());
    }
}
