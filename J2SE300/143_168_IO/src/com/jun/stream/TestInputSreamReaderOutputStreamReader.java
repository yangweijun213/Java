package com.jun.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestInputSreamReaderOutputStreamReader {
	
	public static void main(String[] args) {
		//接受用户的输入
		BufferedReader bReader =null;
		
		try {
			System.out.println("名字： " );
			//“标准”输入流。
			bReader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("用户输入： "+bReader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
