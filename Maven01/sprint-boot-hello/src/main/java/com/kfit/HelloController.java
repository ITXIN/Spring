package com.kfit;
import java.util.Date;

//
//import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello world 1234 5";
	}
	@RequestMapping("/hello1")
	public String hello1() {
		return "hello world1";
	}
	@RequestMapping("/getUser")
	public User getUser() {
		User user = new User();
		user.setId("111");
		user.setName("李亚青");
		user.setCreateTime(new Date());
		user.setRemarks("remark");
		return user;
	}
}
