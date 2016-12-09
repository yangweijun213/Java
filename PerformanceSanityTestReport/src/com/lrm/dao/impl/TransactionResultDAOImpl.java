package com.lrm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lrm.dao.TransactionResultDAO;
import com.lrm.vo.TransactionResult;

public class TransactionResultDAOImpl implements TransactionResultDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public TransactionResultDAOImpl(Connection conn){
		this.conn=conn;
	}
	
	
	@Override
	public List<TransactionResult> doSearch(String keys) {
		// TODO Auto-generated method stub
		if (keys==null) {
			keys="";
		}
		String sql = "select c.transaction_name, b.start_time, avg(a.response_time) as average_response  from FACT_PERF_TEST_RESULT a inner join DIM_TEST_RUN b on a.dim_test_run_fkn = b.RUN_ID inner join DIM_BUSINESS_TRANSACTION c on  a.dim_business_transaction_fkn = c.transaction_id group by b.start_time, c.transaction_name order by b.start_time "+keys;
		List<TransactionResult> all = new ArrayList<TransactionResult>();
		System.out.println(sql);
		 try {				
				this.pstmt = this.conn.prepareStatement(sql);		
				ResultSet rs = this.pstmt.executeQuery();
				TransactionResult transactionResult = null;
				while(rs.next()){
					transactionResult = new TransactionResult(rs.getString("transaction_name"),rs.getString("start_time"),rs.getString("average_response"));					
					all.add(transactionResult);
				}
				this.pstmt.close();			
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		
		 System.out.println(all);
		 
		return all;
	}

}
