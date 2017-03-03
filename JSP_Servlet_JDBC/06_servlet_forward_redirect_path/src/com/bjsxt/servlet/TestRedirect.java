package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestRedirect extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//作用域，map结构.往request容器里面放东西 
		System.out.println("reqeust2:"+req.getAttribute("a1"));
		
		// redirect to index2.html
		resp.sendRedirect("index2.html");

	}

}
