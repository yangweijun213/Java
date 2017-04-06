package com.jun.对象和内存分析_30_31_32;

/*
 * 解释对象和类
 */
public class TestObject {

	public static void main(String[] args) {

		Car c1 = new Car();// 类的实例化，对象
		c1.changeColor("red"); // 对象的方法引用
		c1.showColor();
		// 从属类
		System.out.println(Car.tyreNum);
		System.out.println(c1.tyreNum);

		Car c2 = new Car();
		Engine e = new Engine();
		e.speed = 1000;
		e.weight = 10;
		c2.engine = e;
		c2.color = "黑色";

		// 静态变量的值，被所有 对象 共享
		c2.tyreNum = 10;
		System.out.println(c1.tyreNum);
	}

}

class Car {
	static int tyreNum = 4;
	Engine engine; // 对象引用
	String color;// 颜色

	void changeColor(String c) {
		color = c;
	}

	void showColor() {
		System.out.println("我的 颜色是:" + color);
	}

}

class Engine {
	int speed; // 转速
	int weight; // 重量

}
