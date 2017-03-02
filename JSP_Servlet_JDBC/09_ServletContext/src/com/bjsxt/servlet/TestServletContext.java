package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletContext extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		//获取context-param的参数值
		System.out.println(context.getInitParameter("aa"));
		
		//ServletContext增加作用域
		context.setAttribute("c", "cccccc");
		
		
	}	
	
}
