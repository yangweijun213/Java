package cn.sxt.dao;

import java.util.ArrayList;
import java.util.List;

import cn.sxt.vo.User;

public class UserDao {
	public List<User> list(){
		List<User> list = new ArrayList<User>();
		list.add(new User(1, "lis", 23));
		list.add(new User(2, "wangwu", 23));
		list.add(new User(3, "zhangsan", 23));
		return list;
	}
}
