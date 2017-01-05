package com.jun.activemq2;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 * 消息监听 - 订阅者1
 * @author jeff yang
 *
 */
public class Listener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			System.out.println("订阅者1收到的消息:"+ ((TextMessage)message).getText()); //强制转换,监听消息
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
