package com.jun.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


/**
 * @author jeff yang
 *
 */
public class JMSPoducer {
	
	//���ӵ�activemq web����
	private static final String USERNAME=ActiveMQConnection.DEFAULT_USER; //Ĭ�ϵ������û���,admin
	private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD; //Ĭ�ϵ���������, admin
	private static final String BROKEURL=ActiveMQConnection.DEFAULT_BROKER_URL; //Ĭ�ϵ����ӵ�ַ
	private static final int SENDUM=10; //���͵���Ϣ����
	
	public static void main (String[] args) {
		ConnectionFactory connectionFactory; //���ӹ���
		Connection connection = null; //����
		Session session = null; //�Ự ���ͻ������Ϣ���߳�
		Destination destination; //��Ϣ��Ŀ�ĵ�
		MessageProducer messageProducer = null; //��Ϣ������
		
		//ʵ�������ӹ���
		connectionFactory = new ActiveMQConnectionFactory(JMSPoducer.USERNAME, JMSPoducer.PASSWORD, JMSPoducer.BROKEURL);
		
		try {
			connection = connectionFactory.createConnection(); //ͨ�����ӹ�����ȡ����
			connection.start(); //��������
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE); //�����Ự����һ�������Ƿ�����, �ڶ��������Զ�ȷ��
			destination = session.createQueue("firstQueue"); //������Ϣ����
			messageProducer = session.createProducer(destination); //������Ϣ������
			sendMessage(session, messageProducer); //������Ϣ
			session.commit(); //�����ύ, ���������ύ
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection!=null) {
				try {
					connection.close(); //�ر����ӣ��������ķ���������Դ
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		    if (messageProducer !=null) {
		    	try {
					messageProducer.close();
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
	


	/**
	 * ������Ϣ
	 * @param session
	 * @param messageProducer
	 * @throws Exception
	 */
	public static void sendMessage (Session session, MessageProducer messageProducer) throws Exception{
		for (int i=0; i<JMSPoducer.SENDUM;i++){
			TextMessage message=session.createTextMessage("ActiveMQ ������Ϣ"+i);
			System.out.println("������Ϣ��"+"ActiveMQ ������Ϣ"+i);
			messageProducer.send(message); //��Ϣ�ķ�����messageProducer�߷��͵�
		}
	}
}
