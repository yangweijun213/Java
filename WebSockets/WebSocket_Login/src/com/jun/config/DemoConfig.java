package com.jun.config;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

//实现接口ServerApplicationConfig,这个接口的实现类，会在项目启动时，自动执行！所以是被动方式
public class DemoConfig implements ServerApplicationConfig {

	//注解方式的启动,会扫描到所有加了注解的类, 提供了过滤作用
	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scan) {
		// TODO Auto-generated method stub
		
		System.out.println("config....."+scan.size());
		
		//返回扫描到的注解的类,提供了过滤作用
		return scan;
	}
	
	//接口方式的启动
	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
