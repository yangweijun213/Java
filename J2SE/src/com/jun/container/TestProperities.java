package com.jun.container;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestProperities {

	public static void main(String[] args) throws IOException {
		Properties ps = new Properties();
		//绝对路径
		//FileReader reader = new FileReader("F:\\yangweijun\\workspace\\Java\\JavaStart\\src\\com\\jun\\collection\\a.properties");
		//ps.load(reader);
		
		//相对路径读取，class就像设计图片，然后类加载器getClassLoader
		ps.load(TestProperities.class.getClassLoader().getResourceAsStream("a.properties"));
		String a =ps.getProperty("name");
		System.out.println(a);
	}
}