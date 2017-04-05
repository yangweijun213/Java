package com.jun.datatype_07_08_09_12;

public class TestDataType {

	public static void main (String[] args){
		
		//测试数值型
		byte a =1;
		short b = 2; 
		int c =3; 
		long d = 44444444444L; //注意这里要写L
		
		int aa=10;
		System.out.println(Integer.toBinaryString(aa)); //2进制
		System.out.println(Integer.toOctalString(aa)); //8进制
		
		byte a7 =100;
		long a8 =100; //如果数值没有超多,会自动转型
		
		//测试浮点数
		float e =3.14F;    //如果将默认double放入float 需要加F
		double f = 3.14512;   //默认是double类型
		
		//测试字符 char和字符串
		char ggg = 'a';
		
		char c4 ='a';
		int i = c4*2; //ASCII 字符对应不同数字
		char c5 = (char)i; //强制转型为char. 与整数的相互转型
		
		String h ="abcsdd"; //定义字符串, 这是字符串的类
		System.out.println(h);
		
		
		//测试布尔类型,用于逻辑判断,只占一位
		boolean b9 =true;
		if (b9){
			System.out.println("b9= "+b9);
		}

	}

}
