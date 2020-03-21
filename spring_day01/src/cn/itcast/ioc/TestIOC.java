package cn.itcast.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.bean.Bean2;

public class TestIOC {
	@Test
	public void testUser() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		UserService user = (UserService)context.getBean("userService");
		System.out.println(user);
		user.add();

		
//		Bean2 bean2 = (Bean2)context.getBean("bean2");
//		System.out.println(bean2);
//		bean2.add();
	}

}
