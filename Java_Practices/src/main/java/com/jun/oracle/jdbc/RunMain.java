package com.jun.oracle.jdbc;

import java.util.Date;

public class RunMain {

	public static void main(String[] args) throws Exception {

		SimpleOracleJDBC myJdbcUtils = new SimpleOracleJDBC();
		//插入数据
		myJdbcUtils.insertData(1, "jeff", "jeff", new Date());
		//查询数据
		myJdbcUtils.selectData();
		//更新数据
		myJdbcUtils.updateData();
		//删除数据
		myJdbcUtils.deleteData();

	}

}
