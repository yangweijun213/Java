package com.jun.poly;


/**
 * @author jeff yang
 * ����һ������ϵ�����, 3���࣬д3������. ���˶����̬�Ժ�ֻҪ�ڷ������β��Ǹ���Animal��Ȼ��ʵ�ʴ�����Dnkey,����Dnkey
 */
public class TestPoly {
	
	
	void test (Animal h){
		h.move();
	}
	//�����Ŵ�Ҫд
/*	void test (Human h){
		h.move();
	}
	
	void test (Monkey h){
		h.move();
	}
	
	void test (Dnkey h){
		h.move();
	}*/
	
	public static void main(String[] args) {
		//new TestPoly().test(new Human());
		//new TestPoly().test(new Monkey());
		
		//�������ã�ָ��������� . ��new Dnkey��ַ�����˸�������Animal h
		new TestPoly().test(new Dnkey());
		
		//Animal a �Ǳ�������,����ɶ�ͨ��
		//new Monkey()����ʱ���ͣ�ʵ�������ĸ������ĸ���
		Animal a = new Monkey();
		new TestPoly().test(a);
		
		
	}

}

class Animal {
	void move() {
		System.out.println("move");
	}
}

class Human extends Animal {
	void move() {
		System.out.println("ֱ������");
	}
	
}

class Monkey extends Animal {
	void move() {
		System.out.println("��������");
	}
}


class Dnkey extends Animal {
	void move() {
		System.out.println("Dnkey����");
	}
}
