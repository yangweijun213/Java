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
	public List<News> getNewsList() {
		
		List<News> newsList = new ArrayList<News>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet =null;
		
		try {
			//1.��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2��������������ȡ���ݿ�����
			connection = DriverManager.getConnection("jdbc:oracle:thin:@172.20.20.35:1521:ora11g","blog","creditderivative");
			//3����ȡstatement, ִ��sql
			statement = connection.createStatement();
			//4.ִ��sql���ؽ����������
			resultSet = statement.executeQuery("select * from news");
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

}
