package com.jun.wapper;

public class TestWapperClass {
	
	public static void main(String[] args) {
		
		//包含23数字的对象 
		Integer a =new Integer(23);
		Integer a2 =new Integer("23");

		//转成double
	    double d = a.doubleValue();
	    //字符串转换数组, 里面不含有字符，不能这么转。必须是数字 
	    int d2 =Integer.parseInt("222fff");
	    //也不能是 空 字符串 
	    int d3 =Integer.parseInt("");
	    a2.intValue();
	    
		//数字转成字符串
		String aa = a.toString();
		String aa2 = 234+"";
	    
	}

}
