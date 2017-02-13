<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 在MyEclipse会自动生成，但是在Eclipse不会自动生成 -->
<!-- path=hello ; (当前站点名称) -->
<!-- 是获得协议名称、获得服务名称、获得服务端口，再加上之前的上下文路径。 -->
<!-- 这样设置在之后，所有的页面跳转，action都是在这个basePath的基础上进行变化 -->
<!-- 例如：http://localhost:8080/hello/XXX,XXX之前的内容就是basePath，是不会改变的 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<!--   	它指定了当前页面的默认地址为basePath -->
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
<!--   在HelloController.java里面, 封装显示的数据到视图中,mv.addObject("msg", "first spring mvc app"); -->
   ${msg }
  </body>
</html>
