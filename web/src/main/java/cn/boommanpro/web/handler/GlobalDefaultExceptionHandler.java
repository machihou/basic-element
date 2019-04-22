package cn.boommanpro.web.handler;


import cn.boommanpro.common.CallResult;
import cn.boommanpro.web.exception.MyException;
import cn.boommanpro.web.exception.NotLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
@Slf4j
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(BindException.class)
    public CallResult handleResourceNotFoundException(BindException e) {
        //捕获的所有错误对象
        log.error("BindException", e);
        return CallResult.error("参数验证错误", from2Message(e.getAllErrors()));
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CallResult handleHttpRequestMethodNotSupportedException(HttpServletRequest request, HttpRequestMethodNotSupportedException e) {
        //捕获的所有错误对象
        log.error("访问的Url地址为:{},请求的方式为:{}", request.getRequestURL(), e.getMethod());
        return CallResult.error("请求方式" + e.getMethod() + "不支持");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public CallResult httpMessageNotReadableException(HttpServletRequest request, HttpMessageNotReadableException e) {
        //捕获的所有错误对象
        log.error("httpMessageNotReadableException:", e);
        return CallResult.error("请求类型异常 Required request body is missing");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public CallResult handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        StringBuilder result = new StringBuilder();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            result.append(constraintViolation.getMessage() + ";");
        }
        return CallResult.error(result.toString());
    }

    @ExceptionHandler(NotLoginException.class)
    public CallResult handleNotLoginException(NotLoginException e) {
        return CallResult.error("未登录");
    }


    @ExceptionHandler(MyException.class)
    public CallResult myException(MyException myException) {
        log.error("出现自定义异常:{}", myException.getMessage());
        return CallResult.error(myException.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public <T> CallResult<?> methodArgumentNotValidHandler(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException异常:", e);
        BindingResult bindingResult = e.getBindingResult();
        return CallResult.error("参数验证错误", from2Message(bindingResult.getAllErrors()));
    }

    @ExceptionHandler(Exception.class)
    public <T> CallResult<?> defaultExceptionHandler(HttpServletRequest request, Exception e) {
        log.error("出现未知异常:", e);
        //未知错误  提示默认异常
        return CallResult.error("服务器异常");
    }

    private Map<String, String> from2Message(List<ObjectError> allErrors) {
        Map<String, String> errorMap = new HashMap<>(allErrors.size());
        for (ObjectError allError : allErrors) {
            errorMap.put(((FieldError) allError).getField(), allError.getDefaultMessage());
        }
        return errorMap;
    }
}
