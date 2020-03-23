package com.agan.boot.response;

import com.agan.boot.enums.ResultCode;
import com.agan.boot.exceptions.BusinessException;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ErrorResult {
    public String status;// 异常状态码
    public String message;//用户看得见得异常，例如用户名重复
    public String exception;// 异常的名字

    public static ErrorResult fail(ResultCode resultCode,Throwable e, String message) {
        ErrorResult result = ErrorResult.fail(resultCode,e);
        result.setMessage(message);
        return  result;
    }

    public static ErrorResult fail(ResultCode resultCode,Throwable e) {
        ErrorResult result = new ErrorResult();
        result.setMessage(resultCode.message());
        result.setStatus(resultCode.code());
        result.setException(e.getClass().getName());
        return  result;
    }

    public  static  ErrorResult handlerBusinessException(BusinessException e){
        ErrorResult errorResult = new ErrorResult();
        errorResult.setStatus(e.getCode().toString());
        errorResult.setMessage(e.getMessage());
        errorResult.setException(e.getClass().getName());
        return errorResult;
    }


}
