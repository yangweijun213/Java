package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("The second Servlet");
		System.out.println("User Agent: "+req.getHeader("User-Agent"));
		resp.getWriter().println("<html>");
		resp.getWriter().println("<h1>The second servlet</h1>");
		resp.getWriter().println("<style>.red{color:red;}</style>");
		resp.getWriter().println("<script>function test(){alert ('haha');}</script>");
		resp.getWriter().println("<input type=button class=red value=test onclick='test()'/>");
		resp.getWriter().println("</html>");
		
		
		
	}

}
