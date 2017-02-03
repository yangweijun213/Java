package com.jun.string;

import sun.print.resources.serviceui;

public class TestString {
	

	public static void main(String[] args) {
		String a = "abc";
		String a2 = new String("abc");
		String aa = "abc";
		String a3 = "abcdef";
		String a4 = "abc"+"def";
		String a5 = aa+"def";
		
		
		char c = a.charAt(1);
		System.out.println(c);
		
		System.out.println(a==a2);
		System.out.println(a.equals(a2));
		
		System.out.println(a3==a4);
		System.out.println(a4==a5);
		
		System.out.println(a3.equals(a4));
		System.out.println(a4.equals(a5));
		
		
		String sss="xxxx.rmvb.avi";
		System.out.println(sss.substring(sss.lastIndexOf(".")+1));
	}

}
