package com.jun.object;

public class TestObject {

	public static void main(String[] args) {

		Car car = new Car();// 类的实例化，对象
		car.changeColor("red"); //对象的方法引用
		car.showColor();
	}

}

class Car {
	Engine engine; // 对象引用
	String color;// 颜色

	void changeColor(String c) {
		color = c;
	}

	void showColor() {
		System.out.println("颜色是:"+color);
	}

}

class Engine {
	int speed; // 转速
	int weight; // 重量

}
