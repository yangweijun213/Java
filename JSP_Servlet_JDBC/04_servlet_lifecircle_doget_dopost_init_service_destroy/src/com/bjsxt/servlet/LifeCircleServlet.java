package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCircleServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("servlet is executed");
		resp.getWriter().println("servlet is executed");
	}

	@Override
	public void destroy() {
		System.out.println("servlet is destoryed");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("servlet is initial");

	}
	
}
