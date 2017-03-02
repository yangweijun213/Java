package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestSession extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//一个客户端对应一个session对象，如果没有，需要创建session对象
		HttpSession session = req.getSession();
		//session id 是被servlet容器指定 
		resp.getWriter().println(session.getId());
		session.setAttribute("a", 123456);
		
	}
	
}
