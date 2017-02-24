package com.bjsxt.ejb;

import javax.naming.InitialContext;

public class StatelessEjbClient {
	
	public static void main (String[] args) throws Exception{
		
		//��ʼ��InitialContext�� InitialContext��������JNDI���� JNDI�� Jboss�������ṩ��һ��Ӧ�÷��� 
		//���ƹ��� �� bean Factory
		InitialContext context = new InitialContext();
		//�õ�ejb���� �� name��ejb����/���ʽӿڷ�ʽ. ��һ�λỰ
		StatelessEjb statelessEjb = (StatelessEjb)context.lookup("StatelessEjb/remote");
		System.out.println(statelessEjb.getResult());
		statelessEjb.compute(1);
		System.out.println(statelessEjb.getResult());
		statelessEjb.compute(1);
		System.out.println(statelessEjb.getResult());
		statelessEjb.compute(1);
		System.out.println(statelessEjb.getResult());
		statelessEjb.compute(1);
		System.out.println(statelessEjb.getResult());
		statelessEjb.compute(1);
		System.out.println(statelessEjb.getResult());
		statelessEjb.compute(1);
		System.out.println(statelessEjb.getResult());
		
		//�ڶ��λỰ
		StatelessEjb statelessEjb2 = (StatelessEjb)context.lookup("StatelessEjb/remote");
		System.out.println(statelessEjb2.getResult());
		statelessEjb2.compute(1);
		System.out.println(statelessEjb2.getResult());
		statelessEjb2.compute(1);
		System.out.println(statelessEjb2.getResult());
		statelessEjb2.compute(1);
		System.out.println(statelessEjb2.getResult());
		statelessEjb2.compute(1);
		System.out.println(statelessEjb2.getResult());
		statelessEjb2.compute(1);
		System.out.println(statelessEjb2.getResult());
		statelessEjb2.compute(1);
		System.out.println(statelessEjb2.getResult());
		
		
	}

}
