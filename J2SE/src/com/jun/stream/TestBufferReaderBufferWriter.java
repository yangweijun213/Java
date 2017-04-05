package com.jun.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author jeff yang
 * 使用bufferFileReader, bufferFileWriter实现文本文件复制。提高性能
 *
 */
public class TestBufferReaderBufferWriter {
	
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br =null;
		BufferedWriter bw = null;
		String temString ="";

		try {
			fr = new FileReader("D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a.txt");
			fw = new FileWriter("D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a_copy.txt");
			br=new BufferedReader (fr);
			bw=new BufferedWriter(fw);
			
			while ((temString = br.readLine()) != null) {
				bw.write(temString+"\r\n");
				System.out.println(temString);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
