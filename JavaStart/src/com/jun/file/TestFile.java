package com.jun.file;

import java.io.File;
import java.io.IOException;

public class TestFile {
	
	public static void main(String[] args) {
		
		//������  File(String pathname)
		File f = new File ("D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\file\\TestFile.txt");
		File f2 = new File ("D:/workspace/Java/JavaStart/src/com/jun/file/");
		//������ File(String parent, String child) 
		File f3 = new File (f2,"TestFile.txt");
		
		if (f.isFile()){
			System.out.println("this is file");
		}
		
		if (f2.isDirectory()) {
			System.out.println("this is a directory");
		}
		
		//�½��ļ�
		File f4 = new File (f2,"TestFile2.txt");
		try {
			f4.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ɾ���ļ�
		f4.delete();
		
		//����Ŀ¼mkdir , �����Ŀ¼����ڣ��ʹ����������ڲ�����
		File f5 = new File ("D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\file\\createfolder");
		f5.mkdir();
		
		//����Ŀ¼mkdirs, ���ǰ��Ŀ¼�����ڣ����Զ�����
		File f6 = new File ("D:/workspace/Java/JavaStart/src/com/jun/file/aa/bb/createfolder");
		f6.mkdirs();
		
	}

}
