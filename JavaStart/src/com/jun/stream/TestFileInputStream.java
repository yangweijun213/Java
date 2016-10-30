package com.jun.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileInputStream  {
	
	//���ļ�
	static void testRead() {	
		File f = new File ("F:\\yangweijun\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a.txt");
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream (f);
			int i ;
			while ((i=fis.read())!= -1) {
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
				if (fis!=null){
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	//д�ļ�
	static void testWrite() {
			FileOutputStream fos = null;
			String str = "abcdefdfddfdfdf";
			try {
				fos = new FileOutputStream ("F:\\yangweijun\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\b.txt");
				//fos.write('c');
				
//				for (int i=0; i<str.length();i++){
//					fos.write(str.charAt(i));
//				}
				
				//ת���ַ�
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
