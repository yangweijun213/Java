package com.jun.collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	
	static void testMap () {
	
		Map m = new HashMap();
		Dog d1 = new Dog (10,"��ɫ");
		Dog d2 = new Dog (10,"��ɫ");
		m.put ("aa", d1);
		m.put ("bb", d2);
		
		Dog d3 = new Dog (10,"��ɫ");
	}
	
	
	static void testMap2() {
		
	}
	public static void main (String[] args){
		
	}

	
}

class Dog {
	
	int weight;
	String color;
	
	//�������� �Ҽ�->source->Generate Constructer using Fields 
	public Dog(int weight, String color) {
		super();
		this.weight = weight;
		this.color = color;
	}

	
}
