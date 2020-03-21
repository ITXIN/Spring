package com.istudy.group.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = "/getStr")
    public String getStr() {
        return  "test1";
    }

    @GetMapping(value="/empty")
    public void empty () {

    }
    @GetMapping(value="/error")
    public void error () {
        int i = 9/0;
    }

    @GetMapping(value = "/u/{id}")
    public User findById(@PathVariable int id) {
        Random rand = new Random();
        User user = new User();
        user.setId(id);
        String temp = "temp01";
        user.setUsername(temp);
        user.setPassword(temp);
        int n = rand.nextInt(2);
        user.setSex((byte)n);
        return user;
    }
//    @PostMapping(value = "/user/ceate",produces = APPLICATION_JSON_UTF8_VALUE, consumes = App)
    public User createUser(@RequestBody User user) {
        return  user;
    }
}
