package com.bjsxt.ejb;

import javax.naming.InitialContext;

public class StatefulEjbClient {
	
	public static void main (String[] args) throws Exception{
		
		//��ʼ��InitialContext�� InitialContext��������JNDI���� JNDI�� Jboss�������ṩ��һ��Ӧ�÷��� 
		//���ƹ��� �� bean Factory
		InitialContext context = new InitialContext();
		//�õ�ejb���� �� name��ejb����/���ʽӿڷ�ʽ. ��һ�λỰ
		StatefulEjb statefulEjb = (StatefulEjb)context.lookup("StatefulEjb/remote");
		System.out.println(statefulEjb.getResult());
		
	}

}