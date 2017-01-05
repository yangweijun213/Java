package com.jun.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import com.jun.activemq.Listener;

public class JMSConsumer2 {

	// ���ӵ�activemq web����
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // Ĭ�ϵ������û���,admin
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // Ĭ�ϵ���������
																				// //
																				// admin
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // Ĭ�ϵ����ӵ�ַ

	public static void main(String[] args) {

		ConnectionFactory connectionFactory; // ���ӹ���
		Connection connection = null; // ����
		Session session = null; // �Ự ���ͻ������Ϣ���߳�
		Destination destination; // ��Ϣ��Ŀ�ĵ�
		MessageConsumer messageConsumer = null; // ��Ϣ��������

		// ʵ�������ӹ���
		connectionFactory = new ActiveMQConnectionFactory(JMSConsumer2.USERNAME, JMSConsumer2.PASSWORD,
				JMSConsumer2.BROKEURL);

		try {
			connection = connectionFactory.createConnection(); // ͨ�����ӹ�����ȡ����
			connection.start(); // ��������
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE); // ����session,
																							// consumer����Ҫ�ύ����
			destination = session.createQueue("firstQueue"); // �������ӵ���Ϣ����,��Ҫ��JMSProducer��createQueueһ��
			messageConsumer = session.createConsumer(destination);
			System.out.println("Consumer:->Begin listening...");
			messageConsumer.setMessageListener(new Listener()); // ��ʼ����
			
			//
			Thread.sleep(120000);
			System.out.println("Consumer:->End listening...");
	

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close(); // �ر����ӣ��������ķ���������Դ
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (messageConsumer != null) {
				try {
					messageConsumer.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (session != null) {
				try {
					session.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
