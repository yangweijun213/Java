package com.bjsxt.init;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

public class SocketConfig  implements ServerApplicationConfig {

	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> ss) {
		// TODO Auto-generated method stub
		System.out.println("endPointɨ�赽��������"+ss.size());
		
		return ss;
	}

	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(
			Set<Class<? extends Endpoint>> ss) {
		// TODO Auto-generated method stub
		System.out.println("ʵ��EndPoint�ӿڵ���������"+ss.size());
		return null;
	}

}
