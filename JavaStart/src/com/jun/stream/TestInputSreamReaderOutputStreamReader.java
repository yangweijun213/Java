package com.jun.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestInputSreamReaderOutputStreamReader {
	
	public static void main(String[] args) {
		//�����û�������
		BufferedReader bReader =null;
		
		try {
			System.out.println("���֣� " );
			//����׼����������
			bReader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("�û����룺 "+bReader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
