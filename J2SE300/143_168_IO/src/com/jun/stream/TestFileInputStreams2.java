package com.jun.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileInputStreams2  {
	

	//读文件 - read(byte[)方法，加了缓存池，一起读取
	static void testRead() {	
		FileInputStream fis = null;
		
		try {
			//通过打开一个到实际文件的连接来创建一个 FileInputStream
			fis = new FileInputStream ("D:\\workspace\\Java\\J2SE300\\143_168_IO\\src\\com\\jun\\stream\\a.txt");
			
			//一个可变的字符序列, 效率高,如果使用str+效率比较低
			StringBuilder sb = new StringBuilder();
			int temp=0;
			//字节数组,定义缓存1k
			byte[] buf =new byte[1024];

			//读入一个 byte 数组
			while ((temp=fis.read(buf))!= -1) {
				//分配一个新的 String,参数:字节数组,开始,字节数组大小
				String str =new String(buf, 0, temp);
				//增加string
				sb.append(str);
				
			}
			
			//将可变字符序列专程字符串打印出来
			System.out.println(sb.toString());
			
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
