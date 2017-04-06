package com.jun.类型转换_10;

/*
 * 10_尚学堂_高淇_JAVA基础300集最全教程_基本数据类型自动转换_强制转型_类型提升问题
 */
public class TestTypeConvert {
	
	public static void main(String[] args) {
		
		//自动转型
		byte a1=110;
	//	byte a2=300; 编译报错,超过范围 0-256
		
		//强制类型转换
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
		
		int a8=-100; //-100超过char的类型,所以转换成完全不同的值,会产生无意义的值
		System.out.println("a8= "+(char)a8);
		
		
		//表达式中的类型提升问题
		int c1=1;
		long c2= 4;
		int c3 = (int)(c1+c2); //c1是int, c3是long, 算完是long, 所以需要强制转型,避免超过范围.
		
	}

}
