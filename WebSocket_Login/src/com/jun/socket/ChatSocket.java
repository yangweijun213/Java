package com.jun.socket;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatSocket")
public class ChatSocket {
	
	private String username;
	@OnOpen
	public void open(Session session) {
		//��ǰ��websocket��session����,����servlet��session����
		
		//��var target���������ʺŵĴ�ӡ����
		String queryString = session.getQueryString();
		System.out.println(queryString);
		
		//aaa,bbb, ȡ��aaa���ֵ
		//username = queryString.split("=")[1];
	}

}
