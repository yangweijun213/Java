package cn.bjsxt.oop.testInterface;

public interface Flyable {
	
	int MAX_SPEED=11000;
	int MIN_HEIGHT=1;
	void fly();
			
}

interface Attack {
	void attack();
}

class Plane implements Flyable{
	

	
	@Override
	public void fly() {
		System.out.println("跳起来");
		
	}
	
}

class Stone implements Flyable,Attack {
	
	int weight =1;
	
	public void run(){
		System.out.println("跑起来");
	}
	
	@Override
	public void fly() {
		System.out.println("仍出去");
	}

	@Override
	public void attack() {
		System.out.println("攻击");
		
	}	
}