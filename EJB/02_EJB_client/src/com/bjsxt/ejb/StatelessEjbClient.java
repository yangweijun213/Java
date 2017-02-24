package com.bjsxt.ejb;

import javax.naming.InitialContext;

public class StatelessEjbClient {
	
	public static void main (String[] args) throws Exception{
		
		//初始化InitialContext， InitialContext对象属于JNDI对象， JNDI是 Jboss服务器提供的一个应用服务 
		//类似工厂 。 bean Factory
		InitialContext context = new InitialContext();
		//得到ejb对象 ， name是ejb名称/访问接口方式. 第一次会话
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
		
		//第二次会话
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
