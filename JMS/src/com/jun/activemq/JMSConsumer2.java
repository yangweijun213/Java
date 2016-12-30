package com.jun.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import com.jun.activemq.Listener;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

//使用注册监听的方式,开发中使用这个方式
public class JMSConsumer2 {

	// 连接到activemq web服务
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名,admin
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
																				// admin
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // 默认的连接地址

	public static void main(String[] args) {

		ConnectionFactory connectionFactory; // 连接工厂
		Connection connection = null; // 连接
		Session session; // 会话 发送或接受消息的线程
		Destination destination; // 消息的目的地
		MessageConsumer messageConsumer; // 消息的消费者

		// 实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);

		try {
			connection = connectionFactory.createConnection(); // 通过连接工厂获取连接
			connection.start(); // 启动连接
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE); //consumer不需要提交事务
			destination = session.createQueue("firstQueue"); //创建连接的消息对列,需要与JMSProducer的createQueue一样
			messageConsumer=session.createConsumer(destination);
			messageConsumer.setMessageListener(new Listener()); //注册消息监听
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close(); // 关闭连接，否则消耗服务器的资源
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
