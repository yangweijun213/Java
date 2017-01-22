package com.jun.file;

import java.io.File;
import java.io.IOException;

public class TestFile {
	
	public static void main(String[] args) {
		
		//构造器  File(String pathname)
		File f = new File ("D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\file\\TestFile.txt");
		File f2 = new File ("D:/workspace/Java/JavaStart/src/com/jun/file/");
		//构造器 File(String parent, String child) 
		File f3 = new File (f2,"TestFile.txt");
		
		if (f.isFile()){
			System.out.println("this is file");
		}
		
		if (f2.isDirectory()) {
			System.out.println("this is a directory");
		}
		
		//新建文件
		File f4 = new File (f2,"TestFile2.txt");
		try {
			f4.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//删除文件
		f4.delete();
		
		//创建目录mkdir , 如果父目录村存在，就创建，不存在不创建
		File f5 = new File ("D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\file\\createfolder");
		f5.mkdir();
		
		//创建目录mkdirs, 如果前面目录不存在，会自动创建
		File f6 = new File ("D:/workspace/Java/JavaStart/src/com/jun/file/aa/bb/createfolder");
		f6.mkdirs();
		
	}

}
