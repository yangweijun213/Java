<%@ page contentTyep="text/html; charset=gbk" import="com.jun.login.User" %>

<html>
	<head></head>
	<body>
		<jsp:useBean id="u1" class="com.jun.login.User" scope="request"></jsp:useBean>
		
		<!-- scope request, 这个页面和其它页面（如forward页面）都能使用 -->
		<%
			request.setAttribute("u1", new User());
		%>
		
		
		<!-- 
			scope = "page"
			pageContext.setAttribute ("u1", new User());
			
			只是针对 当前 页面 ，离开了这张页面，就无效。
		-->
	</body>
</html>