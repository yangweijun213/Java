package com.jun.datatype;

public class TestVatiable {
	
	int v=3; //成员变量,实例变量 -从属对象,系统自动初始化
	static String aa;
	static int x =5; // 静态变量,从属类,共享给所有对象,系统自动初始化
	
	static final double ABC = 3.14; //静态常量,从属类,共享给所有对象
	final double DEF = 3.111; //常量, 在类中声明
			
	public static void main(String[] args) {
		int a =4; //局部变量 - 从属方法,使用之前必须手工初始化
		int b=1,c=1;
		System.out.println(TestVatiable.aa);
		System.out.println(TestVatiable.ABC);
	
	}
	
}
