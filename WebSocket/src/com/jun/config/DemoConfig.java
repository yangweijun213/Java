package com.jun.config;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

//ʵ�ֽӿ�ServerApplicationConfig,����ӿڵ�ʵ���࣬������Ŀ����ʱ���Զ�ִ�У������Ǳ�����ʽ
public class DemoConfig implements ServerApplicationConfig {

	//ע�ⷽʽ������,��ɨ�赽���м���ע�����, �ṩ�˹�������
	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scan) {
		// TODO Auto-generated method stub
		
		System.out.println("config....."+scan.size());
		
		//����ɨ�赽��ע�����,�ṩ�˹�������
		return scan;
	}
	
	//�ӿڷ�ʽ������
	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
