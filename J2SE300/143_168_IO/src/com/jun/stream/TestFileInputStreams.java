package com.jun.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileInputStreams  {
	
	//读文件 - read()方法，一个个字节读
	static void testRead() {	
		File f = new File ("D:\\workspace\\Java\\J2SE300\\143_168_IO\\src\\com\\jun\\stream\\a.txt");
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream (f);
			int i ;
			//从此输入流中读取一个数据字节
			while ((i=fis.read())!= -1) {
				//强转：int转换char
				char a = (char)i;
				System.out.print(a);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//用来之后要关闭
				if (fis!=null){
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		//读文件
		testRead();
	
		
	}
}
