package com.jun.interfaceClass;

public interface Flyable {
	
	//�Ӳ�������ν���㲻�ӣ�ϵͳ�����
	/*pubic static final */int MAX_HEIGHT=100000;
	
	int MIN_HEIGHT=1;
	void land();
	void fly();
	
}

interface Explode {
	void baozhao();
}

//ʵ�ֶ���ӿڣ����ǽӿڶ�jicheng
class Missile implements Flyable,Explode {

	@Override
	public void land() {
		System.out.println("������½");
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("������");
		
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
		System.out.println("ʯͷ��½");
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("ʯͷ��");
		
	}
	
}
