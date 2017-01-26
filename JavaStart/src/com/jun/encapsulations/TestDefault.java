package com.jun.encapsulations;

public class TestDefault {
	public static void main(String[] args) {
		TestDefault2 t2 = new TestDefault2();
		
		//在同一个包内，可以用
		t2.cc();
	}
}

class TestDefault2 {
	int a;

	//使用default 修饰方法
	void cc() {
		System.out.println("ccc");
	}

	void dd() {
		// 只能在本类中调用
		cc();
	}
}

class TestDefault2child extends TestDefault2 {
	void ee() {

		//在同一个包内的继承也可以
		super.cc();
	}
}