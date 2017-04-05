package com.jun.encapsulations;

public class TestPrivate {
	public static void main(String[] args) {
		TestPrivate2 t2 = new TestPrivate2();
		// 不能调用Test2的私有方法cc()
		// change visibility of cc()
		// t2.cc();
	}
}

class TestPrivate2 {
	int a;

	private void cc() {
		System.out.println("ccc");
	}

	void dd() {
		// 只能在本类中调用
		cc();
	}
}

class TestPrivate2Child extends TestPrivate2 {
	void ee() {
		// 不能调用父类的私有方法 cc()
		// change visibility of cc()
		// super.cc();
	}
}