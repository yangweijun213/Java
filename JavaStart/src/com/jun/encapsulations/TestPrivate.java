package com.jun.encapsulations;

public class TestPrivate {
	public static void main(String[] args) {
		TestPrivate2 t2 = new TestPrivate2();
		// ���ܵ���Test2��˽�з���cc()
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
		// ֻ���ڱ����е���
		cc();
	}
}

class TestPrivate2Child extends TestPrivate2 {
	void ee() {
		// ���ܵ��ø����˽�з��� cc()
		// change visibility of cc()
		// super.cc();
	}
}