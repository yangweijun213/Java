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
	 * 方法描述  数据库连接，查询所有新闻集合
	 * @return 新闻集合
	 *
	 */
	public List<TestStep> getTestStepList(Integer pageNumber, Integer pageSize) {
		
		List<TestStep> testStepList = new ArrayList<TestStep>();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet =null;
		
		try {
			//1.加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2。驱动管理器获取数据库连接
			connection = DriverManager.getConnection("jdbc:oracle:thin:@172.20.20.35:1521:ora11g","PERF_SANITYTESTREPORT","creditderivative");
			//3。获取statement, 执行sql
			statement = connection.createStatement();
			//4.执行sql返回结果集并解析
			int startSize = (pageNumber-1)*pageSize;
			int endSize = startSize+pageSize;
			//MySQL分页 使用limit
			//resultSet = statement.executeQuery("select * from news limit "+startSize+","+pageSize);
			//Oracle分页 使用rownum
			
		//	resultSet = statement.executeQuery("select * from ( select A.*, ROWNUM rn from ("+sql+") A where ROWNUM <="+endSize+") where rn>"+startSize);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {

				String stepName = resultSet.getString("STEP_NAME");
				String startTime = resultSet.getString("START_TIME");
				String averageTime = resultSet.getString ("ART");
			
				//将返回结果封装到对象 NewsDao，并添加到 列表newsList
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
	 * 方法描述  返回新闻总条数
	 * @return 新闻总条数
	 *
	 */
	
		public int getCount() {
			int count =0;
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet =null;
			
			try {
				//1.加载驱动
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//2。驱动管理器获取数据库连接
				connection = DriverManager.getConnection("jdbc:oracle:thin:@172.20.20.35:1521:ora11g","PERF_SANITYTESTREPORT","creditderivative");
				//3。获取statement, 执行sql
				statement = connection.createStatement();
				//4.执行sql返回结果集并解析, 返回条数(使用count(*)聚合函数)
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
