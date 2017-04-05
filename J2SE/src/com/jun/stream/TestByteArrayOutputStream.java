package com.jun.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestByteArrayOutputStream {

	// ����������д��������(�õĲ���)
	static byte[] getBytesFromIS(FileInputStream fis) {

		ByteArrayOutputStream baos = null;
		StringBuilder sb = new StringBuilder();
		int temp = 0;
		int num = 0;

		try {
			baos = new ByteArrayOutputStream();

			// һ��һ���ֽڶ�
			while ((temp = fis.read()) != -1) {
				baos.write(temp);
			}
			// ��
			return baos.toByteArray();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	
	}

	public static void main(String[] args) {
		File f = new File("D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ���ļ�
		byte[] output = getBytesFromIS(fis);
		System.out.println((char)output[1]);

	}
}
