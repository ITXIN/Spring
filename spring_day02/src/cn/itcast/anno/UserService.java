package cn.itcast.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserService {
	//  使用注解不需要setter，getter
	@Autowired
//	@Resource(name="userDao")//这种方式必须和UserDao注解value值保持一致，Autowired不需要
	private UserDao userDao;
	public void add () {
		System.out.println("userService add.........");
		userDao.add();
		
	}
}
