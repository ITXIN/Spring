package com.istudy.group.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;
// 切记不是@Configurable 是
@Configuration
@EnableAsync
public class SyncConfiguration {
    @Bean(name = "scorePoolTaskExecutor")
    public ThreadPoolTaskExecutor getScorePoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);// 核心线程数
        taskExecutor.setMaxPoolSize(100);//线程池维护的最大数量，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        taskExecutor.setQueueCapacity(50);// 缓存队列
        taskExecutor.setKeepAliveSeconds(200);//空闲时间
        taskExecutor.setThreadNamePrefix("score-");//异步方法内部线程名称
        // 当队列满了且线程数达到最大，还有任务来，就会才去任务拒绝策略。
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return  taskExecutor;
    }
}
