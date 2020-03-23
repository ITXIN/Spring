package com.agan.boot.enums;


public enum ResultCode {
    SUCCESS("000000", "成功"),

    SYSTEM_ERROR("10000", "系统异常，请稍后重试"),
    UNAUTHORIZED("10401", "签名验证失败"),

    /* 参数错误10001-19999*/
    PARAM_IS_ERROR("10001", "参数无效"),

    /* 参数错误20001-29999*/
    USER_HAS_EXISTED("20001","用户名已存在"),
    USER_NOT_FIND("20002","用户名不存在"),
    USER_LOGIN_ERROR("20003","用户名或密码错误");

    private  String code;
    private  String message;
    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public String code() {
        return  this.code;
    }
    public  String message () {
        return  this.message;
    }

}
