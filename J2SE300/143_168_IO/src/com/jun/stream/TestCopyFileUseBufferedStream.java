package com.jun.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用bufferedStream来实现 文件复制
 * 
 * @author jeff yang
 *
 */
public class TestCopyFileUseBufferedStream {

		void copyFile(String src, String dec) {
			FileInputStream fis = null;
			FileOutputStream fos = null;
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			int temp = 0;

			try {
				fis = new FileInputStream(src);
				fos = new FileOutputStream(dec);
				bis = new BufferedInputStream(fis);
				bos = new BufferedOutputStream(fos);

				while ((temp = bis.read()) != -1) {
					// - write(byte[] b, int off, int len)
					bos.write(temp);
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// 处理流，后开的先关
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		TestCopyFileUseBufferedStream testCopyFile = new TestCopyFileUseBufferedStream();

		String src = "D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a.txt";
		String dec = "D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a_copy.txt";
		
		testCopyFile.copyFile(src, dec);
	}

}
