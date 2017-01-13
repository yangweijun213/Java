package com.jun.socket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

//�ٷ����� D:\tool\Development\3rdPartty\apache-tomcat-7.0.73\webapps\examples\WEB-INF\classes\websocket\echo

@ServerEndpoint("/echo")
public class EchoSocket {
	
	public EchoSocket() {
		System.out.println("EchoSocket.EchoSocket()");
	}
	
	
	//�¼���Ӧ����ע��,ֻҪ��������socket,open�����ͻ�ִ��,��ʱ,�ͻ�����ע�����session
	@OnOpen 
	public void open(Session session) {
		//һ��session ����һ��ͨ�ŻỰ��һ���ܵ�����һ��session, �ܵ�����,session����
		//һ���ܵ��кܶ�ͻ��������ӣ�Ϊ�����ֹܵ���˭������,�������Ҫͨ��sessionid��֪��
		System.out.println("sessionid: "+session.getId());
	}
	
	
	
	//�ر�,ֻ��Ҫ��ע��onclose
	@OnClose
	public void close (Session session) {
		System.out.println("session:"+session.getId()+"�ر���");
		
	}
	
	//Message�¼�,����ע���¼�
	@OnMessage
	public void message(Session session, String msg, boolean last){
		
		System.out.println("�ͻ���"+msg);
		
		try {
			session.getBasicRemote().sendText("��������hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
