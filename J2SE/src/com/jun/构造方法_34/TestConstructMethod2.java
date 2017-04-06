package com.jun.构造方法_34;

/*
 * 测试构造方法,使用this
 */
public class TestConstructMethod2 {
	
	int x, y;

	public TestConstructMethod2(int x, int y) { // 构造方法的形参和属性名一样的时候，可以用this,来指代这个类
		this.x = x;
		this.y = y;

	}

	public static void main(String[] args) {
		TestConstructMethod test = new TestConstructMethod(1, 3);
		System.out.println(test.x); //对象属性值
		System.out.println(test.y);
	}

}
