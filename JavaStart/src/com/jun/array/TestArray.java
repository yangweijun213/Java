package com.jun.array;

public class TestArray {
	public static void main(String[] args) {
		int a[];
		int[] b;
		b =new int[50];
		
		for (int i=0; i<50;i++){
			b[i]=i*2;
			System.out.println(b[i]);
			
		}
		
		Dog[] dogs = new Dog[3];
		dogs[0] = new Dog("ww",1);
		dogs[1] = new Dog("aa",2);
		dogs[2] = new Dog("vv",4);
		
		//��̬��ʼ�� 
		int[] d = {11,22,33,44};
		Dog[] dogs2 = {
						new Dog("dd",1), 
						new Dog("ddd",2)
		};
	}
}

class Dog {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// �вεĹ�����
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// һ��Ҫ�����޲εĹ��������ͷ����й�ϵ
	public Dog() {
	}

}
