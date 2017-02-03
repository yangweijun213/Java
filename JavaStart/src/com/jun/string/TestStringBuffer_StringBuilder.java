package com.jun.string;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class TestStringBuffer_StringBuilder {
	
	public static void main(String[] args) {
		
		StringBuffer a = new StringBuffer("aaaa");
		//实际上是数组，在aaa后面加 了def
		a=a.append("def");
		//a.reverse();
		
		
		//一般使用这个，效率高 
		StringBuilder bc = new StringBuilder("aaaa");
		bc=bc.append("ddd");
		
		//一个时间也是一个数字 
		long d1=System.currentTimeMillis();
/*		String s ="";
		for (int i=0; i<1000000; i++) {
			s+=i;
		}*/
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<1000000; i++) {
			sb.append(i);
		}
		
		long d2=System.currentTimeMillis();
		System.out.println(d2-d1);
	}


	
}
