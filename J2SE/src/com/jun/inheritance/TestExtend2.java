package com.jun.inheritance;


/**
 * @author jeff yang
 * 如果使用了继承，可以减少重复的方法和属性 , Animal都可以用 
 *
 */
public class TestExtend2 {
	
	class Animal {
		int age;
		int weight;
		int speed;
		int height;
		void move() {
			System.out.println("我在 移动 ");
		}
	}
	
	class Puluo extends Animal {

		String puluo;	
		//扩展新的方法
		void chinai() {
			System.out.println("我在吃奶 ");
		}
	}
	
	class crawler extends Animal {
		
		//重写了 方法  (重新定义)
		@Override
		void move() {
			System.out.println("我在爬行 ");
		}
	}

}
