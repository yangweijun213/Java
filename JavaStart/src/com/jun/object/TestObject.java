package com.jun.object;

public class TestObject {

	public static void main(String[] args) {

		Car c1 = new Car();// ���ʵ����������
		c1.changeColor("red"); // ����ķ�������
		c1.showColor();
		// ������
		System.out.println(Car.tyreNum);
		System.out.println(c1.tyreNum);

		Car c2 = new Car();
		Engine e = new Engine();
		e.speed = 1000;
		e.weight = 10;
		c2.engine = e;
		c2.color = "��ɫ";

		// ��̬������ֵ�������� ���� ����
		c2.tyreNum = 10;
		System.out.println(c1.tyreNum);
	}

}

class Car {
	static int tyreNum = 4;
	Engine engine; // ��������
	String color;// ��ɫ

	void changeColor(String c) {
		color = c;
	}

	void showColor() {
		System.out.println("�ҵ� ��ɫ��:" + color);
	}

}

class Engine {
	int speed; // ת��
	int weight; // ����

}
