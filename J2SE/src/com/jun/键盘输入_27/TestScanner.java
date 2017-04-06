package com.jun.键盘输入_27;

import java.util.Scanner;

/*
 * 测试键盘的输入
 */
public class TestScanner {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in); //调用构造器Scanner 参数是system.in输入
		String str = s.next(); //程序中断，等待下一个输入
		System.out.println("键盘的输入是： "+str);
		
	}

}
