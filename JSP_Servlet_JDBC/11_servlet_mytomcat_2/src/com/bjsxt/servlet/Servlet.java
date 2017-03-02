package com.bjsxt.servlet;

import com.bjsxt.server.Request;
import com.bjsxt.server.Response;

public abstract class Servlet {
	
	
	/**
	 * 处理请求
	 * @param request
	 * @param response
	 */
	public abstract void service(Request request,Response response);
}
