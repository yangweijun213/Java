package com.jun.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestMap {
	
	static void testMap () {
	
		Map m = new HashMap();
		Dog d1 = new Dog (10,"黑色");
		Dog d2 = new Dog (10,"白色");
		m.put ("aa", d1);
		m.put ("bb", d2);
		
		Dog d3 = (Dog) m.get("aa");
		System.out.println(d3==d1);
	}
	
	
	static void testMap2() {
		//姓名:张三，年龄:30,地址:北京 体重：90
		//姓名:李四，年龄:30,地址:北京 体重：90
		Map m = new HashMap();
		m.put("name", "张三");
		
//		List list = new ArrayList();
//		list.add("张三");
				
		Map m2 = new HashMap();
		m2.put("name", "李四");
		
		//使用list把所有信息存储,数据库取出的数据库可以这么放
		List list = new ArrayList();
		list.add(m);
		list.add(m2);
		
	}
	
	static void testGeneric() {
		List<String> list = new ArrayList();
		
		////编译提前报错误，规范数据
		//list.add(1);
		
		//长度可以变，非常灵活
		list.add("abcddddddd");
		
		//编译提前报错误，规范数据
		//list.add(new Dog(12,"yellow"));
		
		//返回不是object了，是string
		list.get(0);
		
		Set<Dog> set = new HashSet<Dog> ();
		set.add(new Dog (11,"red"));
		
		//键是字符，值是Dog对象
		Map <String,Dog> map = new HashMap <String,Dog> ();
		map.put ("abc", new Dog(1232,"red"));
		//不用转型，保证出来是泛型
		Dog d = map.get("abc");
		
		
		
	}
	
	public static void main (String[] args){
		testMap();
	}

}

class Dog {
	
	int weight;
	String color;
	
	//构造器， 右键->source->Generate Constructer using Fields 
	public Dog(int weight, String color) {
		super();
		this.weight = weight;
		this.color = color;
	}

	
}
