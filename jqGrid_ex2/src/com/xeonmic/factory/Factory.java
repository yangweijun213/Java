package com.xeonmic.factory;

import com.xeonmic.dao.DemoDAO;
import com.xeonmic.dao.GoodListDAO;
import com.xeonmic.dao.proxy.DemoDAOProxy;
import com.xeonmic.dao.proxy.GoodListDAOProxy;

public class Factory {
	public static DemoDAO getDemoDAOInstance(){
		return new DemoDAOProxy();
	}
	
	public static GoodListDAO getGoodListDAOInstance(){
		return new GoodListDAOProxy();
	}
}
