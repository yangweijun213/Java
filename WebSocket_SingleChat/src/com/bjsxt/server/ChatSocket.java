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

import com.bjsxt.vo.ContentVo;
import com.bjsxt.vo.Message;
import com.google.gson.Gson;

@ServerEndpoint("/chatSocket")
public class ChatSocket {

	// private static Set<ChatSocket> sockets=new HashSet<ChatSocket>();
	// private static Map<String, ChatSocket> sMap=new HashMap<String,
	// ChatSocket>();

	private static List<Session> sessions = new ArrayList<Session>();
	private static Map<String, Session> map = new HashMap<String, Session>();
	private static List<String> names = new ArrayList<String>();
	private Session session;
	private String username;
	private static Gson gson = new Gson();

	@OnOpen
	public void open(Session session) {

		// ��ǰwebsocket��session����
		String queryString = session.getQueryString();
		System.out.println(queryString);
		username = queryString.split("=")[1];
		this.names.add(username);
		this.sessions.add(session);
		this.map.put(this.username, session);

		String msg = "��ӭ" + this.username + "����������!";
		Message message = new Message();
		message.setAlert(msg);
		message.setNames(names);

		this.broadcast(this.sessions, message.toJson());

	}

	@OnMessage
	public void message(Session session, String json) {

		// ��Jason�� ת��Java����
		ContentVo vo = gson.fromJson(json, ContentVo.class);

		if (vo.getType() == 1) {
			// �㲥
			Message message = new Message();
			message.setSendMsg(this.username, vo.getMsg());
			broadcast(sessions, message.toJson());
		} else {
			// ����
			// ����username ������ҵ���Ӧ��session����
			String to = vo.getTo();
			Session to_session = this.map.get(to);

			Message message = new Message();
			message.setSendMsg(this.username,"<font color=red>˽��: "+vo.getMsg()+"</font>");

			try {
				to_session.getBasicRemote().sendText(message.toJson());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@OnClose
	public void close(Session session) {

		this.sessions.remove(session);
		this.names.remove(this.username);

		String msg = "�˳�" + this.username + "�뿪������!";
		Message message = new Message();
		message.setAlert(this.username + "�˳������ң���");
		message.setNames(names);

		// �㲥
		broadcast(this.sessions, message.toJson());

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
