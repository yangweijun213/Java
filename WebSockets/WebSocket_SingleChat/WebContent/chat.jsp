<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	var ws;
	var url = "ws://localhost:8080/WebSocket_SingleChat/chatSocket?username=${sessionScope.username}";

	window.onload = connect;
	function connect() {
		if ('WebSocket' in window) {
			ws = new WebSocket(url);
		} else if ('MozWebSocket' in window) {
			ws = new MozWebSocket(url);
		} else {
			alert('WebSocket is not supported by this browser.');
			return;
		}
		ws.onmessage = function(event) {
			//使用eval转jason,把json返回给result
			eval("var msg=" + event.data + ";");

			console.info(msg);

			if (undefined != msg.alert) {
				$("#content").append(msg.alert + "<br/>");
			}

			if (msg.names != undefined) {

				//清空列表
				$("#userList").html("");
				//遍历数组，获取人名，信息分离
				$(msg.names).each(
						function() {
							$("#userList").append(
									"<input type=checkbox value='"+this+"'/>"
											+ this + "<br/>")
						});
			}

			if (undefined != msg.sendMsg) {
				$("#content").append(msg.sendMsg);
			}

		}
	}

	function subSend() {

		// 		var val = $("#msg").val();
		// 		ws.send(val);
		// 		$("#msg").val("");

		// 		找到所有被勾选的人名
		// 		var ss= $("#userList :checked");
		// 		console.info(ss.val());

		var ss = $("#userList :checked");
		var val = $("#msg").val();
		var obj = null;
		if (ss.size() == 0) {
			obj = {

				to : to,
				msg : val,
				type : 1
			// 1广播， 2 单聊
			}
		} else {
			var to = $("#userList :checked").val();
			obj = {
				to : to,
				msg : val,
				type : 2
			// 1广播， 2 单聊
			}
		}
			var str=JSON.stringify(obj);
			ws.send(str);
			
			//数据清空
			$("#msg").val("");
			console.info(str);
	}
</script>
</head>
<body>

	<h3>欢迎 ${sessionScope.username } 使用本系统！！</h3>

	<div id="content"
		style="border: 1px solid black; width: 400px; height: 300px; float: left;"></div>
	<div id="userList"
		style="border: 1px solid black; width: 100px; height: 300px; float: left;"></div>

	<div style="clear: both;">
		<input id="msg" />
		<button onclick="subSend();">send</button>
	</div>


</body>
</html>