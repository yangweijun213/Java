package com.jun.stream;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 * @author jeff yang
 * �����л� - ���ļ���������
 *
 */
public class TestObjectStream2 {
	
public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileInputStream fis = null;
		ObjectInputStream ois= null;
		
		//�����л� ���� ��
		fis = new FileInputStream("d:/ccc.txt");
		ois= new ObjectInputStream(fis);
		
		Person p = (Person) ois.readObject();
		System.out.println(p.name);
	
		ois.close();
		fis.close();
		
	}

}
