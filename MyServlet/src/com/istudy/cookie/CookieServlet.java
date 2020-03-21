package com.istudy.cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	String formateDate = sdf.format(date);
	
	Cookie cookie = new Cookie("lastTime",formateDate);
	response.setContentType("text/html;charset=UTF-8");
	response.getWriter().write("第一次登录"+formateDate);
	/*
	 * 默认情况下cookie是会话级别的打开浏览器，关闭浏览器为一次会话，如果
	 * 不设置持久化时间，cookie会存储在浏览器的内存中，浏览器关闭cookie信息销毁。
	 * 默认情况下会在访问创建cookie的web资源相同路径都携带cookie信息。可通过设置path解决
	 * cookie.setPath("/MySevlet");
	 * */
	//设置cookie客户端存储时间
//	cookie.setMaxAge(100);
	response.addCookie(cookie);
	// 删除cookie
//	cookie.setMaxAge(0);
	
//	获取cookie
	Cookie[] cookies = request.getCookies();
	String lastTime = null;
	if (cookies != null) {
		for (Cookie c : cookies) {
			if (c.getName().equals("lastTime")) {
				lastTime = c.getValue();
				System.out.println("cookie:"+c.getValue());
//				response.getWriter().write("cookie key:"+name+"value:"+c.getValue());
			}
		}
	}
	if (lastTime != null) {
		response.getWriter().write("上次登录时间:"+lastTime);
	}else {
		response.getWriter().write("第一次登录");
	}
	
	
	
	}

}
