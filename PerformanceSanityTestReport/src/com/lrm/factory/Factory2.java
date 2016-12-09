package com.lrm.factory;

import com.lrm.dao.TransactionResultDAO;
import com.lrm.dao.proxy.TransactionResultDAOProxy;

public class Factory2 {
	public static TransactionResultDAO getTransactionResultDAOInstance(){
		return new TransactionResultDAOProxy();
	}
}
