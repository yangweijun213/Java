<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	int a =3;
	int b=4;
	System.out.println(a+b);
	if (a==b){
 %>
 	<p>a===b</p>
 <%
 	}else{
  %>
  <p>a===b</p>
 <%
 	}
  %>
</body>
</html>