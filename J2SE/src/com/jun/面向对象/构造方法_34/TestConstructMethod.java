package com.jun.面向对象.构造方法_34;

/*
 * 测试构造方法
 */
public class TestConstructMethod {

	int x, y;

	public TestConstructMethod(int _x, int _y) { // 这就是构造方法
		x = _x;
		y = _y;

	}

	public static void main(String[] args) {
		TestConstructMethod test = new TestConstructMethod(1, 3);
		System.out.println(test.x); //对象属性值
		System.out.println(test.y);
	}

}
