.properties 如何使用
## 1.改端口
```$xslt
server.port=9090
```
## 2.改随机端口
```$xslt
server.port=${random.int[1024,9999]}
```

## 3.自定义配置
使用注解@value：作用为了简化读取properties配置值。
具体使用如下：
```$xslt
1。先在.properties 文件中定义配置如
msg= xxxxx
2。在使用时,如下：
 @Value("${msg}")
 private String msg;
    
  @GetMapping("msg")
  public String getMsg() {
      return msg;
  }
```


## 4.为何控制台只输出 info warn error?
因为spring boot 默认是info 级别的
```$xslt
设置日志级别：logging.level.xxx (xxx是包名)
logging.level.com.istudy.group=trace

```

## 5.配置日志的生成存储路径和日志名称

```$xslt
#logging.path=output/logs 废弃 日志存储路径，默认日志名为sprin.log
logging.file.path=output/logs
# 自定义日志文件及名称
loggin

```
## 6.配置日志的格式

```
# %d-时间格式 %thread-线程 %-5level-从左5字符宽度,%logger{50}-日志50字符，%msg-信息，%n-换行
#设置控制台输出的日志格式
logging.pattern.console=%d{yyyy-MM-dd} [%thread] %-5level %logger{50} -%msg%n
# 设置输出到文件到日志格式
logging.pattern.file=%d{yyyy-MM-dd} === [%thread]=== %-5level=== %logger{50}=== -%msg%n
```
## 7.lombok 注解
@Data 注解在实体类上，自动生成javabean的getter/setter 方法,构造器，equals等方法。
如何使用
1.在pom 文件手动添加依赖包
```
 <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
```
2.使用
```
 @RequestMapping("/user")
    public User user() {
        User user = new User();
        user.setId(10000);
        user.setUsername("root");
        return user;
    }
 ```

## 8.Slf4j 注解,代替了日志声明,不用每次都使用
 ```
使用@Slf4j 之前
private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
  @GetMapping("/log")
    public void log() {
        logger.trace("------------trace----------");
        logger.debug("------------debug----------");
        logger.info("------------info----------");
        logger.warn("------------warn----------");
        logger.error("------------error----------");
    }

使用后：log 是使用@Slf4j 后的
 @RequestMapping("/log")
    public void log() {
        log.trace("------------trace----------");
        log.debug("------------debug----------");
        log.info("------------info----------");
        log.warn("------------warn----------");
        log.error("------------error----------");
    }

```
## 9. 使用@Async 实现异步调用
1.开启异步任务?不使用也是可以的，不明白？
采用@EnableAsync 来开启异步任务支持，另外需要加入@Configuration 来把当前类加入SpringIOC 容器中。
``` 
@Configurable
@EnableAsync
public class SyncConfiguration {
}

```

2.需要增加一个service类，且在类中的方法加上@Async
```
 @Async
    public void addScore() {
        try {
            Thread.sleep(1000*5);
            log.info("----处理积分---");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
```

## 10. 使用@Async 线程池
1。配置线程池(注意@Bean(name="scorePoolTaskExecutor") 线程名字)
``` 

@Configurable
@EnableAsync
public class SyncConfiguration {
    @Bean(name="scorePoolTaskExecutor")
    public ThreadPoolTaskExecutor getSocrePoolTaskExecutor() {
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

```
2. 为@Async 指定线程池名字，如上"scorePoolTaskExecutor"。