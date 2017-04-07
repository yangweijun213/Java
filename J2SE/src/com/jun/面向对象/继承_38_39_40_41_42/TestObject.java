package com.jun.面向对象.继承_38_39_40_41_42;

public class TestObject {
	
	public static void main(String[] args) {
		
		Object obj = new Object();
		Object obj2 = new Object();
		System.out.println(obj.toString());
		System.out.println(obj2.toString());
		System.out.println(obj==obj2);
		System.out.println(obj.equals(obj2)); 
		
		//调用mobile 重写的toString
		Mobile m = new Mobile();
		System.out.println(m.toString()); //把父类的Object toString覆盖了.
	}
}
