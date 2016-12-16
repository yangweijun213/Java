package com.xeonmic.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xeonmic.dao.GoodListDAO;
import com.xeonmic.vo.goodlist;

public class GoodListDAOImpl implements GoodListDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public GoodListDAOImpl(Connection conn){
		this.conn=conn;
	}
	@Override
	public List<goodlist> doSearch(String keys) {
		if (keys==null) {
			keys="";
		}
		String sql = "SELECT id,g_id,g_name,g_type,d_num FROM v_list"+keys;
		List<goodlist> all = new ArrayList<goodlist>();
		System.out.println(sql);
		 try {				
				this.pstmt = this.conn.prepareStatement(sql);		
				ResultSet rs = this.pstmt.executeQuery();
				goodlist good = null;
				while(rs.next()){
					good = new goodlist(rs.getInt("id"),rs.getInt("g_id"),rs.getString("g_name"),rs.getInt("g_type"),rs.getInt("d_num"));					
					all.add(good);
				}
				this.pstmt.close();			
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		return all;
	}

}
