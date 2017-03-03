package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.model.User;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		String uname = req.getParameter("uname/").trim();
		String pwd = req.getParameter("pwd/").trim();

		 if ("jeff".equals(uname) && "111".equals(pwd)) {
		 // login success
		
		 // 需要封装数据 User
		 User user = new User(uname, pwd);
		 // 在这个session里面作用域 放入user对象
		 req.getSession().setAttribute("user", user);
		
		 // 转发或重定向
		 req.getRequestDispatcher("login_ok.jsp").forward(req, resp);
		 return;
		
		 } else {
		 // 登录失败
		 req.setAttribute("errormessage", "login error");
		 req.getRequestDispatcher("loginFailurer").forward(req, resp);
		 }
	}

}
