
<%@ page session="false" import="com.jun.servlet.TestPageContext" %>
<% 
	response.getWriter().println("ddd");
	out.println("out");
//	session.setAttribute("abc");
	application.setAttribute ("c","dddd");
%>


<% 
	new TestPageContext().test(pageContext);
%>

<%
//	request.getRequestDispatcher("2.jsp").forward(request,response);
//	pageContext.forward("2.jsp");

//	String str = request.getParameter("includepage");
%>

<%-- 
<jsp:include page='<%=request.getParameter("includepage") %>'></jsp:include>

<jsp:include page= "4.jsp">
	<jsp:param value="454545" name="kk" />
</jsp:include>

--%>

<%--
<jsp:forward page="4.jsp"></jsp:forward> 
--%>

<jsp:forward page="4.jsp">
	<jsp:param value="dddd" name="kk"/>
</jsp:forward>