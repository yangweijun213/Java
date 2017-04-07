package com.jun.面向对象.继承_38_39_40_41_42;

/**
 * 测试组合
 * @author dell
 *
 */
public class Animal2 {
	String eye;
	
	public void run(){
		System.out.println("跑跑！");
	}
	public void eat(){
		System.out.println("吃吃！");
	}
	public void sleep(){
		System.out.println("zzzzz");
	}
	
	public  Animal2(){
		super();
		System.out.println("创建一个动物！");
	}
	
	public static void main(String[] args) {
		Bird2 b = new Bird2();
		b.run();
		b.animal2.eat(); 
	}
	
}

class Mammal2  {
	Animal2 animal2=new Animal2();  //所谓组合,就是将父类的Animal2作为属性放在这里
	public void taisheng(){
		System.out.println("我是胎生");
	}
	
}

class Bird2  {
	Animal2 animal2=new Animal2(); //所谓组合,就是将父类的Animal2作为属性放在这里
	
	public void run(){
		animal2.run(); //调用父类的run 
		System.out.println("我是一个小小小小鸟，飞呀飞不高");
	}
	
	public void eggSheng(){
		System.out.println("卵生");
	}
	
	public Bird2(){
		super();
		System.out.println("建一个鸟对象");
	}
	
}
