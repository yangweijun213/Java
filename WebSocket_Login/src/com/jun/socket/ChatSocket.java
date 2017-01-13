package com.jun.socket;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatSocket")
public class ChatSocket {
	
	private String username;
	@OnOpen
	public void open(Session session) {
		//当前的websocket的session对象,不是servlet的session对象
		
		//把var target后面所有问号的打印出来
		String queryString = session.getQueryString();
		System.out.println(queryString);
		
		//aaa,bbb, 取了aaa这个值
		//username = queryString.split("=")[1];
	}

}
