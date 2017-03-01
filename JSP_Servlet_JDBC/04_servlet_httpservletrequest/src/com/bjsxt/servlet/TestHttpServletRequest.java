package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestHttpServletRequest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
//		testGetNetInfo(req);
//		testGetURL(req,resp);
//		testGetHeader(req);
		testGetParameter(req);
	}
	
	
	/**
	 * get network info
	 * @param req
	 */
	void testGetNetInfo(HttpServletRequest req) {
		System.out.println("remote ip: "+req.getRemoteAddr());
		System.out.println("local address: "+req.getLocalAddr());
		System.out.println("remote port: "+req.getRemotePort());
	}
	
	void testGetURL(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		PrintWriter out =resp.getWriter();
		out.println("request method:"+req.getMethod()+"<br/>");
		out.println("protocol:"+req.getScheme()+"<br/>");
		out.println("web app folder contextpath:"+req.getContextPath()+"<br/>");
		out.println("URI:"+req.getRequestURI()+"<br/>");
		out.println("URL:"+req.getRequestURL()+"<br/>");
		out.println("parameter:"+req.getQueryString()+"<br/>");
	}
	
	void testGetHeader(HttpServletRequest req){
		String str = req.getHeader("Accept-Language");
		System.out.println("Accept-Language: "+str);
		
		Enumeration e = req.getHeaderNames();
		while (e.hasMoreElements()){
			String temp = (String) e.nextElement();
			System.out.println(temp+"==="+req.getHeader(temp));
		}
	}
	
	//有错误，获取的值是null
	void testGetParameter(HttpServletRequest req){
		String u = req.getParameter("uname");
		String p = req.getParameter("pwd");
		System.out.println("uname:"+u);
		System.out.println("pwd:"+p);
		
		String mobile[] = req.getParameterValues("mobile");
		for (String string :mobile){
			System.out.println(string);
		}
	}
}
