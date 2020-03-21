package com.agan.boot.advice;

import com.agan.boot.utils.JsonUtil;
import com.agan.boot.response.ErrorResult;
import com.agan.boot.response.Result;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
/**
 * @ControllerAdvice增强了controller的扩展功能
 * 1。对controller全局数据统一处理。
 * 2。对controller全局异常统一处理。
 * 注意：
 *  .要加上basePackages，如果不加，它可能对整个系统对Controller做了扩展功能，可能与系统某些特殊功能产生冲突
 * */
@ControllerAdvice(basePackages = "com.agan.boot")
@Slf4j
public class ResponseHandler implements ResponseBodyAdvice <Object>{
    /**
     * 是否支持advice 功能
     * true=支持
     * */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }
    /**
     * 处理response的具体业务方法
     * */
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof ErrorResult){
            ErrorResult errorResult = (ErrorResult)o;
            return Result.fail(errorResult.getStatus(),errorResult.getMessage());
        }else if(o instanceof String){
            return JsonUtil.object2Json(Result.suc(o));
        }
        return Result.suc(o);
    }
}
