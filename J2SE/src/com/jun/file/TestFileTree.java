package com.jun.file;

import java.io.File;

/**
 * @author jeff yang
 * չ���ļ���Ŀ¼����״�ṹ
 *
 */
public class TestFileTree {
	
	public static void main(String[] args) {
		File f = new File("D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\file");
		printFile(f, 0);
	}
	
	static void printFile (File file, int level) {
		for (int i=0;i<level;i++){
			//��ӡ�ַ���û�лس�
			System.out.print("-");
		}
		//��ӡ�ַ����лس�
		System.out.println(file.getName());
		
		if (file.isDirectory()) {
			//Ŀ¼�е��ļ�,��������
			File[] files = file.listFiles();
			for (File temp:files) {
				printFile(temp, level+1);
			}
		}
	}

}
