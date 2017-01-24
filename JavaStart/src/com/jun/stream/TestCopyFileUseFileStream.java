package com.jun.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopyFileUseFileStream {

	void copyFile(String src, String dec) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] buffer = new byte[1024];
		int temp = 0;

		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dec);
			while ((temp = fis.read(buffer)) != -1) {
				//	- write(byte[] b, int off, int len) 
				fos.write(buffer, 0, temp);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args) {
		TestCopyFileUseFileStream testCopyFile = new TestCopyFileUseFileStream();
		
		String src="D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a.txt";
		String dec="D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a_copy.txt";
		testCopyFile.copyFile(src, dec);
	}

}
