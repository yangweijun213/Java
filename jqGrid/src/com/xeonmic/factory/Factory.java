package com.xeonmic.factory;

import com.xeonmic.dao.DemoDAO;
import com.xeonmic.dao.proxy.DemoDAOProxy;

public class Factory {
	public static DemoDAO getDemoDAOInstance(){
		return new DemoDAOProxy();
	}
}
