package com.jun.abstractclass;

public class TestAbstractClass {
	
	public static void main(String[] args) {
		//抽象类不能实例化，及不能new来实例化抽象类
		Computer computer = new Laptop();
		
	}

}

//抽象类, 没有具体的实现 （包含抽象方法的类）
abstract class Computer{
	//改方法是抽象的，没有具体的方法实现. 这样的方法必须重写
	//抽象规范
	abstract public void startup();
	abstract public void shutdown();
	
	//具体实现
	public void cal() {
		System.out.println("我在计算");
	}
}

//子类必须重写父类的抽象方法
class Laptop extends Computer{
	
	@Override  //给其它程序看。帮助其它程序做解析
	public void shutdown() {  //给虚拟机看
		
	}

	@Override
	public void startup() {
		// TODO Auto-generated method stub  //给人看
		
	}
}

//子类必须重写父类的抽象方法
class Mobile extends Computer {

	@Override
	public void startup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}
	
}