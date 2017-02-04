package com.jun.socket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

//官方例子 D:\tool\Development\3rdPartty\apache-tomcat-7.0.73\webapps\examples\WEB-INF\classes\websocket\echo

@ServerEndpoint("/echo")
public class EchoSocket {
	
	public EchoSocket() {
		System.out.println("EchoSocket.EchoSocket()");
	}
	
	
	//事件响应基于注解,只要游人连接socket,open方法就会执行,此时,就会依赖注入进来session
	@OnOpen 
	public void open(Session session) {
		//一个session 代表一个通信会话，一个管道代表一个session, 管道结束,session结束
		//一个管道有很多客户端来连接，为了区分管道是谁连接呢,，因此需要通过sessionid来知道
		System.out.println("sessionid: "+session.getId());
	}
	
	
	
	//关闭,只需要加注解onclose
	@OnClose
	public void close (Session session) {
		System.out.println("session:"+session.getId()+"关闭了");
		
	}
	
	//Message事件,依赖注入事件
	@OnMessage
	public void message(Session session, String msg, boolean last){
		
		System.out.println("客户端"+msg);
		
		try {
			session.getBasicRemote().sendText("服务器：hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
