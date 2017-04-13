package cn.bjsxt.oop.polymorphism;

public class Test {
	
	public static void testAnimalVoice(Animal c){
		c.voice();
		if(c instanceof Cat){
			((Cat) c).catchMouse();
		}
	}
	
	/*
	public static void testAnimalVoice(Dog c){
		c.voice();
	}
	
	public static void testAnimalVoice(Pig c){
		c.voice();
	}*/
//javac Test.java	
//	java Test
	public static void main(String[] args) {
		Animal a = new Cat();
		a.voice(); //父类对象,调用voice方法,此方法也在cat中. 但是cat有的方法,animal没有的方法不能调用
		Cat a2 = (Cat)a; //转型 cat 对象
		testAnimalVoice(a);

//		a2.catchMouse();

//		Animal b = new Dog();
//		Animal c = new Tiger();
//		testAnimalVoice(b);
//		testAnimalVoice(c);
		
	}
}
