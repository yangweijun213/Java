package com.jun.typeconvert;

public class TestTypeConvert {
	
	public static void main(String[] args) {
		
		byte b =12;
		System.out.println((int)b);
		
		int c=99;
		System.out.println((long)c);
		System.out.println((byte)c);
		//99 相当于c
		System.out.println((char)c);
		
		long d = 12132323;
		System.out.println((int)d);
		
		char e= '1';
		//字符1 相当于49
		System.out.println((int)e);
		

	}

}
