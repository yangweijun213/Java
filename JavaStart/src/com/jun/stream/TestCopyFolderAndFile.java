package com.jun.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopyFolderAndFile {

	static void copyDir(File file, File file2) {

		// 如果目标目录没有，就新建一个目录
		new File(file2, file.getName()).mkdir();
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				System.out.println("==FileFolder==");
				System.out.println(f.getName());
				System.out.println(file2.getName());
				System.out.println(file.getName());
				copyDir(f, new File(file2, file.getName()));
			}
			if (f.isFile()) {
				System.out.println("==File==");
				System.out.println(f.getName());
				copyFile (f,new File(new File(file2,file.getName()),f.getName()));
			}
		}
	}

	static void copyFile(File file, File file2) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] buffer = new byte[1024];
		int temp = 0;

		try {
			
			fis = new FileInputStream(file);
			fos = new FileOutputStream(file2);
			while ((temp = fis.read(buffer)) != -1) {
				// - write(byte[] b, int off, int len)
				fos.write(buffer, 0, temp);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		// 复制目录, 将stream目录下面的所有目录，复制到D:\test目录下
		File sourceFile = new File("D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream");
		File tagetFile = new File("D:\\test");
		TestCopyFolderAndFile.copyDir(sourceFile, tagetFile);
		//TestCopyFolderAndFile.copyFile(sourceFile, tagetFile);
	}

}
