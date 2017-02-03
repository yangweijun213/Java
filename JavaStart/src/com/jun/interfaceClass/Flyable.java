package com.jun.interfaceClass;

public interface Flyable {
	
	//加不加无所谓，你不加，系统帮你加
	/*pubic static final */int MAX_HEIGHT=100000;
	
	int MIN_HEIGHT=1;
	void land();
	void fly();
	
}

interface Explode {
	void baozhao();
}

//实现多个接口，不是接口多jicheng
class Missile implements Flyable,Explode {

	@Override
	public void land() {
		System.out.println("导弹着陆");
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("导弹飞");
		
	}

	@Override
	public void baozhao() {
		// TODO Auto-generated method stub
		
	}
	
}

class Stone implements Flyable {

	@Override
	public void land() {
		// TODO Auto-generated method stub
		System.out.println("石头着陆");
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("石头飞");
		
	}
	
}
