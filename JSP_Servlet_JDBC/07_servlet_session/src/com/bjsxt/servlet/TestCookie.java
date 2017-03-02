package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Cookie c1 = new Cookie("a","23434dd");
		c1.setMaxAge(3600*24*30);
		Cookie c2 = new Cookie ("bb","ddddd");
		
		resp.addCookie(c1);
		resp.addCookie(c2);
		
		HttpSession session = req.getSession();
		resp.getWriter().println(session.getId());
	}
	
}
