package com.jun.activemq2;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 * ��Ϣ���� - ������2
 * @author jeff yang
 *
 */
public class Listener2 implements MessageListener {

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			System.out.println("������2�յ�����Ϣ:"+ ((TextMessage)message).getText()); //ǿ��ת��,������Ϣ
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
