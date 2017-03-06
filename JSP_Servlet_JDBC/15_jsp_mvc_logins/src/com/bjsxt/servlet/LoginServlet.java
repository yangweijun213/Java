package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.model.User;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//uname和pwd与jsp的表单名一样
		String uname = req.getParameter("uname").trim();
		String pwd = req.getParameter("pwd").trim();
		
		//如果用户名和密码符合
		if ("jeff".equals(uname) && "111".equals(pwd)) {
			
			//将封装的user添加到session的作用域
			User user = new User(uname, pwd);
			req.getSession().setAttribute("user", user);
			
			//页面请求转发到登录成功页面
			req.getRequestDispatcher("login_ok.jsp").forward(req, resp);
			return;
			
		} else {
			//登录失败，请求转发到失败的url-pattern
			req.setAttribute("errormessage", "login error");
			req.getRequestDispatcher("loginFailurer").forward(req, resp);
		}
	}

}
