package com.jun.junit4;

public class T {
	public int add (int x, int y) {
		return x+y;
	}
	
	public int divide (int x, int y) {
		return x/y;
	}
	
	//原来使用main方式测试，但是这个方式很土。
	public static void main(String[] args) {
		int z =new T().add(3, 5);
		System.out.println(z);
	}
}
