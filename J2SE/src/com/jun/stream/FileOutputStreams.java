package com.jun.stream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import sun.applet.Main;

public class FileOutputStreams {

	// 写文件
	static void testWrite() {
				
		FileOutputStream fos = null;
				String str = "abcdefdfddfdfdf";
				try {
					//追加
					//fos = new FileOutputStream ("F:\\yangweijun\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a.txt",true);
					
					//重写
					//fos = new FileOutputStream ("F:\\yangweijun\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a.txt",false);
					
					fos = new FileOutputStream ("D:\\yangweijun\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a.txt");
					//fos.write('c');
					
					//方法1。从字符串读取字节（charAt）
//					for (int i=0; i<str.length();i++){
//						fos.write(str.charAt(i));
//					}
					
					//将流中数据冲刷到数据源,但是由于调了close(),所以调不调无所谓
					//fos.flush();
					//方法2。将指定的字节写入文件输出流，将字符串转换字节数组
					fos.write(str.getBytes());
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (fos!=null){
							fos.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
									
		}
	
	public static void main(String[] args) {
		
		//读文件
		//testRead();
		testWrite();
		
	}

}
