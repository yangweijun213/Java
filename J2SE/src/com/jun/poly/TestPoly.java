package com.jun.poly;


/**
 * @author jeff yang
 * 这是一个高耦合的例子, 3个类，写3个方法. 有了多个形态以后，只要在方法的形参是父类Animal，然后，实际传的是Dnkey,就是Dnkey
 */
public class TestPoly {
	
	
	void test (Animal h){
		h.move();
	}
	//重载屡次要写
/*	void test (Human h){
		h.move();
	}
	
	void test (Monkey h){
		h.move();
	}
	
	void test (Dnkey h){
		h.move();
	}*/
	
	public static void main(String[] args) {
		//new TestPoly().test(new Human());
		//new TestPoly().test(new Monkey());
		
		//父类引用，指向子类对象 . 将new Dnkey地址赋给了父类引用Animal h
		new TestPoly().test(new Dnkey());
		
		//Animal a 是编译类型,编译可定通过
		//new Monkey()运行时类型，实际运行哪个就是哪个。
		Animal a = new Monkey();
		new TestPoly().test(a);
		
		
	}

}

class Animal {
	void move() {
		System.out.println("move");
	}
}

class Human extends Animal {
	void move() {
		System.out.println("直立行走");
	}
	
}

class Monkey extends Animal {
	void move() {
		System.out.println("猴子行走");
	}
}


class Dnkey extends Animal {
	void move() {
		System.out.println("Dnkey行走");
	}
}
