package com.istudy.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		session.setAttribute("keySess", "istudy.group");
		session.getAttribute("keySess");
		session.removeAttribute("keySess");
		
		System.out.println("session:"+session.getAttribute("keySess"));
		/*
		 * 销毁 :1.服务器关闭。2.session 过期。3.手动 session.invalidate。
		 * 浏览器关闭，session 销毁。这句话是不正确的。
		 * */ 
		session.invalidate();
		
		
	}

}
