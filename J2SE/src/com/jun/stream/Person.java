package com.jun.stream;

import java.io.Serializable;

//���������浽Ӳ���� 
public class Person implements Serializable{
	int age;
	boolean isMan;
	
	//transient���λ���������Բ��ᱻ���л� 
	transient String name;
	public Person (int age, boolean isMan, String name) {
		super();
		this.age=age;
		this.isMan=isMan;
		this.name=name;
	}

}
