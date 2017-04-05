package com.jun.wapper;

public class TestWapperClass2 {
	
	public static void main(String[] args) {
		
		//自动装箱, 相当于Integer aa2 = new Integer(33); 编译器做了优化，加了new Integer(33)
		Integer aa =3;
		Integer aa2 = new Integer(33);
		
		//自动拆箱，编译器自动替我们加了 new Integer(343).intValue();
		int d = new Integer(343);
		int d2 = new Integer(343).intValue();
		
		////小于100按数字比较
		Integer b1 = 888;
		Integer b2 = 888;
		
		Integer c1 =100;
		Integer c2 = 100;
		
		System.out.println(b1==b2);
		System.out.println(c1==c2);
	}

}
