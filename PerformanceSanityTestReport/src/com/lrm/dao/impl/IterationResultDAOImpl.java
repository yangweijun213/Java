package com.lrm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lrm.dao.IterationResultDAO;
import com.lrm.vo.IterationResult;

public class IterationResultDAOImpl implements IterationResultDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public IterationResultDAOImpl(Connection conn){
		this.conn=conn;
	}
	
	@Override
	public boolean doCreate(IterationResult iterationResult) {
		boolean flag = false;
		String sql = "INSERT INTO FACT_PERF_TEST_RESULT(RESPONSE_TIME,BACKEND_TIME,NETWORK_TIME,PAGESIZE,START_TIME	) VALUES(?,?,?,?)";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, iterationResult.getResponseTime());
			this.pstmt.setString(2, iterationResult.getBackendTime());
			this.pstmt.setString(3, iterationResult.getNetworkTime());
			this.pstmt.setString(4, iterationResult.getPageKb());
			this.pstmt.setString(5, iterationResult.getStartTime());
			if(this.pstmt.executeUpdate()>0){
				flag = true;
			}
			this.pstmt.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<IterationResult> doSearch(String keys) {
		// TODO Auto-generated method stub
		if (keys==null) {
			keys="";
		}
		String sql = "SELECT result_id,response_time,backend_time,network_time,pagesize,start_time FROM FACT_PERF_TEST_RESULT "+keys;
		List<IterationResult> all = new ArrayList<IterationResult>();
		System.out.println(sql);
		 try {				
				this.pstmt = this.conn.prepareStatement(sql);		
				ResultSet rs = this.pstmt.executeQuery();
				IterationResult iterationResult = null;
				while(rs.next()){
					iterationResult = new IterationResult(rs.getInt("result_id"),rs.getString("response_time"),rs.getString("backend_time"),rs.getString("network_time"),rs.getString("pagesize"),rs.getString("start_time"));					
					all.add(iterationResult);
				}
				this.pstmt.close();			
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		 
		return all;
	}

	@Override
	public boolean doDelete(int result_id) {
		boolean flag = false;
		String sql = "DELETE FROM FACT_PERF_TEST_RESULT WHERE result_id = ?";
		
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, result_id);
			if(this.pstmt.executeUpdate()>0){
				flag = true;
			}
			this.pstmt.close();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doChange(IterationResult iterationResult) {
		boolean flag = false;
		String sql = "UPDATE FACT_PERF_TEST_RESULT SET response_time=?,backend_time=?,network_time=?,pagesize=?,start_time=? WHERE result_id=?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(6, iterationResult.getResultId());
			this.pstmt.setString(1, iterationResult.getResponseTime());
			this.pstmt.setString(2, iterationResult.getBackendTime());
			this.pstmt.setString(3, iterationResult.getNetworkTime());
			this.pstmt.setString(4, iterationResult.getPageKb());
			this.pstmt.setString(5, iterationResult.getStartTime());
			if(this.pstmt.executeUpdate()>0){
				flag = true;
			}
			this.pstmt.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return flag;
	}

}
