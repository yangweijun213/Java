package cn.sxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.sxt.util.BaseDao;
import cn.sxt.vo.User;

public class UserDao {
	public List<User> list(){
		List<User> list = new ArrayList<User>();
		Connection conn = BaseDao.getConnection();
		Statement st=null;
		ResultSet rs =null;
		try {
			st = conn.createStatement();
			String sql="select * from t_user";
			rs = st.executeQuery(sql);
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, st, rs);
		}
		return null;
	}
	public int delete(int id){
		Connection conn = BaseDao.getConnection();
		PreparedStatement st=null;
		ResultSet rs =null;
		try {
			String sql="delete from t_user where id=?";
			st =conn.prepareStatement(sql);
			st.setInt(1, id);
			return st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, st, rs);
		}
		return -1;
	}
	public int add(User user){
		Connection conn = BaseDao.getConnection();
		PreparedStatement st=null;
		ResultSet rs =null;
		try {
			String sql="insert into t_user(name,age) values(?,?)";
			st =conn.prepareStatement(sql);
			st.setString(1, user.getName());
			st.setInt(2, user.getAge());
			return st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, st, rs);
		}
		return -1;
	}
}
