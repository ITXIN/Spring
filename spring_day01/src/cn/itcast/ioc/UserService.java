package cn.itcast.ioc;

public class UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add() {
		System.out.println("service...........");
//		UserDao dao = new UserDao();
//		dao.add();
		userDao.add();
		
	}
}
