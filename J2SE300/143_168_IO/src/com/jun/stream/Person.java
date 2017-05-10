package com.jun.stream;

import java.io.Serializable;

//将这个对象存到硬盘上 
public class Person implements Serializable{
	int age;
	boolean isMan;
	
	//transient修饰化，这个属性不会被序列化 
	transient String name;
	public Person (int age, boolean isMan, String name) {
		super();
		this.age=age;
		this.isMan=isMan;
		this.name=name;
	}

}
