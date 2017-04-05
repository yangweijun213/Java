package com.jun.stream;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 * @author jeff yang
 * 反序列化 - 从文件读出对象
 *
 */
public class TestObjectStream2 {
	
public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileInputStream fis = null;
		ObjectInputStream ois= null;
		
		//反序列化 （读 ）
		fis = new FileInputStream("d:/ccc.txt");
		ois= new ObjectInputStream(fis);
		
		Person p = (Person) ois.readObject();
		System.out.println(p.name);
	
		ois.close();
		fis.close();
		
	}

}
