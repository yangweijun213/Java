package com.jun.stream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import sun.applet.Main;

public class FileOutputStreams {

	// д�ļ�
	static void testWrite() {
				
		FileOutputStream fos = null;
				String str = "abcdefdfddfdfdf";
				try {
					//׷��
					//fos = new FileOutputStream ("F:\\yangweijun\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a.txt",true);
					
					//��д
					//fos = new FileOutputStream ("F:\\yangweijun\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a.txt",false);
					
					fos = new FileOutputStream ("D:\\yangweijun\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a.txt");
					//fos.write('c');
					
					//����1�����ַ�����ȡ�ֽڣ�charAt��
//					for (int i=0; i<str.length();i++){
//						fos.write(str.charAt(i));
//					}
					
					//���������ݳ�ˢ������Դ,�������ڵ���close(),���Ե���������ν
					//fos.flush();
					//����2����ָ�����ֽ�д���ļ�����������ַ���ת���ֽ�����
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
		
		//���ļ�
		//testRead();
		testWrite();
		
	}

}
