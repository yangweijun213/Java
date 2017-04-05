package com.jun.string;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class TestStringBuffer_StringBuilder {
	
	public static void main(String[] args) {
		
		StringBuffer a = new StringBuffer("aaaa");
		//ʵ���������飬��aaa����� ��def
		a=a.append("def");
		//a.reverse();
		
		
		//һ��ʹ�������Ч�ʸ� 
		StringBuilder bc = new StringBuilder("aaaa");
		bc=bc.append("ddd");
		
		//һ��ʱ��Ҳ��һ������ 
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
