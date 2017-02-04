<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="cn.sxt.vo.User,cn.sxt.dao.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <table width="80%" align="center">
   	<tr>
   		<td>编号</td>
   		<td>姓名</td>
   		<td>年龄</td>
   	</tr>
   <%
   		List<User> list = new UserDao().list();
   		for(int i=0;i<list.size();i++){
   %>
   	<tr>
   		<td><%=list.get(i).getId() %></td>
   		<td><%=list.get(i).getName() %></td>
   		<td><%=list.get(i).getAge() %></td>
   	</tr>
   <%} %>
   </table>
  </body>
</html>
