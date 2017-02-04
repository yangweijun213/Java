package cn.sxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import cn.sxt.util.BaseDao;
import cn.sxt.vo.News;

public class NewsDao {
	public List<News> list(){
		List<News> list = new ArrayList<News>();
		Connection conn = BaseDao.getConnection();
		Statement st=null;
		ResultSet rs =null;
		try {
			st = conn.createStatement();
			String sql="select * from t_news";
			rs = st.executeQuery(sql);
			while(rs.next()){
				News news = new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				list.add(news);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, st, rs);
		}
		return null;
	}
	public News getById(int id){
		Connection conn = BaseDao.getConnection();
		Statement st=null;
		ResultSet rs =null;
		try {
			st = conn.createStatement();
			String sql="select * from t_news where id="+id;
			rs = st.executeQuery(sql);
			if(rs.next()){
				News news = new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				return news;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, st, rs);
		}
		return null;
	}
	public int update(News news){
		Connection conn = BaseDao.getConnection();
		PreparedStatement st=null;
		ResultSet rs =null;
		try {
			String sql="update t_news set title=?,content=? where id=?";
			st =conn.prepareStatement(sql);
			st.setString(1, news.getTitle());
			st.setString(2,news.getContent());
			st.setInt(3,news.getId());
			return st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, st, rs);
		}
		return -1;
	}
}
