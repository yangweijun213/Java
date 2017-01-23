package com.jun.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileInputStreams  {
	
	//���ļ� - read()������һ�����ֽڶ�
	static void testRead() {	
		File f = new File ("F:\\yangweijun\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a.txt");
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream (f);
			int i ;
			//�Ӵ��������ж�ȡһ�������ֽ�
			while ((i=fis.read())!= -1) {
				//ǿת��intת��char
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
				//����֮��Ҫ�ر�
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
		
		//���ļ�
		testRead();
	
		
	}
}
