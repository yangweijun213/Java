package com.bjsxt.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

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
		
		//获取web.xml context-param的参数值
		System.out.println(context.getInitParameter("aa"));
		
		//servletcontext 增加作用域 (对所有servlet都有效，从加载到卸载)
		context.setAttribute("a", "contextAttribute");
		System.out.println(context.getAttribute("a"));
		
		//获取index.html路径 
		String path = context.getRealPath("/index.html");
		String path2 = context.getRealPath("index.html");
		System.out.println(path);
		System.out.println(path2);
		
		
		//获取img资源路径 
		Set<String> set =context.getResourcePaths("/image");
		for (String string:set){
			System.out.println(string);
		}
		
		//获取a.properities资源文件数据
		//默认从WebAPP根目录下取资源
		InputStream is = context.getResourceAsStream("a.properties");
		//默认则是从ClassPath根下获取，path不能以’/'开头，最终是由ClassLoader获取资源
		//InputStream is = this.getClass().getClassLoader().getResourceAsStream("a.properties");
		Properties ps = new Properties();
		ps.load(is);
		System.out.println(ps.get("a"));
		
		
		
	}	
}
