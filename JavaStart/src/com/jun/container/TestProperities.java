package com.jun.container;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestProperities {

	public static void main(String[] args) throws IOException {
		Properties ps = new Properties();
		//����·��
		//FileReader reader = new FileReader("F:\\yangweijun\\workspace\\Java\\JavaStart\\src\\com\\jun\\collection\\a.properties");
		//ps.load(reader);
		
		//���·����ȡ��class�������ͼƬ��Ȼ���������getClassLoader
		ps.load(TestProperities.class.getClassLoader().getResourceAsStream("a.properties"));
		String a =ps.getProperty("name");
		System.out.println(a);
	}
}