package com.agan.boot.Controller;

import com.agan.boot.enums.ResultCode;
import com.agan.boot.exceptions.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/transaction")// 下面方法都是/user路径下的
@Slf4j
@ResponseBody//就是返回值是json数据
public class TransactionController {
    // username
    @GetMapping("/list")
    public Object getTransactionList(@RequestParam Map<String,Object> params, MethodArgumentNotValidException e) {
        log.info("----transaction query:{}",params.values());
        return TransactionList.createTransactionList();
    }
}
