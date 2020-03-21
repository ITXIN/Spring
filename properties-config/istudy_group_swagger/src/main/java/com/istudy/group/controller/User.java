package com.istudy.group.controller;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Byte sex;
    private Byte deleted;
    private Date updateTime;
    private Date createTime;

}
