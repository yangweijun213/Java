package com.newsmanager.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newsmanager.entity.News;

public class NewsDao {	
	
	/**
	 * ��������  ���ݿ����ӣ���ѯ�������ż���
	 * @return ���ż���
	 *
	 */
	public List<News> getNewsList(Integer pageNumber, Integer pageSize) {
		
		List<News> newsList = new ArrayList<News>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet =null;
		
		try {
			//1.��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2��������������ȡ���ݿ�����
			connection = DriverManager.getConnection("jdbc:oracle:thin:@172.20.20.35:1521:ora11g","NEWSMANAGER","creditderivative");
			//3����ȡstatement, ִ��sql
			statement = connection.createStatement();
			//4.ִ��sql���ؽ����������
			int startSize = (pageNumber-1)*pageSize;
			int endSize = startSize+pageSize;
			//MySQL��ҳ ʹ��limit
			//resultSet = statement.executeQuery("select * from news limit "+startSize+","+pageSize);
			//Oracle��ҳ ʹ��rownum
			resultSet = statement.executeQuery("select * from ( select A.*, ROWNUM rn from (select * from news) A where ROWNUM <="+endSize+") where rn>"+startSize);
			while (resultSet.next()) {
				int newsId = resultSet.getInt("newsid");
				String newsTitle = resultSet.getString("newstitle");
				String newsContent = resultSet.getString ("newscontent");
				String newsStatus = resultSet.getString ("newsstatus");
				String newsType = resultSet.getString ("newstype");
				Date createTime = resultSet.getDate ("createtime");
				
				//�����ؽ����װ������ NewsDao������ӵ� �б�newsList
				News news = new News (newsId, newsTitle, newsContent, newsStatus,newsType,createTime);
				newsList.add(news);
				
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
		
		return newsList;
		
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
				connection = DriverManager.getConnection("jdbc:oracle:thin:@172.20.20.35:1521:ora11g","NEWSMANAGER","creditderivative");
				//3����ȡstatement, ִ��sql
				statement = connection.createStatement();
				//4.ִ��sql���ؽ����������, ��������(ʹ��count(*)�ۺϺ���)
				resultSet = statement.executeQuery("select count(*) from news");
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
