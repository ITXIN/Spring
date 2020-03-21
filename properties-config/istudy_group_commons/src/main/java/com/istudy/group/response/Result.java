package com.istudy.group.response;

import com.istudy.group.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {
    private  Integer status;

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
    public static Result fail(Integer status, String desc) {
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
