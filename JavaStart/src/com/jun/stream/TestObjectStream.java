package com.jun.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 * @author jeff yang
 * ���л� - �Ѷ�����д���ļ���Ӳ�̣�
 *
 */
public class TestObjectStream {
	
	public static void main(String[] args) throws IOException {
		
		Person person = new Person(20, true, "aa");
		Person person2 = new Person(30, true, "addddda");
		//����������д���ļ���
		FileOutputStream fos = null;
		ObjectOutputStream oos= null;
		
		//���л� ��д ��
		fos = new FileOutputStream("d:/ccc.txt");
		//��fos
		oos= new ObjectOutputStream(fos);
		
		//д
		oos.writeObject(person);
		oos.writeObject(person2);
		oos.flush();
		
		
		oos.close();
		fos.close();
		
	}

}
