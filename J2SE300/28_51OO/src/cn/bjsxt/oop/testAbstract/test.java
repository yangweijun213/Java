package cn.bjsxt.oop.testAbstract;

public class test {
	
	public static void main(String[] args) {
		
		Animal a = new Cat();
		a.run(); //子类的, 猫的 run
		a.fly();//抽象类,非抽象方法,继承概念
	}

}
