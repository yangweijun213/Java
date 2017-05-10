package com.jun.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 * @author jeff yang
 * 序列化 - 把对象流写到文件（硬盘）
 *
 */
public class TestObjectStream {
	
	public static void main(String[] args) throws IOException {
		
		Person person = new Person(20, true, "aa");
		Person person2 = new Person(30, true, "addddda");
		//把流的数据写到文件里
		FileOutputStream fos = null;
		ObjectOutputStream oos= null;
		
		//序列化 （写 ）
		fos = new FileOutputStream("d:/ccc.txt");
		//传fos
		oos= new ObjectOutputStream(fos);
		
		//写
		oos.writeObject(person);
		oos.writeObject(person2);
		oos.flush();
		
		
		oos.close();
		fos.close();
		
	}

}
