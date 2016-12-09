package com.perf.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.perf.entity.TestStep;

public class TestStepDao {	
	
	final String sql = "select * from (select step_name, response_time, FKN_TESTRUN from FCT_RESULT) pivot (avg(response_time) avg_responseTime for (FKN_TESTRUN) in ('1','2','3','4','5','6','7','8' ))";
		
	/**
	 * ��������  ���ݿ����ӣ���ѯ�������ż���
	 * @return ���ż���
	 *
	 */
	public List<TestStep> getTestStepList(Integer pageNumber, Integer pageSize) {
		
		List<TestStep> testStepList = new ArrayList<TestStep>();

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
			
		//	resultSet = statement.executeQuery("select * from ( select A.*, ROWNUM rn from ("+sql+") A where ROWNUM <="+endSize+") where rn>"+startSize);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {

				String stepName = resultSet.getString("STEP_NAME");
				String startTime = resultSet.getString("START_TIME");
				String averageTime = resultSet.getString ("ART");
			
				//�����ؽ����װ������ NewsDao������ӵ� �б�newsList
				TestStep testStep = new TestStep (stepName, startTime, averageTime);
				testStepList.add(testStep);
				
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
	
		return testStepList;
		
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
				resultSet = statement.executeQuery("select count(*) from "+"("+sql+")");
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
