package cn.bjsxt.oop.polymorphism;

public class Animal {
	String str;
	public void voice(){
		System.out.println("普通动物叫声！");
	}
	
	public void attack(){
		System.out.println("普通动物攻击！");
	}
    public Animal() {
    	System.out.println("Animal 对象生成");
    }
}

class Cat extends Animal {
	
	public Cat() {
		System.out.println("Cat 对象生成");
	}
	public void voice(){
		System.out.println("喵喵喵");
	}
	public void catchMouse(){
		System.out.println("抓老鼠");
	}
}

class Dog extends Animal {
	
	public Dog() {
		System.out.println("Dog 对象生成");
	}
	public void voice(){
		System.out.println("汪汪汪");
	}
	
	public void seeDoor(){
		System.out.println("看门！");
	}
	
}

class Tiger extends Animal {
	public void voice(){
		System.out.println("哇哇哇");
	}

	
}

class Pig extends Animal {
	public void voice(){
		System.out.println("哼哼哼");
	}
}
