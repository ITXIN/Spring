package com.agan.boot.Controller;

import com.agan.boot.enums.ResultCode;
import com.agan.boot.exceptions.BusinessException;
import com.agan.boot.response.ErrorResult;
import com.agan.boot.response.Result;
import com.agan.boot.utils.ConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.portable.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

//import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


@RestController
@RequestMapping("/user")// 下面方法都是/user路径下的
@Slf4j
@ResponseBody//就是返回值是json数据
public class UserController {
    @Autowired
    ConfigProperties configProperties;

//    @PostMapping(value = "/create", produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
//    @PostMapping(value = "/create",produces = "MediaType.APPLICATION_JSON_UTF8_VALUE"+";charset=utf-8")
    //https://www.hangge.com/blog/cache/detail_2485.html (例子)

    // 下面样例 Controller 接收 form-data 格式的 POST 数据：
//    @PostMapping(value = "/create")
//    public User createUser(@RequestParam("username") String username,
//                           @RequestParam("password") String password) {
//        User user = new User();
//        user.setPassword(password);
//        user.setUsername(username);
//        log.info("---{},{}",username,password);
//        this.createUser1(user);
//        return user;
//    }

//    使用 map 来接收参数
//    @PostMapping(value = "/create")
//    public User createUser(@RequestParam Map<String,Object> params) {
//        User user = new User();
//        user.setUsername(String.valueOf(params.get("username")));
//        user.setPassword(String.valueOf(params.get("password")));
//        log.info("---{},{}",params.get("username"),params.get("password"));
//        this.createUser1(user);
//        return user;
//    }

    // 接收一个数组
//    @PostMapping(value = "/create")
//    public User createUser(@RequestParam("name") String[] names) {
//        User user = new User();
//        for (String username:names) {
//            user.setUsername(username);
//        }
//        log.info("---{},{}",names);
//        this.createUser1(user);
//        return user;
//    }

    @PostMapping("/hello")
    public String hello(@RequestBody User user){
        log.info("----hello1");
        return user.getName() + " " + user.getPassword();
    }
    // 对象
    /**
     * 报错Content type 'application/octet-stream' not supported
     *原因是后端（即自己开发的后端工程），不支持Content type 为'application/octet-stream'的http请求。
     *解决方式是，在发起http请求的时候，在header中，手动添加Content type属性。如：Content-type: application/json
     * */
    @PostMapping(value = "/create")
    public User createUser(@RequestBody User user) {
        log.info("---name:{},pass:{}",user.getName(),user.getPassword());
        this.createUser1(user);
        return user;
    }

    /**
     * 参数json
     * */
    @PostMapping(value = "/create_json")
    public String createUserJson(@RequestBody List<User> users) {
        String result = "";
        for (User user:users) {
            result += user.getName() + " " + user.getPassword() + "\n";
        }
        return result;
    }

    public void createUser1(@RequestBody @Validated User user) {

    }

    //数据校验
//    @PostMapping("/validated")
//    public List<String> addUser(@RequestBody @Validated User user, BindingResult result) {
//        List<String> errors = new ArrayList<>();
//        if (result.hasErrors()) {
//            List<ObjectError> allErrors = result.getAllErrors();
//            for (ObjectError error:allErrors) {
//                errors.add(error.getDefaultMessage());
//            }
//        }
//        log.info("-----adduser: {}",errors);
//        return errors;
//    }

    // 由于GlobalExceptionHandler 参数验证是捕获MethodArgumentNotValidException，所以参数要加上MethodArgumentNotValidException
    @PostMapping("/login")
    public String login(@RequestBody @Validated User user, MethodArgumentNotValidException e) {
        log.info("----name:{},password:{}",user.getName(),user.getPassword());
        if (user.getName().equals("admin") && user.getPassword().equals("147258")) {
            return "登录成功";
        }else {
            throw new BusinessException(ResultCode.USER_LOGIN_ERROR);
        }

    }

    // 路径传参数
    @GetMapping("/hello/{name}")
    public String getTest(@PathVariable("name") String name) {
        log.info("---get test:{}",name);
        return "name:" + name;
    }

    // ?xxx=yyy ,如果没有传递参数 Controller 将会报错，我们可以使用 required = false 标注参数是非必须的。
    @GetMapping("/hello")
    public String getTestCommon(@RequestParam(name = "name",defaultValue = "默认值", required = false) String name) {
        log.info("---get test:{}",name);
        return "获取到到name是" + name;
    }

    // get with map
    @GetMapping("/getMap")
    public String getWithMap(@RequestParam Map<String, Object> params) {
        log.info("---get getWithMap:{}",params);
        return  "name:" + params.get("name") + ",age:" + params.get("age");
    }

    @GetMapping("/getObject")
    public User getWithObject(User user) {
        return user;
    }

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

    @GetMapping(value = "/error4")
    public void error4(){
        throw new RuntimeException("用户已存在");
    }

    @GetMapping(value = "/error2")
    public void error2(){
        Integer.valueOf("a");
    }

    @GetMapping(value = "/error3")
    public void error3(){
        throw new BusinessException(ResultCode.USER_HAS_EXISTED);
    }

    @GetMapping("/getResult")
    public Result getResult(){
        return Result.suc();// 初级程序员这样写，
    }

    @GetMapping(value = "/u/{id}")
    public User findById(@PathVariable int id) {
        Random rand = new Random();
        User user = new User();
//        user.setId(id);
        String temp = "temp01";
        user.setName(temp);
        user.setPassword(temp);
        int n = rand.nextInt(2);
//        user.setSex((byte)n);
        return user;
    }

}
