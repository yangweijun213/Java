package cn.bjsxt.oop.testAbstract;

public abstract class Animal {
	public abstract void run();//抽象方法
	
	public void fly() {   //定义自己的方法
		System.out.println("动物飞");
	}

}

class Cat extends Animal {

	@Override
	public void run() {
		System.out.println("猫跑");
		
	}
	
}

class Dog extends Animal {

	@Override
	public void run() {
		System.out.println("狗跑");
		
	}
	
}