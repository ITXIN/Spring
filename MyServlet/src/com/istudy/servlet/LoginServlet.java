package com.istudy.servlet;

//import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
//import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
//		ServletContext sc1 = config.getServletContext();
//		System.out.print("init"+sc1+"\n");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.print("destroy\n");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("service\n");
		
		// 1.获取请求参数
//		String userName = request.getParameter("username");
//		String pwd = request.getParameter("pwd");
//		System.out.print("userName= "+userName+"pwd="+pwd+"\n");
		
		//2.使用dbutils链接数据库当中。
//		response.addHeader("name", "istudy");
//		response.addIntHeader("age", 100);
//		response.addDateHeader("date",	new Date().getTime());
		
		// 设置重定向
//		response.setStatus(302);
		// 第一种
//		response.setHeader("location", "/MyServlet/loctionServlet");
		// 第二种
//		response.sendRedirect("MyServlet/loctionServlet");
		
		// 定时刷新重定向 隔3秒才去转发
//		response.setHeader("refresh", "3;url=http://www.baidu.com");
		
		//解决中文乱码 
		// 设置缓存区使用编码UTF-8 只适合post，get不能用也没有效果。
//		response.setCharacterEncoding("UTF-8");
		// 还需要在响应当中主动告诉浏览器使用什么样的编码来接收
//		response.setHeader("Content-type", "text/html;charset=UTF-8");
		//上面简写如下，放在响应体前设置
//		response.setContentType("text/html;charset=UTF-8");
		/*
		// 加载文件
		String path = this.getServletContext().getRealPath("a.txt");
		FileInputStream in = new FileInputStream(path);
		
		//读取文件,当文件读取完毕时返回-1
		in.read();
//		byte[] buffer = new byte[];
		
		
		//关闭文件
		in.close();
		*/
		
		Map<String, String[]> allP = request.getParameterMap();
//		for (Map.Entry<String, String[]> entry: allP.entrySet()) {
//			System.out.println(entry.getKey()+Arrays.toString(entry.getValue()));
//		}
//		
		UserInfo u = new UserInfo();
		try {
			BeanUtils.populate(u, allP);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 设置 uid
		u.setUid(UUID.randomUUID().toString());
		System.out.println(u);
				
		
		//模拟
//		if (userName !=null && userName.equals("admin") && pwd !=null && pwd.equals("123456")) {
//			response.getWriter().write("login success name:"+userName+",pwd:"+pwd);
////			response.setStatus(200);
//		}else {
//			response.getWriter().write("login error name:"+userName+",pwd:"+pwd);
////			response.setStatus(1001);
//		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("doGet\n");
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("doPost\n");
	}

}
