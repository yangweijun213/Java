package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestSession2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//session id 是被servlet容器指定 
		resp.getWriter().println(req.getSession().getId());
		//测试是否 能取得 来自 TestSession的id.
		System.out.println(req.getSession().getAttribute("a"));
		
	}
	
}
