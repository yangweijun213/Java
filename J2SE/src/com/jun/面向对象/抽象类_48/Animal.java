package com.jun.面向对象.抽象类_48;

/*
 * 抽象类
 */
public abstract class Animal {

	// 抽象方法,没有实现，只有定义和
	public abstract void run(); // 子类必须要实现这个方法，否则报错

	// 抽象类可以定义普通方法
	public void breath() {
		System.out.println("呼吸");
		run(); //多态,运行时候,调用哪个对象,就是哪个对象
	}
}

class Cat extends Animal {

	@Override
	public void run() { // 子类必须要重写
		System.out.println("猫跑");

	}

	class Dog extends Animal {

		@Override
		public void run() {
			System.out.println("狗跑");

		}

	}

}