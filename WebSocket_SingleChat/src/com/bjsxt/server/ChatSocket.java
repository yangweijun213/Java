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

		// 当前websocket的session对象
		String queryString = session.getQueryString();
		System.out.println(queryString);
		username = queryString.split("=")[1];
		this.names.add(username);
		this.sessions.add(session);
		this.map.put(this.username, session);

		String msg = "欢迎" + this.username + "进入聊天室!";
		Message message = new Message();
		message.setAlert(msg);
		message.setNames(names);

		this.broadcast(this.sessions, message.toJson());

	}

	@OnMessage
	public void message(Session session, String json) {

		// 将Jason串 转成Java对象
		ContentVo vo = gson.fromJson(json, ContentVo.class);

		if (vo.getType() == 1) {
			// 广播
			Message message = new Message();
			message.setSendMsg(this.username, vo.getMsg());
			broadcast(sessions, message.toJson());
		} else {
			// 单聊
			// 根据username 如果能找到对应的session对象
			String to = vo.getTo();
			Session to_session = this.map.get(to);

			Message message = new Message();
			message.setSendMsg(this.username,"<font color=red>私聊: "+vo.getMsg()+"</font>");

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

		String msg = "退出" + this.username + "离开聊天室!";
		Message message = new Message();
		message.setAlert(this.username + "退出聊天室！！");
		message.setNames(names);

		// 广播
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
