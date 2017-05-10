package com.jun.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author jeff yang
 * 使用 FileReader和FileWriter实现文件复制
 *
 */
public class TestFileReadeFileWriter {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		int c = 0;

		try {
			fr = new FileReader("D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a.txt");
			fw = new FileWriter("D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a_copy.txt");

			while ((c = fr.read()) != -1) {
				fw.write(c);
				System.out.println((char)c);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
