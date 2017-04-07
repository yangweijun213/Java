package com.jun.异常_71_72_73_74_75_76;

public class TestNullPoint {

	// class cast exception
	void test2 (Object obj){
		if (obj instanceof Computer2){
			Computer com = (Computer) obj;
		}
	}

	public static void main(String[] args) {
		Computer c = null;
		// 通过加判断，来避免空指针
		if (c != null) {
			c.start(); // 对象是null,,调用了对象的方法和属性
		}

	}
}

class Computer2 {
	void start() {
		System.out.println("计算机启动！");
	}
}
