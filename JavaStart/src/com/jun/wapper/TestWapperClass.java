package com.jun.wapper;

public class TestWapperClass {
	
	public static void main(String[] args) {
		
		//����23���ֵĶ��� 
		Integer a =new Integer(23);
		Integer a2 =new Integer("23");

		//ת��double
	    double d = a.doubleValue();
	    //�ַ���ת������, ���治�����ַ���������ôת������������ 
	    int d2 =Integer.parseInt("222fff");
	    //Ҳ������ �� �ַ��� 
	    int d3 =Integer.parseInt("");
	    a2.intValue();
	    
		//����ת���ַ���
		String aa = a.toString();
		String aa2 = 234+"";
	    
	    
	}

}
