package cn.itcast.ioc;

public class User {
	
	
	private String userName;
	private String sex;
	
	public void setSex(String sex) {
		this.sex = sex;
	}


	public User(String userName) {
		super();
		this.userName = userName;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add() {
		System.out.println("add........"+userName+sex);
	}
	
//	public static void main(String[] args) {
//		User user = new User();
//		user.add();
//	}
}
