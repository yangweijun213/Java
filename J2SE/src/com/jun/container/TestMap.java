package com.jun.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestMap {
	
	static void testMap () {
	
		Map m = new HashMap();
		Dog d1 = new Dog (10,"��ɫ");
		Dog d2 = new Dog (10,"��ɫ");
		m.put ("aa", d1);
		m.put ("bb", d2);
		
		Dog d3 = (Dog) m.get("aa");
		System.out.println(d3==d1);
	}
	
	
	static void testMap2() {
		//����:����������:30,��ַ:���� ���أ�90
		//����:���ģ�����:30,��ַ:���� ���أ�90
		Map m = new HashMap();
		m.put("name", "����");
		
//		List list = new ArrayList();
//		list.add("����");
				
		Map m2 = new HashMap();
		m2.put("name", "����");
		
		//ʹ��list��������Ϣ�洢,���ݿ�ȡ�������ݿ������ô��
		List list = new ArrayList();
		list.add(m);
		list.add(m2);
		
	}
	
	static void testGeneric() {
		List<String> list = new ArrayList();
		
		////������ǰ�����󣬹淶����
		//list.add(1);
		
		//���ȿ��Ա䣬�ǳ����
		list.add("abcddddddd");
		
		//������ǰ�����󣬹淶����
		//list.add(new Dog(12,"yellow"));
		
		//���ز���object�ˣ���string
		list.get(0);
		
		Set<Dog> set = new HashSet<Dog> ();
		set.add(new Dog (11,"red"));
		
		//�����ַ���ֵ��Dog����
		Map <String,Dog> map = new HashMap <String,Dog> ();
		map.put ("abc", new Dog(1232,"red"));
		//����ת�ͣ���֤�����Ƿ���
		Dog d = map.get("abc");
		
	}
	
	public static void main (String[] args){
		testMap();
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
