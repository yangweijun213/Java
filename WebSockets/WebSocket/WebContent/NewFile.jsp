<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	var ws; //一个ws对象就是一个通信管道
	var target = "ws://localhost:8080/WebSocket/echo"; //定位到服务器的EchoSocket的endpoint

	function subOpen() {

		if ('WebSocket' in window) {
			ws = new WebSocket(target);
		} else if ('MozWebSocket' in window) {
			ws = new MozWebSocket(target);
		} else {
			alert('WebSocket is not supported by this browser.');
			return;
		}

		//注册onmessage时间，数据被动接收
/* 		ws.onmessage = function(event) {
			//chrome控制台打印onmessage事件信息
			console.info(event);
		}; */
		
		//event对象里面有data属性，获取data属性值
		ws.onmessage = function(event) {
		 //打印到id=dv的 地方 
		 var dv = document.getElementById("dv");
		 dv.innerHTML += event.data;
		 }; 
	}

	function subSend() {
		//找到input的 value值
		var msg = document.getElementById("msg").value
		ws.send(msg);
		document.getElementById("msg").value = "";
	}
</script>
</head>
<body>

	<button onclick="subOpen();">open</button>
	<input id="msg" />
	<button onclick="subSend();">send</button>
	<div id="dv"></div>
</body>
</html>