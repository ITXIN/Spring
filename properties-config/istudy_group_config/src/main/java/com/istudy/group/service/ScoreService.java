package com.istudy.group.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@Slf4j
public class ScoreService {

    @Async
    public void addScore() {
        try {
            Thread.sleep(1000*5);
            log.info("----处理积分---");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async("scorePoolTaskExecutor")
    public void addScore2() {
        try {
            Thread.sleep(1000*5);
            log.info("----处理积分2---");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
