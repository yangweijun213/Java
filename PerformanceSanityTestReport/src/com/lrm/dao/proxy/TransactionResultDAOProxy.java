package com.lrm.dao.proxy;

import java.util.List;

import com.lrm.dao.TransactionResultDAO;
import com.lrm.dao.impl.TransactionResultDAOImpl;
import com.lrm.dbc.DatabaseConnection;
import com.lrm.vo.TransactionResult;

public class TransactionResultDAOProxy implements TransactionResultDAO {
	private DatabaseConnection dbc = null;
	private TransactionResultDAO ddao = null;
	
	public TransactionResultDAOProxy(){
		this.dbc = new DatabaseConnection();
		this.ddao = new TransactionResultDAOImpl(this.dbc.getConnection());
	}
	

	@Override
	public List<TransactionResult> doSearch(String keys) {
		// TODO Auto-generated method stub
		List<TransactionResult> all = null;
		all = this.ddao.doSearch(keys);
		this.dbc.close();
		
		return all;
	}


}
