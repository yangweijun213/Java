<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript">
	//就是登陆的那个人 
	var username = "${sessionScope.username}";
	var ws; //一个ws对象就是一个通信管道
	var target = "ws://localhost:8080/WebSocket_Login/chatSocket?username"
			+ username; //定位到服务器的EchoSocket的endpoint

	window.onload = function() {

		//进入聊天页面,就打开socket通道
		if ('WebSocket' in window) {
			ws = new WebSocket(target);
		} else if ('MozWebSocket' in window) {
			ws = new MozWebSocket(target);
		} else {
			alert('WebSocket is not supported by this browser.'); 
			return;
		}

	}
</script>
</head>
<body>

	<!-- 	放聊天内容 -->
	<div id="content"></div>

	<!-- 	进入聊天室的人 -->
	<div id="userList"></div>

</body>
</html>