package com.agan.boot.Controller;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@SuppressWarnings("unchecked")
public class TransactionList {
    private String total;
    private Map[] items;

    public static TransactionList createTransactionList() {
        TransactionList list = new TransactionList();
        list.setTotal("20");
        Map dict = new HashMap();
        dict.put("order_no","1234");
        dict.put("price","133234");
        dict.put("status","success");
        Map[] s = {dict, dict};
        list.setItems(s);
        return list;
    }
}
