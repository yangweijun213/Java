package com.jun.operation;

public class TestOperation {
	
	public static void main(String[] args) {
		
		//类型提升,谁大听谁
		int a=3;
		long b=4;
		long c =a*b;
		
		//测试一元运算符
		int i=4;
		//后减
		i--;
		//先减
		--i;
		
		//按位与,测试位运算符, 二进制的true/false, 1->true, 0 -> false
		int j=3&2;
		System.out.println(j);
		//按位或
		int g=3|2;
		System.out.println(g);
		
		//移位,移位最快
		int bb=3<<2; //相当于3*2*2
		System.out.println(bb);
				
		//测试字符串连接符,加号两边只要有一个字符,就是字符
		System.out.println(""+3+4); //34
		System.out.println(3+4+""); //7
		
		//测试三目运算符,x?y:z 条件运算 
		int aa=1;
		int bbb=2;
	    System.out.println((aa<bbb)?"aa<bbb":"aa>bbb");
	}

}
