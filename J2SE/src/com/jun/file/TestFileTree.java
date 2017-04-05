package com.jun.file;

import java.io.File;

/**
 * @author jeff yang
 * 展现文件和目录的树状结构
 *
 */
public class TestFileTree {
	
	public static void main(String[] args) {
		File f = new File("D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\file");
		printFile(f, 0);
	}
	
	static void printFile (File file, int level) {
		for (int i=0;i<level;i++){
			//打印字符串没有回车
			System.out.print("-");
		}
		//打印字符串有回车
		System.out.println(file.getName());
		
		if (file.isDirectory()) {
			//目录中的文件,返回数组
			File[] files = file.listFiles();
			for (File temp:files) {
				printFile(temp, level+1);
			}
		}
	}

}
