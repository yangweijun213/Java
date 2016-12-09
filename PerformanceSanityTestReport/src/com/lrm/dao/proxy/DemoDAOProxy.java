package com.lrm.dao.proxy;

import java.util.List;

import com.lrm.dao.IterationResultDAO;
import com.lrm.dao.impl.IterationResultDAOImpl;
import com.lrm.dbc.DatabaseConnection;
import com.lrm.vo.IterationResult;

public class DemoDAOProxy implements IterationResultDAO {
	private DatabaseConnection dbc = null;
	private IterationResultDAO ddao = null;
	
	public DemoDAOProxy(){
		this.dbc = new DatabaseConnection();
		this.ddao = new IterationResultDAOImpl(this.dbc.getConnection());
	}
	
	@Override
	public boolean doCreate(IterationResult iterationResult) {
		boolean flag = false;
		flag = this.ddao.doCreate(iterationResult);
		this.dbc.close();
		return flag;
	}

	@Override
	public List<IterationResult> doSearch(String keys) {
		// TODO Auto-generated method stub
		List<IterationResult> all = null;
		all = this.ddao.doSearch(keys);
		this.dbc.close();
		
		return all;
	}

	@Override
	public boolean doDelete(int id) {
		boolean flag = false;
		flag = this.ddao.doDelete(id);
		this.dbc.close();
		return flag;
	}

	@Override
	public boolean doChange(IterationResult iterationResult) {
		boolean flag = false;
		flag = this.ddao.doChange(iterationResult);
		this.dbc.close();
		return flag;
	}

}
