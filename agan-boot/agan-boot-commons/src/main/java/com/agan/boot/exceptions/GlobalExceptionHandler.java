package com.agan.boot.exceptions;

import com.agan.boot.enums.ResultCode;
import com.agan.boot.response.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理运行时异常，并把异常统一封装为ErrorResult对象
     * */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//指定客户端收到的http状态码，这里配置500错误，客户端就显示500错误
    @ExceptionHandler(Throwable.class)//统一处理某一类异常，从而能减少代码重复率和复杂度。 @ExceptionHandler(Throwable.class)指处理Throwable的异常
    public ErrorResult handlerThrowable(Throwable e, HttpServletRequest request) {
        ErrorResult errorResult = ErrorResult.fail(ResultCode.SYSTEM_ERROR,e);
        log.error("URL:{},系统异常：",request.getRequestURI(),e);
        return errorResult;
    }

    /**
     * 处理自定义异常
     *
     * */
    @ExceptionHandler(BusinessException.class)
    public ErrorResult handlerBusinessException(BusinessException e,HttpServletRequest request) {
        ErrorResult errorResult = ErrorResult.handlerBusinessException(e);
        log.warn("URL:{},业务异常",request.getRequestURI(),errorResult);
        return  errorResult;
    }

}
