package com.jun.运算符_13_14;

/*
 * 13_尚学堂_高淇_JAVA基础300集最全教程_运算符_01_算术_逻辑_位运算符_扩展运算符
 */
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
		int a1 =3;
		int b1=a1++; //先赋值,再自增
		int c1=++a1; //先自增,后赋值
		
		
		//按位与,测试位运算符, 二进制的true/false, 1->true, 0 -> false
		int j=3&2;
		System.out.println(j);
		//按位或
		int g=3|2;
		System.out.println(g);
		
		//移位,移位最快
		int bb=3<<2; //相当于3*2*2
		System.out.println(bb);
		
		boolean s1 = true&false; //与运算， 所以还是用逻辑运算
		System.out.println(s1);
				
		//测试字符串连接符,加号两边只要有一个字符,就是字符
		System.out.println(""+3+4); //34
		System.out.println(3+4+""); //7
		
		//测试三目运算符,x?y:z 条件运算 
		int aa=1;
		int bbb=2;
	    System.out.println((aa<bbb)?"aa<bbb":"aa>bbb");
	}

}
