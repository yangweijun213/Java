package com.jun.object;

public class TestObject {

	public static void main(String[] args) {

		Car car = new Car();// ���ʵ����������
		car.changeColor("red"); //����ķ�������
		car.showColor();
	}

}

class Car {
	Engine engine; // ��������
	String color;// ��ɫ

	void changeColor(String c) {
		color = c;
	}

	void showColor() {
		System.out.println("��ɫ��:"+color);
	}

}

class Engine {
	int speed; // ת��
	int weight; // ����

}
