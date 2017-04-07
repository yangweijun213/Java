package com.jun.面向对象.接口_49;

public class MyClass implements MyInterface {

	@Override
	public void test01() {
		
		//使用常量,
		System.out.println(MyInterface.MAX_SPEED);
		System.out.println("test01");
		
	}

	@Override
	public int test02(int a, int b) {
		System.out.println("test02");
		return a+b;
	}
	

}
