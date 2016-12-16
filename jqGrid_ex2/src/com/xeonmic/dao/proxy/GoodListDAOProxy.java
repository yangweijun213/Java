package com.xeonmic.dao.proxy;

import java.util.List;

import com.xeonmic.dao.GoodListDAO;
import com.xeonmic.dao.impl.GoodListDAOImpl;
import com.xeonmic.dbc.DatabaseConnection;
import com.xeonmic.vo.goodlist;

public class GoodListDAOProxy implements GoodListDAO {
	private DatabaseConnection dbc = null;
	private GoodListDAO ddao = null;
	
	public GoodListDAOProxy(){
		this.dbc = new DatabaseConnection();
		this.ddao = new GoodListDAOImpl(this.dbc.getConnection());
	}
	@Override
	public List<goodlist> doSearch(String keys) {
		List<goodlist> all = null;
		all = this.ddao.doSearch(keys);
		this.dbc.close();
		return all;
	}

}
