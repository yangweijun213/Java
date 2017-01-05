package com.jun.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSConsumer {

	// ���ӵ�activemq web����
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // Ĭ�ϵ������û���,admin
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // Ĭ�ϵ���������																			// admin
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // Ĭ�ϵ����ӵ�ַ

	public static void main(String[] args) {

		ConnectionFactory connectionFactory; // ���ӹ���
		Connection connection = null; // ����
		Session session; // �Ự ���ͻ������Ϣ���߳�
		Destination destination; // ��Ϣ��Ŀ�ĵ�
		MessageConsumer messageConsumer; // ��Ϣ��������

		// ʵ�������ӹ���
		connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKEURL);

		try {
			connection = connectionFactory.createConnection(); // ͨ�����ӹ�����ȡ����
			connection.start(); // ��������
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE); //����session, consumer����Ҫ�ύ����
			destination = session.createQueue("firstQueue"); //�������ӵ���Ϣ����,��Ҫ��JMSProducer��createQueueһ��
			messageConsumer=session.createConsumer(destination);
			
			//һֱ�ڼ�������������Ҫ�������ʽ���ã�һ�㲻��ô��
			while (true) {
				TextMessage textMessage = (TextMessage)messageConsumer.receive(100000);
				if (textMessage !=null) {
					System.out.println("�յ�����Ϣ: "+textMessage.getText());
				}else {
					break;
				}
			}
			
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
		}

	}
}
