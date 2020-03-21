package com.istudy.group.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.istudy.group.service.ScoreService;

@RestController
@Slf4j
public class LoginController {

//    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Value("${msg}")
    private String msg;

    @GetMapping("msg")
    public String getMsg() {
        return msg;
    }

    @RequestMapping("/user")
    public User user() {
        User user = new User();
        user.setId(10000);
        user.setUsername("root");
        return user;
    }

    @GetMapping("/login")
    public String login(){
        return "login result";
    }

    //log 是使用@Slf4j 后的
    @RequestMapping("/log")
    public void log() {
        log.trace("------------trace----------");
        log.debug("------------debug----------");
        log.info("------------info----------");
        log.warn("------------warn----------");
        log.error("------------error----------");
    }

//    异步
    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/async")
    public String createUser() {
        log.info("--------注册用户-------");
        this.scoreService.addScore();
        return "ok";
    }
    @RequestMapping("/async2")
    public String createUser2() {
        log.info("--------注册用户2-------");
        this.scoreService.addScore2();
        return "ok2";
    }

}
