package com.jun.inheritance;


/**
 * @author jeff yang
 * 如果没有继承话，代码重复率很高 （冗余 ）
 *
 */
public class TestExtend {
	
	class Animal {
		int age;
		int weight;
		int speed;
		int height;
		void move() {
			System.out.println("我在 移动 ");
		}
	}
	
	class Puluo {
		int age;
		int weight;
		int speed;
		int height;
		String puluo;
		void move() {
			System.out.println("我在 移动 ");
		}
		
		void chinai() {
			System.out.println("我在吃奶 ");
		}
	}
	
	class crawler {
		int age;
		int weight;
		int speed;
		int height;
		void move() {
			System.out.println("我在爬行 ");
		}
	}

}
