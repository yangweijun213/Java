package com.jun.stream;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestByteArrayInputStream {

	static void testRead() {
		ByteArrayInputStream bais = null;
		StringBuilder sb = new StringBuilder();
		int temp = 0;
		int num = 0;

		try {
			// ת���ֽ�����
			byte[] b = "abcdefghijklmnopqrstuvwxyz".getBytes();
			bais = new ByteArrayInputStream(b);
			// bais=new ByteArrayInputStream(b,0,10);

			// һ��һ���ֽڶ�
			while ((temp = bais.read()) != -1) {
				//System.out.println(temp);
				sb.append((char) temp);
				num++;
			}
			System.out.println(sb);
		} finally {
			try {
				// ����֮��Ҫ�ر�
				if (bais != null) {
					bais.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		// ���ļ�
		testRead();

	}

}
