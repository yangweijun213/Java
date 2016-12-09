package com.lrm.factory;

import com.lrm.dao.IterationResultDAO;
import com.lrm.dao.proxy.DemoDAOProxy;

public class Factory {
	public static IterationResultDAO getDemoDAOInstance(){
		return new DemoDAOProxy();
	}
}
