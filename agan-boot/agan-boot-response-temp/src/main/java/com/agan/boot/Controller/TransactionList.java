package com.agan.boot.Controller;

import lombok.Data;

@Data
public class TransactionList {
    private String total;
    private String[] items;

    public static TransactionList createrTransactionList() {
        TransactionList list = new TransactionList();
        list.setTotal("20");
        String[] s = {"data1", "data2"};
        list.setItems(s);
        return list;
    }
}
