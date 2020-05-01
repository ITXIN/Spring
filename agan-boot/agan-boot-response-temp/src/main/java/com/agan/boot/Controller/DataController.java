package com.agan.boot.Controller;

import com.agan.boot.modle.DashboardList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")// 下面方法都是/user路径下的
@Slf4j
public class DataController {
    // username
    @PostMapping("/transaction/list")
    public Object getTransactionList(@RequestParam Map<String,Object> params, MethodArgumentNotValidException e) {
        log.info("----transaction query:{}",params.values());
        return TransactionList.createTransactionList();
    }

    @PostMapping("/panelgroup/list")
    public Object panelGroupList(MethodArgumentNotValidException e) {
        log.info("----tpanelgroup");
        return DashboardList.createDashboardList();
    }
}
