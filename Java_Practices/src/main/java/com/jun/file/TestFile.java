package com.jun.file;

import java.io.File;

public class TestFile {
	
	public static void main(String[] args) {
		File f = new File ("F:\\yangweijun\\workspace\\Java\\JavaStart\\src\\com\\jun\\file\\TestFile.txt");
		File f2 = new File ("F:\\yangweijun\\workspace\\Java\\JavaStart\\src\\com\\jun\\file\\");
		File f3 = new File (f2,"TestFile.txt");
		
		if (f.isFile()){
			System.out.println("this is file");
		}
		
		if (f2.isDirectory()) {
			System.out.println("this is a directory");
		}
	}

}
