<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			$.post("json.do", function(data) {
				var html="";
				for(var i=0;i<data.length;i++){
					html+="<tr><td>"+data[i].id+"</td><td>"+data[i].name+"</td><td>"+data[i].pwd+"</td></tr>";
				}
				$("#content").html(html);
			});
		});
	});
</script>
</head>
<body>
	<input id="btn" value="获取数据" type="button" />
<table width="80%" align="center">
	<tr>
		<td>编号</td>
		<td>姓名</td>
		<td>密码</td>
	</tr>
	<tbody id="content">
	
	</tbody>
</table>
</body>
</html>
