package com.istudy.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet implements Servlet{
	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.print("init\n");
		//1. 可以获取servlet 名称 web.xml 中的
		String name = arg0.getServletName();
		System.out.print("servletName = "+name);
		//2. 获取一些初始化参数
//		String value = arg0.getInitParameter("myxq");
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.print("hello word");
		HttpServletResponse res = (HttpServletResponse)arg1;
		res.getWriter().write("hello word");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.print("destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
