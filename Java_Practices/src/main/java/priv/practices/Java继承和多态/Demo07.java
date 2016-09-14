package priv.practices.Java继承和多态;

/**
 * @author http://www.weixueyuan.net/view/6000.html Java多态和动态绑定 - 多态
 *         多态存在的三个必要条件：要有继承、要有重写、父类变量引用子类对象。 
 *         在Java中，父类的变量可以引用父类的实例，也可以引用子类的实例
 * 
 */

public class Demo07 {

	public static void main(String[] args) {
		// 借助多态，主人可以给很多动物喂食
		Master ma = new Master();
		ma.feed(new Animal07(), new Food07());
		ma.feed(new Cat07(), new Fish07());
		ma.feed(new Dog07(), new Bone07());
	}
}

// Animal类及其子类
class Animal07 {
	public void eat(Food07 f) {
		System.out.println("我是一个小动物，正在吃" + f.getFood());
	}
}

class Cat07 extends Animal07 {
	public void eat(Food07 f) {
		System.out.println("我是一只小猫咪，正在吃" + f.getFood());
	}
}

class Dog07 extends Animal07 {
	public void eat(Food07 f) {
		System.out.println("我是一只狗狗，正在吃" + f.getFood());
	}
}

// Food及其子类
class Food07 {
	public String getFood() {
		return "食物";
	}
}

class Fish07 extends Food07 {
	public String getFood() {
		return "鱼";
	}
}

class Bone07 extends Food07 {
	public String getFood() {
		return "骨头";
	}
}

// Master类
class Master {
	public void feed(Animal07 an, Food07 f) {
		an.eat(f);
	}

}
