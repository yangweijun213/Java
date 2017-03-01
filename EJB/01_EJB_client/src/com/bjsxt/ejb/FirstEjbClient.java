package com.bjsxt.ejb;

import javax.naming.InitialContext;

public class FirstEjbClient {
	
	public static void main (String[] args) throws Exception{
		
		//��ʼ��InitialContext�� InitialContext��������JNDI���� JNDI�� Jboss�������ṩ��һ��Ӧ�÷��� 
		//���ƹ��� �� bean Factory
		InitialContext context = new InitialContext();
		//�õ�ejb���� �� name��ejb����/���ʽӿڷ�ʽ
		FirstEjb firstEjb = (FirstEjb)context.lookup("FirstEjbBean/remote");
		String s = firstEjb.saySomething("jeff yang");
		System.out.println(s);
	}

}