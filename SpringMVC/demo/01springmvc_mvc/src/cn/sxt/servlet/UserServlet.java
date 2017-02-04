package cn.sxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sxt.dao.UserDao;
import cn.sxt.vo.User;
@WebServlet("/list")
//注解相当于web.xml中的配置
/**
 * <servlet>
 * 	<servlet-name>user</servlet-name>
 *  <servlet-class>cn.sxt.servlet.UserServlet</servlet-class>
 * </servlet>
 * <servlet-mapping>
 * <servlet-name>user</servlet-name>
 * <url-pattern>/list</url-pattern>
 * </servlet-mapping>
 * */
public class UserServlet extends HttpServlet {
	private UserDao userDao = new UserDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		List<User> list = userDao.list();
		req.setAttribute("list", list);
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}
}
