package com.jun.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println ("我的第二个servlet");
		System.out.println("客户端浏览器的类型:"+req.getHeader("User-Agent"));
		
		resp.getWriter().println("<h1>Hello Servlet!!</h1>");
		resp.getWriter().println("<h2>Hello Servlet!!</h2>");
		resp.getWriter().println("<hr color='red'/>");
		
	}

}
