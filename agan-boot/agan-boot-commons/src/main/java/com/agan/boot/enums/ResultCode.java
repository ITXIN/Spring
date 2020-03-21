package com.agan.boot.enums;


public enum ResultCode {
    SUCCESS(0, "成功"),

    SYSTEM_ERROR(10000, "系统异常，请稍后重试"),
    UNAUTHORIZED(10401, "签名验证失败"),

    /* 参数错误10001-19999*/
    PARAM_IS_ERROR(10001, "参数无效"),

    /* 参数错误20001-29999*/
    USER_HAS_EXISTED(20001,"用户名已存在"),
    USER_NOT_FIND(20002,"用户名不存在");

    private Integer code;
    private  String message;
    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer code() {
        return  this.code;
    }
    public  String message () {
        return  this.message;
    }

}
