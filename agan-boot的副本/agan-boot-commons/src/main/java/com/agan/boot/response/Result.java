package com.agan.boot.response;

import com.agan.boot.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuppressWarnings("unchecked")// 处理使用了未经检查或不安全的操作
public class Result<T> {
    private  String status;

    private  String desc;

    private  T data;

    // 成功创建result 没有数据
    public static Result suc() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    // 成功创建result 有data数据
    public static Result suc(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    // 失败,指定status，desc
    public static Result fail(String status, String desc) {
        Result result = new Result();
        result.setStatus(status);
        result.setDesc(desc);
        return  result;
    }

    // 失败，指定ResultCode
    public static Result fail(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return  result;
    }

    // 把ResultCode 枚举转换为Result
    private void setResultCode (ResultCode code) {
        this.status = code.code();
        this.desc = code.message();
    }

}
