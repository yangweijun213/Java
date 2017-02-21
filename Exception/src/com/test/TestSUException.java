package com.test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.lombardrisk.colline.supportutil.exception.SUException;

public class TestSUException {
	
	public static void main(String[] args) throws Exception {
		TestSUException.showMessage();
	}
	
	public static void showMessage() throws Exception {
		InputStream is = new FileInputStream("无效文件.txt");  
	}

}
