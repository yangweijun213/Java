<%@ page import="com.jun.servlet.TestPageContext" %>
<%
	response.getWriter().println("dd");
	session.setAttribute("a", "ccc");
 %>
 
<!-- PageContext -->
<%
	new TestPageContext().test(pageContext);
 %>
<%
	pageContext.forward("2.jsp");
	request.getRequestDispatcher("2.jsp").forward(request,response);
 %>
 
 