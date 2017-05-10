package com.bjsxt.servlet;

import com.bjsxt.server.Request;
import com.bjsxt.server.Response;

/**
 * 抽象为一个父类
 * @author Administrator
 *
 */
public abstract class Servlet {
	public void service(Request req,Response rep) throws Exception{
		this.doGet(req,rep);
		this.doPost(req,rep);
	}
	
	protected abstract void doGet(Request req,Response rep) throws Exception;
	protected abstract void doPost(Request req,Response rep) throws Exception;
}
