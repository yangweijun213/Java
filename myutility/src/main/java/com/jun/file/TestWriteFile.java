package com.jun.file;

import java.util.ArrayList;
import java.util.List;

public class TestWriteFile {
	
	public static void main(String[] args) throws Exception {
		
		List list=new ArrayList();
		list.add("1");
		list.add("2");
		String fileName ="D:\\workspace\\Java\\myutility\\demo\\file\\test.csv";
		
		//测试:将list写到csv文件
		WriteToFile.writeCSVFile(list, fileName);
	}

}
