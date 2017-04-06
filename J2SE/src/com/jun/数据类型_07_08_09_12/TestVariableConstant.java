package com.jun.数据类型_07_08_09_12;

/*
 * 12_尚学堂_高淇_JAVA基础300集最全教程_变量_成员变量和局部变量_常量_命名规范
 */
public class TestVariableConstant {
	
	int v=3; 
	static String aa;
	static int x =5; 
	
	static final double ABC = 3.14; 
	final double DEF = 3.111;  //常量, 在类中声明
	final double HIJ = DEF+2.11; 
			
	public static void main(String[] args) {
		int a =4; 
		int b=1,c=1;

		System.out.println(TestVariableConstant.aa);
		System.out.println(TestVariableConstant.ABC);
	
	}
	
}
