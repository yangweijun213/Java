package com.jun.继承_38_39_40_41;

/**
 * @author jeff yang 测试继承基本使用,重写
 * 
 */
public class Animal {
	int age;
	int weight;
	int speed;
	int height;

	void move() {
		System.out.println("动物 - move ");
	}
	
}

	class Puluo extends Animal {

		String puluo;

		void chinai() { // 拓展了方法
			this.age = 12;
			System.out.println("Puluo: " + age);
		}
	}

	class crawler extends Animal {

		@Override
		void move() { // 重写方法
			super.move(); //调用父类方法
			System.out.println("爬行动物 - move");
		}
	}


