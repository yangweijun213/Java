package com.jun.oracle.jdbc;

import java.util.Date;

public class RunMain {

	public static void main(String[] args) throws Exception {
		
		//使用JDBC prepareStamtement执行 insert,select,update,delete
//		PrepareStatement mypstmt = new PrepareStatement();
//		mypstmt.insertData(1, "PrepareStatement", "PrepareStatement", new Date());
//		mypstmt.selectData();
//		mypstmt.updateData();
//		mypstmt.deleteData();
		
		// 使用JDBC createStamtement执行 insert,select,update,delete
		CreateStatement mystmt = new CreateStatement();
		mystmt.insertData();
		mystmt.selectData();
//		mystmt.updateData();
//		mystmt.deleteData();

	}

}
