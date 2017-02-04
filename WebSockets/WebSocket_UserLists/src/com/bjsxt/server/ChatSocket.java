package com.bjsxt.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.bjsxt.vo.Message;
import com.google.gson.Gson;

@ServerEndpoint("/chatSocket")
public class ChatSocket {

	// private static Set<ChatSocket> sockets=new HashSet<ChatSocket>();
	// private static Map<String, ChatSocket> sMap=new HashMap<String,
	// ChatSocket>();

	private static List<Session> sessions = new ArrayList<Session>();
	private static List<String> names = new ArrayList<String>();
	private Session session;
	private String username;
//	private Gson gson = new Gson();

	@OnOpen
	public void open(Session session) {
		
		//��ǰwebsocket��session����
		String queryString = session.getQueryString();
		System.out.println(queryString);
		username = queryString.split("=")[1];
		this.names.add(username);
		this.sessions.add(session);
		
		String msg="��ӭ"+this.username+"����������!";
		Message message = new Message();
		message.setAlert(msg);
		message.setNames(names);
		
		this.broadcast(this.sessions, message.toJson());
		
	}

/*	@OnMessage
	public void receive(Session session, String msg) {

		Message message = new Message();
		message.setSendMsg(msg);
		message.setFrom(this.username);
	}
*/
	@OnClose
	public void close(Session session) {
		
		this.sessions.remove(session);
		this.names.remove(this.username);
		
		String msg="�˳�"+this.username+"�뿪������!";
		Message message = new Message();
		message.setAlert(this.username + "�˳������ң���");
		message.setNames(names);
		
		//�㲥
		broadcast(this.sessions,message.toJson());
		
	}

	public void broadcast(List<Session> ss, String msg) {

		for (Iterator iterator = ss.iterator(); iterator.hasNext();) {
			Session session = (Session) iterator.next();
			try {
				session.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
