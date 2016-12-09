package com.perf.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.perf.entity.Iterations;

public class IterationsDao {	
	
	/**
	 * ��������  ���ݿ����ӣ���ѯ�������ż���
	 * @return ���ż���
	 *
	 */
	public List<Iterations> getIterationsList(Integer pageNumber, Integer pageSize) {
		
		List<Iterations> iterationsList = new ArrayList<Iterations>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet =null;
		
		try {
			//1.��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2��������������ȡ���ݿ�����
			connection = DriverManager.getConnection("jdbc:oracle:thin:@172.20.20.35:1521:ora11g","PERF_SANITYTESTREPORT","creditderivative");
			//3����ȡstatement, ִ��sql
			statement = connection.createStatement();
			//4.ִ��sql���ؽ����������
			int startSize = (pageNumber-1)*pageSize;
			int endSize = startSize+pageSize;
			//MySQL��ҳ ʹ��limit
			//resultSet = statement.executeQuery("select * from news limit "+startSize+","+pageSize);
			//Oracle��ҳ ʹ��rownum
			resultSet = statement.executeQuery("select * from ( select A.*, ROWNUM rn from (select * from ITERATION) A where ROWNUM <="+endSize+") where rn>"+startSize);
			while (resultSet.next()) {
				int resultId = resultSet.getInt("RESULT_ID");
				String responseTime = resultSet.getString("RESPONSE_TIME");
				String backendTime = resultSet.getString ("BACKEND_TIME");
				String networkTime = resultSet.getString ("NETWORK_TIME");
				String pageKb = resultSet.getString ("PAGESIZE");
				String time = resultSet.getString ("TIME");
			
				//�����ؽ����װ������ NewsDao������ӵ� �б�newsList
				Iterations iterations = new Iterations (resultId, time, responseTime, backendTime, networkTime,pageKb);
				iterationsList.add(iterations);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if (resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return iterationsList;
		
	}
	
	/**
	 * ��������  ��������������
	 * @return ����������
	 *
	 */
	
		public int getCount() {
			int count =0;
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet =null;
			
			try {
				//1.��������
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//2��������������ȡ���ݿ�����
				connection = DriverManager.getConnection("jdbc:oracle:thin:@172.20.20.35:1521:ora11g","PERF_SANITYTESTREPORT","creditderivative");
				//3����ȡstatement, ִ��sql
				statement = connection.createStatement();
				//4.ִ��sql���ؽ����������, ��������(ʹ��count(*)�ۺϺ���)
				resultSet = statement.executeQuery("select count(*) from ITERATION");
				if (resultSet.next()) {
					count = resultSet.getInt(1);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
				if (resultSet!=null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (resultSet!=null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (resultSet!=null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			return count;
			
		}

}
