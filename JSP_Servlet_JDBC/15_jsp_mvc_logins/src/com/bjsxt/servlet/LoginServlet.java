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
		 // 登录成功
		
		 // éœ€è¦�å°�è£…æ•°æ�® User
		 User user = new User(uname, pwd);
		 // åœ¨è¿™ä¸ªsessioné‡Œé�¢ä½œç”¨åŸŸ æ”¾å…¥userå¯¹è±¡
		 req.getSession().setAttribute("user", user);
		
		 // è½¬å�‘æˆ–é‡�å®šå�‘
		 req.getRequestDispatcher("login_ok.jsp").forward(req, resp);
		 return;
		
		 } else {
		 // ç™»å½•å¤±è´¥
		 req.setAttribute("errormessage", "login error");
		 req.getRequestDispatcher("loginFailurer").forward(req, resp);
		 }
	}

}
