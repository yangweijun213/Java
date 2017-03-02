package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestHttpServletResponse extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setHeader("content-type", "text/xml;charset=utf-8");
		
		//output html
		PrintWriter pw =resp.getWriter();
//		pw.println("<b>aaa</b>");
		
		//output xml, content-type is text/xml
		pw.println("<man><name>kebi</name></man>");

	}
	
	
	
}
